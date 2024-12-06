package com.raagnair.belt.iterators;

public class WindowByteArrayIter extends AbstractWindowArrayIter<byte[]> {
    public WindowByteArrayIter(byte[] input, int maxWindow, int stepSize, boolean reuseOutput) {
        super(input, input.length, maxWindow, stepSize, byte[]::new, reuseOutput);
    }
}
