package lms.book.service;

import java.util.Map;

import lms.book.Book;
import lms.book.dao.BookDAO;

public class AllBookSelectService {
	
	private BookDAO bookDAO;
	
	public AllBookSelectService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void call() {
		Map<String, Book> db = bookDAO.getBookDB();

		System.out.println();
		System.out.println(" >> 전체 책 정보   (이름 / 출판사 / 위치)");
		System.out.println();
			
		for(String key : db.keySet()) {
			Book b = db.get(key);
			System.out.println("   "+b.getName()+"  / " + b.getPublisher()+"  / " + b.getLocation());
		}
			
		System.out.println();
	}
}
