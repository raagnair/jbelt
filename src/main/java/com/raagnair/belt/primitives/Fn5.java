package com.raagnair.belt.primitives;

@FunctionalInterface
public interface Fn5<A, B, C, D, E, Out> {
    Out apply(A a, B b, C c, D d, E e);
}
