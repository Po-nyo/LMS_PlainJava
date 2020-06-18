package lms.member.service;

import lms.member.Member;
import lms.member.dao.MemberDAO;

public class MemberRegisterService {
	
	private MemberDAO memberDAO;
	
	public MemberRegisterService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void register(Member m) {
		if(!isRegistered(m.getName())) {
			memberDAO.insert(m);
			System.out.println("\t등록이 완료되었습니다.");
		}
		else {
			System.out.println("\t이미 등록된 회원입니다.");
		}
	}
	
	public boolean isRegistered(String name) {
		if(memberDAO.select(name)==null) 
			return false;
		else
			return true;
	}

}
