package com.raagnair.belt.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public abstract class AbstractWindowArrayIter<ArrayType> implements Iterator<ArrayType> {
    private final ArrayType input;
    private final int windowSize, inputLength, stepSize;
    private final boolean reuseOutput;
    private final Function<Integer, ArrayType> newArrayFn;

    protected int firstIdxOfWindow = 0, lastSeenIdx = -1;
    private ArrayType reusedOutputHolder = null;

    protected AbstractWindowArrayIter(
            ArrayType input,
            int inputLength,
            int maxWindow,
            int stepSize,
            Function<Integer, ArrayType> newArrayFn,
            boolean reuseOutput) {
        this.input = input;
        this.windowSize = maxWindow;
        this.stepSize = stepSize;
        this.inputLength = inputLength;
        this.newArrayFn = newArrayFn;
        this.reuseOutput = reuseOutput;

    }

    @Override
    public boolean hasNext() {
        return lastSeenIdx < inputLength;
    }

    @Override
    public ArrayType next() {
        if (!hasNext()) throw new NoSuchElementException("iterator depleted");
        int thisWindowSize = Math.min(inputLength - firstIdxOfWindow, windowSize);
        ArrayType thisWindow = getOutputHolder(thisWindowSize);
        if (thisWindowSize >= 0) System.arraycopy(input, firstIdxOfWindow, thisWindow, 0, thisWindowSize);

        lastSeenIdx = firstIdxOfWindow + thisWindowSize;
        firstIdxOfWindow += stepSize;

        return thisWindow;
    }

    private ArrayType getOutputHolder(int capacity) {
        if (!reuseOutput || capacity < windowSize) return newArrayFn.apply(capacity);
        if (reusedOutputHolder == null) reusedOutputHolder = newArrayFn.apply(capacity);
        return reusedOutputHolder;
    }
}
