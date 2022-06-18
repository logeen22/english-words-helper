package com.englishwordshelper.port.output.word;

import com.englishwordshelper.entity.word.Word;

import java.util.List;

public interface GetWordsPort {
    List<Word> getWords(int groupId);
}
