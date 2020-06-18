package lms.main.service;

import java.util.Scanner;

import lms.book.Book;
import lms.book.assembler.BookAssembler;
import lms.clearScreen.ClearScreen;
import lms.member.Member;
import lms.member.assembler.MemberAssembler;

public class RegisterService {

	private MemberAssembler ma;
	private BookAssembler ba;
	private Scanner sc;
	
	public RegisterService(MemberAssembler ma, BookAssembler ba, Scanner sc) {
		this.ma = ma;
		this.ba = ba;
		this.sc = sc;
	}
	
	public void call() {
		Running : while(true) {
			ClearScreen.clear();
			String input = printMenu();
			ClearScreen.clear();

			switch(input) {
				case "1" : memberRegist(); System.out.println("\n\tPress Enter.");
						 sc.nextLine(); break;
				case "2" : bookRegist(); System.out.println("\n\tPress Enter.");
					 	 sc.nextLine(); break;
				case "3" : break Running;
				default : System.out.println("\t다시 입력해주세요.");
			}
		}
	}
	
	private String printMenu() {
		String input = "";
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> 등록 서비스 <<");
		System.out.println("\t\t[1] 회원 등록");
		System.out.println("\t\t[2] 책 등록");
		System.out.println("\t\t[3] 돌아가기");
		System.out.println("\t-----------------------------------------------------");
		System.out.print("\t 입력 : ");
		input = sc.nextLine();
		return input;
	}
	
	
	private void bookRegist() {
		String name, publisher, loc;
		
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t책 등록하기");
		System.out.println("\t----------------------------------------");
		System.out.print("\t 책 이름 : ");
		name = sc.nextLine();
		System.out.print("\t 책 출판사 : ");
		publisher = sc.nextLine();
		System.out.print("\t 책 위치 : ");
		loc = sc.nextLine();
		ClearScreen.clear();
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t책 등록하기");
		System.out.println("\t----------------------------------------");
		System.out.println("\t 책 이름 : "+name);
		System.out.println("\t 출판사 : "+publisher);
		System.out.println("\t 위치 : "+loc);
		System.out.println("\t----------------------------------------");
		System.out.print("\t등록 하시겠습니까 [y/n] ? ");
		
		while(true) {
			String input = sc.nextLine();
			if(input.equals("y")) {
				Book b = new Book(name, publisher, loc);
				ba.getRegister().register(b);
				break;
			}
			else if(input.equals("n")) {
				System.out.println("\t등록이 취소되었습니다.");
				break;
			}
		}
		System.out.println();
	}
	
	private void memberRegist() {
		String name, gender, phoneNum;
		
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t회원 등록하기");
		System.out.println("\t----------------------------------------");
		System.out.print("\t 회원 이름 : ");
		name = sc.nextLine();
		System.out.print("\t 성별 : ");
		gender = sc.nextLine();
		System.out.print("\t 휴대폰 번호 : ");
		phoneNum = sc.nextLine();
		ClearScreen.clear();
		
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t회원 등록하기");
		System.out.println("\t----------------------------------------");
		System.out.println("\t 회원 이름 : "+name);
		System.out.println("\t 성별 : "+gender);
		System.out.println("\t 휴대폰 번호 : "+phoneNum);
		System.out.println("\t----------------------------------------");
		System.out.print("\t등록 하시겠습니까 [y/n] ? ");
		
		while(true) {
			String input = sc.nextLine();
			if(input.equals("y")) {
				Member m = new Member(name, gender, phoneNum);
				ma.getRegister().register(m);
				break;
			}
			else if(input.equals("n")) {
				System.out.println("\t등록이 취소되었습니다.");
				break;
			}
		}
		System.out.println();
		
	}
	
	
}
