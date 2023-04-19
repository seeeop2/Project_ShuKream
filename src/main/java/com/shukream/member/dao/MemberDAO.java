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
	

}
