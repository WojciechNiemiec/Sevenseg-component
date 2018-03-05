package com.wniemiec.component;

public interface DisplayControl<T> extends ModuleControl<T> {
    T split(int index, T data);
}
