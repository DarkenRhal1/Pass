package com.dictionary.dictionary.service;

import com.dictionary.dictionary.model.Synonym;
import com.dictionary.dictionary.model.Word;
import com.dictionary.dictionary.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

////'com.dictionary.dictionary.model.Synonym
//
//import com.dictionary.dictionary.model.Synonym;
//import com.dictionary.dictionary.model.Synonym;
//import com.dictionary.dictionary.repository.SynonymRepository;
//import com.dictionary.dictionary.service.SynonymService;
//import com.dictionary.dictionary.model.Word;
//import com.dictionary.dictionary.repository.WordRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//
@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    private List<Word> wordList; // Assuming a simple in-memory list for demonstration

//
//    @Autowired
//    private OxfordApiService oxfordApiService;
//    @Autowired
//    private SynonymService synonymService;
//
//    @Autowired
//    private SynonymRepository synonymRepository;
//
//    public WordService(WordRepository wordRepository, SynonymService synonymService) {
//        this.wordRepository = wordRepository;
//        this.synonymService = synonymService;
//    }
//

    public Word createWord(Word word) {
        word.getSynonyms().forEach((Synonym synonym) -> synonym.setWord(word));
        return wordRepository.save(word);
    }

    public List<Word> findAllWords() {
        return (List<Word>) wordRepository.findAll();
    }


    public List<Word> findByTerm(String term) {
        // Assuming a case-sensitive match for simplicity; modify as needed
        List<Word> matchingWords = new ArrayList<>();
        Word[] wordList = new Word[0];
        for (Word word : wordList) {
            if (word.getTerm().equals(term)) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

//    public List<Word> updateWord(Word newWord) {
//
//        Optional<Word> existingWord = wordRepository.findById(newWord.getId());
//
//        if (existingWord.isPresent()) {
//            Word accountToUpdate = existingWord.get();
//
//            accountToUpdate.setTerm(newWord.getTerm());
//            accountToUpdate.setDefinition(newWord.getDefinition());
//            accountToUpdate.setSynonyms(newWord.getSynonyms());
//
//
//            // Save the updated account
//            wordRepository.save(accountToUpdate);
//
//            return List.of(accountToUpdate);
//        } else {
//            // Return empty optional if the account with the given ID doesn't exist
//            return Collections.emptyList();
//        }
//    }
//
//}

    public Word updateWord(Word updatedWord) {
        // Assuming Word class has a method to retrieve term
        String term = updatedWord.getTerm();
        List<Word> wordList = new ArrayList<>();

        for (int i = 0; i < wordList.size(); i++) {
            Word existingWord = wordList.get(i);
            if (existingWord.getTerm().equals(term)) {
                //  Word class method to update definition
                existingWord.setDefinition(updatedWord.getDefinition());
                // Update other properties as needed
                wordList.set(i, existingWord); // Update the word in the list
                return existingWord; // Return the updated word
            }
        }

        // If the term is not found, you might choose to throw an exception or return null
        return null;
    }

    public List<Word> findByDefinition(String definition) {
        List<Word> matchingWords = new ArrayList<>();
        for (Word word : wordList) {
            if (word.getDefinition().equals(definition)) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }
////    public Word save(Word word) {
////        word.getSynonyms().forEach((Synonym synonym) -> synonym.setWord(word));
////        return wordRepository.save(word);
////    }
////
////    public void deleteByTerm(String term) {
////        findByTerm(term).ifPresent(word -> {
////            synonymService.deleteByWordId(word.getId());
////            wordRepository.delete(word);
////        });
////    }
//
//    public Word save(Word word) {
//        word.getSynonyms().forEach((synonym) -> synonym.setWord(word));
//        return wordRepository.save(word);
//    }
//
//    public List<Word> findAllWords() {
//        return (List<Word>) wordRepository.findAll();
//    }
//
//    public Optional<Word> findWordById(String word) {
//        return wordRepository.findByWord(word);
//    }
//
////    public Optional<Word> findWord(String word) {
////        Optional<Word> foundWord = wordRepository.findByWord(word);
////        if (foundWord.isPresent()) {
////            oxfordApiService.getWordDefinition(word).ifPresent(definition -> {
////                foundWord.get().setDefinition(toString());
////                wordRepository.save(foundWord.get());
////            });
////        }
////        return foundWord;
////    }
//
//    public Optional<Synonym> findSynonyms(Long wordId) {
//        Optional<Synonym> byWord = synonymRepository.findByWordId(wordId);
//        return byWord;
//    }
//
////    public void deleteByTerm(String term){
////        wordRepository.findByTerm(term).isPresent(word -> {
////            for (Synonym synonym : Word.getSynonyms()) Synonym.getWord().remove(word);
////            wordRepository.delete(word);
////        });
////    }
}
