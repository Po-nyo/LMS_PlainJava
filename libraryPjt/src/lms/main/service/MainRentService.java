package lms.main.service;

import java.util.Scanner;

import lms.book.Book;
import lms.book.assembler.BookAssembler;
import lms.clearScreen.ClearScreen;
import lms.member.Member;
import lms.member.assembler.MemberAssembler;
import lms.rent.assembler.RentAssembler;

public class MainRentService {
	
	
	private MemberAssembler ma;
	private BookAssembler ba;
	private RentAssembler ra;
	
	private Scanner sc;

	public MainRentService(MemberAssembler ma, BookAssembler ba, RentAssembler ra, Scanner sc) {
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
				case "1" : rent(); System.out.print("\n\tPress Enter.");
						 sc.nextLine(); break;
				case "2" : break Running;
				default : System.out.println("\t다시 입력해주세요.");
			}
		}
	}
	
	private String printMenu() {
		String input = "";
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> 책 대여 <<");
		System.out.println("\t\t[1] 책 대여하기");
		System.out.println("\t\t[2] 돌아가기");
		System.out.println("\t-----------------------------------------------------");
		System.out.print("\t 입력 : ");
		input = sc.nextLine();
		return input;
	}
	
	private void rent() {
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> 책 대여 서비스 <<");
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t 빌리는 회원 이름과 빌릴 책 이름을 '/'로 구분하여 입력해주세요");
		System.out.println("\t ex) 김철수/빌리는책이름");
		System.out.print("\t>> ");
		String input = sc.nextLine();
		String[] s = input.split("/");
		
		if(s.length == 2) {
			Member m = ma.getSelector().findMember(s[0]);
			Book b = ba.getSelector().findBook(s[1]);
			if(m==null || b==null) {
				System.out.println();
				return;
			}
			System.out.println();
			System.out.print("\t대여 하시겠습니까 [y/n] ? ");
			while(true) {
				input = sc.nextLine();
				if(input.equals("y")) {
					ra.getRenter().rent(m, b);
					break;
				}
				else {
					System.out.println("\t대여가 취소되었습니다.");
					break;
				}
			}
		}
		else {
			System.out.println("\t잘못된 입력입니다.\n");
			return;
		}
		
	}
}
