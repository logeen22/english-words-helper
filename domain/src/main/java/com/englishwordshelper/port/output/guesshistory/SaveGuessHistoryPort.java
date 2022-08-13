package com.englishwordshelper.port.output.guesshistory;

import com.englishwordshelper.entity.guesshistory.GuessHistory;

public interface SaveGuessHistoryPort {
    void saveGuessHistory(GuessHistory guessHistory);
}
