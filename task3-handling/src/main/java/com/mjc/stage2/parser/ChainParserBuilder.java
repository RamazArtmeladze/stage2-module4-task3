package com.mjc.stage2.parser;

public class ChainParserBuilder {
    private AbstractTextParser parserChain;

    public ChainParserBuilder() {
        // Define parsers in the correct order: WordParser -> LexemeParser
        WordParser wordParser = new WordParser();
        LexemeParser lexemeParser = new LexemeParser();

        lexemeParser.setNextParser(wordParser);

        // Start chain with the LexemeParser
        parserChain = lexemeParser;
    }

    public AbstractTextParser build() {
        return parserChain;
    }
}