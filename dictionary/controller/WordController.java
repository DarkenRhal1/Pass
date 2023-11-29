package com.dictionary.dictionary.controller;

import com.dictionary.dictionary.exceptions.WordExceptions;
import com.dictionary.dictionary.model.Word;
import com.dictionary.dictionary.service.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//
//import com.dictionary.dictionary.model.Synonym;
//import com.dictionary.dictionary.model.Word;
//import com.dictionary.dictionary.service.WordService;
//import com.dictionary.dictionary.service.SynonymService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    private static Logger logger = LoggerFactory.getLogger(WordController.class);


    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping("/words")
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        logger.info("Creating a new word: {}", word);
        Word createdWord = wordService.createWord(word);
        logger.info("Word created: {}", createdWord);
        return ResponseEntity.ok(createdWord);
    }

    // Get all words
    @GetMapping("/{words}")
    public ResponseEntity<List<Word>> getWords(@PathVariable String term) {
        logger.info("Fetching all words");
        List<Word> words = wordService.findAllWords();
        logger.info("Fetched all words: {}", words);
        if (words.isEmpty()) {
            throw new WordExceptions.WordNotFoundException(term);
        }
        return ResponseEntity.ok(words);
    }

    // Update an existing word
    @PutMapping("/{word}")
    public ResponseEntity<Object> updateWord(@PathVariable String term, @RequestBody Word updatedWord) {
        logger.info("Updating word with term: {}", term);
        List<Word> wordList = wordService.findByTerm(term);
        if (!wordList.isEmpty()) {
            Word existingWord = wordList.get(0);
            existingWord.setDefinition(updatedWord.getDefinition());
            // Update other properties as needed
            Word savedWord = wordService.updateWord(existingWord);
            logger.info("Word updated: {}", savedWord);
            return ResponseEntity.ok(savedWord);
        } else {
            logger.warn("Word not found for update with term: {}", term);
            throw new WordExceptions.WordNotFoundException(term);
        }
    }

    // Get words by their definition
    @GetMapping("/by-definition")
    public ResponseEntity<List<Word>> getWordsByDefinition(@RequestParam String definition) {
        logger.info("Fetching words by definition: {}", definition);
        List<Word> words = wordService.findByDefinition(definition);
        logger.info("Words found by definition {}: {}", definition, words);

        if (words.isEmpty()) {
            throw new WordExceptions.NoWordsFoundByDefinitionException(definition);
        }

        return ResponseEntity.ok(words);
    }
}
