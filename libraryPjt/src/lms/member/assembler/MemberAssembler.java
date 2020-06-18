package lms.member.assembler;

import lms.member.dao.MemberDAO;
import lms.member.service.AllMemberSelectService;
import lms.member.service.MemberDeleteService;
import lms.member.service.MemberModifyService;
import lms.member.service.MemberRegisterService;
import lms.member.service.MemberSelectService;

public class MemberAssembler {
	
	private MemberDAO memberDAO;
	private MemberRegisterService register;
	private MemberDeleteService deleter;
	private AllMemberSelectService allSelector;
	private MemberModifyService modifier;
	private MemberSelectService selector;
	
	public MemberAssembler(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
		
		this.register = new MemberRegisterService(memberDAO);
		this.deleter = new MemberDeleteService(memberDAO);
		this.allSelector = new AllMemberSelectService(memberDAO);
		this.modifier = new MemberModifyService(memberDAO);
		this.selector = new MemberSelectService(memberDAO);
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public MemberRegisterService getRegister() {
		return register;
	}

	public void setRegister(MemberRegisterService register) {
		this.register = register;
	}

	public MemberDeleteService getDeleter() {
		return deleter;
	}

	public void setDeleter(MemberDeleteService deleter) {
		this.deleter = deleter;
	}

	public AllMemberSelectService getAllSelector() {
		return allSelector;
	}

	public void setAllSelector(AllMemberSelectService allSelector) {
		this.allSelector = allSelector;
	}

	public MemberModifyService getModifier() {
		return modifier;
	}

	public void setModifier(MemberModifyService modifier) {
		this.modifier = modifier;
	}

	public MemberSelectService getSelector() {
		return selector;
	}

	public void setSelector(MemberSelectService selector) {
		this.selector = selector;
	}
	
}
