package com.urlshortener.valueobject;

import java.io.Serializable;

public abstract class BaseId<T> implements Serializable {
    private T value;

    public BaseId() {
    }

    public BaseId(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
