package com.dictionary.dictionary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class WordExceptions {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class WordNotFoundException extends WordControllerException {
        public WordNotFoundException(String term) {
            super("Word not found with term: " + term);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class NoWordsFoundByDefinitionException extends WordControllerException {
        public NoWordsFoundByDefinitionException(String definition) {
            super("No words found with definition: " + definition);
        }
    }

    public void WordControllerException() {

    }

    private static class WordControllerException {
        public WordControllerException(String s) {

        }
    }
}
