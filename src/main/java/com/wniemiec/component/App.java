package com.wniemiec.component;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        DoubleSegmentDisplay sevenSegmentDisplay = new DoubleSegmentDisplay();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(1800, 300);
        window.add(sevenSegmentDisplay);
        window.setVisible(true);

        sevenSegmentDisplay.setMutedColor(new Color(20,20,20));
        sevenSegmentDisplay.setBackground(Color.BLACK);
        sevenSegmentDisplay.setShiningColor(Color.RED);

        double v;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sevenSegmentDisplay.setModulesCount(5);
            v = Math.random() * 1000000;
            sevenSegmentDisplay.setValue(v);
            System.out.println(v);
            Thread.sleep(3000L);
            sevenSegmentDisplay.setModulesCount(6);
            v = Math.random() * -10;
            sevenSegmentDisplay.setValue(v);
            System.out.println(v);
            Thread.sleep(3000L);
        }
    }
}
