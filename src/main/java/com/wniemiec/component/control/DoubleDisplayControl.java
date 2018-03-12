package com.wniemiec.component.control;

import com.wniemiec.component.SevenSegmentModule;
import com.wniemiec.component.type.SegmentPositionType;

import java.util.List;

public class DoubleDisplayControl implements DisplayControl<Double, Character> {

    private DisplayControl<String, Character> delegate = new DefaultDisplayControl();

    @Override
    public void light(List<SevenSegmentModule<Character>> sevenSegmentModules, Double value) {
        delegate.light(sevenSegmentModules, String.valueOf(value));
    }

    @Override
    public List<SegmentPositionType> getSegments(Character character) {
        return delegate.getSegments(character);
    }
}
