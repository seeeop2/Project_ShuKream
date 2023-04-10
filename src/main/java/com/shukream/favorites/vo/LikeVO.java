package com.shukream.favorites.vo;

import org.springframework.stereotype.Component;

@Component("likeVO")
public class LikeVO {
	
	int like_idx; //관심등록인덱스
	String like_product_idx; //상품번호
	String like_mem_id; //회원아이디
	
	
	
	public int getLike_idx() {
		return like_idx;
	}
	public void setLike_idx(int like_idx) {
		this.like_idx = like_idx;
	}
	public String getLike_product_idx() {
		return like_product_idx;
	}
	public void setLike_product_idx(String like_product_idx) {
		this.like_product_idx = like_product_idx;
	}
	public String getLike_mem_id() {
		return like_mem_id;
	}
	public void setLike_mem_id(String like_mem_id) {
		this.like_mem_id = like_mem_id;
	}
	

	
	
}
