package com.wniemiec.component.control;

import com.wniemiec.component.type.SegmentPositionType;

import java.util.List;

public interface ModuleControl<T> {

    List<SegmentPositionType> getSegments(T t);
}
