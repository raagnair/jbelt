package com.raagnair.belt.iterators;

public class WindowLongArrayIter extends AbstractWindowArrayIter<long[]> {
    public WindowLongArrayIter(long[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, long[]::new, reuseOutput);
    }
}
