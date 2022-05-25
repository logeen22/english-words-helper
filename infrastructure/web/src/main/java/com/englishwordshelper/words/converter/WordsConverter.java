package com.englishwordshelper.words.converter;

import com.englishwordshelper.entity.word.SaveWordCommand;
import com.englishwordshelper.entity.word.UpdateWordCommand;
import com.englishwordshelper.entity.word.Word;
import com.englishwordshelper.words.dto.SaveWordDto;
import com.englishwordshelper.words.dto.UpdateWordDto;
import com.englishwordshelper.words.dto.WordDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordsConverter {

    public List<WordDto> convert(List<Word> words) {
        return words.stream().map(this::convert).toList();
    }

    public WordDto convert(Word word) {
        return new WordDto(
            word.id(),
            word.originalWord(),
            word.translate()
        );
    }

    public UpdateWordCommand convertToCommand(
        int wordId,
        UpdateWordDto updateWordDto
    ) {
        return new UpdateWordCommand(
            wordId,
            updateWordDto.originalWord(),
            updateWordDto.translate()
        );
    }

    public SaveWordCommand convertToCommand(SaveWordDto saveWordDto) {
        return new SaveWordCommand(
            saveWordDto.originalWord(),
            saveWordDto.translate()
        );
    }
}
