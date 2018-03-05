package com.wniemiec.component.control;

public interface DisplayControl<T> extends ModuleControl<T> {
    T split(int index, T data);
}
