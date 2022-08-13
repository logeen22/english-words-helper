package com.englishwordshelper.port.output.guesshistory;

import com.englishwordshelper.entity.guesshistory.GuessHistory;

import java.util.List;

public interface GetGuessHistoriesPort {
    List<GuessHistory> getGuessHistories();
}
