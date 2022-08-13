package com.englishwordshelper.peersistence.guesshistory;

import com.englishwordshelper.entity.guesshistory.GuessHistory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuessHistoryRowMapper implements RowMapper<GuessHistory> {

    @Override
    public GuessHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new GuessHistory(
            rs.getInt("word_id"),
            rs.getInt("times")
        );
    }
}
