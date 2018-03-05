package com.wniemiec.component;

import com.wniemiec.component.type.SegmentPositionType;
import com.wniemiec.component.util.SegmentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Map;

public class SevenSegmentModule<T> extends JComponent {

    private final Map<SegmentPositionType, Segment> segments;

    private final SevenSegmentDisplay<T> sevenSegmentDisplay;

    SevenSegmentModule(SevenSegmentDisplay<T> sevenSegmentDisplay) {
        this.sevenSegmentDisplay = sevenSegmentDisplay;
        this.segments = SegmentFactory.initializeSegments(this);
        addComponentListener(resizeListener());
    }

    public void light(T t) {
        segments.values()
                .forEach(Segment::turnOff);

        sevenSegmentDisplay.getDisplayControl()
                .getSegments(t)
                .stream()
                .map(segments::get)
                .forEach(Segment::turnOn);

        repaint();
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        segments.values().forEach(component -> component.setVisible(true));
    }

    private ComponentAdapter resizeListener() {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                segments.values().forEach(Segment::updatePosition);
            }
        };
    }

    public int getSegmentThickness() {
        return sevenSegmentDisplay.getSegmentThickness();
    }

    public Color getMutedColor() {
        return sevenSegmentDisplay.getMutedColor();
    }

    public Color getShiningColor() {
        return sevenSegmentDisplay.getShiningColor();
    }
}
