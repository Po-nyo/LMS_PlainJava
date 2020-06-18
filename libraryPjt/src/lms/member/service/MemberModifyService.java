package lms.member.service;

import java.util.Map;

import lms.member.Member;
import lms.member.dao.MemberDAO;

public class MemberModifyService {
	
	private MemberDAO memberDAO;
	
	public MemberModifyService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void modify(Member oldM, Member newM) {
		Map<String, Member> db = memberDAO.getMemberDB();
		db.remove(oldM.getName());
		db.put(newM.getName(), newM);
		
		System.out.println("\t 수정이 완료되었습니다.");
	}


}
