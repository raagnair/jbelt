package com.raagnair.belt.primitives;

@FunctionalInterface
public interface BooleanToFloatFn {
    float apply(boolean input);
}
