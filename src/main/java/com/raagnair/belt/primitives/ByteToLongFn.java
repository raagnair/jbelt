package com.raagnair.belt.primitives;

@FunctionalInterface
public interface ByteToLongFn {
    long apply(byte input);
}
