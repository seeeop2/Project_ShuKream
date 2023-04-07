package com.shukream.member.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String user_name;
	private String user_email;
	@Override
	public String toString() {
		return "MemberVO [user_name=" + user_name + ", user_email=" + user_email + ", user_regdate=" + user_regdate
				+ ", user_update=" + user_update + ", select_level_id=" + select_level_id + "]";
	}
	private Date user_regdate;
	private Date user_update;
	private int select_level_id;
	
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
	public int getSelect_level_id() {
		return select_level_id;
	}
	public void setSelect_level_id(int select_level_id) {
		this.select_level_id = select_level_id;
	}
}


