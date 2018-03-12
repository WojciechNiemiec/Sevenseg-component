package com.wniemiec.component.control;

import com.wniemiec.component.Dot;
import com.wniemiec.component.SevenSegmentModule;
import com.wniemiec.component.type.SegmentPositionType;

import java.util.List;

public class DefaultDisplayControl implements DisplayControl<String, Character> {

    private ModuleControl<Character> moduleControl = DefaultModuleControl.getInstance();

    @Override
    public void light(List<SevenSegmentModule<Character>> modules, List<Dot> dots, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < modules.size() - value.length(); i++) {
            stringBuilder.append(' ');
        }

        String text = stringBuilder.append(value).toString();
        dots.forEach(Dot::turnOff);

        if (text.contains(".")) {
            dots.get(text.indexOf('.') - 1).turnOn();
            text = text.replace(".","");
        }

        for (int i = 0; i < modules.size(); i++) {
            modules.get(i).light(text.charAt(i));
        }
    }

    @Override
    public List<SegmentPositionType> getSegments(Character character) {
        return moduleControl.getSegments(character);
    }
}
