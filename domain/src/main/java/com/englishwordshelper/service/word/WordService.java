package com.englishwordshelper.service.word;

import com.englishwordshelper.entity.word.SaveWordCommand;
import com.englishwordshelper.entity.word.UpdateWordCommand;
import com.englishwordshelper.entity.word.Word;
import com.englishwordshelper.port.input.word.DeleteWordUseCase;
import com.englishwordshelper.port.input.word.GetWordsQuery;
import com.englishwordshelper.port.input.word.SaveWordUseCase;
import com.englishwordshelper.port.input.word.UpdateWordUseCase;
import com.englishwordshelper.port.output.word.DeleteWordPort;
import com.englishwordshelper.port.output.word.GetWordsPort;
import com.englishwordshelper.port.output.word.SaveWordPort;
import com.englishwordshelper.port.output.word.UpdateWordPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService implements DeleteWordUseCase, GetWordsQuery, SaveWordUseCase, UpdateWordUseCase {
    private final DeleteWordPort deleteWordPort;
    private final GetWordsPort getWordsPort;
    private final SaveWordPort saveWordPort;
    private final UpdateWordPort updateWordPort;

    WordService(
        DeleteWordPort deleteWordPort,
        GetWordsPort getWordsPort,
        SaveWordPort saveWordPort,
        UpdateWordPort updateWordPort
    ) {
        this.deleteWordPort = deleteWordPort;
        this.getWordsPort = getWordsPort;
        this.saveWordPort = saveWordPort;
        this.updateWordPort = updateWordPort;
    }

    @Override
    public void deleteWord(int id) {
        deleteWordPort.deleteWord(id);
    }

    @Override
    public List<Word> getWords(int groupId) {
        return getWordsPort.getWords(groupId);
    }

    @Override
    public void saveWord(SaveWordCommand command) {
        saveWordPort.saveWord(command);
    }

    @Override
    public void updateWord(UpdateWordCommand command) {
        updateWordPort.updateWord(command);
    }
}
