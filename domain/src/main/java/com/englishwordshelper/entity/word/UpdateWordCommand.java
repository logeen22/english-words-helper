package com.englishwordshelper.entity.word;

public record UpdateWordCommand(
    int id,
    String originalWord,
    String translate
) {
}
