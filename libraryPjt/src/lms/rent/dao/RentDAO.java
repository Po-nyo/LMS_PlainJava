package lms.rent.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lms.book.Book;
import lms.member.Member;

public class RentDAO {
	private Map<Member, ArrayList<Book>> rentDB = new HashMap<>();
	
	public void insert(Member m, Book b) {
		if(rentDB.containsKey(m))
			rentDB.get(m).add(b);
		else {
			rentDB.put(m, new ArrayList<Book>());
			rentDB.get(m).add(b);
		}
			
	}
	
	public Map<Member, ArrayList<Book>> getRentDB() {
		return rentDB;
	}
	
	public void setRendDB(Map<Member, ArrayList<Book>> rentDB) {
		this.rentDB = rentDB;
	}
}
