package com.raagnair.belt.iterators;

public class WindowBooleanArrayIter extends AbstractWindowArrayIter<boolean[]> {
    public WindowBooleanArrayIter(boolean[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, boolean[]::new, reuseOutput);
    }
}
