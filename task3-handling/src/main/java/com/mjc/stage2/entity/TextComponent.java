package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    private final List<AbstractTextComponent> componentList = new ArrayList<>();

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder result = new StringBuilder();
        for (AbstractTextComponent component : componentList) {
            result.append(component.operation()).append(componentType.getDelimiter());
        }
        return result.toString().trim(); // Remove trailing delimiter
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        return componentList.size();
    }
}