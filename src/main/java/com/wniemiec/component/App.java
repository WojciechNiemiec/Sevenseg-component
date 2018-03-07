package com.wniemiec.component;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        IntegerSegmentDisplay sevenSegmentDisplay = new IntegerSegmentDisplay();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(1000, 300);
        window.add(sevenSegmentDisplay);
        window.setVisible(true);

        sevenSegmentDisplay.setMutedColor(new Color(20,20,20));
        sevenSegmentDisplay.setBackground(Color.BLACK);
        sevenSegmentDisplay.setShiningColor(Color.RED);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sevenSegmentDisplay.setValue(i);
            Thread.sleep(100L);
        }
    }
}
