package com.sen.learning.springwebdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sen.learning.springwebdemo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
