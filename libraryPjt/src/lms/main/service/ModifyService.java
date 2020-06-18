package lms.main.service;

import java.util.Scanner;

import lms.book.Book;
import lms.book.assembler.BookAssembler;
import lms.clearScreen.ClearScreen;
import lms.member.Member;
import lms.member.assembler.MemberAssembler;

public class ModifyService {
	
	private MemberAssembler ma;
	private BookAssembler ba;
	private Scanner sc;
	
	public ModifyService(MemberAssembler ma, BookAssembler ba, Scanner sc) {
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
				case "1" : memberModify(); System.out.print("\n\tPress Enter.");
						 sc.nextLine(); break;
				case "2" : bookModify(); System.out.print("\n\tPress Enter.");
					 	 sc.nextLine(); break;
				case "3" : break Running;
				default : System.out.println("\t다시 입력해주세요.");
			}
		}
	}
	
	private String printMenu() {
		String input = "";
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> 정보 수정 <<");
		System.out.println("\t\t[1] 회원 정보 수정");
		System.out.println("\t\t[2] 책 정보 수정");
		System.out.println("\t\t[3] 돌아가기");
		System.out.println("\t-----------------------------------------------------");
		System.out.print("\t 입력 : ");
		input = sc.nextLine();
		return input;
	}
	
	private void bookModify() {
		String name;
		
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t책 정보 수정하기");
		System.out.println("\t----------------------------------------");
		System.out.print("\t 수정할 책 이름 : ");
		name = sc.nextLine();
		Book b = ba.getSelector().findBook(name);
		
		if(b != null) {
			Book b2 = new Book(b.getName(), b.getPublisher(), b.getLocation());
			System.out.println("\t----------------------------------------");
			System.out.println("\t수정할 속성과 내용을 '/'로 구분하여 입력해주세요. (속성 : 이름, 출판사, 위치)");
			System.out.println("\tex) 출판사/수정할 출판사");
			System.out.print("\t>> ");
			String input = sc.nextLine();
			String[] s = input.split("/");
			
			if(s.length == 2) {
				if(s[0].equals("이름")) {
					b2.setName(s[1]);
				}
				else if(s[0].equals("출판사")) {
					b2.setPublisher(s[1]);
				}
				else if(s[0].equals("위치")) {
					b2.setLocation(s[1]);
				}
				else {
					System.out.println("\t잘못된 입력입니다.\n");
					return;
				}
				ClearScreen.clear();
				System.out.println("\t----------------------------------------");
				System.out.println("\t\t 수정된 정보");
				System.out.println("\t----------------------------------------");
				System.out.println("\t 책 이름 : "+b2.getName());
				System.out.println("\t 출판사 : "+b2.getPublisher());
				System.out.println("\t 위치 : "+b2.getLocation());
				System.out.println("\t----------------------------------------");
				System.out.print("\t수정 하시겠습니까 [y/n] ?");
				while(true) {
					input = sc.nextLine();
					if(input.equals("y")) {
						ba.getModifier().modify(b, b2);
						break;
					}
					else if(input.equals("n")) {
						System.out.println("\t수정이 취소되었습니다.");
						break;
					}
				}
				
			}
			else {
				System.out.println("\t잘못된 입력입니다.\n");
				return;
			}
			
			System.out.println();
			
		}
	}
	
	private void memberModify() {
		String name;
		
		System.out.println("\t----------------------------------------");
		System.out.println("\t\t회원 정보 수정하기");
		System.out.println("\t----------------------------------------");
		System.out.print("\t 수정할 회원 이름 : ");
		name = sc.nextLine();
		Member m = ma.getSelector().findMember(name);
		
		if(m != null) {
			Member m2 = new Member(m.getName(), m.getGender(), m.getPhoneNum());
			System.out.println("\t----------------------------------------");
			System.out.println("\t수정할 속성과 내용을 '/'로 구분하여 입력해주세요. (속성 : 이름, 성별, 휴대폰)");
			System.out.println("\tex) 휴대폰/010-1234-5678");
			System.out.print("\t>> ");
			String input = sc.nextLine();
			String[] s = input.split("/");
			
			if(s.length == 2) {
				if(s[0].equals("이름")) {
					m2.setName(s[1]);
				}
				else if(s[0].equals("성별")) {
					m2.setGender(s[1]);
				}
				else if(s[0].equals("휴대폰")) {
					m2.setPhoneNum(s[1]);
				}
				else {
					System.out.println("\t잘못된 입력입니다.\n");
					return;
				}
				ClearScreen.clear();
				System.out.println("\t----------------------------------------");
				System.out.println("\t\t 수정된 정보");
				System.out.println("\t----------------------------------------");
				System.out.println("\t 회원 이름 : "+m2.getName());
				System.out.println("\t 성별 : "+m2.getGender());
				System.out.println("\t 휴대폰 번호 : "+m2.getPhoneNum());
				System.out.println("\t----------------------------------------");
				System.out.print("\t수정 하시겠습니까 [y/n] ?");
				while(true) {
					input = sc.nextLine();
					if(input.equals("y")) {
						ma.getModifier().modify(m, m2);
						break;
					}
					else if(input.equals("n")) {
						System.out.println("\t수정이 취소되었습니다.");
						break;
					}
				}
				
			}
			else {
				System.out.println("\t잘못된 입력입니다.\n");
				return;
			}
			
			System.out.println();
			
		}
	}

}
