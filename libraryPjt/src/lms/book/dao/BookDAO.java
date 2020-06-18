package lms.book.dao;

import java.util.HashMap;
import java.util.Map;

import lms.book.Book;

public class BookDAO {
	
	private Map<String, Book> bookDB = new HashMap<>();
	
	public void insert(Book b) {
		bookDB.put(b.getName(), b);
	}
	
	public void delete(Book b) {
		bookDB.remove(b.getName());
	}
	
	public Book select(String name) {
		return bookDB.get(name);
	}
	
	public void delete(String name) {
		bookDB.remove(name);
	}
	
	public void update(Book oldB, Book b) {
		bookDB.remove(oldB.getName());
		bookDB.put(b.getName(), b);
	}
	
	public void setBookDB(Map<String, Book> bookDB) {
		this.bookDB = bookDB;
	}
	
	public Map<String, Book> getBookDB() {
		return this.bookDB;
	}

}
