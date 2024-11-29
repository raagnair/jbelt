package com.raagnair.belt.primitives;

@FunctionalInterface
public interface Fn4<A, B, C, D, Out> {
    Out apply(A a, B b, C c, D d);
}
