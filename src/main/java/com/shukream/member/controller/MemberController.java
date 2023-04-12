package com.shukream.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.event.controller.EventController;
import com.shukream.member.service.MemberService;
import com.shukream.member.vo.MemberVO;

@Controller("memberController")
@RequestMapping(value="/member")
public class MemberController {

	@Autowired 
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	
	// log4j 객체 생성
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	
	@RequestMapping(value="/loginForm.do", method= RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		  System.out.println("loginForm.do 호출!"); 
		  
			// ModelANdView 객체 생성
		    ModelAndView mav = new ModelAndView();
		    
		    // Viewname 가져오기
		    String viewName = (String) request.getAttribute("viewName");
		    
		    // Viewname에 대한 info 생성
		    logger.info(viewName);
		    
		    // ModelAndView 객체에 viewName을 셋팅
		    mav.setViewName(viewName);

		    // ModelAndView 반환
		    return mav;
		
		
	}
	
	//loginForm.jsp 화면에서 아이디 비밀번호를 입력하고 로그인 버튼을 눌렀을 때,
	// 2차주소 : http://localhost:8090/shukream/member/login.do"
	@RequestMapping(value="/login.do", method= RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		memberVO = memberService.login(loginMap);
		
		String email = memberVO.getUser_email();
		
		
		if(memberVO != null && memberVO.getUser_email() != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberInfo", memberVO);
			session.setAttribute("email", email);
			
			mav.setViewName("redirect:/main.do");
			
		}else {
			
			String message="아이디나 비밀번호가 틀립니다. 다시 로그인 해주세요";
			mav.addObject("message" , message);
			mav.setViewName("/member/loginForm");
		}
		return mav;
		
	}
	
		//header.jsp 화면에서 로그아웃 요청을 하였을 때,
		// 2차주소 : http://localhost:8090/shukream/member/logout.do"
		@RequestMapping(value="/logout.do", method= RequestMethod.GET)
		public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			ModelAndView mav = new ModelAndView();
			
			HttpSession session=request.getSession();
			
			session.setAttribute("isLogOn", false); //로그아웃 시키는 false값 저장 
			
			session.removeAttribute("memberInfo");//로그인 요청시 입력한 아이디 비번을 이용해서 조회 했던 회원정보(MemberVO객체)를 삭제 !
			
			String contextPath = request.getContextPath();
			
			// 메인페이지로 redirect 요청하기
			mav.setViewName("redirect:'"+contextPath+"'/main.do");
			
			return mav;
			
		}
	

}
