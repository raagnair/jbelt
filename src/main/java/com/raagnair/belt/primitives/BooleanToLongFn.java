package com.raagnair.belt.primitives;

@FunctionalInterface
public interface BooleanToLongFn {
    long apply(boolean input);
}
