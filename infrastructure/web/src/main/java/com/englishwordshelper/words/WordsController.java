//package com.englishwordshelper.words;
//
//import com.englishwordshelper.port.input.word.DeleteWordUseCase;
//import com.englishwordshelper.port.input.word.GetWordsQuery;
//import com.englishwordshelper.port.input.word.SaveWordUseCase;
//import com.englishwordshelper.port.input.word.UpdateWordUseCase;
//import com.englishwordshelper.words.converter.WordsConverter;
//import com.englishwordshelper.words.dto.SaveWordDto;
//import com.englishwordshelper.words.dto.UpdateWordDto;
//import com.englishwordshelper.words.dto.WordDto;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/${groupId}/words")
//public class WordsController {
//    private final GetWordsQuery getWordsQuery;
//    private final SaveWordUseCase saveWordUseCase;
//    private final UpdateWordUseCase updateWordUseCase;
//    private final DeleteWordUseCase deleteWordUseCase;
//    private final WordsConverter wordsConverter;
//
//    public WordsController(
//        GetWordsQuery getWordsQuery,
//        SaveWordUseCase saveWordUseCase,
//        UpdateWordUseCase updateWordUseCase,
//        DeleteWordUseCase deleteWordUseCase,
//        WordsConverter wordsConverter
//    ) {
//        this.getWordsQuery = getWordsQuery;
//        this.saveWordUseCase = saveWordUseCase;
//        this.updateWordUseCase = updateWordUseCase;
//        this.deleteWordUseCase = deleteWordUseCase;
//        this.wordsConverter = wordsConverter;
//    }
//
//    @GetMapping
//    public List<WordDto> getWords(@PathVariable int groupId) {
//        var words = getWordsQuery.getWords(groupId);
//
//        return wordsConverter.convert(words);
//    }
//
//    @PostMapping
//    public void saveWord(
//        @RequestBody SaveWordDto saveWordDto
//    ) {
//        var command = wordsConverter.convertToCommand(saveWordDto);
//        saveWordUseCase.saveWord(command);
//    }
//
//    @PutMapping("/wordId")
//    public void updateWord(
//        @PathVariable int wordId,
//        @RequestBody UpdateWordDto updateWordDto
//    ) {
//        var command = wordsConverter.convertToCommand(
//            wordId,
//            updateWordDto
//        );
//
//        updateWordUseCase.updateWord(command);
//    }
//
//
//    @DeleteMapping("/{wordId}")
//    public void deleteWord(
//        @PathVariable int wordId
//    ) {
//        deleteWordUseCase.deleteWord(wordId);
//    }
//}
