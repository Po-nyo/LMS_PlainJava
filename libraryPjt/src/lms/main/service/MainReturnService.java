package lms.main.service;

import java.util.Scanner;

import lms.book.Book;
import lms.book.assembler.BookAssembler;
import lms.clearScreen.ClearScreen;
import lms.rent.assembler.RentAssembler;

public class MainReturnService {
	private BookAssembler ba;
	private RentAssembler ra;
	private Scanner sc;
	
	public MainReturnService(BookAssembler ba, RentAssembler ra, Scanner sc) {
		this.ba = ba;
		this.ra = ra;
		this.sc = sc;
	}
	
	public void call() {
		Running : while(true) {
			ClearScreen.clear();
			String input = printMenu();
			ClearScreen.clear();

			switch(input) {
				case "1" : returnBook(); System.out.print("\n\tPress Enter.");
						 sc.nextLine(); break;
				case "2" : break Running;
				default : System.out.println("\t다시 입력해주세요.");
			}
		}
	}
	
	private String printMenu() {
		String input = "";
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> 책 반납 <<");
		System.out.println("\t\t[1] 책 반납하기");
		System.out.println("\t\t[2] 돌아가기");
		System.out.println("\t-----------------------------------------------------");
		System.out.print("\t 입력 : ");
		input = sc.nextLine();
		return input;
	}
	
	private void returnBook() {
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> 책 반납하기 <<");
		System.out.println("\t-----------------------------------------------------");
		System.out.print("\t 반납할 책 이름 : ");
		String input = sc.nextLine();
		Book b = ba.getSelector().findBook(input);
		
		if(b == null) {
			System.out.println();
			return;
		}
		ra.getReturnS().returnBook(b);
		System.out.println();
		
	}
}
