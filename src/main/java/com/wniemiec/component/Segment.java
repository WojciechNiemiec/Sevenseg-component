package com.wniemiec.component;

import com.wniemiec.component.type.SegmentPositionType;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Segment extends JComponent {

    private SevenSegmentModule module;
    private SegmentPositionType segmentPositionType;

    private Color actualColor;

    public Segment(Dimension size) {
        this.setSize(size);
    }

    public Segment(SegmentPositionType segmentPositionType) {
        this.segmentPositionType = segmentPositionType;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(actualColor);
        g.fillPolygon(preparePolygon());
    }

    private Polygon preparePolygon() {
        final int correction = getLowerDimension() / 2;

        Polygon polygon = new Polygon();

        polygon.addPoint(correction, 0);
        polygon.addPoint(getWidth() - correction, 0);
        polygon.addPoint(getWidth(), correction);
        polygon.addPoint(getWidth() - correction, getHeight());
        polygon.addPoint(correction, getHeight());
        polygon.addPoint(0,  correction);

        return polygon;
    }

    public void updatePosition() {
        segmentPositionType.getPositioner().accept(this);
        repaint();
    }

    public void turnOn() {
        actualColor = module.getShiningColor();
        repaint();
    }

    public void turnOff() {
        actualColor = module.getMutedColor();
        repaint();
    }

    public SevenSegmentModule getModule() {
        return module;
    }

    public void setModule(SevenSegmentModule module) {
        this.module = module;
        actualColor = module.getMutedColor();
    }

    private int getLowerDimension() {
        return (getWidth() < getHeight()) ? getWidth() : getHeight();
    }
}
