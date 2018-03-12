package com.wniemiec.component;

import com.wniemiec.component.control.DoubleDisplayControl;

public class DoubleSegmentDisplay extends SevenSegmentDisplay<Double, Character> {
    public DoubleSegmentDisplay() {
        super(new DoubleDisplayControl(), 8);
    }
}
