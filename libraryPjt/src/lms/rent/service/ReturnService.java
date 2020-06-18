package lms.rent.service;

import java.util.ArrayList;
import java.util.Map;

import lms.book.Book;
import lms.member.Member;
import lms.rent.dao.RentDAO;

public class ReturnService {
	private RentDAO rentDAO;
	
	public ReturnService(RentDAO rentDAO) {
		this.rentDAO = rentDAO;
	}
	
	public void returnBook(Book b) {
		Map<Member, ArrayList<Book>> db = rentDAO.getRentDB();
		
		for(Member key : db.keySet()) {
			ArrayList<Book> list = db.get(key);
			if(list.contains(b)) {
				b.setAvailable(true);
				list.remove(b);
				System.out.println("\n\t반납이 완료되었습니다.");
				return;
			}
		}
		
		System.out.println("\n\t대여 기록이 없는 책 입니다.");
	}

}
