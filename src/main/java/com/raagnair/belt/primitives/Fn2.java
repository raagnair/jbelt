package com.raagnair.belt.primitives;

@FunctionalInterface
public interface Fn2<A, B, Out> {
    Out apply(A a, B b);
}
