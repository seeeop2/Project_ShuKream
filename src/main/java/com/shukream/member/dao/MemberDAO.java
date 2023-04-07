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
	
	public MemberVO login(String user_email) throws DataAccessException{
		
		MemberVO member=(MemberVO)sqlSession.selectOne("mapper.member.login",user_email);
		
	   return member;
	}

	
	
	
}
