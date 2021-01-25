package com.codedifferently.collections.sortedmap;

public class KeyVal<T> {
    private String hash;
    private T key;
    private T value;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;gi
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
