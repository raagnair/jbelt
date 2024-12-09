package com.raagnair.belt;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static com.raagnair.belt.ArrayTools.*;
import static com.raagnair.belt.Belt.arr;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayToolsTest {

    @Test
    void GenericArrays() {
        String[] input = {"alpha", "bravo", "charlie", "delta", "epsilon"};

        assertArrayEquals(
                new Integer[]{5, 5, 7, 5, 7},
                arr.map(input, String::length));

        assertArrayEquals(
                new Integer[]{5, 5, 7, 5, 7},
                arr.map(input, new Integer[5], String::length));
    }

    @Test
    void StringArrays_Windows() {
        String[] input = {"one", "two", "three", "four", "five"};
        Iterator<String[]> stringWindowIter;
        String[] firstWindow, secondWindow;

        stringWindowIter = arr.windows(input, 2, String[]::new);
        assertArrayEquals(new String[]{"one", "two"}, stringWindowIter.next());
        assertArrayEquals(new String[]{"three", "four"}, stringWindowIter.next());
        assertArrayEquals(new String[]{"five"}, stringWindowIter.next());
        assertFalse(stringWindowIter.hasNext());

        stringWindowIter = arr.windows(input, 3, 1, String[]::new);
        assertArrayEquals(new String[]{"one", "two", "three"}, stringWindowIter.next());
        assertArrayEquals(new String[]{"two", "three", "four"}, stringWindowIter.next());
        assertArrayEquals(new String[]{"three", "four", "five"}, stringWindowIter.next());
        assertFalse(stringWindowIter.hasNext());

        stringWindowIter = arr.windows(input, 3, 2, String[]::new);
        assertArrayEquals(new String[]{"one", "two", "three"}, stringWindowIter.next());
        assertArrayEquals(new String[]{"three", "four", "five"}, stringWindowIter.next());
        assertFalse(stringWindowIter.hasNext());

        stringWindowIter = arr.windows(input, 3, 3, String[]::new);
        assertArrayEquals(new String[]{"one", "two", "three"}, stringWindowIter.next());
        assertArrayEquals(new String[]{"four", "five"}, stringWindowIter.next());
        assertFalse(stringWindowIter.hasNext());

        stringWindowIter = arr.windows(input, 3, 2, String[]::new, true);
        firstWindow = stringWindowIter.next();
        assertArrayEquals(new String[]{"one", "two", "three"}, firstWindow);
        secondWindow = stringWindowIter.next();
        assertArrayEquals(new String[]{"three", "four", "five"}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(stringWindowIter.hasNext());

        stringWindowIter = arr.windows(input, 2, 2, String[]::new, true);
        firstWindow = stringWindowIter.next();
        assertArrayEquals(new String[]{"one", "two"}, firstWindow);
        secondWindow = stringWindowIter.next();
        assertArrayEquals(new String[]{"three", "four"}, secondWindow);
        var thirdWindow = stringWindowIter.next();
        assertArrayEquals(new String[]{"five"}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }


    @Test
    void BooleanArrays() {
        boolean[] input = {true, true, false, false, true};

        assertArrayEquals(
                new String[]{"true", "true", "false", "false", "true"},
                arr.map(input, (boolean in) -> String.valueOf(in)));

        assertArrayEquals(
                new String[]{"true", "true", "false", "false", "true"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new String[]{"true", "true", "false", "false", "true"},
                arr.map(input, (boolean in) -> String.valueOf(in)));

        assertArrayEquals(
                new String[]{"true", "true", "false", "false", "true"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, true, true, false},
                arr.map(input, (boolean in) -> !in));

        assertArrayEquals(
                new boolean[]{false, false, true, true, false},
                arr.map(input, new boolean[input.length], in -> !in));

        assertArrayEquals(
                new byte[]{1, 1, 0, 0, 1},
                arr.map(input, (boolean in) -> in ? (byte) 1 : 0));

        assertArrayEquals(
                new byte[]{1, 1, 0, 0, 1},
                arr.map(input, new byte[input.length], in -> in ? (byte) 1 : 0));

        assertArrayEquals(
                new char[]{'t', 't', 'f', 'f', 't'},
                arr.map(input,  (boolean in) -> in ? 't' : 'f'));

        assertArrayEquals(
                new char[]{'t', 't', 'f', 'f', 't'},
                arr.map(input, new char[input.length], in -> in ? 't' : 'f'));

        assertArrayEquals(
                new short[]{1, 1, 0, 0, 1},
                arr.map(input, (boolean in) -> in ? (short) 1 : 0));

        assertArrayEquals(
                new short[]{1, 1, 0, 0, 1},
                arr.map(input, new short[input.length], in -> in ? (short) 1 : 0));

        assertArrayEquals(
                new int[]{1, 1, 0, 0, 1},
                arr.map(input, (boolean in) -> in ? 1 : 0));

        assertArrayEquals(
                new int[]{1, 1, 0, 0, 1},
                arr.map(input, new int[input.length], in -> in ? 1 : 0));

        assertArrayEquals(
                new float[]{1, 1, 0, 0, 1},
                arr.map(input, (boolean in) -> in ? (float) 1 : 0));

        assertArrayEquals(
                new float[]{1, 1, 0, 0, 1},
                arr.map(input, new float[input.length], in -> in ? (float) 1 : 0));

        assertArrayEquals(
                new long[]{1, 1, 0, 0, 1},
                arr.map(input, (boolean in) -> in ? (long) 1 : 0));

        assertArrayEquals(
                new long[]{1, 1, 0, 0, 1},
                arr.map(input, new long[input.length], in -> in ? (long) 1 : 0));

        assertArrayEquals(
                new double[]{1, 1, 0, 0, 1},
                arr.map(input, (boolean in) -> in ? (double) 1 : 0));

        assertArrayEquals(
                new double[]{1, 1, 0, 0, 1},
                arr.map(input, new double[input.length], in -> in ? (double) 1 : 0));

    }

    @Test
    void BooleanArrays_Windows() {
        boolean[] input = {true, true, false, false, true};
        Iterator<boolean[]> boolWindowIter;
        boolean[] firstWindow, secondWindow;

        boolWindowIter = arr.windows(input, 2);
        assertArrayEquals(new boolean[]{true, true}, boolWindowIter.next());
        assertArrayEquals(new boolean[]{false, false}, boolWindowIter.next());
        assertArrayEquals(new boolean[]{true}, boolWindowIter.next());
        assertFalse(boolWindowIter.hasNext());

        boolWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new boolean[]{true, true, false}, boolWindowIter.next());
        assertArrayEquals(new boolean[]{true, false, false}, boolWindowIter.next());
        assertArrayEquals(new boolean[]{false, false, true}, boolWindowIter.next());
        assertFalse(boolWindowIter.hasNext());

        boolWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new boolean[]{true, true, false}, boolWindowIter.next());
        assertArrayEquals(new boolean[]{false, false, true}, boolWindowIter.next());
        assertFalse(boolWindowIter.hasNext());

        boolWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new boolean[]{true, true, false}, boolWindowIter.next());
        assertArrayEquals(new boolean[]{false, true}, boolWindowIter.next());
        assertFalse(boolWindowIter.hasNext());

        boolWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = boolWindowIter.next();
        assertArrayEquals(new boolean[]{true, true, false}, firstWindow);
        secondWindow = boolWindowIter.next();
        assertArrayEquals(new boolean[]{false, false, true}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(boolWindowIter.hasNext());

        boolWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = boolWindowIter.next();
        assertArrayEquals(new boolean[]{true, true}, firstWindow);
        secondWindow = boolWindowIter.next();
        assertArrayEquals(new boolean[]{false, false}, secondWindow);
        var thirdWindow = boolWindowIter.next();
        assertArrayEquals(new boolean[]{true}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }

    @Test
    void ByteArrays() {
        byte[] input = {1, 2, 3, 4, 5};

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, (byte i) -> String.valueOf(i)));

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, (byte i) -> String.valueOf(i)));

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, true, false, true, false},
                arr.map(input,  (byte b) -> b % 2 == 0));

        assertArrayEquals(
                new boolean[]{false, true, false, true, false},
                arr.map(input, new boolean[input.length], b -> b % 2 == 0));
        assertArrayEquals(
                new byte[]{2, 3, 4, 5, 6},
                arr.map(input, (byte b) -> (byte) (b + 1)));

        assertArrayEquals(
                new byte[]{2, 3, 4, 5, 6},
                arr.map(input, new byte[input.length], b -> (byte) (b + 1)));

        assertArrayEquals(
                new char[]{'\u0001', '\u0002', '\u0003', '\u0004', '\u0005'},
                arr.map(input, (byte b) -> (char) b));

        assertArrayEquals(
                new char[]{'\u0001', '\u0002', '\u0003', '\u0004', '\u0005'},
                arr.map(input, new char[input.length], b -> (char) b));

        assertArrayEquals(
                new short[]{11, 12, 13, 14, 15},
                arr.map(input, (byte b) -> (short) (b + 10)));

        assertArrayEquals(
                new short[]{11, 12, 13, 14, 15},
                arr.map(input, new short[input.length], b -> (short) (b + 10)));

        assertArrayEquals(
                new int[]{11, 12, 13, 14, 15},
                arr.map(input, (byte b) -> b + 10));

        assertArrayEquals(
                new int[]{11, 12, 13, 14, 15},
                arr.map(input, new int[input.length], b -> b + 10));

        assertArrayEquals(
                new float[]{0.5f, 1.0f, 1.5f, 2.0f, 2.5f},
                arr.map(input, (byte b) -> b / 2.0f));

        assertArrayEquals(
                new float[]{0.5f, 1.0f, 1.5f, 2.0f, 2.5f},
                arr.map(input, new float[input.length], b -> b / 2.0f));

        assertArrayEquals(
                new long[]{100, 200, 300, 400, 500},
                arr.map(input, (byte b) -> b * 100L));

        assertArrayEquals(
                new long[]{100, 200, 300, 400, 500},
                arr.map(input, new long[input.length], b -> b * 100L));

        assertArrayEquals(
                new double[]{0.1, 0.2, 0.3, 0.4, 0.5},
                arr.map(input, (byte b) -> b / 10.0));

        assertArrayEquals(
                new double[]{0.1, 0.2, 0.3, 0.4, 0.5},
                arr.map(input, new double[input.length], b -> b / 10.0));
    }

    @Test
    void ByteArrays_Windows() {
        byte[] input = {1, 2, 3, 4, 5};
        Iterator<byte[]> byteWindowIter;
        byte[] firstWindow, secondWindow;

        byteWindowIter = arr.windows(input, 2);
        assertArrayEquals(new byte[]{1, 2}, byteWindowIter.next());
        assertArrayEquals(new byte[]{3, 4}, byteWindowIter.next());
        assertArrayEquals(new byte[]{5}, byteWindowIter.next());
        assertFalse(byteWindowIter.hasNext());

        byteWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new byte[]{1, 2, 3}, byteWindowIter.next());
        assertArrayEquals(new byte[]{2, 3, 4}, byteWindowIter.next());
        assertArrayEquals(new byte[]{3, 4, 5}, byteWindowIter.next());
        assertFalse(byteWindowIter.hasNext());

        byteWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new byte[]{1, 2, 3}, byteWindowIter.next());
        assertArrayEquals(new byte[]{3, 4, 5}, byteWindowIter.next());
        assertFalse(byteWindowIter.hasNext());

        byteWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new byte[]{1, 2, 3}, byteWindowIter.next());
        assertArrayEquals(new byte[]{4, 5}, byteWindowIter.next());
        assertFalse(byteWindowIter.hasNext());

        byteWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = byteWindowIter.next();
        assertArrayEquals(new byte[]{1, 2, 3}, firstWindow);
        secondWindow = byteWindowIter.next();
        assertArrayEquals(new byte[]{3, 4, 5}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(byteWindowIter.hasNext());

        byteWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = byteWindowIter.next();
        assertArrayEquals(new byte[]{1, 2}, firstWindow);
        secondWindow = byteWindowIter.next();
        assertArrayEquals(new byte[]{3, 4}, secondWindow);
        var thirdWindow = byteWindowIter.next();
        assertArrayEquals(new byte[]{5}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }

    @Test
    void CharArrays() {
        char[] input = {'a', 'b', 'c', 'd', 'e'};

        assertArrayEquals(
                new String[]{"a", "b", "c", "d", "e"},
                arr.map(input, (char c) -> String.valueOf(c)));

        assertArrayEquals(
                new String[]{"a", "b", "c", "d", "e"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, (char c) -> Character.isUpperCase(c)));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], Character::isUpperCase));

        assertArrayEquals(
                new byte[]{97, 98, 99, 100, 101},
                arr.map(input, (char c) -> (byte) c));

        assertArrayEquals(
                new byte[]{97, 98, 99, 100, 101},
                arr.map(input, new byte[input.length], c -> (byte) c));

        assertArrayEquals(
                new char[]{'b', 'c', 'd', 'e', 'f'},
                arr.map(input, (char c) -> (char) (c + 1)));

        assertArrayEquals(
                new char[]{'b', 'c', 'd', 'e', 'f'},
                arr.map(input, new char[input.length], c -> (char) (c + 1)));

        assertArrayEquals(
                new short[]{97, 98, 99, 100, 101},
                arr.map(input, (char c) -> (short) c));

        assertArrayEquals(
                new short[]{97, 98, 99, 100, 101},
                arr.map(input, new short[input.length], c -> (short) c));

        assertArrayEquals(
                new int[]{97, 98, 99, 100, 101},
                arr.map(input, (char c) -> (int) c));

        assertArrayEquals(
                new int[]{97, 98, 99, 100, 101},
                arr.map(input, new int[input.length], c -> c));

        assertArrayEquals(
                new float[]{97.0f, 98.0f, 99.0f, 100.0f, 101.0f},
                arr.map(input, (char c) -> (float) c));

        assertArrayEquals(
                new float[]{97.0f, 98.0f, 99.0f, 100.0f, 101.0f},
                arr.map(input, new float[input.length], c -> (float) c));

        assertArrayEquals(
                new long[]{970L, 980L, 990L, 1000L, 1010L},
                arr.map(input, (char c) -> (long) c * 10));

        assertArrayEquals(
                new long[]{970L, 980L, 990L, 1000L, 1010L},
                arr.map(input, new long[input.length], c -> (long) c * 10));

        assertArrayEquals(
                new double[]{0.97, 0.98, 0.99, 1.0, 1.01},
                arr.map(input, (char c) -> c / 100.0));

        assertArrayEquals(
                new double[]{0.97, 0.98, 0.99, 1.0, 1.01},
                arr.map(input, new double[input.length], c -> c / 100.0));

    }

    @Test
    void CharArrays_Windows() {
        char[] input = {'a', 'b', 'c', 'd', 'e'};
        Iterator<char[]> charWindowIter;
        char[] firstWindow, secondWindow;

        charWindowIter = arr.windows(input, 2);
        assertArrayEquals(new char[]{'a', 'b'}, charWindowIter.next());
        assertArrayEquals(new char[]{'c', 'd'}, charWindowIter.next());
        assertArrayEquals(new char[]{'e'}, charWindowIter.next());
        assertFalse(charWindowIter.hasNext());

        charWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new char[]{'a', 'b', 'c'}, charWindowIter.next());
        assertArrayEquals(new char[]{'b', 'c', 'd'}, charWindowIter.next());
        assertArrayEquals(new char[]{'c', 'd', 'e'}, charWindowIter.next());
        assertFalse(charWindowIter.hasNext());

        charWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new char[]{'a', 'b', 'c'}, charWindowIter.next());
        assertArrayEquals(new char[]{'c', 'd', 'e'}, charWindowIter.next());
        assertFalse(charWindowIter.hasNext());

        charWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new char[]{'a', 'b', 'c'}, charWindowIter.next());
        assertArrayEquals(new char[]{'d', 'e'}, charWindowIter.next());
        assertFalse(charWindowIter.hasNext());

        charWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = charWindowIter.next();
        assertArrayEquals(new char[]{'a', 'b', 'c'}, firstWindow);
        secondWindow = charWindowIter.next();
        assertArrayEquals(new char[]{'c', 'd', 'e'}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(charWindowIter.hasNext());

        charWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = charWindowIter.next();
        assertArrayEquals(new char[]{'a', 'b'}, firstWindow);
        secondWindow = charWindowIter.next();
        assertArrayEquals(new char[]{'c', 'd'}, secondWindow);
        var thirdWindow = charWindowIter.next();
        assertArrayEquals(new char[]{'e'}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }

    @Test
    void ShortArrays() {
        short[] input = {1, 2, 3, 4, 5};
        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, (short i) -> String.valueOf(i)));

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, (short i) -> i < 0));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], i -> i < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, (short i) -> (byte) i));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], i -> (byte) i));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, (short i) -> (char) ('A' + i - 1)));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], i -> (char) ('A' + i - 1)));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, (short i) -> i));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], i -> i));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, (short i) -> (int) i));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], i -> i));

        assertArrayEquals(
                new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f},
                arr.map(input, (short i) -> (float) i));

        assertArrayEquals(
                new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f},
                arr.map(input, new float[input.length], i -> (float) i));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, (short i) -> (long) i));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, new long[input.length], i -> (long) i));

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0, 4.0, 5.0},
                arr.map(input, (short i) -> (double) i));

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0, 4.0, 5.0},
                arr.map(input, new double[input.length], i -> (double) i));
    }

    @Test
    void ShortArrays_Windows() {
        short[] input = {1, 2, 3, 4, 5};
        Iterator<short[]> shortWindowIter;
        short[] firstWindow, secondWindow;

        shortWindowIter = arr.windows(input, 2);
        assertArrayEquals(new short[]{1, 2}, shortWindowIter.next());
        assertArrayEquals(new short[]{3, 4}, shortWindowIter.next());
        assertArrayEquals(new short[]{5}, shortWindowIter.next());
        assertFalse(shortWindowIter.hasNext());

        shortWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new short[]{1, 2, 3}, shortWindowIter.next());
        assertArrayEquals(new short[]{2, 3, 4}, shortWindowIter.next());
        assertArrayEquals(new short[]{3, 4, 5}, shortWindowIter.next());
        assertFalse(shortWindowIter.hasNext());

        shortWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new short[]{1, 2, 3}, shortWindowIter.next());
        assertArrayEquals(new short[]{3, 4, 5}, shortWindowIter.next());
        assertFalse(shortWindowIter.hasNext());

        shortWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new short[]{1, 2, 3}, shortWindowIter.next());
        assertArrayEquals(new short[]{4, 5}, shortWindowIter.next());
        assertFalse(shortWindowIter.hasNext());

        shortWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = shortWindowIter.next();
        assertArrayEquals(new short[]{1, 2, 3}, firstWindow);
        secondWindow = shortWindowIter.next();
        assertArrayEquals(new short[]{3, 4, 5}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(shortWindowIter.hasNext());

        shortWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = shortWindowIter.next();
        assertArrayEquals(new short[]{1, 2}, firstWindow);
        secondWindow = shortWindowIter.next();
        assertArrayEquals(new short[]{3, 4}, secondWindow);
        var thirdWindow = shortWindowIter.next();
        assertArrayEquals(new short[]{5}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }

    @Test
    void IntArrays() {
        int[] input = {1, 2, 3, 4, 5};

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, (int i) -> String.valueOf(i)));

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, (int i) -> i < 0));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], i -> i < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, (int i) -> (byte) i));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], i -> (byte) i));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, (int i) -> (char) ('A' + i - 1)));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], i -> (char) ('A' + i - 1)));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, (int i) -> (short) i));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], i -> (short) i));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, (int i) -> i));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], i -> i));

        assertArrayEquals(
                new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f},
                arr.map(input, (int i) -> (float) i));

        assertArrayEquals(
                new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f},
                arr.map(input, new float[input.length], i -> (float) i));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, (int i) -> (long) i));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, new long[input.length], i -> (long) i));

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0, 4.0, 5.0},
                arr.map(input, (int i) -> (double) i));

        assertArrayEquals(
                new double[]{1.0, 2.0, 3.0, 4.0, 5.0},
                arr.map(input, new double[input.length], i -> (double) i));
    }

    @Test
    void IntArrays_Windows() {
        int[] input = {1, 2, 3, 4, 5};
        Iterator<int[]> intWindowIter;
        int[] firstWindow, secondWindow;

        intWindowIter = arr.windows(input, 2);
        assertArrayEquals(new int[]{1, 2}, intWindowIter.next());
        assertArrayEquals(new int[]{3, 4}, intWindowIter.next());
        assertArrayEquals(new int[]{5}, intWindowIter.next());
        assertFalse(intWindowIter.hasNext());

        intWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new int[]{1, 2, 3}, intWindowIter.next());
        assertArrayEquals(new int[]{2, 3, 4}, intWindowIter.next());
        assertArrayEquals(new int[]{3, 4, 5}, intWindowIter.next());
        assertFalse(intWindowIter.hasNext());

        intWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new int[]{1, 2, 3}, intWindowIter.next());
        assertArrayEquals(new int[]{3, 4, 5}, intWindowIter.next());
        assertFalse(intWindowIter.hasNext());

        intWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new int[]{1, 2, 3}, intWindowIter.next());
        assertArrayEquals(new int[]{4, 5}, intWindowIter.next());
        assertFalse(intWindowIter.hasNext());

        intWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = intWindowIter.next();
        assertArrayEquals(new int[]{1, 2, 3}, firstWindow);
        secondWindow = intWindowIter.next();
        assertArrayEquals(new int[]{3, 4, 5}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(intWindowIter.hasNext());

        intWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = intWindowIter.next();
        assertArrayEquals(new int[]{1, 2}, firstWindow);
        secondWindow = intWindowIter.next();
        assertArrayEquals(new int[]{3, 4}, secondWindow);
        var thirdWindow = intWindowIter.next();
        assertArrayEquals(new int[]{5}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }

    @Test
    void FloatArrays() {
        float[] input = {1.0f, 2.5f, 3.75f, 4.0f, 5.5f};

        assertArrayEquals(
                new String[]{"1.0", "2.5", "3.75", "4.0", "5.5"},
                arr.map(input, (float f) -> String.valueOf(f)));

        assertArrayEquals(
                new String[]{"1.0", "2.5", "3.75", "4.0", "5.5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, (float f) -> f < 0));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], f -> f < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, (float f) -> (byte) f));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], f -> (byte) f));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, (float f) -> (char) ('A' + (int) f - 1)));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], f -> (char) ('A' + (int) f - 1)));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, (float f) -> (short) f));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], f -> (short) f));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, (float f) -> (int) f));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], f -> (int) f));

        assertArrayEquals(
                new float[]{1.0f, 2.5f, 3.75f, 4.0f, 5.5f},
                arr.map(input, (float f) -> f));

        assertArrayEquals(
                new float[]{1.0f, 2.5f, 3.75f, 4.0f, 5.5f},
                arr.map(input, new float[input.length], f -> f));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, (float f) -> (long) f));

        assertArrayEquals(
                new long[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, new long[input.length], f -> (long) f));

        assertArrayEquals(
                new double[]{1.0, 2.5, 3.75, 4.0, 5.5},
                arr.map(input, (float f) -> (double) f));

        assertArrayEquals(
                new double[]{1.0, 2.5, 3.75, 4.0, 5.5},
                arr.map(input, new double[input.length], f -> (double) f));
    }

    @Test
    void FloatArrays_Windows() {
        float[] input = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        Iterator<float[]> floatWindowIter;
        float[] firstWindow, secondWindow;

        floatWindowIter = arr.windows(input, 2);
        assertArrayEquals(new float[]{1.1f, 2.2f}, floatWindowIter.next());
        assertArrayEquals(new float[]{3.3f, 4.4f}, floatWindowIter.next());
        assertArrayEquals(new float[]{5.5f}, floatWindowIter.next());
        assertFalse(floatWindowIter.hasNext());

        floatWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new float[]{1.1f, 2.2f, 3.3f}, floatWindowIter.next());
        assertArrayEquals(new float[]{2.2f, 3.3f, 4.4f}, floatWindowIter.next());
        assertArrayEquals(new float[]{3.3f, 4.4f, 5.5f}, floatWindowIter.next());
        assertFalse(floatWindowIter.hasNext());

        floatWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new float[]{1.1f, 2.2f, 3.3f}, floatWindowIter.next());
        assertArrayEquals(new float[]{3.3f, 4.4f, 5.5f}, floatWindowIter.next());
        assertFalse(floatWindowIter.hasNext());

        floatWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new float[]{1.1f, 2.2f, 3.3f}, floatWindowIter.next());
        assertArrayEquals(new float[]{4.4f, 5.5f}, floatWindowIter.next());
        assertFalse(floatWindowIter.hasNext());

        floatWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = floatWindowIter.next();
        assertArrayEquals(new float[]{1.1f, 2.2f, 3.3f}, firstWindow);
        secondWindow = floatWindowIter.next();
        assertArrayEquals(new float[]{3.3f, 4.4f, 5.5f}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(floatWindowIter.hasNext());

        floatWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = floatWindowIter.next();
        assertArrayEquals(new float[]{1.1f, 2.2f}, firstWindow);
        secondWindow = floatWindowIter.next();
        assertArrayEquals(new float[]{3.3f, 4.4f}, secondWindow);
        var thirdWindow = floatWindowIter.next();
        assertArrayEquals(new float[]{5.5f}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }

    @Test
    void LongArrays() {
        long[] input = {1L, 2L, 3L, 4L, 5L};

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, (long d) -> String.valueOf(d)));

        assertArrayEquals(
                new String[]{"1", "2", "3", "4", "5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, (long d) -> d < 0));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], d -> d < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, (long d) -> (byte) d));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], d -> (byte) d));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, (long d) -> (char) ('A' + (int) (d - 1))));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], d -> (char) ('A' + (int) (d - 1))));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, (long d) -> (short) d));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], d -> (short) d));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, (long d) -> (int) d));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], d -> (int) d));

        assertArrayEquals(
                new float[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, (long d) -> (float) d));

        assertArrayEquals(
                new float[]{1L, 2L, 3L, 4L, 5L},
                arr.map(input, new float[input.length], d -> (float) d));

        assertArrayEquals(
                new double[]{0.5, 1.0, 1.5, 2.0, 2.5},
                arr.map(input, (long d) -> (double) d / 2));

        assertArrayEquals(
                new double[]{0.5, 1.0, 1.5, 2.0, 2.5},
                arr.map(input, new double[input.length], d -> (double) d / 2));

        assertArrayEquals(
                new long[]{1, 2, 3, 4, 5},
                arr.map(input, (long d) -> d));

        assertArrayEquals(
                new long[]{1, 2, 3, 4, 5},
                arr.map(input, new long[input.length], d -> d));
    }

    @Test
    void LongArrays_Windows() {
        long[] input = {1L, 2L, 3L, 4L, 5L};
        Iterator<long[]> longWindowIter;
        long[] firstWindow, secondWindow;

        longWindowIter = arr.windows(input, 2);
        assertArrayEquals(new long[]{1L, 2L}, longWindowIter.next());
        assertArrayEquals(new long[]{3L, 4L}, longWindowIter.next());
        assertArrayEquals(new long[]{5L}, longWindowIter.next());
        assertFalse(longWindowIter.hasNext());

        longWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new long[]{1L, 2L, 3L}, longWindowIter.next());
        assertArrayEquals(new long[]{2L, 3L, 4L}, longWindowIter.next());
        assertArrayEquals(new long[]{3L, 4L, 5L}, longWindowIter.next());
        assertFalse(longWindowIter.hasNext());

        longWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new long[]{1L, 2L, 3L}, longWindowIter.next());
        assertArrayEquals(new long[]{3L, 4L, 5L}, longWindowIter.next());
        assertFalse(longWindowIter.hasNext());

        longWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new long[]{1L, 2L, 3L}, longWindowIter.next());
        assertArrayEquals(new long[]{4L, 5L}, longWindowIter.next());
        assertFalse(longWindowIter.hasNext());

        longWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = longWindowIter.next();
        assertArrayEquals(new long[]{1L, 2L, 3L}, firstWindow);
        secondWindow = longWindowIter.next();
        assertArrayEquals(new long[]{3L, 4L, 5L}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(longWindowIter.hasNext());

        longWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = longWindowIter.next();
        assertArrayEquals(new long[]{1L, 2L}, firstWindow);
        secondWindow = longWindowIter.next();
        assertArrayEquals(new long[]{3L, 4L}, secondWindow);
        var thirdWindow = longWindowIter.next();
        assertArrayEquals(new long[]{5L}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }

    @Test
    void DoubleArrays() {
        double[] input = {1.1, 2.2, 3.3, 4.4, 5.5};

        assertArrayEquals(
                new String[]{"1.1", "2.2", "3.3", "4.4", "5.5"},
                arr.map(input, (double d) -> String.valueOf(d)));

        assertArrayEquals(
                new String[]{"1.1", "2.2", "3.3", "4.4", "5.5"},
                arr.map(input, new String[input.length], String::valueOf));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, (double d) -> d < 0));

        assertArrayEquals(
                new boolean[]{false, false, false, false, false},
                arr.map(input, new boolean[input.length], d -> d < 0));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, (double d) -> (byte) d));

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                arr.map(input, new byte[input.length], d -> (byte) d));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, (double d) -> (char) ('A' + (int) (d - 1))));

        assertArrayEquals(
                new char[]{'A', 'B', 'C', 'D', 'E'},
                arr.map(input, new char[input.length], d -> (char) ('A' + (int) (d - 1))));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, (double d) -> (short) d));

        assertArrayEquals(
                new short[]{1, 2, 3, 4, 5},
                arr.map(input, new short[input.length], d -> (short) d));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, (double d) -> (int) d));

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                arr.map(input, new int[input.length], d -> (int) d));

        assertArrayEquals(
                new float[]{1.1f, 2.2f, 3.3f, 4.4f, 5.5f},
                arr.map(input, (double d) -> (float) d));

        assertArrayEquals(
                new float[]{1.1f, 2.2f, 3.3f, 4.4f, 5.5f},
                arr.map(input, new float[input.length], d -> (float) d));

        assertArrayEquals(
                new long[]{1, 2, 3, 4, 5},
                arr.map(input, (double d) -> (long) d));

        assertArrayEquals(
                new long[]{1, 2, 3, 4, 5},
                arr.map(input, new long[input.length], d -> (long) d));

        assertArrayEquals(
                new double[]{2.2, 4.4, 6.6, 8.8, 11},
                arr.map(input, (double d) -> d * 2));

        assertArrayEquals(
                new double[]{2.2, 4.4, 6.6, 8.8, 11},
                arr.map(input, new double[input.length], d -> d * 2));
    }

    @Test
    void DoubleArrays_Windows() {
        double[] input = {1.1, 2.2, 3.3, 4.4, 5.5};
        Iterator<double[]> doubleWindowIter;
        double[] firstWindow, secondWindow;

        doubleWindowIter = arr.windows(input, 2);
        assertArrayEquals(new double[]{1.1, 2.2}, doubleWindowIter.next());
        assertArrayEquals(new double[]{3.3, 4.4}, doubleWindowIter.next());
        assertArrayEquals(new double[]{5.5}, doubleWindowIter.next());
        assertFalse(doubleWindowIter.hasNext());

        doubleWindowIter = arr.windows(input, 3, 1);
        assertArrayEquals(new double[]{1.1, 2.2, 3.3}, doubleWindowIter.next());
        assertArrayEquals(new double[]{2.2, 3.3, 4.4}, doubleWindowIter.next());
        assertArrayEquals(new double[]{3.3, 4.4, 5.5}, doubleWindowIter.next());
        assertFalse(doubleWindowIter.hasNext());

        doubleWindowIter = arr.windows(input, 3, 2);
        assertArrayEquals(new double[]{1.1, 2.2, 3.3}, doubleWindowIter.next());
        assertArrayEquals(new double[]{3.3, 4.4, 5.5}, doubleWindowIter.next());
        assertFalse(doubleWindowIter.hasNext());

        doubleWindowIter = arr.windows(input, 3, 3);
        assertArrayEquals(new double[]{1.1, 2.2, 3.3}, doubleWindowIter.next());
        assertArrayEquals(new double[]{4.4, 5.5}, doubleWindowIter.next());
        assertFalse(doubleWindowIter.hasNext());

        doubleWindowIter = arr.windows(input, 3, 2, ReuseOutput.TRY);
        firstWindow = doubleWindowIter.next();
        assertArrayEquals(new double[]{1.1, 2.2, 3.3}, firstWindow);
        secondWindow = doubleWindowIter.next();
        assertArrayEquals(new double[]{3.3, 4.4, 5.5}, secondWindow);
        assertSame(firstWindow, secondWindow);
        assertFalse(doubleWindowIter.hasNext());

        doubleWindowIter = arr.windows(input, 2, 2, ReuseOutput.TRY);
        firstWindow = doubleWindowIter.next();
        assertArrayEquals(new double[]{1.1, 2.2}, firstWindow);
        secondWindow = doubleWindowIter.next();
        assertArrayEquals(new double[]{3.3, 4.4}, secondWindow);
        var thirdWindow = doubleWindowIter.next();
        assertArrayEquals(new double[]{5.5}, thirdWindow);
        assertSame(firstWindow, secondWindow);
        assertNotSame(firstWindow, thirdWindow);
    }
}
