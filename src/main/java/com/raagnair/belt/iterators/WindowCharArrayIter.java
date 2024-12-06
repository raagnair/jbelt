package com.raagnair.belt.iterators;

public class WindowCharArrayIter extends AbstractWindowArrayIter<char[]> {
    public WindowCharArrayIter(char[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, char[]::new, reuseOutput);
    }
}
