package com.wniemiec.component.control;

import com.wniemiec.component.Dot;
import com.wniemiec.component.SevenSegmentModule;

import java.util.List;

public interface DisplayControl<T, V> extends ModuleControl<V> {
    void light(List<SevenSegmentModule<V>> modules, List<Dot> dots, T value);
}
