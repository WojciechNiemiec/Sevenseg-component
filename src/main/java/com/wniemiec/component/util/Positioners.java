package com.wniemiec.component.util;

import com.wniemiec.component.Segment;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public final class Positioners {

    private Positioners() {
    }

    public static Consumer<Segment> top() {
        return segment -> positionHorizontally(
                segment,
                (seg, thickness) -> thickness
        );
    }

    public static Consumer<Segment> center() {
        return segment -> positionHorizontally(
                segment,
                (seg, thickness) -> PositionerUtils.getModuleHeight(seg) / 2 - thickness / 2
        );
    }

    public static Consumer<Segment> bottom() {
        return segment -> positionHorizontally(
                segment,
                (seg, thickness) -> PositionerUtils.getModuleHeight(seg) - thickness * 2
        );
    }

    public static Consumer<Segment> topLeft() {
        return segment -> positionVertically(
                segment,
                PositionerUtils.leftSegmentXResolver()
        );
    }

    public static Consumer<Segment> topRight() {
        return segment -> positionVertically(
                segment,
                PositionerUtils.rightSegmentXResolver()
        );
    }

    public static Consumer<Segment> bottomLeft() {
        return segment -> positionVertically(
                segment,
                PositionerUtils.leftSegmentXResolver(),
                PositionerUtils.verticalBottomYResolver()
        );
    }

    public static Consumer<Segment> bottomRight() {
        return segment -> positionVertically(
                segment,
                PositionerUtils.rightSegmentXResolver(),
                PositionerUtils.verticalBottomYResolver()
        );
    }

    private static void positionHorizontally(Segment segment, BiFunction<Segment, Integer, Integer> yResolver) {
        int thickness = PositionerUtils.getSegmentThickness(segment);

        int x = PositionerUtils.getMargin(thickness);
        int y = yResolver.apply(segment, thickness);

        segment.setLocation(x, y);
        segment.setSize(PositionerUtils.getSegmentWidth(segment, x), thickness);
    }

    private static void positionVertically(Segment segment, BiFunction<Segment, Integer, Integer> xResolver) {
        positionVertically(
                segment,
                xResolver,
                (seg, thickness) -> PositionerUtils.getMargin(thickness)
        );
    }

    private static void positionVertically(Segment segment,
                                           BiFunction<Segment, Integer, Integer> xResolver,
                                           BiFunction<Segment, Integer, Integer> yResolver) {
        int thickness = PositionerUtils.getSegmentThickness(segment);

        int x = xResolver.apply(segment, thickness);
        int y = yResolver.apply(segment, thickness);

        segment.setLocation(x, y);
        segment.setSize(thickness, PositionerUtils.getSegmentHeight(segment, thickness));
    }
}
