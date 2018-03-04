package com.wniemiec.component;

import com.wniemiec.component.type.SegmentPositionType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wniemiec.component.type.SegmentPositionType.*;

public class DefaultModuleControl implements ModuleControl<Integer> {

    private static DefaultModuleControl instance;

    private Map<Integer, List<SegmentPositionType>> segments = new HashMap<>(10);

    private DefaultModuleControl() {
        segments.put(0, Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT));
        segments.put(1, Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT));
        segments.put(2, Arrays.asList(TOP, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM));
        segments.put(3, Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, CENTER));
        segments.put(4, Arrays.asList(TOP_LEFT, CENTER, BOTTOM_RIGHT, TOP_RIGHT));
        segments.put(5, Arrays.asList(TOP, BOTTOM_RIGHT, BOTTOM, TOP_LEFT, CENTER));
        segments.put(6, Arrays.asList(TOP, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put(7, Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT));
        segments.put(8, Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put(9, Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, TOP_LEFT, CENTER));
    }

    public static DefaultModuleControl getInstance() {
        return (null != instance) ? instance : (instance = new DefaultModuleControl());
    }

    /**
     * This method takes any integer number and converts it to List of segment positions to light.
     * Method takes the least significant digit only.
     *
     * @param integer any number
     * @return List of segment positions to light
     */
    @Override
    public List<SegmentPositionType> apply(Integer integer) {
        return segments.get(Math.abs(integer) % 10);
    }
}
