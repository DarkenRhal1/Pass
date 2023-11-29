package com.dictionary.dictionary.model;

import com.sun.istack.NotNull;
import lombok.Data;
import com.dictionary.dictionary.model.Synonym;

import javax.persistence.*;

@Data
@Entity
public class Synonym {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String term;

    @ManyToOne
    @JoinColumn(name = "word")
    private Word word;

    public Synonym(){

    }

    public Synonym(Long id, String term, Word word) {
        this.id = id;
        this.term = term;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
