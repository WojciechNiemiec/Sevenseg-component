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
                createSegment(SegmentPositionType.TOP),
                createSegment(SegmentPositionType.CENTER),
                createSegment(SegmentPositionType.BOTTOM),
                createSegment(SegmentPositionType.TOP_LEFT),
                createSegment(SegmentPositionType.TOP_RIGHT),
                createSegment(SegmentPositionType.BOTTOM_LEFT),
                createSegment(SegmentPositionType.BOTTOM_RIGHT)
        ).peek(module::add)
                .peek(segment -> segment.setModule(module))
                .collect(Collectors.toMap(Segment::getSegmentPositionType, Function.identity()));
    }

    private static Segment createSegment(SegmentPositionType segmentPositionType) {
        return new Segment(segmentPositionType);
    }
}
