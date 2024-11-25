package com.raagnair.belt.primitives;

@FunctionalInterface
public interface BooleanToByteFn {
    byte apply(boolean input);
}
