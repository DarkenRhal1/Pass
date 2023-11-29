package com.dictionary.dictionary.repository;

import com.dictionary.dictionary.model.Thesaurus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//
//import com.dictionary.dictionary.model.Thesaurus;
//import org.springframework.data.repository.CrudRepository;
//
@Repository
public interface ThesaurusRepository extends JpaRepository<Thesaurus, Long> {
}
