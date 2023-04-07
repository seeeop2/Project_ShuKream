package com.shukream.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.member.service.MemberService;
import com.shukream.member.vo.MemberVO;


@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberVO memberVO;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, 
							  HttpServletResponse response) throws Exception{
				
		ModelAndView mav = new ModelAndView();

	    String viewName = (String) request.getAttribute("viewName");
	    mav.setViewName(viewName);
		return mav;
	}
	@RequestMapping(value = "/loginPro.do",method = RequestMethod.GET)
	public ModelAndView signIn(@RequestParam("user_email") String user_email,
							    HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.getParameter("user_email");
		ModelAndView signMav = new ModelAndView();
		
//		memberVO = memberService.login(user_email);
		
//		if(memberVO != null && memberVO.getUser_email()!=null) {
//			System.out.println("로그인프로에서 memberVO정보"+memberVO.toString());
//			
//			HttpSession session = request.getSession();
////			session.setAttribute("sign", true);
////			session.setAttribute("memberInfo", memberVO);
////			session.setAttribute("email", memberVO.getUser_email());
//			signMav.setViewName("/main");
//		}else {
			String message = "로그인 실패";
			
			signMav.addObject("message", message);
//			signMav.setViewName("redirect:http://localhost:8090/shuKream/member/login.do");
			signMav.setViewName("/member/loginForm");
//		}
		
        return signMav;
		
	
	}
}