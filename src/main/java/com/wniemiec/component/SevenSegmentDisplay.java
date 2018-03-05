package com.wniemiec.component;

import lombok.Getter;
import sun.plugin.dom.exception.InvalidStateException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class SevenSegmentDisplay<T> extends JComponent {

    private List<SevenSegmentModule<T>> modules;

    @Getter
    private DisplayControl<T> displayControl;

    private int segmentThickness;

    private Color mutedColor = Color.DARK_GRAY;

    private Color shiningColor = Color.GREEN;

    public SevenSegmentDisplay(DisplayControl<T> displayControl) {
        this(displayControl, 1);
    }

    public SevenSegmentDisplay(DisplayControl<T> displayControl, int modulesCount) {
        if (modulesCount > 0) {
            this.displayControl = displayControl;
            setLayout(new FlowLayout());
            modules = new ArrayList<>(modulesCount);

            for (int i = 0; i < modulesCount; i++) {
                SevenSegmentModule<T> module = new SevenSegmentModule<>(this);
                modules.add(module);
                this.add(module);
            }
        } else {
            throw new InvalidStateException("Modules count must be greater than zero");
        }
    }

    public void light(T t) {
        for (int i = 0; i < modules.size(); i++) {
            int valueIndex = modules.size() - 1 - i;
            modules.get(i).light(displayControl.split(valueIndex, t));
        }
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        int moduleWidth = getWidth() / modules.size();
        for (SevenSegmentModule module : modules) {
            module.setPreferredSize(new Dimension(moduleWidth, getHeight()));
        }
        repaint();
    }

    public int getSegmentThickness() {
        return segmentThickness;
    }

    public void setSegmentThickness(int segmentThickness) {
        this.segmentThickness = segmentThickness;
        repaint();
    }

    public Color getMutedColor() {
        return mutedColor;
    }

    public void setMutedColor(Color mutedColor) {
        this.mutedColor = mutedColor;
        repaint();
    }

    public Color getShiningColor() {
        return shiningColor;
    }

    public void setShiningColor(Color shiningColor) {
        this.shiningColor = shiningColor;
        repaint();
    }
}
