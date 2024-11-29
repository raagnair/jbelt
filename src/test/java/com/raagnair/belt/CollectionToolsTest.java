package com.raagnair.belt;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.raagnair.belt.Belt.col;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionToolsTest {

    @Test
    void Fold() {
        assertEquals(
                1006,
                col.fold(
                        List.of("i", "iii", "ii"),
                        1000,
                        (acc, elem) -> acc + elem.length()));
    }

    @Test
    void SizeIf() {
        assertEquals(
                4,
                col.sizeIf(List.of('a', 'B', 'c', 'D', 'e', 'F', 'g'), Character::isLowerCase));

        assertEquals(
                3,
                col.sizeIf(List.of('a', 'B', 'c', 'D', 'e', 'F', 'g'), Character::isUpperCase));
    }

    @Test
    void IsEmptyIf() {
        assertTrue(col.isEmptyIf(List.of(1, 2, 3, 4), i -> i > 5));
        assertFalse(col.isEmptyIf(List.of(1, 2, 3, 4), i -> i > 3));
    }

    @Test
    void Filter() {
        assertEquals(
                List.of(1, 3, 5),
                col.filter(List.of(1, 2, 3, 4, 5), i -> i % 2 == 1, new ArrayList<>()));
    }

    @Test
    void Filter_Lazy() {
        AtomicBoolean createdNewArrayList = new AtomicBoolean(false);
        assertEquals(
                Collections.emptyList(),
                col.filter(
                        List.of(1, 2, 3), i -> i > 3,
                        () -> {
                            createdNewArrayList.set(true);
                            return new ArrayList<>();
                        },
                        col.noList()));
        assertFalse(createdNewArrayList.get());

        assertEquals(
                Collections.emptySet(),
                col.filter(Set.of(1, 2, 3), i -> i > 3, HashSet::new, col.noSet()));

        assertEquals(
                Set.of(1, 2, 3),
                col.filter(Set.of(1, 2, 3, 4, 5), i -> i < 4, HashSet::new, col.noSet()));

        assertEquals(
                Set.of(1, 2),
                col.filter(List.of(1, 2, 2, 1, 2, 4, 4), i -> i < 4, HashSet::new, col.noSet()));
    }
}
