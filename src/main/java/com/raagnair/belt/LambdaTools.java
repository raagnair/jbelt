package com.raagnair.belt;

import java.util.function.Consumer;
import java.util.function.Function;

public enum LambdaTools {
    INSTANCE;

    public final <T> Consumer<T> uncheck(ThrowingConsumer<T, Exception> throwingConsumer) {
        return input -> {
            try {
                throwingConsumer.accept(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public final <I, O> Function<I, O> uncheck(ThrowingFunction<I, O, Exception> throwingFunction) {
        return input -> {
            try {
                return throwingFunction.apply(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public final <T> Consumer<T> forgive(Consumer<T> consumer) {
        return input -> {
            try {
                consumer.accept(input);
            } catch (Exception e) { /* ignore */ }
        };
    }

    @SafeVarargs
    public final <T> Consumer<T> forgive(Consumer<T> consumer, Class<? extends Exception>... ex) {
        return input -> {
            try {
                consumer.accept(input);
            } catch (Exception e) {
                for (Class<? extends Exception> exCls : ex) if (exCls.isInstance(e)) return;
                throw e;
            }
        };
    }

    public final <T, O> Function<T, O> forgive(Function<T, O> function, O defaultOutput) {
        return input -> {
            try {
                return function.apply(input);
            } catch (Exception e) {
                return defaultOutput;
            }
        };
    }

    @SafeVarargs
    public final <T, O> Function<T, O> forgive(
            Function<T, O> function,
            O defaultOutput,
            Class<? extends Exception>... ex) {

        return input -> {
            try {
                return function.apply(input);
            } catch (Exception e) {
                for (Class<? extends Exception> exCls : ex) if (exCls.isInstance(e)) return defaultOutput;
                throw e;
            }
        };
    }

    public final <T> Consumer<T> uncheckForgive(ThrowingConsumer<T, Exception> throwingConsumer) {
        return uncheckForgive(throwingConsumer, Exception.class);
    }

    @SafeVarargs
    public final <T> Consumer<T> uncheckForgive(
            ThrowingConsumer<T, Exception> throwingConsumer,
            Class<? extends Exception>... ex) {
        return input -> {
            try {
                throwingConsumer.accept(input);
            } catch (Exception e) {
                for (Class<? extends Exception> exCls : ex) if (exCls.isInstance(e)) return;
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    public interface ThrowingConsumer<I, E extends Exception> {
        void accept(I i) throws E;
    }

    @SafeVarargs
    public final <I, O> Function<I, O> uncheckForgive(
            ThrowingFunction<I, O, Exception> throwingFunction,
            O defaultValue,
            Class<? extends Exception>... ex) {
        return input -> {
            try {
                return throwingFunction.apply(input);
            } catch (Exception e) {
                for (Class<? extends Exception> exCls : ex) if (exCls.isInstance(e)) return defaultValue;
                throw new RuntimeException(e);
            }
        };
    }

    public final <I, O> Function<I, O> uncheckForgive(
            ThrowingFunction<I, O, Exception> throwingFunction,
            O defaultValue) {
        return uncheckForgive(throwingFunction, defaultValue, Exception.class);
    }

    @FunctionalInterface
    public interface ThrowingFunction<I, O, E extends Exception> {
        O apply(I i) throws E;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Class.forName(LambdaTools.class.getName()));
    }
}
