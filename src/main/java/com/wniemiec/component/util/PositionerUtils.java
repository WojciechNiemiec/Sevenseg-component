package com.wniemiec.component.util;

import com.wniemiec.component.Segment;

import java.util.function.BiFunction;

public final class PositionerUtils {

    private PositionerUtils() {
    }

    private static final float BIG_MARGIN_MULTIPLIER = 1.75f;
    private static final float SMALL_MARGIN_MULTIPLIER = 0.25f;

    static int getMargin(int thickness) {
        return (int) (thickness * BIG_MARGIN_MULTIPLIER);
    }

    static int getSegmentThickness(Segment segment) {
        return segment.getModule().getSegmentThickness();
    }

    static int getSegmentWidth(Segment segment, int bigMargin) {
        return getModuleWidth(segment) - 2 * bigMargin;
    }

    static int getSegmentHeight(Segment segment, int thickness) {
        return getModuleHeight(segment) / 2 - 2 * thickness;
    }

    static int getModuleWidth(Segment segment) {
        return segment.getModule().getWidth();
    }

    static int getModuleHeight(Segment segment) {
        return segment.getModule().getHeight();
    }

    /**
     * Resolves Y coordinate for all vertical bottom segments.
     */
    static BiFunction<Segment, Integer, Integer> verticalBottomYResolver() {
        return (seg, thickness) -> getModuleHeight(seg) / 2 + (int) (thickness * SMALL_MARGIN_MULTIPLIER);
    }

    /**
     * Resolves X coordinate for all left segments.
     */
    public static BiFunction<Segment, Integer, Integer> leftSegmentXResolver() {
        return (seg, thickness) -> thickness;
    }

    /**
     * Resolves X coordinate for all right segments.
     */
    static BiFunction<Segment, Integer, Integer> rightSegmentXResolver() {
        return (seg, thickness) -> getModuleWidth(seg) - 2 * thickness;
    }
}
