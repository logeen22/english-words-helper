package com.englishwordshelper.port.input.word;

import com.englishwordshelper.entity.word.SaveWordCommand;

public interface SaveWordUseCase {
    void saveWord(SaveWordCommand command);
}
