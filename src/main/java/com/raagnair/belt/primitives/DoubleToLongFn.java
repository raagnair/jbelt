package com.raagnair.belt.primitives;

@FunctionalInterface
public interface DoubleToLongFn {
    long apply(double input);
}
