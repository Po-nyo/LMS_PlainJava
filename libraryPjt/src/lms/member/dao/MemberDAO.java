package lms.member.dao;

import java.util.HashMap;
import java.util.Map;

import lms.member.Member;

public class MemberDAO {
	
	private Map<String, Member> memberDB = new HashMap<>();
	
	public void insert(Member m) {
		memberDB.put(m.getName(), m);
	}
	
	public Member select(String name) {
		return memberDB.get(name);
	}
	
	public void update(Member oldM, Member m) {
		memberDB.remove(oldM.getName());
		memberDB.put(m.getName(), m);
	}
	
	public void delete(String name) {
		memberDB.remove(name);
	}
	
	public void setMemberDB(Map<String, Member> memberDB) {
		this.memberDB = memberDB;
	}
	
	public Map<String, Member> getMemberDB() {
		return memberDB;
	}

}
