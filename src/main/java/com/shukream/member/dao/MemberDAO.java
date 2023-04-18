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
   
   public MemberVO login(Map<String, String> loginMap) throws DataAccessException{
      
      MemberVO member=(MemberVO)sqlSession.selectOne("mapper.member.login", loginMap);
      
      return member;
   }

	public void insertNewMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.insert("mapper.member.insertNewMember",memberVO);
		
	}

	public Map emailCheck(Map map){
		Map result = sqlSession.selectOne("mapper.member.emailCheck", map);
		return result;
	}

	public List<String> checkbids(String id) {
		
		
		String img_repthumb = "1";
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("img_repthumb", img_repthumb);
		map.put("id", id);
		
		List<String> checkbids = sqlSession.selectList("mapper.member.checkbids", map);
		
		System.out.println("memberDAO -> checkbids 호출!");
		
		System.out.println(checkbids);
		
		return checkbids;
	}
	
	public List<String> checkasks(String id) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		String img_repthumb = "1";
		
		map.put("img_repthumb", img_repthumb);
		map.put("id", id);
		
		List<String> checkasks = sqlSession.selectList("mapper.member.checkasks", map);
		
		System.out.println("memberDAO -> checkasks 호출!");
		
		System.out.println(checkasks);
		
		return checkasks;
	}
	

}
