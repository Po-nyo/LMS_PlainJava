package lms.main;

import java.util.Scanner;

import lms.book.assembler.BookAssembler;
import lms.clearScreen.ClearScreen;
import lms.database.DatabaseConn;
import lms.main.service.assembler.MainServiceAssembler;
import lms.member.assembler.MemberAssembler;
import lms.rent.assembler.RentAssembler;

public class LMSProcessing {
	
	private DatabaseConn con;
	private MemberAssembler ma;
	private BookAssembler ba;
	private RentAssembler ra;
	private Scanner sc;
	
	private MainServiceAssembler msa;
	
	public LMSProcessing() {
		sc = new Scanner(System.in);
		this.con = new DatabaseConn();
		this.ma = new MemberAssembler(con.getMemberDAO());
		this.ba = new BookAssembler(con.getBookDAO());
		this.ra = new RentAssembler(con.getRentDAO(), con.getMemberDAO(), con.getBookDAO());
		this.msa = new MainServiceAssembler(ma, ba, ra, sc);
		
		ma.getAllSelector().call();
		ba.getAllSelector().call();
		ra.getAllSelector().call();
	}
	
	public void run() {
		System.out.println("*** Library Management System ***");
		System.out.println("Press Enter.");
		sc.nextLine();
		ClearScreen.clear();
		
		Running : while(true) {
			String input = printHomeMenu();
			ClearScreen.clear();
			switch(input) {
				case "1" : msa.getShowInfoService().call(); break;
				case "2" : msa.getRegisterService().call(); break;
				case "3" : msa.getmodifyService().call(); break;
				case "4" : msa.getMainRentService().call(); break;
				case "5" : msa.getMainReturnService().call(); break;
				case "6" : con.commit(); break;
				case "0" : con.commit(); System.out.println("LMS 를 종료합니다. \n\nlmsProject"); 
						   System.out.println("Last Update 2020.04.15");break Running;
				default : 
			}
		}
	}
	
	private String printHomeMenu() {
		String input = "";
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t Library Management System");
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t >> Home Menu <<");
		System.out.println("\t\t[1] 정보 검색(회원정보, 책 정보, 대여정보)");
		System.out.println("\t\t[2] 등록 (회원, 책)");
		System.out.println("\t\t[3] 정보 수정 (회원, 책)");
		System.out.println("\t\t[4] 책 대여하기");
		System.out.println("\t\t[5] 책 반납하기");
		System.out.println("\t\t[6] 데이터 저장");
		System.out.println("\t\t[0] 종료 및 데이터 저장");
		System.out.println("\t-----------------------------------------------------");
		System.out.print("\t 입력 : ");
		input = sc.nextLine();
		return input;
	}

}
