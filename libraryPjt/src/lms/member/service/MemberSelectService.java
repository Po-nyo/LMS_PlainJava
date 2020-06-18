package lms.member.service;

import lms.member.Member;
import lms.member.dao.MemberDAO;

public class MemberSelectService {
	
	private MemberDAO memberDAO;
	
	public MemberSelectService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public Member findMember(String member_name) {
		Member m = memberDAO.select(member_name);
		System.out.println("\t----------------------------------------");
		System.out.println("\tSerach for : "+member_name);
		System.out.println("\t----------------------------------------");
		if(m==null)
			System.out.println("\t없는 회원 입니다.");
		else {
			System.out.println("\t이름 : "+m.getName());
			System.out.println("\t성별 : "+m.getGender());
			System.out.println("\t휴대폰 번호  : "+m.getPhoneNum());			
		}
		
		return m;
	}
}
