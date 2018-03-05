package com.wniemiec.component.util;

import com.wniemiec.component.SevenSegmentModule;

import java.awt.*;

interface Locator {
    Point getLocation(SevenSegmentModule module, Integer margin);
}