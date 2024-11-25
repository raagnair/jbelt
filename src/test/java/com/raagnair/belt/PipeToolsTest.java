package com.raagnair.belt;

import org.junit.jupiter.api.Test;

import static com.raagnair.belt.Belt.pipes;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PipeToolsTest {

    @Test
    void Get() {
        assertEquals("inside", pipes.of("inside").get());
    }

    @Test
    void Pipe() {
        assertEquals(
                "INSIDE",
                pipes.of("inside")
                        .pipe(String::toUpperCase)
                        .get());

        assertEquals(
                "Result: 12",
                pipes.of("inside")
                        .pipe(String::length)
                        .pipe(i -> i * 2)
                        .pipe(i -> "Result: " + i)
                        .get());
    }

    @Test
    void To() {
        StringBuilder builder = new StringBuilder();
        pipes.of("inside")
                .pipe(String::toUpperCase)
                .pipe(s -> "// " + s)
                .to(builder::append);

        assertEquals("// INSIDE", builder.toString());
    }

    @Test
    void Raw_Get() {
        assertEquals(
                "inside",
                pipes.ofRaw("inside").get());
    }

    @Test
    void Raw_PipeUntyped() {
        assertEquals(
                "inside",
                pipes.ofRaw("IN")
                        .pipe(o -> ((String) o).toLowerCase())
                        .pipe(o -> o.toString() + "side")
                        .get());
    }

    @Test
    void Raw_PipeTyped() {
        assertEquals(
                "INSIDE",
                pipes.ofRaw("in")
                        .pipe(String.class, String::toUpperCase)
                        .pipe(String.class, s -> s + "SIDE")
                        .get());
    }

    @Test
    void Raw_To() {
        StringBuilder builder = new StringBuilder();
        pipes.ofRaw("inside")
                .pipe(String.class, String::toUpperCase)
                .pipe(String.class, s -> "// " + s)
                .to(builder::append);

        assertEquals("// INSIDE", builder.toString());
    }
}
