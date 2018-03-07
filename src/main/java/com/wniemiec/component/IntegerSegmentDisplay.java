package com.wniemiec.component;

import com.wniemiec.component.control.DefaultDisplayControl;

import javax.swing.*;
import java.awt.*;

public class IntegerSegmentDisplay extends JComponent {

    private SevenSegmentDisplay<Integer> delegate;

    public IntegerSegmentDisplay() {
        final int DEFAULT_MODULES_COUNT = 8;
        this.setLayout(new BorderLayout());
        delegate = new SevenSegmentDisplay<>(new DefaultDisplayControl(), DEFAULT_MODULES_COUNT);
        this.add(delegate);
        repaint();
    }

    public void setValue(Integer number) {
        delegate.setValue(number);
    }

    public int getValue() {
        return delegate.getValue();
    }

    public int getModulesCount() {
        return delegate.getModulesCount();
    }

    public void setModulesCount(int modulesCount) {
        delegate.setModulesCount(modulesCount);
    }

    public int getSegmentThickness() {
        return delegate.getSegmentThickness();
    }

    public void setSegmentThickness(int segmentThickness) {
        delegate.setSegmentThickness(segmentThickness);
    }

    public Color getMutedColor() {
        return delegate.getMutedColor();
    }

    public void setMutedColor(Color mutedColor) {
        delegate.setMutedColor(mutedColor);
    }

    public Color getShiningColor() {
        return delegate.getShiningColor();
    }

    public void setShiningColor(Color shiningColor) {
        delegate.setShiningColor(shiningColor);
    }
}
