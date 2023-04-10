package com.shukream.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.member.dao.MemberDAO;
import com.shukream.member.vo.MemberVO;

@Service("memberSerivce")
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public MemberVO login(Map<String, String> loginMap) throws Exception{
		return memberDAO.login(loginMap);
	}

}
