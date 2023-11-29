package com.dictionary.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThesaurusService {
    private Map<String, List<String>> synonymMap; // Assuming a simple in-memory map for demonstration
    private Map<String, List<String>> antonymMap;

    public ThesaurusService() {
        this.synonymMap = new HashMap<>();
        // Initialized synonymMap with some dummy data for demonstration
        List<String> synonyms1 = List.of("word1a", "word1b");
        synonymMap.put("synonym1", synonyms1);

        List<String> synonyms2 = List.of("word2a", "word2b", "word2c");
        synonymMap.put("synonym2", synonyms2);


            this.antonymMap = new HashMap<>();
            // Initialize antonymMap with some dummy data for demonstration
            antonymMap.put("happy", List.of("sad", "unhappy"));
            antonymMap.put("hot", List.of("cold"));

    }

    public List<String> findWordsBySynonym(String synonym) {
        return synonymMap.getOrDefault(synonym, new ArrayList<>());
    }

    public List<String> findAntonymsByWord(String word) {
        return antonymMap.getOrDefault(word, new ArrayList<>());
    }
}
