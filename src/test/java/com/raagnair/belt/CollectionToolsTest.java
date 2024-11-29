package com.raagnair.belt;

import org.junit.jupiter.api.Test;

import java.util.List;

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
}
