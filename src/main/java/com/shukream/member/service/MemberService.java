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

   public int login(Map<String, String> loginMap) throws Exception{
      
	   System.out.println("서비스로그인");
	   
	   return memberDAO.login(loginMap);
   }
   
   public int emailCheck(String user_email) {

		Map loginCheck = new HashMap();
		 
		 loginCheck.put("user_email1", user_email);
		 loginCheck.put("user_email2", user_email);
		
		 Map email2 = memberDAO.emailCheck(loginCheck); //0
		 
		 String email3 = (String) email2.get("USER_EMAIL");
		 
		 int result = 0;
		 if( email3.equals("0")) {
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

	public void updateBidsOrder(Map<String, Object> map) throws Exception {
		
		System.out.println("MemberService -> updateBidsOrderNumber 호출!");
		
		memberDAO.updateBidsOrder(map);
		
	}

	public MemberVO readMember(String user_email) throws Exception{
		
		System.out.println("서비스 readMember");
		
		return memberDAO.readMember(user_email);
	}

	public List<MemberVO> updateMember(String id) {
		
		System.out.println("서비스 updateMember");
		
		return memberDAO.updateMember(id);
		
	}

	public void updateMemberpro(String name, String pw, String id) {
		
		memberDAO.updateMemberpro(name, pw, id);
		
		System.out.println("서비스 updateMemberpro");
		
		}
 
	public List<MemberVO> delMember(String email) {
		
		System.out.println("서비스 delMember");
		
		return memberDAO.delMember(email);
	}

	public void delMemberpro(String user_email) {
		
		memberDAO.delMemberpro(user_email);
		
		System.out.println("서비스updateMemberpro");
		
	}

	public void addMember(MemberVO memberVO) throws Exception{
		
		System.out.println("서비스 addMember");
		
		memberDAO.addMember(memberVO);
		
	}

	
	  
	 
	

	

	

}
