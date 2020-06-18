package lms.book.service;

import lms.book.dao.BookDAO;

public class BookDeleteService {
	
	private BookDAO bookDAO;
	
	public BookDeleteService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

}
