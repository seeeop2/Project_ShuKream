package com.shukream.products.vo;

import org.springframework.stereotype.Component;

@Component("imageFileVO")
public class ImageFileVO {

	private int img_id; //이미지 인덱스
	private int product_idx; // 상품인덱스
	private String img_realFile; // 원본파일이름
	private String img_file; // 서버에 저장될 파일 이름
	private String img_thumb; // 썸네일 이미지
	private int img_repthumb; // 대표썸네일 여부
	private int img_del; // 파일 삭제 여부
	
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	public int getProduct_idx() {
		return product_idx;
	}
	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}
	public String getImg_realFile() {
		return img_realFile;
	}
	public void setImg_realFile(String img_realFile) {
		this.img_realFile = img_realFile;
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
