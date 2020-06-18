package lms.rent.service;

import lms.book.Book;
import lms.book.dao.BookDAO;
import lms.member.Member;
import lms.member.dao.MemberDAO;
import lms.rent.dao.RentDAO;

public class RentService {
	private RentDAO rentDAO;
	private MemberDAO memberDAO;
	private BookDAO bookDAO;
	
	public RentService(RentDAO rentDAO, MemberDAO memberDAO, BookDAO bookDAO) {
		this.rentDAO = rentDAO;
		this.setMemberDAO(memberDAO);
		this.setBookDAO(bookDAO);
	}
	
	public void rent(Member m, Book b) {
		if(!b.isAvailable())
			System.out.println("\t대여중인 책 입니다.");
		else {
			b.setAvailable(false);
			rentDAO.insert(m, b);
			System.out.println("\t 대여가 완료되었습니다.");
		}
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
}
