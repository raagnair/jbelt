package com.raagnair.belt;

import java.util.function.Consumer;
import java.util.function.Function;

public enum PipeTools {
    INSTANCE;

    public <T> PipeVal<T> of(T value) {
        return new PipeVal<>(value);
    }

    public RawPipeVal ofRaw(Object value) {
        return new RawPipeVal(value);
    }

    public record PipeVal<T>(T value) {
        public T get() {
            return value;
        }

        public <E> PipeVal<E> pipe(Function<T, E> pipeFn) {
            return new PipeVal<E>(pipeFn.apply(value));
        }

        public void to(Consumer<T> pipeCns) {
            pipeCns.accept(value);
        }

        public PipeVal<T> via(Consumer<T> pipeCns) {
            pipeCns.accept(value);
            return this;
        }
    }

    public static class RawPipeVal {
        private Object value;

        private RawPipeVal(Object value) {
            this.value = value;
        }

        public <T> RawPipeVal pipe(Class<T> cls, Function<T, Object> function) {
            value = function.apply(cls.cast(value));
            return this;
        }

        public RawPipeVal pipe(Function<Object, Object> function) {
            value = function.apply(value);
            return this;
        }

        public Object get() {
            return value;
        }

        public <T> T get(Class<T> cls) {
            return cls.cast(value);
        }

        public void to(Consumer<Object> consumer) {
            consumer.accept(value);
        }

        public <T> void to(Class<? extends T> cls, Consumer<T> consumer) {
            consumer.accept(cls.cast(value));
        }

        public RawPipeVal via(Consumer<Object> consumer) {
            consumer.accept(value);
            return this;
        }

        public <T> RawPipeVal via(Class<? extends T> cls, Consumer<T> consumer) {
            consumer.accept(cls.cast(value));
            return this;
        }
    }
}
