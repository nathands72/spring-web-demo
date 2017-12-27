/**
 * 
 */
package com.sen.learning.springwebdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sen.learning.springwebdemo.model.Book;

/**
 * @author natha
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
