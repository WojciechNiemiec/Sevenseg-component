package com.wniemiec.component;

import com.wniemiec.component.control.DefaultDisplayControl;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        SevenSegmentDisplay<Integer> sevenSegmentDisplay = new SevenSegmentDisplay<>(new DefaultDisplayControl(), 5);

        JFrame window = new JFrame();
        window.setSize(1000, 300);
        window.add(sevenSegmentDisplay);
        window.setVisible(true);

        sevenSegmentDisplay.setMutedColor(new Color(20,20,20));
        sevenSegmentDisplay.setShiningColor(Color.RED);
        sevenSegmentDisplay.setBackground(Color.BLACK);
        sevenSegmentDisplay.setSegmentThickness(30);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sevenSegmentDisplay.light(i);
            Thread.sleep(100L);
        }
    }
}
