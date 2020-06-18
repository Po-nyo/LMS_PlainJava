package lms.book.service;

import java.util.Map;

import lms.book.Book;
import lms.book.dao.BookDAO;

public class BookModifyService {
	
	private BookDAO bookDAO;
	
	public BookModifyService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void modify(Book oldB, Book newB) {
		Map<String, Book> db = bookDAO.getBookDB();
		db.remove(oldB.getName());
		db.put(newB.getName(), newB);
		
		System.out.println("\t 수정이 완료되었습니다.");
	}

}
