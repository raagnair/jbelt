package com.raagnair.belt.primitives;

@FunctionalInterface
public interface IntToByteFn {
    byte apply(int input);
}
