package com.raagnair.belt;

import com.raagnair.belt.primitives.Tuple2;
import com.raagnair.belt.primitives.Tuple3;
import com.raagnair.belt.primitives.Tuple4;
import com.raagnair.belt.primitives.Tuple5;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.raagnair.belt.Belt.tup;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TupleToolsTest {

    @Test
    void Tuple2_Of() {
        assertEquals(
                new Tuple2<>("one", 2),
                tup.of("one", 2));
    }

    @Test
    void Tuple2_Fn() {
        var input = List.of(
                tup.of("one", 1.0),
                tup.of("two", 2.0),
                tup.of("three", 3.0));

        assertEquals(
                List.of("one-1.0", "two-2.0", "three-3.0"),
                input.stream()
                        .map(tup.fn((a, b) -> a + "-" + b))
                        .toList());
    }

    @Test
    void Tuple2_FromEntry() {
        var input = Map.of(
                1, "one value",
                2, "two values",
                3, "three values");

        assertEquals(
                Set.of(tup.of(1, "one value"), tup.of(2, "two values"), tup.of(3, "three values")),
                input.entrySet().stream()
                        .map(tup::fromEntry)
                        .collect(Collectors.toSet()));
    }

    @Test
    void Tuple2_FromMap() {
        var input = Map.of(
                1, "one value",
                2, "two values",
                3, "three values");

        assertEquals(
                Set.of(tup.of(1, "one value"), tup.of(2, "two values"), tup.of(3, "three values")),
                tup.fromMap(input));
    }

    @Test
    void Tuple2_Fn_Fields() {
        var input = List.of(
                tup.of("one", 1.0),
                tup.of("two", 2.0),
                tup.of("three", 3.0));

        assertEquals(
                List.of(tup.of("ONE", 1.0), tup.of("TWO", 2.0), tup.of("THREE", 3.0)),
                input.stream()
                        .map(tup.fnA2(String::toUpperCase))
                        .toList());

        assertEquals(
                List.of(tup.of("one", 10.0), tup.of("two", 20.0), tup.of("three", 30.0)),
                input.stream()
                        .map(tup.fnB2(n -> n * 10))
                        .toList());
    }

    @Test
    void Tuple2_To() {
        var input = List.of(
                tup.of("one", 1.0),
                tup.of("two", 2.0),
                tup.of("three", 3.0));
        var output = new StringBuilder();

        input.forEach(tup.to((a, b) -> output.append(a).append(b)));
        assertEquals("one1.0two2.0three3.0", output.toString());
    }

    @Test
    void Tuple2_AsArray() {
        assertArrayEquals(
                new Number[]{2, 22.2},
                tup.asArray(tup.of(2, 22.2), new Number[2]));
    }

    @Test
    void Tuple3_Of() {
        assertEquals(
                new Tuple3<>("one", 2, 200.0),
                tup.of("one", 2, 200.0));
    }

    @Test
    void Tuple3_Fn() {
        var input = List.of(
                tup.of("one", 1.0, 100),
                tup.of("two", 2.0, 200),
                tup.of("three", 3.0, 300));

        assertEquals(
                List.of("one-1.0+100", "two-2.0+200", "three-3.0+300"),
                input.stream()
                        .map(tup.fn((a, b, c) -> a + "-" + b + "+" + c))
                        .toList());
    }

    @Test
    void Tuple3_Fn_Fields() {
        var input = List.of(
                tup.of("one", 1.0, 100),
                tup.of("two", 2.0, 200),
                tup.of("three", 3.0, 300));

        assertEquals(
                List.of(tup.of("ONE", 1.0, 100), tup.of("TWO", 2.0, 200), tup.of("THREE", 3.0, 300)),
                input.stream()
                        .map(tup.fnA3(String::toUpperCase))
                        .toList());

        assertEquals(
                List.of(tup.of("one", 10.0, 100), tup.of("two", 20.0, 200), tup.of("three", 30.0, 300)),
                input.stream()
                        .map(tup.fnB3(n -> n * 10))
                        .toList());

        assertEquals(
                List.of(tup.of("one", 1.0, 101), tup.of("two", 2.0, 201), tup.of("three", 3.0, 301)),
                input.stream()
                        .map(tup.fnC3(n -> n + 1))
                        .toList());
    }

    @Test
    void Tuple3_To() {
        var input = List.of(
                tup.of("one", 1.0, 100),
                tup.of("two", 2.0, 200),
                tup.of("three", 3.0, 300));
        var output = new StringBuilder();

        input.forEach(tup.to((a, b, c) -> output.append(a).append(b).append(c)));
        assertEquals("one1.0100two2.0200three3.0300", output.toString());
    }

    @Test
    void Tuple3_AsArray() {
        assertArrayEquals(
                new Number[]{2, 22.2, 200},
                tup.asArray(tup.of(2, 22.2, 200), new Number[3]));
    }

    @Test
    void Tuple4_Of() {
        assertEquals(
                new Tuple4<>("one", 2, 200.0, 3),
                tup.of("one", 2, 200.0, 3));
    }

    @Test
    void Tuple4_Fn() {
        var input = List.of(
                tup.of("one", 1.0, 100, 'x'),
                tup.of("two", 2.0, 200, 'y'),
                tup.of("three", 3.0, 300, 'z'));

        assertEquals(
                List.of("one-1.0+100.x", "two-2.0+200.y", "three-3.0+300.z"),
                input.stream()
                        .map(tup.fn((a, b, c, d) -> a + "-" + b + "+" + c + "." + d))
                        .toList());
    }

    @Test
    void Tuple4_Fn_Fields() {
        var input = List.of(
                tup.of("one", 1.0, 100, 'x'),
                tup.of("two", 2.0, 200, 'y'),
                tup.of("three", 3.0, 300, 'z'));

        assertEquals(
                List.of(tup.of("ONE", 1.0, 100, 'x'), tup.of("TWO", 2.0, 200, 'y'), tup.of("THREE", 3.0, 300, 'z')),
                input.stream()
                        .map(tup.fnA4(String::toUpperCase))
                        .toList());

        assertEquals(
                List.of(tup.of("one", 10.0, 100, 'x'), tup.of("two", 20.0, 200, 'y'), tup.of("three", 30.0, 300, 'z')),
                input.stream()
                        .map(tup.fnB4(n -> n * 10))
                        .toList());

        assertEquals(
                List.of(tup.of("one", 1.0, 101, 'x'), tup.of("two", 2.0, 201, 'y'), tup.of("three", 3.0, 301, 'z')),
                input.stream()
                        .map(tup.fnC4(n -> n + 1))
                        .toList());

        assertEquals(
                List.of(tup.of("one", 1.0, 100, 'X'), tup.of("two", 2.0, 200, 'Y'), tup.of("three", 3.0, 300, 'Z')),
                input.stream()
                        .map(tup.fnD4(Character::toUpperCase))
                        .toList());
    }

    @Test
    void Tuple4_To() {
        var input = List.of(
                tup.of("one", 1.0, 100, 'x'),
                tup.of("two", 2.0, 200, 'y'),
                tup.of("three", 3.0, 300, 'z'));

        var output = new StringBuilder();

        input.forEach(tup.to((a, b, c, d) -> output.append(a).append(b).append(c).append(d)));
        assertEquals("one1.0100xtwo2.0200ythree3.0300z", output.toString());
    }

    @Test
    void Tuple4_AsArray() {
        assertArrayEquals(
                new Number[]{2, 22.2, 200, 2L},
                tup.asArray(tup.of(2, 22.2, 200, 2L), new Number[4]));
    }

    @Test
    void Tuple5_Of() {
        assertEquals(
                new Tuple5<>("one", 2, 200.0, 3, 'x'),
                tup.of("one", 2, 200.0, 3, 'x'));
    }

    @Test
    void Tuple5_Fn() {
        var input = List.of(
                tup.of("one", 1.0, 100, 'x', 1L),
                tup.of("two", 2.0, 200, 'y', 2L),
                tup.of("three", 3.0, 300, 'z', 3L));

        assertEquals(
                List.of("one-1.0+100.x1", "two-2.0+200.y2", "three-3.0+300.z3"),
                input.stream()
                        .map(tup.fn((a, b, c, d, e) -> a + "-" + b + "+" + c + "." + d + e))
                        .toList());
    }

    @Test
    void Tuple5_Fn_Fields() {
        var input = List.of(
                tup.of("one", 1.0, 100, 'x', 1L),
                tup.of("two", 2.0, 200, 'y', 2L),
                tup.of("three", 3.0, 300, 'z', 3L));

        assertEquals(
                List.of(
                        tup.of("ONE", 1.0, 100, 'x', 1L),
                        tup.of("TWO", 2.0, 200, 'y', 2L),
                        tup.of("THREE", 3.0, 300, 'z', 3L)),
                input.stream()
                        .map(tup.fnA5(String::toUpperCase))
                        .toList());

        assertEquals(
                List.of(
                        tup.of("one", 10.0, 100, 'x', 1L),
                        tup.of("two", 20.0, 200, 'y', 2L),
                        tup.of("three", 30.0, 300, 'z', 3L)),
                input.stream()
                        .map(tup.fnB5(n -> n * 10))
                        .toList());

        assertEquals(
                List.of(
                        tup.of("one", 1.0, 101, 'x', 1L),
                        tup.of("two", 2.0, 201, 'y', 2L),
                        tup.of("three", 3.0, 301, 'z', 3L)),
                input.stream()
                        .map(tup.fnC5(n -> n + 1))
                        .toList());

        assertEquals(
                List.of(
                        tup.of("one", 1.0, 100, 'X', 1L),
                        tup.of("two", 2.0, 200, 'Y', 2L),
                        tup.of("three", 3.0, 300, 'Z', 3L)),
                input.stream()
                        .map(tup.fnD5(Character::toUpperCase))
                        .toList());

        assertEquals(
                List.of(
                        tup.of("one", 1.0, 100, 'x', -1L),
                        tup.of("two", 2.0, 200, 'y', -2L),
                        tup.of("three", 3.0, 300, 'z', -3L)),
                input.stream()
                        .map(tup.fnE5(i -> i * -1))
                        .toList());
    }

    @Test
    void Tuple5_To() {
        var input = List.of(
                tup.of("one", 1.0, 100, 'x', 1L),
                tup.of("two", 2.0, 200, 'y', 2L),
                tup.of("three", 3.0, 300, 'z', 3L));

        var output = new StringBuilder();

        input.forEach(
                tup.to((a, b, c, d, e) ->
                               output.append(a).append(b).append(c).append(d).append(e).append(' ')));

        assertEquals(
                "one1.0100x1 two2.0200y2 three3.0300z3 ",
                output.toString());
    }

    @Test
    void Tuple5_AsArray() {
        assertArrayEquals(
                new Number[]{2, 22.2, 200, 2L, -2},
                tup.asArray(tup.of(2, 22.2, 200, 2L, -2), new Number[5]));
    }
}
