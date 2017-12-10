/**
 * 
 */
package com.sen.learning.springwebdemo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sen.learning.springwebdemo.model.Author;
import com.sen.learning.springwebdemo.model.Book;
import com.sen.learning.springwebdemo.model.Publisher;
import com.sen.learning.springwebdemo.repositories.AuthorRepository;
import com.sen.learning.springwebdemo.repositories.BookRepository;
import com.sen.learning.springwebdemo.repositories.PublisherRepository;

/**
 * @author natha
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private PublisherRepository publisherRepository;
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	/**
	 * @param authorRepository
	 * @param bookRepository
	 */
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {

		Publisher mac = new Publisher("Mac Row Hill", "New York, USA");
		publisherRepository.save(mac);

		Author sen = new Author("Senthil", "Natha");
		Book wb = new Book("How to build wealth", "12345", mac);
		sen.getBooks().add(wb);
		wb.getAuthors().add(sen);

		authorRepository.save(sen);
		bookRepository.save(wb);

		// Publisher hnb = new Publisher("H & B", "California, USA");
		Author yos = new Author("Yoshitha", "Senthil");
		Book bt = new Book("Beauty Tips", "34332", mac);
		yos.getBooks().add(bt);
		bt.getAuthors().add(yos);

		authorRepository.save(yos);
		bookRepository.save(bt);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
}
