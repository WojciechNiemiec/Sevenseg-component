package com.wniemiec.component.control;

import com.wniemiec.component.Dot;
import com.wniemiec.component.SevenSegmentModule;
import com.wniemiec.component.type.SegmentPositionType;

import java.util.List;

public class DoubleDisplayControl implements DisplayControl<Double, Character> {

    private DisplayControl<String, Character> delegate = new DefaultDisplayControl();

    @Override
    public void light(List<SevenSegmentModule<Character>> sevenSegmentModules, List<Dot> dots, Double value) {
        delegate.light(sevenSegmentModules, dots, String.valueOf(value));
    }

    @Override
    public List<SegmentPositionType> getSegments(Character character) {
        return delegate.getSegments(character);
    }
}
