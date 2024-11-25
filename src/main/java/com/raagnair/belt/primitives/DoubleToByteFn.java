package com.raagnair.belt.primitives;

@FunctionalInterface
public interface DoubleToByteFn {
    byte apply(double input);
}
