package com.englishwordshelper.peersistence.word;

import com.englishwordshelper.entity.word.SaveWordCommand;
import com.englishwordshelper.entity.word.UpdateWordCommand;
import com.englishwordshelper.entity.word.Word;
import com.englishwordshelper.port.output.word.DeleteWordPort;
import com.englishwordshelper.port.output.word.GetWordsPort;
import com.englishwordshelper.port.output.word.SaveWordPort;
import com.englishwordshelper.port.output.word.UpdateWordPort;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WordRepository implements DeleteWordPort, GetWordsPort, SaveWordPort, UpdateWordPort {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final WordRowMapper wordRowMapper;

    public WordRepository(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        WordRowMapper WordRowMapper
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.wordRowMapper = WordRowMapper;
    }

    @Override
    public void deleteWord(int id) {
        var sql = "DELETE FROM words WHERE id = :id";
        var parameters = Map.ofEntries(
            Map.entry("id", id)
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    @Override
    public List<Word> getWords(int groupId) {
        var sql = "SELECT * FROM words WHERE group_id = :groupId";
        var parameters = Map.ofEntries(
            Map.entry("groupId", groupId)
        );
        return namedParameterJdbcTemplate.query(sql, parameters, wordRowMapper);
    }

    @Override
    public void saveWord(SaveWordCommand command) {
        var sql = "INSERT INTO words (original_word, translate) VALUES(:originalWord, :translate)";
        var parameters = Map.ofEntries(
            Map.entry("originalWord", command.originalWord()),
            Map.entry("translate", command.translate())
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }

    @Override
    public void updateWord(UpdateWordCommand command) {
        var sql = "UPDATE words SET original_word = :originalWord, translate = :translate WHERE id = :id";
        var parameters = Map.ofEntries(
            Map.entry("originalWord", command.originalWord()),
            Map.entry("translate", command.translate()),
            Map.entry("id", command.id())
        );
        namedParameterJdbcTemplate.update(sql, parameters);
    }
}