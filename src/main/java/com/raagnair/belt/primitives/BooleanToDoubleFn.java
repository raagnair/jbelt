package com.raagnair.belt.primitives;

@FunctionalInterface
public interface BooleanToDoubleFn {
    double apply(boolean input);
}
