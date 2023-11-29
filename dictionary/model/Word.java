package com.dictionary.dictionary.model;

import javax.annotation.sql.DataSourceDefinition;
import com.dictionary.dictionary.model.Synonym;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Word {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String term;

    private String definition;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Synonym> synonyms;




    public Word(){

    }

    public Word(Long id, String term, String definition, List<Synonym> synonyms) {
        this.id = id;
        this.term = term;
        this.definition = definition;
        this.synonyms = synonyms;
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                ", synonyms=" + synonyms +
                '}';
    }
}
