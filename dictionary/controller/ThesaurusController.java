package com.dictionary.dictionary.controller;

import com.dictionary.dictionary.service.ThesaurusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThesaurusController {

    @Autowired
    private ThesaurusService thesaurusService;

    private static Logger logger = LoggerFactory.getLogger(ThesaurusController.class);


    public ThesaurusController(ThesaurusService thesaurusService) {
        this.thesaurusService = thesaurusService;
    }
    @GetMapping("/dictionary/synonyms")
    public ResponseEntity<List<String>> getWordsBySynonyms(@RequestParam String synonym) {
        logger.info("Fetching synonyms for word: {}", synonym);
        List<String> words = thesaurusService.findWordsBySynonym(synonym);
        if (!words.isEmpty()) {
            logger.info("Synonyms found for word {}: {}", synonym, words);
            return ResponseEntity.ok(words);
        } else {
            logger.info("Synonyms not found for word: {}", synonym);
            return ResponseEntity.notFound().build();
        }
    }

    // Get words and their antonyms
    @GetMapping("/dictionary/antonyms")
    public ResponseEntity<List<String>> getWordsAndAntonyms(@RequestParam String word) {
        logger.info("Fetching antonyms for word: {}", word);
        List<String> antonyms = thesaurusService.findAntonymsByWord(word);
        if (!antonyms.isEmpty()) {
            logger.info("Antonyms found for word {}: {}", word, antonyms);
            return ResponseEntity.ok(antonyms);
        } else {
            logger.info("Antonyms not found for word: {}", word);
            return ResponseEntity.notFound().build();
        }
    }
}
