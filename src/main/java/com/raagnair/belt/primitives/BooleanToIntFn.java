package com.raagnair.belt.primitives;

@FunctionalInterface
public interface BooleanToIntFn {
    int apply(boolean input);
}
