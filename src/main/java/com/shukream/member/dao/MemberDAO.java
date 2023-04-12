package com.shukream.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

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

	public String selectOverlappedID(String email) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedID",email);
		return result;
	}

}
