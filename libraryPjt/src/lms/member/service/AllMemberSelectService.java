package lms.member.service;

import java.util.Map;

import lms.member.Member;
import lms.member.dao.MemberDAO;

public class AllMemberSelectService {
	
	private MemberDAO memberDAO;
	
	public AllMemberSelectService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void call() {
		Map<String, Member> db = memberDAO.getMemberDB();
		
		System.out.println();
		System.out.println(" >> 전체 회원 정보");
		System.out.println("   이름\t성별\t휴대폰번호\n");
		
		for(String key : db.keySet()) {
			Member m = db.get(key);
			System.out.println("   "+m.getName()+"\t"+m.getGender()+"\t"+m.getPhoneNum());
		}
		
		System.out.println();
	}

}
