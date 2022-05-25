package com.englishwordshelper.entity.word;

public record SaveWordCommand(
    String originalWord,
    String translate
) {
}
