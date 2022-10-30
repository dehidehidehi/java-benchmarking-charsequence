package com.github.dehidehidehi.lowlatencyjava.charsequence.impl;
import java.nio.CharBuffer;

public class StringViewImpl implements CharSequence {

    private CharBuffer buffer;
    private int start;
    private int length;

    public void set(final CharBuffer buffer, final int start, final int length) {
        this.buffer = buffer;
        this.start = start;
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(final int index) {
        return buffer.get(start + index);
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        throw new IllegalStateException("Implementation not designed for spending heap memory.");
    }

    @Override
    public String toString() {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = buffer.get(start + i);
        }
        return new String(chars);
    }
}
