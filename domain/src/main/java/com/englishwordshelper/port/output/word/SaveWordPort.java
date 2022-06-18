package com.englishwordshelper.port.output.word;

import com.englishwordshelper.entity.word.SaveWordCommand;

public interface SaveWordPort {
    void saveWord(SaveWordCommand command);
}
