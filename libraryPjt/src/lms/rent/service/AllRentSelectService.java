package lms.rent.service;

import java.util.ArrayList;
import java.util.Map;

import lms.book.Book;
import lms.member.Member;
import lms.rent.dao.RentDAO;

public class AllRentSelectService {
	
	private RentDAO rentDAO;
	
	public AllRentSelectService(RentDAO rentDAO) {
		this.rentDAO = rentDAO;
	}
	
	public void call() {
		Map<Member, ArrayList<Book>> db = rentDAO.getRentDB();
		
		System.out.println();
		System.out.println(" >> 전체 대여 정보 (빌린사람 / 책이름)");
		
		for(Member m : db.keySet()) {
			ArrayList<Book> list = db.get(m);
			System.out.print("   "+m.getName()+" / ");
			
			for(int i=0; i<list.size(); i++) {
				System.out.print("["+(i+1)+"]"+list.get(i).getName()+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}

}
