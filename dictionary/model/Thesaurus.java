package com.dictionary.dictionary.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//
//import javax.persistence.*;
//import java.util.List;
@Data
@Entity
public class Thesaurus {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = Synonym.class)
    private List<Synonym> synonyms;

    public Thesaurus(){

    }

    public Thesaurus(Long id, List<Synonym> synonyms) {
        this.id = id;
        this.synonyms = synonyms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Synonym> getSynonyms() {

        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "Thesaurus{" +
                "id=" + id +
                ", synonyms=" + synonyms +
                '}';
    }
}
