package com.shukream.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
   private SqlSession sqlSession;
	
   public int login(Map<String, String> loginMap) throws DataAccessException{
      
	   System.out.println("다오로그인"); 
	   int result = 0;
      MemberVO member=sqlSession.selectOne("mapper.member.login", loginMap);
      if(member == null) {
    	  
    	result = 0;
    	  
      }else {
    	  
    	  result = 1;
    	  
      }
      
      
      return result;
   }

	public Map emailCheck(Map map){
		Map result = sqlSession.selectOne("mapper.member.emailCheck", map);
		return result;
	}

	public List<Map<String, Object>> checkbids(String id) {
		
		System.out.println("memberDAO -> checkbids 호출!");

		String img_repthumb = "1";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("img_repthumb", img_repthumb);
		map.put("id", id);
		
		// List안에 Map을 넣어서 가져온다.
		List<Map<String, Object>> checkbids = sqlSession.selectList("mapper.member.checkbids", map);
		
		return checkbids;
	}
	
	public List<Map<String, Object>> checkasks(String id) {
		
		System.out.println("memberDAO -> checkasks 호출!");
		
		String img_repthumb = "1";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("img_repthumb", img_repthumb);
		map.put("id", id);
		
		// List안에 Map을 넣어서 가져온다.
		List<Map<String, Object>> checkasks = sqlSession.selectList("mapper.member.checkasks", map);
		
		return checkasks;
	}

	public void updateBidsOrder(Map<String, Object> map) {
		
		System.out.println("memberDAO -> updateBidsOrder 호출!");
		
		sqlSession.update("mapper.member.updateBidsOrder", map);
		
	}

	public MemberVO readMember(String user_email) throws Exception{
		
		System.out.println("다오 readMember");
		
		MemberVO memberVO = sqlSession.selectOne("mapper.member.readMember", user_email);
		
		System.out.println("다오2readMember"+memberVO.getUser_email());
		
		return memberVO;
	}

	public List<MemberVO> updateMember(String id) {
		
		System.out.println("다오 updateMember");
		
		List<MemberVO> updateMember = sqlSession.selectList("mapper.member.updateMember", id);
		
		System.out.println(updateMember);
		
		
		return updateMember;
	}
	
	public void updateMemberpro(String name, String pw, String id) {

		System.out.println("다오 updateMemberpro");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("pw", pw);
		map.put("id", id);
		
		int updateMemberpro = sqlSession.update("mapper.member.updateMemberpro", map);
		
		System.out.println(updateMemberpro);
		
	}

	public List<MemberVO> delMember(String email) {
		
		System.out.println("다오 delMember");
		
		List<MemberVO> delMember = sqlSession.selectList("mapper.member.delMember", email);
		
		System.out.println(delMember);
		
		return delMember;
	}

	public void delMemberpro(String user_email) {
		
		System.out.println("다오 delMemberpro");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("user_email", user_email);
		
		int delMemberpro = sqlSession.delete("mapper.member.delMemberpro", map);
		
		System.out.println(delMemberpro);
	  }

	public void addMember(String email, String name, String pw) {
		
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		int addMember = sqlSession.insert("mapper.member.addMember", map);
		
		System.out.println(addMember);
		
	}

	public void addMember(MemberVO memberVO) {
		
		System.out.println("다오 addMember");
		
		int addMember = sqlSession.insert("mapper.member.addMember", memberVO);
		
	}

		
		 
		

	
	


}
