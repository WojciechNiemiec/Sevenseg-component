package com.wniemiec.component;

import com.wniemiec.component.control.DisplayControl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SevenSegmentDisplay<T, V> extends JComponent {

    private static final int DEFAULT_SEGMENT_THICKNESS = 10;
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 100);

    private final List<SevenSegmentModule<V>> modules = new ArrayList<>();

    private final List<Dot> dots = new ArrayList<>();

    private DisplayControl<T, V> displayControl;

    private T value;

    private int segmentThickness = DEFAULT_SEGMENT_THICKNESS;

    private Color mutedColor = Color.DARK_GRAY;

    private Color shiningColor = Color.GREEN;

    private FlowLayout layoutManager = new FlowLayout(FlowLayout.CENTER, segmentThickness, 0);

    public SevenSegmentDisplay(DisplayControl<T, V> displayControl) {
        this(displayControl, 1);
    }

    public SevenSegmentDisplay(DisplayControl<T, V> displayControl, int modulesCount) {
        if (modulesCount > 0) {
            this.displayControl = displayControl;
            setLayout(layoutManager);
            setPreferredSize(DEFAULT_SIZE);

            createModules(modulesCount);
        } else {
            throw new IllegalStateException("Modules count must be greater than zero");
        }
    }

    public void setModulesCount(int modulesCount) {
        removeAll();
        modules.clear();
        setLayout(new BorderLayout());
        createModules(modulesCount);
    }

    public int getModulesCount() {
        return modules.size();
    }

    public void setValue(T t) {
        value = t;
        displayControl.light(modules, t);
    }

    public T getValue() {
        return value;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0,0, getWidth(), getHeight());
        super.paint(g);
    }

    @Override
    public void repaint() {
        int actualThickness = getActualThickness();
        int moduleWidth = getWidth() / modules.size() - actualThickness * 3;
        layoutManager.setHgap(actualThickness);
        for (SevenSegmentModule module : modules) {
            module.setPreferredSize(new Dimension(moduleWidth, getHeight()));
        }

        for (Dot dot : dots) {
            dot.setPreferredSize(new Dimension(actualThickness, getHeight()));
        }

        super.repaint();
    }

    public DisplayControl<T, V> getDisplayControl() {
        return displayControl;
    }

    public int getSegmentThickness() {
        return segmentThickness;
    }

    public void setSegmentThickness(int segmentThickness) {
        this.segmentThickness = segmentThickness;
        setLayout(new FlowLayout(FlowLayout.LEFT, segmentThickness, 0));
        repaint();
    }

    public int getActualThickness() {
        return (int) (getSegmentThickness() / 100f * getLowerDimension());
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

    private int getLowerDimension() {
        return (getWidth() < getHeight()) ? getWidth() : getHeight();
    }

    private void createModules(int modulesCount) {
        addModule();
        for (int i = 1; i < modulesCount; i++) {
            addDot();
            addModule();
        }
    }

    private void addDot() {
        Dot dot = new Dot(this);
        dots.add(dot);
        this.add(dot);
    }

    private void addModule() {
        SevenSegmentModule<V> module = new SevenSegmentModule<>(this);
        modules.add(module);
        this.add(module);
    }
}
