package com.shukream.bids.vo;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class BidsVO {
  private int bids_idx;
  private int bids_size_idx;
  private int bids_price;
  private Date bids_regdate;
  private Date bids_update;
  private Date bids_expiration;
  private int bids_order_state_idx;
  private Date bids_matched_date;
  private int bids_total_price;
  private String bids_order_number;
  private int bids_ship_idx;
  
  public int getBids_idx() {
    return bids_idx;
  }
  public void setBids_idx(int bids_idx) {
    this.bids_idx = bids_idx;
  }
  public int getBids_size_idx() {
    return bids_size_idx;
  }
  public void setBids_size_idx(int bids_size_idx) {
    this.bids_size_idx = bids_size_idx;
  }
  public int getBids_price() {
    return bids_price;
  }
  public void setBids_price(int bids_price) {
    this.bids_price = bids_price;
  }
  public Date getBids_regdate() {
    return bids_regdate;
  }
  public void setBids_regdate(Date bids_regdate) {
    this.bids_regdate = bids_regdate;
  }
  public Date getBids_update() {
    return bids_update;
  }
  public void setBids_update(Date bids_update) {
    this.bids_update = bids_update;
  }
  public Date getBids_expiration() {
    return bids_expiration;
  }
  public void setBids_expiration(Date bids_expiration) {
    this.bids_expiration = bids_expiration;
  }
  public int getBids_order_state_idx() {
    return bids_order_state_idx;
  }
  public void setBids_order_state_idx(int bids_order_state_idx) {
    this.bids_order_state_idx = bids_order_state_idx;
  }
  public Date getBids_matched_date() {
    return bids_matched_date;
  }
  public void setBids_matched_date(Date bids_matched_date) {
    this.bids_matched_date = bids_matched_date;
  }
  public int getBids_total_price() {
    return bids_total_price;
  }
  public void setBids_total_price(int bids_total_price) {
    this.bids_total_price = bids_total_price;
  }
  public String getBids_order_number() {
    return bids_order_number;
  }
  public void setBids_order_number(String bids_order_number) {
    this.bids_order_number = bids_order_number;
  }
  public int getBids_ship_idx() {
    return bids_ship_idx;
  }
  public void setBids_ship_idx(int bids_ship_idx) {
    this.bids_ship_idx = bids_ship_idx;
  }
  
  
  
}
