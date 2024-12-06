package com.raagnair.belt.iterators;

public class WindowShortArrayIter extends AbstractWindowArrayIter<short[]> {
    public WindowShortArrayIter(short[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, short[]::new, reuseOutput);
    }
}
