package lms.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import lms.book.Book;
import lms.book.dao.BookDAO;
import lms.member.Member;
import lms.member.dao.MemberDAO;
import lms.rent.dao.RentDAO;

public class DatabaseConn {
	
	private MemberDAO memberDAO;
	private BookDAO bookDAO;
	private RentDAO rentDAO;
	
	public DatabaseConn() {
		memberDAO = new MemberDAO();
		bookDAO = new BookDAO();
		rentDAO = new RentDAO();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(".\\members.txt"),"UTF8"));
			String data = "";
			while((data=br.readLine())!=null) {
				String[] s = data.split("/");
				Member m = new Member(s[0], s[1], s[2]);
				memberDAO.insert(m);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("** 기존 members data 없음 **");
		} catch(Exception e) {
			System.out.println("** members 로딩 실패 **");
			e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(".\\books.txt"),"UTF8"));
			String data = "";
			while((data=br.readLine())!=null) {
				String[] s = data.split("/");
				Book b = new Book(s[0], s[1], s[2]);
				bookDAO.insert(b);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("** 기존 books 없음 **");
		} catch(Exception e) {
			System.out.println("** books 로딩 실패 **");
			e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(".\\rents.txt"),"UTF8"));
			String data = "";
			while((data=br.readLine())!=null) {
				String[] s = data.split("/");
				Member m = memberDAO.select(s[0]);
				for(int i=1; i<s.length; i++) {
					Book b = bookDAO.select(s[i]);
					b.setAvailable(false);
					rentDAO.insert(m, b);					
				}
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("** 기존 rents 없음 **");
		} catch(Exception e) {
			System.out.println("** rents 로딩 실패 **");
			e.printStackTrace();
		}
		System.out.println("** 데이터 로딩 완료 **");
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setmemberDAO(MemberDAO db) {
		this.memberDAO = db;
	}
	
	public BookDAO getBookDAO() {
		return bookDAO;
	}
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public RentDAO getRentDAO() {
		return rentDAO;
	}
	
	public void setRentDAO(RentDAO rentDAO) {
		this.rentDAO = rentDAO;
	}
	
	public void commit() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(".\\members.txt"),"UTF8"));
			
			Map<String, Member> db = memberDAO.getMemberDB();
			Iterator<String> it = db.keySet().iterator();
			while(it.hasNext()) {
				String data = "";
				String key = it.next();
				Member m = db.get(key);
				data += m.getName() + "/";
				data += m.getGender() + "/";
				data += m.getPhoneNum()+"\n";
				
				bw.write(data);
			}
			bw.close();
			System.out.println("Members 커밋 완료");
		} catch (IOException e) { 
			System.out.println("Members 커밋 실패");
			e.printStackTrace();
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(".\\books.txt"),"UTF8"));
			
			Map<String, Book> db = bookDAO.getBookDB();
			Iterator<String> it = db.keySet().iterator();
			while(it.hasNext()) {
				String data = "";
				String key = it.next();
				Book b = db.get(key);
				data += b.getName() + "/";
				data += b.getPublisher() + "/";
				data += b.getLocation()+"\n";
				
				bw.write(data);
			}
			bw.close();
			System.out.println("Books 커밋 완료");
		} catch (IOException e) { 
			System.out.println("Books 커밋 실패");
			e.printStackTrace();
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(".\\rents.txt"),"UTF8"));
			
			Map<Member, ArrayList<Book>> db = rentDAO.getRentDB();
			Iterator<Member> it = db.keySet().iterator();
			while(it.hasNext()) {
				String data = "";
				Member m = it.next();
				data += m.getName() + "/";
				for(Book b : db.get(m)) {
					data += b.getName() + "/";
				}
				data+="\n";
				bw.write(data);
			}
			bw.close();
			System.out.println("Rents 커밋 완료");
		} catch (IOException e) { 
			System.out.println("Rents 커밋 실패");
			e.printStackTrace();
		}
		
	}
	
	

}
