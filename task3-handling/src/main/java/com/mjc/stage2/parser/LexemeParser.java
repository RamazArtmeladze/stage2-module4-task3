package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";

    @Override
    public void parse(AbstractTextComponent textComponent, String string) {
        String[] lexemes = string.split(LEXEME_REGEX);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = new TextComponent(TextComponentType.WORD);
            textComponent.add(lexemeComponent);
            if (nextParser != null) {
                nextParser.parse(lexemeComponent, lexeme);
            }
        }
    }
}