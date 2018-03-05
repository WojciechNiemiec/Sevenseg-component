package com.wniemiec.component;

import com.wniemiec.component.type.SegmentPositionType;
import lombok.Getter;

import java.util.List;

public class DefaultDisplayControl implements DisplayControl<Integer> {

    @Getter
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
