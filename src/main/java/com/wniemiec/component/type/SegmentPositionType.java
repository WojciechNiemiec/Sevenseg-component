package com.wniemiec.component.type;

import com.wniemiec.component.util.Positioners;
import com.wniemiec.component.Segment;

import java.util.function.Consumer;

public enum SegmentPositionType {
    TOP(Positioners.top()),
    CENTER(Positioners.center()),
    BOTTOM(Positioners.bottom()),
    TOP_LEFT(Positioners.topLeft()),
    TOP_RIGHT(Positioners.topRight()),
    BOTTOM_LEFT(Positioners.bottomLeft()),
    BOTTOM_RIGHT(Positioners.bottomRight());

    SegmentPositionType(Consumer<Segment> positioner) {
        this.positioner = positioner;
    }

    private Consumer<Segment> positioner;

    public Consumer<Segment> getPositioner() {
        return positioner;
    }
}
