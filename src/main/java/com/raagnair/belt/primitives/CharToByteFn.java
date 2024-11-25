package com.raagnair.belt.primitives;

@FunctionalInterface
public interface CharToByteFn {
    byte apply(char input);
}
