package com.shukream.shop.vo;

import java.sql.Date;

public class ProductsVO {

	private int product_id;
	private String product_name;
	private String model_number;
	private String ticker_number;
	private int product_price;
	private Date product_release_date;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getModel_number() {
		return model_number;
	}
	public void setModel_number(String model_number) {
		this.model_number = model_number;
	}
	public String getTicker_number() {
		return ticker_number;
	}
	public void setTicker_number(String ticker_number) {
		this.ticker_number = ticker_number;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public Date getProduct_release_date() {
		return product_release_date;
	}
	public void setProduct_release_date(Date product_release_date) {
		this.product_release_date = product_release_date;
	}
	
	@Override
	public String toString() {
		return "ProductsVO [product_id=" + product_id + ", product_name=" + product_name + ", model_number="
				+ model_number + ", ticker_number=" + ticker_number + ", product_price=" + product_price
				+ ", product_release_date=" + product_release_date + "]";
	}
	
	
	
	
}
