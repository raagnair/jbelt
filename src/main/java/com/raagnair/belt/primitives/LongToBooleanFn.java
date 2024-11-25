package com.raagnair.belt.primitives;

@FunctionalInterface
public interface LongToBooleanFn {
    boolean apply(long input);
}
