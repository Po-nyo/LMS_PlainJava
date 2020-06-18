package lms.rent.service;

import java.util.ArrayList;
import java.util.Map;

import lms.book.Book;
import lms.member.Member;
import lms.member.dao.MemberDAO;
import lms.rent.dao.RentDAO;

public class RentSelectService {
	private RentDAO rentDAO;
	private MemberDAO memberDAO;
	
	public RentSelectService(RentDAO rentDAO, MemberDAO memberDAO) {
		this.rentDAO = rentDAO;
		this.memberDAO = memberDAO;
	}
	
	public void findByMemberName(String name) {
		Map<Member, ArrayList<Book>> db = rentDAO.getRentDB();
		Member m = memberDAO.select(name);
		ArrayList<Book> list = db.get(m);
		
		
		if(list==null)
			System.out.println("빌린 책 없음");
		else {
			for(int i=0; i<list.size(); i++) {
				System.out.print("["+(i+1)+"]"+list.get(i).getName()+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
