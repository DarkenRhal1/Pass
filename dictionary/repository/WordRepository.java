package com.dictionary.dictionary.repository;

import com.dictionary.dictionary.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//
//import com.dictionary.dictionary.model.Synonym;
//import com.dictionary.dictionary.model.Word;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query(value = "SELECT w.* FROM Word w JOIN synonym ON synonym.synonym_id = w.synonym_id WHERE w.synonym_id = ?1", nativeQuery = true)
    List<Word> findByWordId(Long wordId);

}
