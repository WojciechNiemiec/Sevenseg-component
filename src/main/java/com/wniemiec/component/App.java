package com.wniemiec.component;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        SevenSegmentDisplay<Integer> sevenSegmentDisplay = new SevenSegmentDisplay<>(new DefaultDisplayControl(), 3);

        JFrame window = new JFrame();
        window.setSize(600, 500);
        window.add(sevenSegmentDisplay);
        window.setVisible(true);

        sevenSegmentDisplay.setSize(500, 400);
        sevenSegmentDisplay.setMutedColor(Color.LIGHT_GRAY);
        sevenSegmentDisplay.setShiningColor(Color.RED);
        sevenSegmentDisplay.setSegmentThickness(30);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sevenSegmentDisplay.light(i);
            Thread.sleep(50L);
        }
    }
}
