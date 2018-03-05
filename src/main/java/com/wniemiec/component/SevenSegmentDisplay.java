package com.wniemiec.component;

import com.wniemiec.component.control.DisplayControl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SevenSegmentDisplay<T> extends JComponent {

    private List<SevenSegmentModule<T>> modules;

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
            setLayout(new FlowLayout(FlowLayout.CENTER, 0, segmentThickness));
            modules = new ArrayList<>(modulesCount);

            for (int i = 0; i < modulesCount; i++) {
                SevenSegmentModule<T> module = new SevenSegmentModule<>(this);
                modules.add(module);
                this.add(module);
            }
        } else {
            throw new IllegalStateException("Modules count must be greater than zero");
        }
    }

    public void light(T t) {
        for (int i = 0; i < modules.size(); i++) {
            int valueIndex = modules.size() - 1 - i;
            modules.get(i).light(displayControl.split(valueIndex, t));
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0,0, getWidth(), getHeight());
        super.paint(g);
    }

    @Override
    public void repaint() {
        int moduleWidth = getWidth() / modules.size() - segmentThickness;
        for (SevenSegmentModule module : modules) {
            module.setPreferredSize(new Dimension(moduleWidth, getHeight()));
        }
        super.repaint();
    }

    public DisplayControl<T> getDisplayControl() {
        return displayControl;
    }

    public int getSegmentThickness() {
        return segmentThickness;
    }

    public void setSegmentThickness(int segmentThickness) {
        this.segmentThickness = segmentThickness;
        setLayout(new FlowLayout(FlowLayout.CENTER, segmentThickness, 0));
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
