package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;

public class WordParser extends AbstractTextParser {

    @Override
    public void parse(AbstractTextComponent lexemeComponent, String word) {
        for (char symbol : word.toCharArray()) {
            SymbolLeaf symbolLeaf = new SymbolLeaf(symbol);
            lexemeComponent.add(symbolLeaf);
        }
    }
}