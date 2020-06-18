package lms.book.service;

import lms.book.Book;
import lms.book.dao.BookDAO;

public class BookRegisterService {
	
	private BookDAO bookDAO;
	
	public BookRegisterService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void register(Book b) {
		if(!isRegistered(b.getName())) {
			bookDAO.insert(b);
			System.out.println("\t등록이 완료되었습니다.");
		}
		else
			System.out.println("\t이미 등록된 책입니다.");
			
	}
	
	public boolean isRegistered(String name) {
		if(bookDAO.select(name)==null)
			return false;
		else
			return true;
	}

}
