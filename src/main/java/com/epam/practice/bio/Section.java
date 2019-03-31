package com.epam.practice.bio;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Objects;

@Value
@RequiredArgsConstructor
public class Section implements Comparable<Section> {

    public static final int NUM_OF_LETTERS_IN_LONG = 32;

    private final int numOfSymbolsInLastLong;
    private final long[] arr;

    //Store string representation or not?
    //private String string;

    public Section(String inputString) {
        // 32 symbols (2 bit) in 1 Long
        this.numOfSymbolsInLastLong = inputString.length() % NUM_OF_LETTERS_IN_LONG;
        int numOfLongs = (inputString.length() - numOfSymbolsInLastLong) / NUM_OF_LETTERS_IN_LONG;

        if (numOfSymbolsInLastLong != 0) {
            numOfLongs++;
        }

        // n * 2 num of bits
        arr = new long[numOfLongs];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0L;
        }

        for (int i = 0; i < inputString.length(); i++) {
            int shift = i % NUM_OF_LETTERS_IN_LONG;
            int numOfLong = (i - shift) / NUM_OF_LETTERS_IN_LONG;
            long code = fromChar(inputString.charAt(i));
            arr[numOfLong] |= code << (shift * 2);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int numOfLetters = (arr.length - 1) * NUM_OF_LETTERS_IN_LONG + numOfSymbolsInLastLong;
        for (int i = 0; i < numOfLetters; i++) {
            int shift = i % NUM_OF_LETTERS_IN_LONG;
            int numOfLong = (i - shift) / NUM_OF_LETTERS_IN_LONG;
            byte byteRepresentation = (byte) (0b11 & (arr[numOfLong] >>> (shift * 2)));
            builder.append(fromMask(byteRepresentation));
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || other != null && getClass() == other.getClass()
                && Objects.equals(this.toString(), other.toString());
    }

    public static char fromMask(byte a) {
        switch (a) {
            case 0b00:
                return 65;
            case 0b01:
                return 67;
            case 0b10:
                return 71;
            case 0b11:
                return 84;
            default:
                return 00;
        }
    }

    public long fromChar(char a) {
        switch (a) {
            case 65:
                return 0b00;
            case 67:
                return 0b01;
            case 71:
                return 0b10;
            case 84:
                return 0b11;
            default:
                return 00;
        }
    }

    @Override
    public int compareTo(Section o) {
        for (int i = 0; i < arr.length; i++) {
            int compare = Long.compare(arr[i], o.arr[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}
