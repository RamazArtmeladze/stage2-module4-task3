package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;

public class WordParser extends AbstractTextParser {

    @Override
    public void parse(AbstractTextComponent textComponent, String string) {
        for (char symbol : string.toCharArray()) {
            SymbolLeaf symbolLeaf = new SymbolLeaf(symbol);
            textComponent.add(symbolLeaf);
        }
    }
}