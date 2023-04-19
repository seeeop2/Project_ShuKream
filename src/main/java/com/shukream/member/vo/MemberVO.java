package com.shukream.member.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {

	
	private String user_name, user_email, user_pw;
	
	private Date user_regdate, user_update;
	
	private int seller_level_id;

	
	
	// Getter & Setter 생성
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public Date getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}

	public Date getUser_update() {
		return user_update;
	}

	public void setUser_update(Date user_update) {
		this.user_update = user_update;
	}

	public int getSeller_level_id() {
		return seller_level_id;
	}

	public void setSeller_level_id(int seller_level_id) {
		this.seller_level_id = seller_level_id;
	}
	
	
	// user_regdate(가입일)을 제외한 생성자 생성
	public MemberVO(String user_name, String user_email, String user_pw, int seller_level_id) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.seller_level_id = seller_level_id;
	}

	// 기본 생성자 생성
	public MemberVO() {
		super();
	}
	
	// 모두 가져오는 생성자 생성
	public MemberVO(String user_name, String user_email, String user_pw, Date user_regdate, Date user_update,
			int seller_level_id) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.user_regdate = user_regdate;
		this.user_update = user_update;
		this.seller_level_id = seller_level_id;
	}

	@Override
	public String toString() {
		return "MemberVO [user_name=" + user_name + ", user_email=" + user_email + ", user_pw=" + user_pw
				+ ", user_regdate=" + user_regdate + ", user_update=" + user_update + ", seller_level_id="
				+ seller_level_id + "]";
	}


	
	
	
	
	
	
	
	

}
