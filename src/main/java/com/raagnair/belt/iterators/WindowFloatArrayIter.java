package com.raagnair.belt.iterators;

public class WindowFloatArrayIter extends AbstractWindowArrayIter<float[]> {
    public WindowFloatArrayIter(float[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, float[]::new, reuseOutput);
    }
}
