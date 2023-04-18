package com.shukream.member.dao;

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

	public List<BidsVO> checkbids(String id) {
		
		List<BidsVO> checkbids = sqlSession.selectList("mapper.member.checkbids", id);
		
		System.out.println("memberDAO -> checkbids 호출!");
		
		return checkbids;
	}
	
	public List<AsksVO> checkasks(String id) {
		
		List<AsksVO> checkasks = sqlSession.selectList("mapper.member.checkasks", id);
		
		System.out.println("memberDAO -> checkasks 호출!");
		
		return checkasks;
	}
	

}
