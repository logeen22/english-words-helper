package com.englishwordshelper.peersistence.guesshistory;

import com.englishwordshelper.entity.guesshistory.GuessHistory;
import com.englishwordshelper.port.output.guesshistory.GetGuessHistoriesPort;
import com.englishwordshelper.port.output.guesshistory.SaveGuessHistoryPort;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GuessHistoryRepository implements GetGuessHistoriesPort, SaveGuessHistoryPort {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final GuessHistoryRowMapper guessHistoryRowMapper;

    public GuessHistoryRepository(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        GuessHistoryRowMapper guessHistoryRowMapper
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.guessHistoryRowMapper = guessHistoryRowMapper;
    }

    @Override
    public List<GuessHistory> getGuessHistories() {
        var sql = "SELECT * FROM guess_history";
        return namedParameterJdbcTemplate.query(sql, guessHistoryRowMapper);
    }

    @Override
    public void saveGuessHistory(GuessHistory guessHistory) {
        var sql = "INSERT INTO guess_history VALUES(:word_id, :times)";
        var parameters = Map.ofEntries(
            Map.entry("name", guessHistory.wordId()),
            Map.entry("name", guessHistory.times())
        );

        namedParameterJdbcTemplate.update(sql, parameters);
    }
}
