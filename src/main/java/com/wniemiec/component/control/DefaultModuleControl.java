package com.wniemiec.component.control;

import com.wniemiec.component.type.SegmentPositionType;

import java.util.*;

import static com.wniemiec.component.type.SegmentPositionType.*;

public class DefaultModuleControl implements ModuleControl<Character> {

    private static DefaultModuleControl instance;

    private Map<Character, List<SegmentPositionType>> segments = new HashMap<>(10);

    private DefaultModuleControl() {
        segments.put('0', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT));
        segments.put('1', Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT));
        segments.put('2', Arrays.asList(TOP, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM));
        segments.put('3', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, CENTER));
        segments.put('4', Arrays.asList(TOP_LEFT, CENTER, BOTTOM_RIGHT, TOP_RIGHT));
        segments.put('5', Arrays.asList(TOP, BOTTOM_RIGHT, BOTTOM, TOP_LEFT, CENTER));
        segments.put('6', Arrays.asList(TOP, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('7', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT));
        segments.put('8', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('9', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, TOP_LEFT, CENTER));
        segments.put(' ', Collections.emptyList());
        segments.put('-', Collections.singletonList(CENTER));
        segments.put('a', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('b', Arrays.asList(BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('c', Arrays.asList(TOP, BOTTOM, BOTTOM_LEFT, TOP_LEFT));
        segments.put('d', Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, CENTER));
        segments.put('e', Arrays.asList(TOP, BOTTOM, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('f', Arrays.asList(TOP, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('g', Arrays.asList(TOP, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT));
        segments.put('h', Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('i', Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT));
        segments.put('j', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT));
        segments.put('k', Arrays.asList(BOTTOM_RIGHT, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('l', Arrays.asList(BOTTOM, BOTTOM_LEFT, TOP_LEFT));
        segments.put('m', Arrays.asList(BOTTOM_RIGHT, BOTTOM_LEFT, CENTER));
        segments.put('n', Arrays.asList(BOTTOM_RIGHT, BOTTOM_LEFT, CENTER));
        segments.put('o', Arrays.asList(BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, CENTER));
        segments.put('p', Arrays.asList(TOP, TOP_RIGHT, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('r', Arrays.asList(BOTTOM_LEFT, CENTER));
        segments.put('s', Arrays.asList(TOP, BOTTOM_RIGHT, BOTTOM, TOP_LEFT, CENTER));
        segments.put('t', Arrays.asList(BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('u', Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, TOP_LEFT));
        segments.put('v', Arrays.asList(BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT));
        segments.put('w', Arrays.asList(BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT));
        segments.put('x', Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('y', Arrays.asList(TOP_RIGHT, BOTTOM_LEFT, TOP_LEFT, CENTER));
        segments.put('z', Arrays.asList(TOP, BOTTOM_RIGHT, BOTTOM, TOP_LEFT, CENTER));
    }

    public static DefaultModuleControl getInstance() {
        return (null != instance) ? instance : (instance = new DefaultModuleControl());
    }

    /**
     * This method takes any letter and converts it to List of segment positions.
     *
     * @param character any value
     * @return List of segment positions to setValue
     */
    @Override
    public List<SegmentPositionType> getSegments(Character character) {
        char c = Character.toLowerCase(character);
        return segments.get(c);
    }
}
