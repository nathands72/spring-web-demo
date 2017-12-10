/**
 * 
 */
package com.sen.learning.springwebdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sen.learning.springwebdemo.model.Publisher;

/**
 * @author natha
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
