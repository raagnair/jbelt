package com.raagnair.belt.primitives;

@FunctionalInterface
public interface LongToByteFn {
    byte apply(long input);
}
