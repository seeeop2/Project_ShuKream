package com.shukream.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shukream.member.dao.MemberDAO;
import com.shukream.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberService {
		
		@Autowired
		private MemberDAO memberDAO;
		
		public MemberVO login(String user_email) throws Exception{
			return memberDAO.login(user_email);
		}
		
		
		
		
}

	

