package lms.book.service;

import lms.book.Book;
import lms.book.dao.BookDAO;

public class BookSelectService {
	
	private BookDAO bookDAO;
	
	public BookSelectService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public Book findBook(String book_name) {
		Book b = bookDAO.select(book_name);
		System.out.println("\t----------------------------------------");
		System.out.println("\tSearch for : "+book_name);
		System.out.println("\t----------------------------------------");
		if(b==null)
			System.out.println("\t없는 책 입니다.");
		else {
			System.out.println("\t책 이름 : "+b.getName());
			System.out.println("\t책 출판사 : "+b.getPublisher());
			System.out.println("\t책 위치 : "+b.getLocation());
			System.out.print("\t대여 가능 여부 : ");
			if(b.isAvailable())
				System.out.print("가능");
			else
				System.out.print("불가");
			System.out.println();
		}
		
		return b;
	}
	

}
