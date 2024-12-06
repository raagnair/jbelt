package com.raagnair.belt.iterators;

import java.util.Arrays;
import java.util.function.Function;

public class WindowArrayIterator<E> extends AbstractWindowArrayIter<E[]> {
    public WindowArrayIterator(
            E[] input,
            int windowSize,
            int skipSize,
            Function<Integer, E[]> newArrayFn,
            boolean reuseOutput) {
        super(input, input.length, windowSize, skipSize, newArrayFn, reuseOutput);
    }
}
