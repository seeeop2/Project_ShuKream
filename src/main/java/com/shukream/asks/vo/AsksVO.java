package com.shukream.asks.vo;

import org.springframework.stereotype.Component;

@Component("AsksVO")
public class AsksVO {
  private int asks_idx;
  private int asks_size_idx;
  private int asks_price;
  private String asks_regdate;
  private String asks_update;
  private String asks_expiration;
  private int asks_order_state_idx;
  private String asks_matched_date;
  private int asks_total_price;
  private String asks_order_number;
  private int asks_address;
  private int asks_product_id;;
  
  
  public int getAsks_idx() {
    return asks_idx;
  }
  public void setAsks_idx(int asks_idx) {
    this.asks_idx = asks_idx;
  }
  public int getAsks_size_idx() {
    return asks_size_idx;
  }
  public void setAsks_size_idx(int asks_size_idx) {
    this.asks_size_idx = asks_size_idx;
  }
  public int getAsks_price() {
    return asks_price;
  }
  public void setAsks_price(int asks_price) {
    this.asks_price = asks_price;
  }
  public String getAsks_regdate() {
    return asks_regdate;
  }
  public void setAsks_regdate(String asks_regdate) {
    this.asks_regdate = asks_regdate;
  }
  public String getAsks_update() {
    return asks_update;
  }
  public void setAsks_update(String asks_update) {
    this.asks_update = asks_update;
  }
  public String getAsks_expiration() {
    return asks_expiration;
  }
  public void setAsks_expiration(String asks_expiration) {
    this.asks_expiration = asks_expiration;
  }
  public int getAsks_order_state_idx() {
    return asks_order_state_idx;
  }
  public void setAsks_order_state_idx(int asks_order_state_idx) {
    this.asks_order_state_idx = asks_order_state_idx;
  }
  public String getAsks_matched_date() {
    return asks_matched_date;
  }
  public void setAsks_matched_date(String asks_matched_date) {
    this.asks_matched_date = asks_matched_date;
  }
  public int getAsks_total_price() {
    return asks_total_price;
  }
  public void setAsks_total_price(int asks_total_price) {
    this.asks_total_price = asks_total_price;
  }
  public String getAsks_order_number() {
    return asks_order_number;
  }
  public void setAsks_order_number(String asks_order_number) {
    this.asks_order_number = asks_order_number;
  }
  public int getAsks_address() {
    return asks_address;
  }
  public void setAsks_address(int asks_address) {
    this.asks_address = asks_address;
  }
  public int getAsks_product_id() {
    return asks_product_id;
  }
  public void setAsks_product_id(int asks_product_id) {
    this.asks_product_id = asks_product_id;
  }
  
  
}
