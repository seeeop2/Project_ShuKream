package com.shukream.member.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.member.dao.MemberDAO;
import com.shukream.member.service.MemberService;
import com.shukream.member.vo.MemberVO;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.event.controller.EventController;
import com.shukream.event.service.EventService;

@Controller("memberController")
@RequestMapping(value="/member")
public class MemberController {

   @Autowired 
   private MemberService memberService;
   
   @Autowired
   private EventService eventService;
   
   @Autowired
   private MemberVO memberVO;
   
   @Autowired
   private MemberDAO memberDAO;

   private BidsVO bidsVO;

   private AsksVO asksVO;

   
   
   // log4j 객체 생성
   private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	
	@RequestMapping(value="/loginForm.do", method = RequestMethod.GET)
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
   @RequestMapping(value="/login.do", method = RequestMethod.POST)
   public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
      
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html; charset=utf-8"); 
	   
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
         mav.setViewName("/member/loginForm.do");
      }
      return mav;
      
   }
   
      //header.jsp 화면에서 로그아웃 요청을 하였을 때,
      // 2차주소 : http://localhost:8090/shukream/member/logout.do"
      @RequestMapping(value="/logout.do", method = RequestMethod.GET)
      public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
         
         ModelAndView mav = new ModelAndView();
         
         HttpSession session=request.getSession();
         
         session.setAttribute("isLogOn", false); //로그아웃 시키는 false값 저장 
         
         session.removeAttribute("memberInfo");//로그인 요청시 입력한 아이디 비번을 이용해서 조회 했던 회원정보(MemberVO객체)를 삭제 !
         
         session.invalidate();//세션에 저장된 로그인정보 제거
         
         // 메인페이지로 redirect 요청하기
         mav.setViewName("redirect:/main.do");
         
         return mav;
         
      }
      
      @RequestMapping(value = "/addMemberForm.do", method = RequestMethod.GET)
      public ModelAndView memberAdd(HttpServletRequest request, HttpServletResponse response) throws Exception{
         
    	
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html; charset=utf-8");
    	  
         System.out.println("addMemberForm.do호출");
         
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
	
		
	      @RequestMapping(value="/addMember.do", method = RequestMethod.POST)
	      public void addMember(@RequestParam("user_email")String user_email,
	                              @RequestParam("user_name")String user_name,
	                              @RequestParam("user_pw")String user_pw,
	                              @RequestParam("seller_level_id")int seller_level_id,
	                              HttpServletRequest request, 
	                              HttpServletResponse response) throws Exception {
	    	  
	          // addmMember.do를 호출시킨다.
	         System.out.println("addMember.do호출");
	         
	         // 한글화 처리 한다.
	         request.setCharacterEncoding("utf-8");
	         response.setCharacterEncoding("utf-8");
	         response.setContentType("text/html; charset=utf-8");
	         
	         // 받아온 param 값들을 출력시켜 본다.
	         System.out.println(user_email);
	         System.out.println(user_name);
	         System.out.println(user_pw);
	         System.out.println(seller_level_id);
	         
	        // 받아온 변수들을 저장시킬 memberVO를 객체 생성한다.
	         MemberVO memberVO = new MemberVO();
	         
	         // memberVO객체에 받아온 변수들을 저장시킨다.
	         memberVO.setUser_email(user_email);
	         memberVO.setUser_name(user_name);
	         memberVO.setUser_pw(user_pw);
	         memberVO.setSeller_level_id(seller_level_id);
	         
	         // memberService를 호출하여 addMember메소들르 호출할때, memberVO를 매개변수로 전달한다.
	         memberService.addMember(memberVO);
	         
	 
	          //PrintWirter 객체 out 생성 및 초기화
	          PrintWriter out = response.getWriter();
	      
	         
	          out.println("<script>alert('회원가입이 완료되었습니다!, 로그인 페이지로 이동합니다');");
	          out.println("location.href='"+request.getContextPath()+"/member/loginForm.do';</script>");
	          out.flush();
	          out.close();

	      }
	      
	  	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
		public ModelAndView mypage(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			  System.out.println("mypage.do 호출!"); 
			  
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
	  	
	  	@RequestMapping(value="/shipping.do", method = RequestMethod.GET)
		public ModelAndView shipping(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			  System.out.println("shipping.do 호출!"); 
			  
				// @ 1) 로그인 된 아이디 값을 가져와서 매개변수로 전달한다.
			    String id = (String)session.getAttribute("email");
			  
			    List<Map<String, Object>> checkbids = memberService.checkbids(id);
			    
			    List<Map<String, Object>> checkasks = memberService.checkasks(id);
			    
			    if(checkbids.isEmpty() && checkasks.isEmpty()) {
			    	
			          //PrintWirter 객체 out 생성 및 초기화
			          PrintWriter out = response.getWriter();
			      
			         
			          out.println("<script>alert('진행 중인 거래가 없습니다!, 마이 페이지로 돌아갑니다');");
			          out.println("location.href='"+request.getContextPath()+"/member/mypage.do';</script>");
			          out.flush();
			          out.close();
			    	
			    }
			    
			    
				// ModelANdView 객체 생성
			    ModelAndView mav = new ModelAndView();
			    
			    // Viewname 가져오기
			    String viewName = (String) request.getAttribute("viewName");
			    
			    // Viewname에 대한 info 생성
			    logger.info(viewName);
			    
			    // ModelAndView 객체에 viewName을 셋팅
			    mav.setViewName(viewName);
			    mav.addObject("bids", checkbids);
			    mav.addObject("asks", checkasks);
			    mav.addObject("id", id);
	          // ModelAndView 반환
	          return mav;
	      
	      
	   }
	  	
	  	@RequestMapping(value="/confirm.do", method = RequestMethod.GET)
		public void confirm(@RequestParam("id")String id,@RequestParam("bon")String bon, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			  System.out.println("confirm.do 호출!"); 
			  
			  System.out.println("id 값 : "+id);
			  System.out.println("bids_order_number 값: "+bon);
			  
			  int bosi = 4;
			  

			  Map<String,Object> map = new HashMap<String,Object>();
			  
			  map.put("id", id);
			  map.put("bon", bon);
			  map.put("bosi", bosi);
			 
			  // 1) 가져온 Bids_order_state_idx 값을 업데이트 시킨다.
			  memberService.updateBidsOrder(map);
			  
			  // 2-1) 현재 응모권 내역을 불러와서 d_cnt 값을 1 추가 시킨뒤 마지막 DB에 업데이트 시킨다.
			  eventService.checkdcnt(id);
			  
	          //PrintWirter 객체 out 생성 및 초기화
	          PrintWriter out = response.getWriter();
	      
	         
	          out.println("<script>location.href='"+request.getContextPath()+"/main.do';</script>");
	          out.flush();
	          out.close();
			  
	      
	      
	   }
	  	
		
	      @RequestMapping(value = "/emailCheck.do", method = RequestMethod.POST)
	      @ResponseBody	
	      public void emailCheck(@RequestParam("user_email")String user_email,HttpServletResponse response) throws Exception{
	    	 
	    	  System.out.println(user_email);
	    	  
	    	  int memberEmailCheck = memberService.emailCheck(user_email);
	    	  System.out.println("컨트롤러 memberEmailCheck : " + memberEmailCheck);
	    	  
	    	  PrintWriter out = response.getWriter();
	    	  
	    	  if(memberEmailCheck == 0) {
	              out.println(0);
	            } else {
	              out.println(1);
	            }

	    	  return;
	      }
		
	      @RequestMapping(value="/info.do", method = RequestMethod.GET)
		  public ModelAndView info(HttpServletRequest request, HttpServletResponse response) throws Exception{
				
				  System.out.println("info.do 호출!"); 
				  
					ModelAndView mav = new ModelAndView();
				    
				    String viewName = (String) request.getAttribute("viewName");
				    
				    logger.info(viewName);
				    
				    mav.setViewName(viewName);
		         
				    return mav;
		    }
	      
	     
	      
	       
      
}