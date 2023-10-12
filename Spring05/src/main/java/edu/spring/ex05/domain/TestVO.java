package edu.spring.ex05.domain;

public class TestVO {
	private String userid;
	private String email;
	private String fileName;
	
	
	public TestVO() {}


	public TestVO(String userid, String email, String fileName) {
		super();
		this.userid = userid;
		this.email = email;
		this.fileName = fileName;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "TestVO [userid=" + userid + ", email=" + email + ", fileName=" + fileName + "]";
	}
	
	
	
	
}
