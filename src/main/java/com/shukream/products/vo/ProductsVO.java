package com.shukream.products.vo;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component("ProductsVO")
public class ProductsVO {
  
  private int product_id;
  private String product_name_en;
  private String product_name_kor;
  private String model_number;
  private String product_brand;
  private int product_price;
  private Date product_release_date;
  private String product_color;
  private int category;
  
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
  public String getProduct_brand() {
    return product_brand;
  }
  public void setProduct_brand(String product_brand) {
    this.product_brand = product_brand;
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
  public String getProduct_color() {
    return product_color;
  }
  public void setProduct_color(String product_color) {
    this.product_color = product_color;
  }
  public int getCategory() {
	return category;
  }
  public void setCategory(int category) {
	this.category = category;
  }
  
}
