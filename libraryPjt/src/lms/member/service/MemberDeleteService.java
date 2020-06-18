package lms.member.service;

import lms.member.dao.MemberDAO;

public class MemberDeleteService {
	
	private MemberDAO memberDAO;

	public MemberDeleteService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
}
