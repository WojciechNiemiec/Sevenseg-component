package com.wniemiec.component.util;

import com.wniemiec.component.Segment;
import com.wniemiec.component.SevenSegmentModule;
import com.wniemiec.component.type.SegmentPositionType;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SegmentFactory {

    private SegmentFactory() {
    }

    public static Map<SegmentPositionType, Segment> initializeSegments(SevenSegmentModule module) {
        return Stream.of(
                createSegment(module, SegmentPositionType.TOP),
                createSegment(module, SegmentPositionType.CENTER),
                createSegment(module, SegmentPositionType.BOTTOM),
                createSegment(module, SegmentPositionType.TOP_LEFT),
                createSegment(module, SegmentPositionType.TOP_RIGHT),
                createSegment(module, SegmentPositionType.BOTTOM_LEFT),
                createSegment(module, SegmentPositionType.BOTTOM_RIGHT)
        ).peek(module::add)
                .collect(Collectors.toMap(Segment::getSegmentPositionType, Function.identity()));
    }

    private static Segment createSegment(SevenSegmentModule module, SegmentPositionType segmentPositionType) {
        return new Segment(module, segmentPositionType);
    }
}
