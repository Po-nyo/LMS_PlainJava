package lms.member;

public class Member {
	
	private String name;
	private String gender;
	private String phoneNum;
	
	
	public Member(String name, String gender, String phoneNum) {
		this.name = name;
		this.gender = gender;
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	

}
