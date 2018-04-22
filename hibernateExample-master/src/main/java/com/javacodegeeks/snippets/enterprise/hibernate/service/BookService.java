package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.service.helper.GenericService;

public class BookService extends GenericService<Book> {


	public BookService() {
		super("from Book",Book.class);
	}


}
