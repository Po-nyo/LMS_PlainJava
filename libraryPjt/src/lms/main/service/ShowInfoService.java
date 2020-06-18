package lms.main.service;

import java.util.Scanner;

import lms.book.assembler.BookAssembler;
import lms.clearScreen.ClearScreen;
import lms.member.assembler.MemberAssembler;
import lms.rent.assembler.RentAssembler;

public class ShowInfoService {
	
	private MemberAssembler ma;
	private BookAssembler ba;
	private RentAssembler ra;
	private Scanner sc;
	
	public ShowInfoService(MemberAssembler ma, BookAssembler ba, RentAssembler ra, Scanner sc) {
		this.ma = ma;
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
				case "1" : ma.getAllSelector().call(); System.out.print("\nPress Enter.");
						 sc.nextLine(); break;
				case "2" : ba.getAllSelector().call(); System.out.print("\nPress Enter.");
					 	 sc.nextLine(); break;
				case "3" : ra.getAllSelector().call(); System.out.print("\nPress Enter.");
						 sc.nextLine(); break;
				case "4" : ba.getSelector().findBook(bookName()); System.out.print("\n\tPress Enter.");
						 sc.nextLine(); break;
				case "5" : findMember();
				case "6" : break Running;
				default : System.out.println("\t다시 입력해주세요.");
			}
		}
	}
	
	private String printMenu() {
		String input = "";
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> 정보 검색 <<");
		System.out.println("\t\t[1] 전체 회원 정보");
		System.out.println("\t\t[2] 전체 책 정보");
		System.out.println("\t\t[3] 전체 대여 정보");
		System.out.println("\t\t[4] 책 검색하기");
		System.out.println("\t\t[5] 회원 검색하기");
		System.out.println("\t\t[6] 돌아가기");
		System.out.println("\t-----------------------------------------------------");
		System.out.print("\t 입력 : ");
		input = sc.nextLine();
		return input;
	}
	
	private String bookName() {
		String b_name;
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t책 검색하기");
		System.out.println("\t----------------------------------------");
		System.out.print("\t 검색할 책 이름 : ");
		b_name = sc.nextLine();
		ClearScreen.clear();
		return b_name;
	}
	
	private void findMember() {
		String m_name;
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t회원 검색하기");
		System.out.println("\t----------------------------------------");
		System.out.print("\t찾을 회원 이름 : ");
		m_name = sc.nextLine();
		ClearScreen.clear();
		
		ma.getSelector().findMember(m_name);
		System.out.print("\t빌린 책 : ");
		ra.getSelector().findByMemberName(m_name);
		System.out.print("\n\tPress Enter.");
		sc.nextLine();
		ClearScreen.clear();
	}

}
