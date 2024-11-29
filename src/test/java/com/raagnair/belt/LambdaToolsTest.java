package com.raagnair.belt;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.raagnair.belt.Belt.lam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LambdaToolsTest {

    @Test
    void Forgive_Consumer() {
        List<Integer> results = new ArrayList<>();
        List<Integer> inputs = List.of(1, 2, 5, 0, 10, 25);

        Consumer<Integer> insertConsumer = intInput -> results.add(50 / intInput);

        assertThrows(
                ArithmeticException.class,
                () -> inputs.forEach(insertConsumer));

        assertEquals(results, List.of(50, 25, 10));
        results.clear();

        inputs.forEach(lam.forgive(insertConsumer));
        assertEquals(results, List.of(50, 25, 10, 5, 2));
    }

    @Test
    void Forgive_Consumer_SpecificException() {
        List<Integer> results = new ArrayList<>();
        List<Integer> inputs = List.of(1, 2, 5, 0, 10, 25);

        Consumer<Integer> insertConsumer = intInput -> results.add(50 / intInput);

        assertThrows(
                ArithmeticException.class,
                () -> inputs.forEach(lam.forgive(insertConsumer, IOException.class)));
        results.clear();

        inputs.forEach(lam.forgive(insertConsumer, ArithmeticException.class));
        assertEquals(results, List.of(50, 25, 10, 5, 2));
    }

    @Test
    void Uncheck_Consumer() {
        List<String> input = List.of(
                LambdaToolsTest.class.getName(),
                "this will throw an exception",
                LambdaTools.class.getName());
        List<Class<?>> results = new ArrayList<>();

        var exceptionThrown = assertThrows(
                RuntimeException.class,
                () -> input.forEach(lam.uncheck(str -> {
                    results.add(Class.forName(str));
                })));
        assertEquals(ClassNotFoundException.class, exceptionThrown.getCause().getClass());
        assertEquals(List.of(LambdaToolsTest.class), results);
    }

    @Test
    void UncheckForgive_Consumer() {
        List<String> input = List.of(
                LambdaToolsTest.class.getName(),
                "this will throw an exception",
                LambdaTools.class.getName());
        List<Class<?>> results = new ArrayList<>();

        input.forEach(lam.uncheckForgive(str -> results.add(Class.forName(str))));
        assertEquals(
                List.of(LambdaToolsTest.class, LambdaTools.class),
                results);
    }

    @Test
    void UncheckForgive_Consumer_SpecificException() {
        List<String> input = List.of(
                LambdaToolsTest.class.getName(),
                "this will throw an exception",
                LambdaTools.class.getName());
        List<Class<?>> results = new ArrayList<>();

        var exceptionThrown = assertThrows(
                RuntimeException.class,
                () -> input.forEach(lam.uncheckForgive(str -> {
                    results.add(Class.forName(str));
                }, ArithmeticException.class)));
        assertEquals(ClassNotFoundException.class, exceptionThrown.getCause().getClass());
        results.clear();

        input.forEach(lam.uncheckForgive(str -> {
            results.add(Class.forName(str));
        }, ClassNotFoundException.class));

        assertEquals(
                List.of(LambdaToolsTest.class, LambdaTools.class),
                results);
    }

    @Test
    void Forgive_Function() {
        List<String> results = new ArrayList<>();
        List<Integer> inputs = List.of(1, 2, 5, 0, 10, 25);

        inputs.stream()
                .map(lam.forgive(i -> 50 / i, -123))
                .map(String::valueOf)
                .forEach(results::add);

        assertEquals(
                List.of("50", "25", "10", "-123", "5", "2"),
                results);
    }

    @Test
    void Forgive_Function_SpecificExceptions() {
        List<String> results = new ArrayList<>();
        List<Integer> inputs = List.of(1, 2, 5, 0, 10, 25);

        inputs.stream()
                .map(lam.forgive(i -> 50 / i, null, ArithmeticException.class))
                .map(lam.forgive(Integer::longValue, -101, NullPointerException.class))
                .map(String::valueOf)
                .forEach(results::add);

        assertEquals(
                List.of("50", "25", "10", "-101", "5", "2"),
                results);

        // The below asserts repeat the above experiment, but do not ignore the correct specific exceptions.
        // The correct exceptions are commented out, and replaced with an IOException.class instead.
        assertThrows(
                ArithmeticException.class,
                () -> inputs.stream()
                        .map(lam.forgive(
                                i -> 50 / i, null,
                                IOException.class /* ArithmeticException.class */))
                        .map(lam.forgive(Integer::longValue, -101, NullPointerException.class))
                        .map(String::valueOf)
                        .forEach(results::add));

        assertThrows(
                NullPointerException.class,
                () -> inputs.stream()
                        .map(lam.forgive(i -> 50 / i, null, ArithmeticException.class))
                        .map(lam.forgive(
                                Integer::longValue, -101,
                                IOException.class /* NullPointerException.class */))
                        .map(String::valueOf)
                        .forEach(results::add));
    }

    @Test
    void Uncheck_Function() {
        List<String> input = List.of(
                LambdaToolsTest.class.getName(),
                "this will throw an exception",
                LambdaTools.class.getName());

        var exceptionThrown = assertThrows(
                RuntimeException.class,
                () -> input.stream()
                        .map(lam.uncheck((String s) -> Class.forName(s)))
                        .toList());
        assertEquals(ClassNotFoundException.class, exceptionThrown.getCause().getClass());
    }

    @Test
    void UncheckForgive_Function() {
        List<String> input = List.of(
                LambdaToolsTest.class.getName(),
                "this will throw an exception",
                LambdaTools.class.getName());

        assertEquals(
                List.of(LambdaToolsTest.class, Object.class, LambdaTools.class),
                input.stream()
                        .map(lam.uncheckForgive(Class::forName, Object.class))
                        .toList());
    }

    @Test
    void UncheckForgive_Function_SpecificException() {
        List<String> input = List.of(
                LambdaToolsTest.class.getName(),
                "this will throw an exception",
                LambdaTools.class.getName());

        var exceptionThrown = assertThrows(
                RuntimeException.class,
                () -> input.stream()
                        .map(lam.uncheckForgive(Class::forName, Object.class, ArithmeticException.class))
                        .toList());
        assertEquals(ClassNotFoundException.class, exceptionThrown.getCause().getClass());

        assertEquals(
                List.of(LambdaToolsTest.class, Object.class, LambdaTools.class),
                input.stream()
                        .map(lam.uncheckForgive(Class::forName, Object.class, ClassNotFoundException.class))
                        .toList());
    }
}
