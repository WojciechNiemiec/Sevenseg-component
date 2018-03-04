package com.wniemiec.component;

import com.wniemiec.component.type.SegmentPositionType;
import com.wniemiec.component.util.SegmentFactory;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Map;

public class SevenSegmentModule<T> extends JComponent {

    private final Map<SegmentPositionType, Segment> segments = SegmentFactory.initializeSegments(this);

    @Getter
    @Setter
    private int segmentThickness;

    @Getter
    @Setter
    private Color mutedColor = Color.DARK_GRAY;

    @Getter
    @Setter
    private Color shiningColor = Color.GREEN;

    @Getter
    private final ModuleControl<T> moduleControl;

    public SevenSegmentModule(ModuleControl<T> moduleControl) {
        this.moduleControl = moduleControl;
        addComponentListener(resizeListener());
    }

    public void light(T t) {
        segments.values()
                .forEach(Segment::turnOff);

        moduleControl.apply(t)
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
}
