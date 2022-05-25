package com.englishwordshelper.port.input.word;

import com.englishwordshelper.entity.word.Word;

import java.util.List;

public interface GetWordsQuery {
    List<Word> getWords(int groupId);
}
