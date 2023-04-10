package com.shukream.favorites.vo;

import org.springframework.stereotype.Component;

@Component("favoritesVO")
public class FavoritesVO {
	
	int	product_id;//상품인덱스					
	String product_name_en;//상품명			
	String product_name_kor;//상품명			
	String model_number;//모델넘버
    int	product_price;//판매가
	String product_release_date;//등록일
	String PRODUCT_COLOR;//색상
	
	
	int	img_id;//이미지인덱스
	int	img_product_idx;//상품인덱스
	String img_realfile;//원본파일이름
	String img_file;//서버에저장될파일이름
	String img_thumb;//썸네일이미지
	int	img_repthumb;//대표썸네일여부
	int	img_del;//파일삭제여부
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name_en() {
		return product_name_en;
	}
	public void setProduct_name_en(String product_name_en) {
		this.product_name_en = product_name_en;
	}
	public String getProduct_name_kor() {
		return product_name_kor;
	}
	public void setProduct_name_kor(String product_name_kor) {
		this.product_name_kor = product_name_kor;
	}
	public String getModel_number() {
		return model_number;
	}
	public void setModel_number(String model_number) {
		this.model_number = model_number;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_release_date() {
		return product_release_date;
	}
	public void setProduct_release_date(String product_release_date) {
		this.product_release_date = product_release_date;
	}
	public String getPRODUCT_COLOR() {
		return PRODUCT_COLOR;
	}
	public void setPRODUCT_COLOR(String pRODUCT_COLOR) {
		PRODUCT_COLOR = pRODUCT_COLOR;
	}
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	public int getImg_product_idx() {
		return img_product_idx;
	}
	public void setImg_product_idx(int img_product_idx) {
		this.img_product_idx = img_product_idx;
	}
	public String getImg_realfile() {
		return img_realfile;
	}
	public void setImg_realfile(String img_realfile) {
		this.img_realfile = img_realfile;
	}
	public String getImg_file() {
		return img_file;
	}
	public void setImg_file(String img_file) {
		this.img_file = img_file;
	}
	public String getImg_thumb() {
		return img_thumb;
	}
	public void setImg_thumb(String img_thumb) {
		this.img_thumb = img_thumb;
	}
	public int getImg_repthumb() {
		return img_repthumb;
	}
	public void setImg_repthumb(int img_repthumb) {
		this.img_repthumb = img_repthumb;
	}
	public int getImg_del() {
		return img_del;
	}
	public void setImg_del(int img_del) {
		this.img_del = img_del;
	}
	
	
	
	
}
