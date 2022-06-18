package com.englishwordshelper.port.output.word;

import com.englishwordshelper.entity.word.UpdateWordCommand;

public interface UpdateWordPort {
    void updateWord(UpdateWordCommand command);
}
