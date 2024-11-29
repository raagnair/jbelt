package com.raagnair.belt;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static com.raagnair.belt.Belt.pip;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PipeToolsTest {

    @Test
    void Get() {
        assertEquals("inside", pip.of("inside").get());
    }

    @Test
    void Pipe() {
        assertEquals(
                "INSIDE",
                pip.of("inside")
                        .pipe(String::toUpperCase)
                        .get());

        assertEquals(
                "Result: 12",
                pip.of("inside")
                        .pipe(String::length)
                        .pipe(i -> i * 2)
                        .pipe(i -> "Result: " + i)
                        .get());
    }

    @Test
    void To() {
        StringBuilder builder = new StringBuilder();
        pip.of("inside")
                .pipe(String::toUpperCase)
                .pipe(s -> "// " + s)
                .to(builder::append);

        assertEquals("// INSIDE", builder.toString());
    }

    @Test
    void Via() {
        StringBuilder builder = new StringBuilder();
        var output = pip.of("inside")
                .pipe(String::toUpperCase)
                .pipe(s -> "// " + s)
                .via(builder::append)
                .pipe(s -> s + "!!!")
                .get();

        assertEquals("// INSIDE", builder.toString());
        assertEquals("// INSIDE!!!", output);
    }

    @Test
    void Raw_Get() {
        assertEquals(
                "inside",
                pip.ofRaw("inside").get());
    }

    @Test
    void Raw_GetTyped() {
        assertEquals(
                "in",
                pip.ofRaw("inside").get(String.class).substring(0, 2));
    }

    @Test
    void Raw_PipeUntyped() {
        assertEquals(
                "inside",
                pip.ofRaw("IN")
                        .pipe(o -> ((String) o).toLowerCase())
                        .pipe(o -> o.toString() + "side")
                        .get());
    }

    @Test
    void Raw_PipeTyped() {
        assertEquals(
                "INSIDE",
                pip.ofRaw("in")
                        .pipe(String.class, String::toUpperCase)
                        .pipe(String.class, s -> s + "SIDE")
                        .get());
    }

    @Test
    void Raw_To() {
        StringBuilder builder = new StringBuilder();
        pip.ofRaw("inside")
                .pipe(String.class, String::toUpperCase)
                .pipe(String.class, s -> "// " + s)
                .to(builder::append);

        assertEquals("// INSIDE", builder.toString());
    }

    @Test
    void Raw_ToTyped() {
        AtomicInteger outputInt = new AtomicInteger(-1);
        pip.ofRaw("inside")
                .pipe(String.class, s -> s.charAt(0))
                .pipe(Character.class, Integer::valueOf)
                .to(Integer.class, outputInt::set);

        assertEquals(Integer.valueOf('i'), outputInt.get());
    }

    @Test
    void Raw_Via() {
        AtomicReference<String> outputString = new AtomicReference<>();
        Object finalOutput = pip.ofRaw("inside")
                .pipe(String.class, String::toUpperCase)
                .via(o -> outputString.set((String) o))
                .pipe(String.class, s -> s.substring(0, 2))
                .get();

        assertEquals("INSIDE", outputString.get());
        assertEquals("IN", finalOutput);
    }
}
