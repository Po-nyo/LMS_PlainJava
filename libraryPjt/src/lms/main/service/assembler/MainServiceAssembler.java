package lms.main.service.assembler;

import java.util.Scanner;

import lms.book.assembler.BookAssembler;
import lms.main.service.MainRentService;
import lms.main.service.MainReturnService;
import lms.main.service.ModifyService;
import lms.main.service.RegisterService;
import lms.main.service.ShowInfoService;
import lms.member.assembler.MemberAssembler;
import lms.rent.assembler.RentAssembler;

public class MainServiceAssembler {
	
	private MemberAssembler ma;
	private BookAssembler ba;
	private RentAssembler ra;
	private Scanner sc;
	
	private ShowInfoService sis;
	private RegisterService rs;
	private ModifyService ms;
	private MainRentService mrs;
	private MainReturnService returnS;
	
	public MainServiceAssembler(MemberAssembler ma, BookAssembler ba, RentAssembler ra, Scanner sc) {
		this.setMa(ma);
		this.setBa(ba);
		this.setRa(ra);
		this.setSc(sc);
		
		sis = new ShowInfoService(ma, ba, ra, sc);
		rs = new RegisterService(ma, ba, sc);
		ms = new ModifyService(ma, ba, sc);
		mrs = new MainRentService(ma, ba, ra, sc);
		returnS = new MainReturnService(ba, ra, sc);
	}
	
	public ShowInfoService getShowInfoService() {
		return this.sis;
	}
	
	public RegisterService getRegisterService() {
		return this.rs;
	}
	
	public ModifyService getmodifyService() {
		return this.ms;
	}
	
	public MainRentService getMainRentService() {
		return mrs;
	}
	
	public MainReturnService getMainReturnService() {
		return returnS;
	}

	public MemberAssembler getMa() {
		return ma;
	}

	public void setMa(MemberAssembler ma) {
		this.ma = ma;
	}

	public BookAssembler getBa() {
		return ba;
	}

	public void setBa(BookAssembler ba) {
		this.ba = ba;
	}

	public RentAssembler getRa() {
		return ra;
	}

	public void setRa(RentAssembler ra) {
		this.ra = ra;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
