package com.englishwordshelper.peersistence.word;

import com.englishwordshelper.entity.word.Word;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WordRowMapper implements RowMapper<Word> {

    @Override
    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Word(
            rs.getInt("id"),
            rs.getString("original_word"),
            rs.getString("translate")
        );
    }
}

