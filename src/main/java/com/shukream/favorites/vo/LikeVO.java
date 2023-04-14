package com.shukream.favorites.vo;

import org.springframework.stereotype.Component;

@Component("likeVO")
public class LikeVO {
	
	int like_idx; //관심등록인덱스
	String like_product; //상품번호
	String like_mem_id; //회원아이디
	String like_product_name_en; //관심상품 이름 (영어)
	String like_product_name_kor; //관심상품 이름 (한국어)
	int like_product_price; //관심상품 가격
	String like_img_file; //관심상품 이미지
	
	
	public String getLike_product_name_en() {
		return like_product_name_en;
	}
	public void setLike_product_name_en(String like_product_name_en) {
		this.like_product_name_en = like_product_name_en;
	}
	public String getLike_product_name_kor() {
		return like_product_name_kor;
	}
	public void setLike_product_name_kor(String like_product_name_kor) {
		this.like_product_name_kor = like_product_name_kor;
	}
	public int getLike_product_price() {
		return like_product_price;
	}
	public void setLike_product_price(int like_product_price) {
		this.like_product_price = like_product_price;
	}
	public String getLike_img_file() {
		return like_img_file;
	}
	public void setLike_img_file(String like_img_file) {
		this.like_img_file = like_img_file;
	}
	public int getLike_idx() {
		return like_idx;
	}
	public void setLike_idx(int like_idx) {
		this.like_idx = like_idx;
	}
	public String getLike_product() {
		return like_product;
	}
	public void setLike_product(String like_product) {
		this.like_product = like_product;
	}
	public String getLike_mem_id() {
		return like_mem_id;
	}
	public void setLike_mem_id(String like_mem_id) {
		this.like_mem_id = like_mem_id;
	}
	

	
	
}
