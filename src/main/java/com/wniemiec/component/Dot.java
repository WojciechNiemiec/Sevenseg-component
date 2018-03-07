package com.wniemiec.component;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

public class Dot extends JComponent {

    private final SevenSegmentDisplay display;

    private Supplier<Color> shiningColor;
    private Supplier<Color> mutedColor;
    private Supplier<Color> actualColor;

    Dot(SevenSegmentDisplay display) {
        this.display = display;
        shiningColor = display::getShiningColor;
        mutedColor = display::getMutedColor;
        actualColor = mutedColor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(actualColor.get());
        int actualThickness = display.getActualThickness();
        g.fillRect(0, getHeight() - actualThickness, getWidth(), actualThickness);
    }

    void turnOn() {
        actualColor = shiningColor;
    }

    void turnOff() {
        actualColor = mutedColor;
    }
}
