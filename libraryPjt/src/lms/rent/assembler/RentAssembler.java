package lms.rent.assembler;

import lms.book.dao.BookDAO;
import lms.member.dao.MemberDAO;
import lms.rent.dao.RentDAO;
import lms.rent.service.AllRentSelectService;
import lms.rent.service.RentSelectService;
import lms.rent.service.RentService;
import lms.rent.service.ReturnService;

public class RentAssembler {
	
	private RentDAO rentDAO;
	private MemberDAO memberDAO;
	private BookDAO bookDAO;
	private AllRentSelectService allSelector;
	private RentService renter;
	private RentSelectService selector;
	private ReturnService returnS;
	
	public RentAssembler(RentDAO rentDAO, MemberDAO memberDAO, BookDAO bookDAO) {
		this.rentDAO = rentDAO;
		this.setMemberDAO(memberDAO);
		this.setBookDAO(bookDAO);
		allSelector = new AllRentSelectService(rentDAO);
		renter = new RentService(rentDAO, memberDAO, bookDAO);
		selector = new RentSelectService(rentDAO, memberDAO);
		returnS = new ReturnService(rentDAO);
	}

	public RentDAO getRentDAO() {
		return rentDAO;
	}

	public void setRentDAO(RentDAO rentDAO) {
		this.rentDAO = rentDAO;
	}

	public AllRentSelectService getAllSelector() {
		return allSelector;
	}

	public void setAllSelector(AllRentSelectService allSelector) {
		this.allSelector = allSelector;
	}

	public RentService getRenter() {
		return renter;
	}

	public void setRenter(RentService renter) {
		this.renter = renter;
	}

	public RentSelectService getSelector() {
		return selector;
	}

	public void setSelector(RentSelectService selector) {
		this.selector = selector;
	}

	public ReturnService getReturnS() {
		return returnS;
	}

	public void setReturnS(ReturnService returnS) {
		this.returnS = returnS;
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