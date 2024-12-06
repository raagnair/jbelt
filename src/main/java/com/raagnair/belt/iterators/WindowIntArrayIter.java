package com.raagnair.belt.iterators;

public class WindowIntArrayIter extends AbstractWindowArrayIter<int[]> {
    public WindowIntArrayIter(int[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, int[]::new, reuseOutput);
    }
}
