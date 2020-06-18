package lms.book.assembler;

import lms.book.dao.BookDAO;
import lms.book.service.AllBookSelectService;
import lms.book.service.BookDeleteService;
import lms.book.service.BookModifyService;
import lms.book.service.BookRegisterService;
import lms.book.service.BookSelectService;

public class BookAssembler {
	
	private BookDAO bookDAO;
	private AllBookSelectService allSelector;
	private BookDeleteService deleter;
	private BookModifyService modifier;
	private BookRegisterService register;
	private BookSelectService selector;
	
	public BookAssembler(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
		
		allSelector = new AllBookSelectService(bookDAO);
		deleter = new BookDeleteService(bookDAO);
		modifier = new BookModifyService(bookDAO);
		register = new BookRegisterService(bookDAO);
		selector = new BookSelectService(bookDAO);
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public AllBookSelectService getAllSelector() {
		return allSelector;
	}

	public void setAllSelector(AllBookSelectService allSelector) {
		this.allSelector = allSelector;
	}

	public BookDeleteService getDeleter() {
		return deleter;
	}

	public void setDeleter(BookDeleteService deleter) {
		this.deleter = deleter;
	}

	public BookModifyService getModifier() {
		return modifier;
	}

	public void setModifier(BookModifyService modifier) {
		this.modifier = modifier;
	}

	public BookRegisterService getRegister() {
		return register;
	}

	public void setRegister(BookRegisterService register) {
		this.register = register;
	}

	public BookSelectService getSelector() {
		return selector;
	}

	public void setSelector(BookSelectService selector) {
		this.selector = selector;
	}
	
	

}
