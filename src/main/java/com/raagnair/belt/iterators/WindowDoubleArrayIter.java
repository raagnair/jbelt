package com.raagnair.belt.iterators;

public class WindowDoubleArrayIter extends AbstractWindowArrayIter<double[]> {
    public WindowDoubleArrayIter(double[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, double[]::new, reuseOutput);
    }
}
