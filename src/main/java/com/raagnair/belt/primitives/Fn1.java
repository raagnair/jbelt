package com.raagnair.belt.primitives;

@FunctionalInterface
public interface Fn1<A, Out> {
    Out apply(A a);
}
