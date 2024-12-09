package com.raagnair.belt;

import com.raagnair.belt.iterators.*;
import com.raagnair.belt.primitives.*;

import java.util.Iterator;
import java.util.function.Function;

public enum ArrayTools {
    INSTANCE;

    public <O> O[] map(boolean[] input, BooleanFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(boolean[] input, O[] dest, BooleanFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(boolean[] input, BooleanToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(boolean[] input, boolean[] dest, BooleanToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(boolean[] input, BooleanToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(boolean[] input, byte[] dest, BooleanToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(boolean[] input, BooleanToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(boolean[] input, char[] dest, BooleanToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(boolean[] input, BooleanToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(boolean[] input, short[] dest, BooleanToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(boolean[] input, BooleanToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(boolean[] input, int[] dest, BooleanToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(boolean[] input, BooleanToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(boolean[] input, float[] dest, BooleanToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(boolean[] input, BooleanToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(boolean[] input, long[] dest, BooleanToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(boolean[] input, BooleanToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(boolean[] input, double[] dest, BooleanToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <O> O[] map(byte[] input, ByteFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(byte[] input, O[] dest, ByteFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(byte[] input, ByteToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(byte[] input, boolean[] dest, ByteToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(byte[] input, ByteToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(byte[] input, byte[] dest, ByteToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(byte[] input, ByteToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(byte[] input, char[] dest, ByteToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(byte[] input, ByteToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(byte[] input, short[] dest, ByteToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(byte[] input, ByteToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(byte[] input, int[] dest, ByteToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(byte[] input, ByteToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(byte[] input, float[] dest, ByteToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(byte[] input, ByteToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(byte[] input, long[] dest, ByteToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(byte[] input, ByteToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(byte[] input, double[] dest, ByteToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <O> O[] map(char[] input, CharFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(char[] input, O[] dest, CharFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(char[] input, CharToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(char[] input, boolean[] dest, CharToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(char[] input, CharToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(char[] input, byte[] dest, CharToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(char[] input, CharToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(char[] input, char[] dest, CharToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(char[] input, CharToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(char[] input, short[] dest, CharToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(char[] input, CharToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(char[] input, int[] dest, CharToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(char[] input, CharToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(char[] input, float[] dest, CharToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(char[] input, CharToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(char[] input, long[] dest, CharToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(char[] input, CharToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(char[] input, double[] dest, CharToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <O> O[] map(short[] input, ShortFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(short[] input, O[] dest, ShortFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(short[] input, ShortToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(short[] input, boolean[] dest, ShortToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(short[] input, ShortToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(short[] input, byte[] dest, ShortToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(short[] input, ShortToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(short[] input, char[] dest, ShortToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(short[] input, ShortToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(short[] input, short[] dest, ShortToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(short[] input, ShortToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(short[] input, int[] dest, ShortToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(short[] input, ShortToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(short[] input, float[] dest, ShortToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(short[] input, ShortToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(short[] input, long[] dest, ShortToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(short[] input, ShortToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(short[] input, double[] dest, ShortToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <O> O[] map(int[] input, IntFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(int[] input, O[] dest, IntFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(int[] input, IntToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(int[] input, boolean[] dest, IntToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(int[] input, IntToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(int[] input, byte[] dest, IntToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(int[] input, IntToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(int[] input, char[] dest, IntToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(int[] input, IntToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(int[] input, short[] dest, IntToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(int[] input, IntToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(int[] input, int[] dest, IntToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(int[] input, IntToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(int[] input, float[] dest, IntToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(int[] input, IntToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(int[] input, long[] dest, IntToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(int[] input, IntToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(int[] input, double[] dest, IntToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <O> O[] map(float[] input, FloatFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(float[] input, O[] dest, FloatFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(float[] input, FloatToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(float[] input, boolean[] dest, FloatToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(float[] input, FloatToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(float[] input, byte[] dest, FloatToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(float[] input, FloatToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(float[] input, char[] dest, FloatToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(float[] input, FloatToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(float[] input, short[] dest, FloatToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(float[] input, FloatToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(float[] input, int[] dest, FloatToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(float[] input, FloatToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(float[] input, float[] dest, FloatToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(float[] input, FloatToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(float[] input, long[] dest, FloatToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(float[] input, FloatToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(float[] input, double[] dest, FloatToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <O> O[] map(long[] input, LongFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(long[] input, O[] dest, LongFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(long[] input, LongToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(long[] input, boolean[] dest, LongToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(long[] input, LongToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(long[] input, byte[] dest, LongToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(long[] input, LongToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(long[] input, char[] dest, LongToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(long[] input, LongToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(long[] input, short[] dest, LongToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(long[] input, LongToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(long[] input, int[] dest, LongToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(long[] input, LongToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(long[] input, float[] dest, LongToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(long[] input, LongToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(long[] input, long[] dest, LongToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(long[] input, LongToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(long[] input, double[] dest, LongToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <O> O[] map(double[] input, DoubleFn<O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <O> O[] map(double[] input, O[] dest, DoubleFn<O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public boolean[] map(double[] input, DoubleToBooleanFn mapFn) {
        return map(input, new boolean[input.length], mapFn);
    }

    public boolean[] map(double[] input, boolean[] dest, DoubleToBooleanFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public byte[] map(double[] input, DoubleToByteFn mapFn) {
        return map(input, new byte[input.length], mapFn);
    }

    public byte[] map(double[] input, byte[] dest, DoubleToByteFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public char[] map(double[] input, DoubleToCharFn mapFn) {
        return map(input, new char[input.length], mapFn);
    }

    public char[] map(double[] input, char[] dest, DoubleToCharFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public short[] map(double[] input, DoubleToShortFn mapFn) {
        return map(input, new short[input.length], mapFn);
    }

    public short[] map(double[] input, short[] dest, DoubleToShortFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public int[] map(double[] input, DoubleToIntFn mapFn) {
        return map(input, new int[input.length], mapFn);
    }

    public int[] map(double[] input, int[] dest, DoubleToIntFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public float[] map(double[] input, DoubleToFloatFn mapFn) {
        return map(input, new float[input.length], mapFn);
    }

    public float[] map(double[] input, float[] dest, DoubleToFloatFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public long[] map(double[] input, DoubleToLongFn mapFn) {
        return map(input, new long[input.length], mapFn);
    }

    public long[] map(double[] input, long[] dest, DoubleToLongFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public double[] map(double[] input, DoubleToDoubleFn mapFn) {
        return map(input, new double[input.length], mapFn);
    }

    public double[] map(double[] input, double[] dest, DoubleToDoubleFn mapFn) {
        for (int i = 0; i < input.length; i++) {
            dest[i] = mapFn.apply(input[i]);
        }
        return dest;
    }

    public <I, O> O[] map(I[] input, Function<I, O> mapFn) {
        return map(input, newRawArray(input.length), mapFn);
    }

    public <I, O> O[] map(I[] input, O[] dest, Function<I, O> mapFn) {
        for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
            dest[inputIdx] = mapFn.apply(input[inputIdx]);
        }
        return dest;
    }

    public <I> Iterator<I[]> windows(I[] input, int maxWindowSize, Function<Integer, I[]> newArrayFn) {
        return windows(input, maxWindowSize, maxWindowSize, newArrayFn, false);
    }

    public <I> Iterator<I[]> windows(I[] input, int maxWindowSize, int stepSize, Function<Integer, I[]> newArrayFn) {
        return windows(input, maxWindowSize, stepSize, newArrayFn, false);
    }

    public <I> Iterator<I[]> windows(
            I[] input, int maxWindowSize, int stepSize, Function<Integer, I[]> newArrayFn, boolean reuseWindow) {
        return new WindowArrayIterator<>(input, maxWindowSize, stepSize, newArrayFn, reuseWindow);
    }

    public Iterator<boolean[]> windows(boolean[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<boolean[]> windows(boolean[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<boolean[]> windows(boolean[] input, int maxWindowSize, int stepSize, ReuseOutput reuseOutput) {
        return new WindowBooleanArrayIter(input, maxWindowSize, stepSize, reuseOutput == ReuseOutput.TRY);
    }

    public Iterator<byte[]> windows(byte[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<byte[]> windows(byte[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<byte[]> windows(byte[] input, int maxWindowSize, int stepSize, ReuseOutput reuseOutput) {
        return new WindowByteArrayIter(input, maxWindowSize, stepSize, reuseOutput == ReuseOutput.TRY);
    }

    public Iterator<char[]> windows(char[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<char[]> windows(char[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<char[]> windows(char[] input, int maxWindowSize, int stepSize, ReuseOutput reuseOutput) {
        return new WindowCharArrayIter(input, maxWindowSize, stepSize, reuseOutput == ReuseOutput.TRY);
    }

    public Iterator<short[]> windows(short[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<short[]> windows(short[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<short[]> windows(short[] input, int maxWindowSize, int stepSize, ReuseOutput reuseOutput) {
        return new WindowShortArrayIter(input, maxWindowSize, stepSize, reuseOutput == ReuseOutput.TRY);
    }

    public Iterator<int[]> windows(int[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<int[]> windows(int[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<int[]> windows(int[] input, int maxWindowSize, int stepSize, ReuseOutput reuseOutput) {
        return new WindowIntArrayIter(input, maxWindowSize, stepSize, reuseOutput == ReuseOutput.TRY);
    }

    public Iterator<float[]> windows(float[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<float[]> windows(float[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<float[]> windows(float[] input, int maxWindowSize, int stepSize, ReuseOutput reuseOutput) {
        return new WindowFloatArrayIter(input, maxWindowSize, stepSize, reuseOutput == ReuseOutput.TRY);
    }

    public Iterator<double[]> windows(double[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<double[]> windows(double[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<double[]> windows(double[] input, int maxWindowSize, int stepSize, ReuseOutput reuseOutput) {
        return new WindowDoubleArrayIter(input, maxWindowSize, stepSize, reuseOutput == ReuseOutput.TRY);
    }

    public Iterator<long[]> windows(long[] input, int maxWindowSize) {
        return windows(input, maxWindowSize, maxWindowSize);
    }

    public Iterator<long[]> windows(long[] input, int maxWindowSize, int stepSize) {
        return windows(input, maxWindowSize, stepSize, ReuseOutput.NEVER);
    }

    public Iterator<long[]> windows(long[] input, int maxWindowSize, int stepSize, ReuseOutput reuseWindow) {
        return new WindowLongArrayIter(input, maxWindowSize, stepSize, reuseWindow == ReuseOutput.TRY);
    }

    @SuppressWarnings("unchecked")
    private <I> I[] newRawArray(int length) {
        return (I[]) new Object[length];
    }

    public enum ReuseOutput {TRY, NEVER}
}
