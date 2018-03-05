package com.wniemiec.component.util;

import com.wniemiec.component.Segment;
import com.wniemiec.component.SevenSegmentModule;

import java.awt.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Positioners {

    private static final float MARGIN_MULTIPLIER = 0.6f;

    private Positioners() {
    }

    public static Consumer<Segment> top() {
        return segment -> positionHorizontally(segment, module -> 0);
    }

    public static Consumer<Segment> center() {
        return segment -> positionHorizontally(segment, module -> module.getHeight() / 2 - module.getSegmentThickness() / 2);
    }

    public static Consumer<Segment> bottom() {
        return segment -> positionHorizontally(segment, module -> module.getHeight() - module.getSegmentThickness());
    }

    public static Consumer<Segment> topLeft() {
        return segment -> positionVertically(segment, ((module, margin) -> new Point(0, margin)));
    }

    public static Consumer<Segment> topRight() {
        Locator locator = (module, margin) -> new Point(module.getWidth() - module.getSegmentThickness(), margin);
        return segment -> positionVertically(segment, locator);
    }

    public static Consumer<Segment> bottomLeft() {
        Locator locator = (module, margin) -> new Point(0, module.getHeight() / 2 - module.getSegmentThickness() / 2 + margin);
        return segment -> positionVertically(segment, locator);
    }

    public static Consumer<Segment> bottomRight() {
        Locator locator = (module, margin) -> new Point(
                module.getWidth() - module.getSegmentThickness(),
                module.getHeight() / 2 - module.getSegmentThickness() / 2 + margin);

        return segment -> positionVertically(segment, locator);
    }

    private static void positionHorizontally(Segment segment, Function<SevenSegmentModule<?>, Integer> heightSupplier) {
        SevenSegmentModule module = segment.getModule();
        int margin = getMargin(module);
        segment.setLocation(margin, heightSupplier.apply(module));
        segment.setSize(module.getWidth() - 2 * margin, module.getSegmentThickness());
    }

    private static void positionVertically(Segment segment, Locator locator) {
        SevenSegmentModule module = segment.getModule();
        int margin = getMargin(module);
        segment.setLocation(locator.getLocation(module, margin));
        segment.setSize(module.getSegmentThickness(), module.getHeight() / 2 + module.getSegmentThickness() / 2 - margin * 2);
    }

    private static int getMargin(SevenSegmentModule<?> module) {
        return (int) (module.getSegmentThickness() * MARGIN_MULTIPLIER);
    }
}
