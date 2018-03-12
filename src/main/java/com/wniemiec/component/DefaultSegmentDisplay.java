package com.wniemiec.component;

import com.wniemiec.component.control.DefaultDisplayControl;

public class DefaultSegmentDisplay extends SevenSegmentDisplay<String, Character> {

    private static final int DEFAULT_MODULES_COUNT = 8;

    public DefaultSegmentDisplay() {
        super(new DefaultDisplayControl(), DEFAULT_MODULES_COUNT);
    }
}
