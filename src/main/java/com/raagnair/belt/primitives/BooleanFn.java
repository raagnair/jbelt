package com.raagnair.belt.primitives;

@FunctionalInterface
public interface BooleanFn<O> {
    O apply(boolean input);
}
