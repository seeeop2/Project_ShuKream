package com.shukream.event.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

// 어노테이션 컴포넌트 적용시키기
@Component("eventVO")
public class EventVO {
	
	// String TYPE으로 처리 된 DB의 name 값 동일하게 추가
	private String member_id, a_cnt, u_cnt, d_cnt, d_ticket, d_contents, d_confirm, d_coupon;
	
	// Number TYPE으로 처리 된 DB의 name 값 동일하게 추가
	private int d_idx;
	
	private Date d_date, expiry_date;

	// Getter & Setter 추가
	
	public String getD_coupon() {
		return d_coupon;
	}

	public void setD_coupon(String d_coupon) {
		this.d_coupon = d_coupon;
	}
	
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getA_cnt() {
		return a_cnt;
	}

	public void setA_cnt(String a_cnt) {
		this.a_cnt = a_cnt;
	}

	public String getU_cnt() {
		return u_cnt;
	}

	public void setU_cnt(String u_cnt) {
		this.u_cnt = u_cnt;
	}

	public String getD_cnt() {
		return d_cnt;
	}

	public void setD_cnt(String d_cnt) {
		this.d_cnt = d_cnt;
	}

	public String getD_ticket() {
		return d_ticket;
	}

	public void setD_ticket(String d_ticket) {
		this.d_ticket = d_ticket;
	}

	public String getD_contents() {
		return d_contents;
	}

	public void setD_contents(String d_contents) {
		this.d_contents = d_contents;
	}

	public String getD_confirm() {
		return d_confirm;
	}

	public void setD_confirm(String d_confirm) {
		this.d_confirm = d_confirm;
	}

	public int getD_idx() {
		return d_idx;
	}

	public void setD_idx(int d_idx) {
		this.d_idx = d_idx;
	}

	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public Date getD_date() {
		return d_date;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	// 기본 생성자
	public EventVO() {
		super();
	}
	
	
	
	
	
	
}
