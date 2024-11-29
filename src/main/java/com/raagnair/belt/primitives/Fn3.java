package com.raagnair.belt.primitives;

@FunctionalInterface
public interface Fn3<A, B, C, Out> {
    Out apply(A a, B b, C c);
}
