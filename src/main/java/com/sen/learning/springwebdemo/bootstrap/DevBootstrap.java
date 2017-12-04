/**
 * 
 */
package com.sen.learning.springwebdemo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sen.learning.springwebdemo.model.Author;
import com.sen.learning.springwebdemo.model.Book;
import com.sen.learning.springwebdemo.repositories.AuthorRepository;
import com.sen.learning.springwebdemo.repositories.BookRepository;

/**
 * @author natha
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	/**
	 * @param authorRepository
	 * @param bookRepository
	 */
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private void initData() {

		Author sen = new Author("Senthil", "Natha");
		Book wb = new Book("How to build wealth", "12345", "S&S");
		sen.getBooks().add(wb);
		wb.getAuthors().add(sen);

		authorRepository.save(sen);
		bookRepository.save(wb);

		Author yos = new Author("Yoshitha", "Senthil");
		Book bt = new Book("Beauty Tips", "34332", "H&B");
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
