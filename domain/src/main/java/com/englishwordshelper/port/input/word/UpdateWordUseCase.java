package com.englishwordshelper.port.input.word;

import com.englishwordshelper.entity.word.UpdateWordCommand;

public interface UpdateWordUseCase {
    void updateWord(UpdateWordCommand command);
}
