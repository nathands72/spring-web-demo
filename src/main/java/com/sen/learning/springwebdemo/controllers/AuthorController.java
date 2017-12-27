package com.sen.learning.springwebdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sen.learning.springwebdemo.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;

	/**
	 * @param authorRepository
	 */
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model model) {

		model.addAttribute("authors", authorRepository.findAll());

		return "authors";
	}
}
