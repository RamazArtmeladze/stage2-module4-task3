package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+"; // Split by spaces

    @Override
    public void parse(AbstractTextComponent parentComponent, String sentence) {
        String[] lexemes = sentence.split(LEXEME_REGEX);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = new TextComponent(TextComponentType.WORD);
            parentComponent.add(lexemeComponent);
            if (nextParser != null) {
                nextParser.parse(lexemeComponent, lexeme);
            }
        }
    }
}