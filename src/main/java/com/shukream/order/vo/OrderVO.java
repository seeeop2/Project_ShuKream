package com.shukream.order.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.shukream.products.vo.ProductsVO;

@Component
public class OrderVO {
	
	private int ship_id;
	private String ship_name;
//	private String secondary_address;
	private String phone_number;
	private String user_id;
	private Date ship_regdate;
	private Date ship_update;
	private ProductsVO productVO;
	public ProductsVO getProductVO() {
		return productVO;
	}
	public void setProductVO(ProductsVO productVO) {
		this.productVO = productVO;
	}
	//주소받기
	private String sample4_postcode; //우편번호
	private String sample4_roadAddress; //도로명주소
	private String sample4_jibunAddress;// 지번주소
	private String sample4_detailAddress;// 상세주소
	private String sample4_extraAddress; // 참고항목
	
	private String primary_address = sample4_postcode+sample4_roadAddress+sample4_jibunAddress+sample4_detailAddress+sample4_extraAddress;
	
	public String getPrimary_address() {
		return primary_address;
	}
	public void setPrimary_address(String primary_address) {
		this.primary_address = primary_address;
	}
	
	
	
	public String getSample4_postcode() {
		return sample4_postcode;
	}
	public void setSample4_postcode(String sample4_postcode) {
		this.sample4_postcode = sample4_postcode;
	}
	public String getSample4_roadAddress() {
		return sample4_roadAddress;
	}
	public void setSample4_roadAddress(String sample4_roadAddress) {
		this.sample4_roadAddress = sample4_roadAddress;
	}
	public String getSample4_jibunAddress() {
		return sample4_jibunAddress;
	}
	public void setSample4_jibunAddress(String sample4_jibunAddress) {
		this.sample4_jibunAddress = sample4_jibunAddress;
	}
	public String getSample4_detailAddress() {
		return sample4_detailAddress;
	}
	public void setSample4_detailAddress(String sample4_detailAddress) {
		this.sample4_detailAddress = sample4_detailAddress;
	}
	public String getSample4_extraAddress() {
		return sample4_extraAddress;
	}
	public void setSample4_extraAddress(String sample4_extraAddress) {
		this.sample4_extraAddress = sample4_extraAddress;
	}
	
	public int getShip_id() {
		return ship_id;
	}
	public void setShip_id(int ship_id) {
		this.ship_id = ship_id;
	}
	public String getShip_name() {
		return ship_name;
	}
	public void setShip_name(String ship_name) {
		this.ship_name = ship_name;
	}
//	public String getPrimary_address() {
//		return primary_address;
//	}
//	public void setPrimary_address(String primary_address) {
//		this.primary_address = primary_address;
//	}
//	public String getSecondary_address() {
//		return secondary_address;
//	}
//	public void setSecondary_address(String secondary_address) {
//		this.secondary_address = secondary_address;
//	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getShip_regdate() {
		return ship_regdate;
	}
	public void setShip_regdate(Date ship_regdate) {
		this.ship_regdate = ship_regdate;
	}
	public Date getShip_update() {
		return ship_update;
	}
	public void setShip_update(Date ship_update) {
		this.ship_update = ship_update;
	}
	@Override
	public String toString() {
		return "OrderVO [ship_id=" + ship_id + ", ship_name=" + ship_name + ", phone_number=" + phone_number
				+ ", user_id=" + user_id + ", ship_regdate=" + ship_regdate + ", ship_update=" + ship_update
				+ ", productVO=" + productVO + ", sample4_postcode=" + sample4_postcode + ", sample4_roadAddress="
				+ sample4_roadAddress + ", sample4_jibunAddress=" + sample4_jibunAddress + ", sample4_detailAddress="
				+ sample4_detailAddress + ", sample4_extraAddress=" + sample4_extraAddress + ", primary_address="
				+ primary_address + "]";
	}
	
	
	
}
