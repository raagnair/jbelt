package com.raagnair.belt.primitives;

@FunctionalInterface
public interface BooleanToShortFn {
    short apply(boolean input);
}
