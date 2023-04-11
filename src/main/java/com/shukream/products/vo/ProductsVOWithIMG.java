package com.shukream.products.vo;

import java.sql.Date;

public class ProductsVOWithIMG {

  private int product_id;
  private String product_name_en;
  private String product_name_kor;
  private String model_number;
  private String product_brand;
  private int product_price;
  private Date product_release_date;
  private String product_color;
  private int category;

  private int img_id; //이미지 인덱스
  private int img_product_idx; // 상품인덱스
  private String img_realFile; // 원본파일이름
  private String img_file; // 서버에 저장될 파일 이름
  private String img_thumb; // 썸네일 이미지
  private int img_repthumb; // 대표썸네일 여부
  private int img_del; // 파일 삭제 여부
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
  @Override
  public String toString() {
    return "ProductsVOWithIMG [product_id=" + product_id + ", product_name_en=" + product_name_en
        + ", product_name_kor=" + product_name_kor + ", model_number=" + model_number
        + ", product_brand=" + product_brand + ", product_price=" + product_price
        + ", product_release_date=" + product_release_date + ", product_color=" + product_color
        + ", category=" + category + ", img_id=" + img_id + ", img_product_idx=" + img_product_idx
        + ", img_realFile=" + img_realFile + ", img_file=" + img_file + ", img_thumb=" + img_thumb
        + ", img_repthumb=" + img_repthumb + ", img_del=" + img_del + "]";
  }
  
  
	
	
}
