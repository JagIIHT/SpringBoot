package com.iiht.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.spring.boot.model.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

}