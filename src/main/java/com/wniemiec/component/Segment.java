package com.wniemiec.component;

import com.wniemiec.component.type.SegmentPositionType;

import java.awt.*;
import java.util.function.Supplier;

public class Segment extends Component {

    private SevenSegmentModule module;
    private SevenSegmentDisplay display;
    private SegmentPositionType segmentPositionType;

    private Supplier<Color> shiningColor;
    private Supplier<Color> mutedColor;
    private Supplier<Color> actualColor;

    public Segment(SevenSegmentModule module, SegmentPositionType segmentPositionType) {
        this.module = module;
        this.segmentPositionType = segmentPositionType;
        display = module.getSevenSegmentDisplay();
        shiningColor = display::getShiningColor;
        mutedColor = display::getMutedColor;
        actualColor = mutedColor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(actualColor.get());
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

    void turnOn() {
        actualColor = shiningColor;
    }

    void turnOff() {
        actualColor = mutedColor;
    }

    public SegmentPositionType getSegmentPositionType() {
        return segmentPositionType;
    }

    public SevenSegmentModule getModule() {
        return module;
    }

    private int getLowerDimension() {
        return (getWidth() < getHeight()) ? getWidth() : getHeight();
    }
}
