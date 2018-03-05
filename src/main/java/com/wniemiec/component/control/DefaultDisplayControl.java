package com.wniemiec.component.control;

import com.wniemiec.component.type.SegmentPositionType;

import java.util.List;

public class DefaultDisplayControl implements DisplayControl<Integer> {

    private ModuleControl<Integer> moduleControl = DefaultModuleControl.getInstance();

    @Override
    public Integer split(int index, Integer data) {
        return data / (int)Math.pow(10, index);
    }

    @Override
    public List<SegmentPositionType> getSegments(Integer integer) {
        return moduleControl.getSegments(integer);
    }
}
