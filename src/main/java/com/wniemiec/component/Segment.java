package com.wniemiec.component;

import com.wniemiec.component.type.SegmentPositionType;

import java.awt.*;

public class Segment extends Component {

    private SevenSegmentModule module;
    private SevenSegmentDisplay display;
    private SegmentPositionType segmentPositionType;

    private Color actualColor;

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
        polygon.addPoint(getWidth(), getHeight() - correction);
        polygon.addPoint(getWidth() - correction, getHeight());
        polygon.addPoint(correction, getHeight());
        polygon.addPoint(0,  getHeight() - correction);
        polygon.addPoint(0,  correction);

        return polygon;
    }

    public void updatePosition() {
        segmentPositionType.getPositioner().accept(this);
        repaint();
    }

    public void turnOn() {
        actualColor = display.getShiningColor();
        repaint();
    }

    public void turnOff() {
        actualColor = display.getMutedColor();
        repaint();
    }

    public SegmentPositionType getSegmentPositionType() {
        return segmentPositionType;
    }

    public SevenSegmentModule getModule() {
        return module;
    }

    public void setModule(SevenSegmentModule module) {
        this.module = module;
        display = module.getSevenSegmentDisplay();
        actualColor = display.getMutedColor();
    }

    private int getLowerDimension() {
        return (getWidth() < getHeight()) ? getWidth() : getHeight();
    }
}
