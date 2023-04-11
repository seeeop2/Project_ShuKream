package com.shukream.shopdetails.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shukream.asks.dao.AsksDAO;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.dao.BidsDAO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.products.dao.ProductsDAO;
import com.shukream.products.vo.ProductsVO;

@Service
public class ShopDetailsService {

  @Autowired
  AsksDAO asksdao;
  
  @Autowired
  BidsDAO bidsdao;
  
  @Autowired
  ProductsDAO productsdao;
  
  public int InsertAsks(AsksVO asksvo) {
    return asksdao.insertAsks(asksvo);
  }
  
  public int InsertBids(BidsVO bidsvo) {
    return bidsdao.insertBids(bidsvo);
  }
  public int SelectLowAsks() {
    return asksdao.selectLowAsks();
  }
  
  public Map selectLowAsksAll() {
    
    Map result = new HashMap();
    for(int i = 220; i<=300;i=i+5) {
      result.put(i, asksdao.selectLowAsksAll(i));
    }
    
    
    return result;
  }

  public List SelectProduct(int product_id) {
    return productsdao.selectProduct(product_id);
  }
  
  
}
