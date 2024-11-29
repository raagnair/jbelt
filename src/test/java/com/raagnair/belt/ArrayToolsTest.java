package com.raagnair.belt;

import org.junit.jupiter.api.Test;

import static com.raagnair.belt.Belt.arr;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayToolsTest {

    @Test
    void BooleanArrays() {
        boolean[] input = {true, true, false, false, true};

        assertArrayEquals(
                new String[]{"true", "true", "false", "false", "true"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, true, true, false},
                arr.map(input, new boolean[input.length], in -> !in));

        assertArrayEquals(
                new byte[]{1, 1, 0, 0, 1},
                arr.map(input, new byte[input.length], in -> in ? (byte) 1 : 0));

        assertArrayEquals(
                new char[]{'t', 't', 'f', 'f', 't'},
                arr.map(input, new char[input.length], in -> in ? 't' : 'f'));

        assertArrayEquals(
                new short[]{1, 1, 0, 0, 1},
                arr.map(input, new short[input.length], in -> in ? (short) 1 : 0));

        assertArrayEquals(
                new int[]{1, 1, 0, 0, 1},
                arr.map(input, new int[input.length], in -> in ? 1 : 0));

        assertArrayEquals(
                new float[]{1, 1, 0, 0, 1},
                arr.map(input, new float[input.length], in -> in ? (float) 1 : 0));

        assertArrayEquals(
                new long[]{1, 1, 0, 0, 1},
                arr.map(input, new long[input.length], in -> in ? (long) 1 : 0));

        assertArrayEquals(
                new double[]{1, 1, 0, 0, 1},
                arr.map(input, new double[input.length], in -> in ? (double) 1 : 0));
    }

    @Test
    void ByteArrays() {
        byte[] input = {1, 2, 3, 4, 5};

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, true, false, true, false},
                arr.map(input, new boolean[input.length], b -> b % 2 == 0));

        assertArrayEquals(
                new byte[]{2, 3, 4, 5, 6},
                arr.map(input, new byte[input.length], b -> (byte) (b + 1)));

        assertArrayEquals(
                new char[]{'\u0001', '\u0002', '\u0003', '\u0004', '\u0005'},
                arr.map(input, new char[input.length], b -> (char) b));

        assertArrayEquals(
                new short[]{11, 12, 13, 14, 15},
                arr.map(input, new short[input.length], b -> (short) (b + 10)));

        assertArrayEquals(
                new int[]{11, 12, 13, 14, 15},
                arr.map(input, new int[input.length], b -> b + 10));

        assertArrayEquals(
                new float[]{0.5f, 1.0f, 1.5f, 2.0f, 2.5f},
                arr.map(input, new float[input.length], b -> b / 2.0f));

        assertArrayEquals(
                new long[]{100, 200, 300, 400, 500},
                arr.map(input, new long[input.length], b -> b * 100L));

        assertArrayEquals(
                new double[]{0.1, 0.2, 0.3, 0.4, 0.5},
                arr.map(input, new double[input.length], b -> b / 10.0));
    }

    @Test
    void CharArrays() {
        char[] input = {'a', 'b', 'c', 'd', 'e'};

        assertArrayEquals(
                new String[]{"a", "b", "c", "d", "e"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], Character::isUpperCase));

        assertArrayEquals(
                new byte[]{97, 98, 99, 100, 101},
                arr.map(input, new byte[input.length], c -> (byte) c));

        assertArrayEquals(
                new char[]{'b', 'c', 'd', 'e', 'f'},
                arr.map(input, new char[input.length], c -> (char) (c + 1)));

        assertArrayEquals(
                new short[]{97, 98, 99, 100, 101},
                arr.map(input, new short[input.length], in -> (short) in));

        assertArrayEquals(
                new int[]{97, 98, 99, 100, 101},
                arr.map(input, new int[input.length], c -> c));

        assertArrayEquals(
                new float[]{97.0f, 98.0f, 99.0f, 100.0f, 101.0f},
                arr.map(input, new float[input.length], c -> (float) c));

        assertArrayEquals(
                new long[]{970L, 980L, 990L, 1000L, 1010L},
                arr.map(input, new long[input.length], c -> (long) c * 10));

        assertArrayEquals(
                new double[]{0.97, 0.98, 0.99, 1.0, 1.01},
                arr.map(input, new double[input.length], c -> c / 100.0));
    }

    @Test
    void ShortArrays() {
        short[] input = {1, 2, 3, 4, 5};

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], i -> i < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], i -> (byte) i));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], i -> (char) ('A' + i - 1)));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], i -> i));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], i -> i));

        assertArrayEquals(
                new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f},
                arr.map(input, new float[input.length], i -> (float) i));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, new long[input.length], i -> (long) i));

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0, 4.0, 5.0},
                arr.map(input, new double[input.length], i -> (double) i));
    }

    @Test
    void IntArrays() {
        int[] input = {1, 2, 3, 4, 5};

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], i -> i < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], i -> (byte) i));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], i -> (char) ('A' + i - 1)));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], i -> (short) i));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], i -> i));

        assertArrayEquals(
                new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f},
                arr.map(input, new float[input.length], i -> (float) i));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, new long[input.length], i -> (long) i));

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0, 4.0, 5.0},
                arr.map(input, new double[input.length], i -> (double) i));
    }

    @Test
    void FloatArrays() {
        float[] input = {1.0f, 2.5f, 3.75f, 4.0f, 5.5f};

        assertArrayEquals(
                new String[]{"1.0", "2.5", "3.75", "4.0", "5.5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], f -> f < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], f -> (byte) f));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], f -> (char) ('A' + (int) f - 1)));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], f -> (short) f));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], f -> (int) f));

        assertArrayEquals(
                new float[]{1.0f, 2.5f, 3.75f, 4.0f, 5.5f},
                arr.map(input, new float[input.length], f -> f));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, new long[input.length], f -> (long) f));

        assertArrayEquals(
                new double[]{1.0, 2.5, 3.75, 4.0, 5.5},
                arr.map(input, new double[input.length], f -> (double) f));
    }


    @Test
    void DoubleArrays() {
        double[] input = {1.1, 2.2, 3.3, 4.4, 5.5};

        assertArrayEquals(
                new String[]{"1.1", "2.2", "3.3", "4.4", "5.5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], d -> d < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], d -> (byte) d));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], d -> (char) ('A' + (int) (d - 1))));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], d -> (short) d));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], d -> (int) d));

        assertArrayEquals(
                new float[]{1.1f, 2.2f, 3.3f, 4.4f, 5.5f},
                arr.map(input, new float[input.length], d -> (float) d));

        assertArrayEquals(
                new long[]{1, 2, 3, 4, 5},
                arr.map(input, new long[input.length], d -> (long) d));
    }
}
