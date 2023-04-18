package com.shukream.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.member.dao.MemberDAO;
import com.shukream.member.vo.MemberVO;

@Service("memberSerivce")
public class MemberService {
   
   @Autowired
   private MemberDAO memberDAO;

   public MemberVO login(Map<String, String> loginMap) throws Exception{
      return memberDAO.login(loginMap);
   }
   
	public void addMember(MemberVO memberVO) {
		memberDAO.insertNewMember(memberVO);
		
	}

	public int emailCheck(String user_email) throws Exception{
		
		 Map email = new HashMap();
		 email.put("user_email1", user_email);
		 email.put("user_email2", user_email);
		 Map email2 = memberDAO.emailCheck(email); //0
		 
		 //String email3 = (String) email2.get("USER_EMAIL");
		 
		 int result = 0;
		 if( email2.equals("0")) {
			 System.out.println("이메일 없다");
			  result = 0;
		 } else {
			 System.out.println("이메일 있다");
			  result = 1;
		 }
		
		return result;
		
	}

	public List<Map<String, Object>> checkbids(String id) {
		
		System.out.println("MemberService -> checkbids 호출!");
		
		return memberDAO.checkbids(id);
	}
	
	public List<Map<String, Object>> checkasks(String id) {
		
		System.out.println("MemberService -> checkasks 호출!");
		
		return memberDAO.checkasks(id);
	}

	public void updateBidsOrder(Map<String, Object> map) {
		
		System.out.println("MemberService -> updateBidsOrderNumber 호출!");
		
		memberDAO.updateBidsOrder(map);
		
	}

}
