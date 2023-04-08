package com.shukream.event.controller;

import java.io.PrintWriter;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.event.service.EventService;
import com.shukream.event.vo.EventVO;

// 컨트롤러로 사용하기 위한 Bean 생성
// 1차 주소 : http://localhost:8090/teamproject/event/*.do
@Controller
@RequestMapping(value = "/event")
public class EventController {
	
	// Autowired 로 EventService 주입하기
	@Autowired
	EventService eventservice;
	
	// Autowired 로 EventService 주입하기
	@Autowired
	EventVO eventVO;
	

	
 // log4j 객체 생성
  private static final Logger logger = LoggerFactory.getLogger(EventController.class);
  

  // #1 ) 2차 주소 : http://localhost:8090/teamproject/event/main.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/main.do", method = RequestMethod.GET)
  public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {

	  System.out.println("main.do 호출!"); 
	  
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
  
  
  
  // #2 ) 2차 주소 : http://localhost:8090/teamproject/event/detail.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/detail.do", method = RequestMethod.GET)
  public ModelAndView detail(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
	  System.out.println("detail.do 호출!"); 
	  
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html; charset=utf-8");

	  
	  //PrintWirter 객체 out 생성 및 초기화
		PrintWriter out = response.getWriter();
	
	  // ModelANdView 객체 생성
	    ModelAndView mav = new ModelAndView();
	  // List 배열 객체 생성  
	    List<EventVO> checkuser = null;
		  
	  
	// @ 1) 로그인이 안되어있을 경우 로그인 페이지로 이동 시킨다.
		// #1. session에 저장한 id 값을 가져와 id 변수에 저장 시킨다. 
		HttpSession session = request.getSession();
		String id = "admin@shukream.co.kr";
		session.setAttribute("id", id);

		System.out.println("id값은 : "+id);

		
		// 로그인 되어있다면?

		if(!id.isEmpty()) {
			
			// @ 2) 응모권이 없을 경우(null), 추첨을 할 수 없도록 설정 한다.
			// #1. service -> dao로 id 값을 보내서 dao에서 조회 시킨다.
			
			checkuser = eventservice.checkuser(id);
			 
			
			// checkuser에 저장된 d_cnt만 꺼낸다.

			String d_cnt = checkuser.get(0).getD_cnt();

			System.out.println(d_cnt);

			
				 // 만약에 응모권이 한개도 없다면
				if(d_cnt.equals("0")) {
					
					// msg 변수에 로그인 해야한다는 문구 저장
					//	String msg = "보유하신 응모권이 없습니다!, 상세페이지로 이동합니다!";
					
					
					// PrinterWriter 클래스를 이용하여 JAVASCRIPT 구문으로 alert를 발생시키고, location.replace 메소드를 통해서 바로 상세페이지로 이동 시킬 때,
					// ticket 값을 0으로 입력하여 eventdetailresult.jsp에 ticket값이 0일 경우 jstl을 이용하여 소지하고있는 응모권이 없습니다를 생성시킨다!
					out.println("<script>alert('보유하신 응모권이 없습니다!, 상세페이지로 이동합니다');");
//					out.println("window.location.replace('http://localhost:8090/shuKream/event/detailresult.do?ticket=0');</script>");
					out.println("window.location.href='http://localhost:8090/shuKream/event/detailresult.do?ticket=0&id="+id+"';</script>");
					out.flush();
					out.close();
				}

		// 만약에 로그인 하지 않았다면?
		}else {

			out.println("<script>alert('로그인 후 이용가능합니다!, 메인 페이지로 이동합니다');");
			out.println("window.location.replace('http://localhost:8090/shuKream/main.do');</script>");
			out.flush();
			out.close();
			
		}

    
    // Viewname 가져오기
    String viewName = (String) request.getAttribute("viewName");
    
    // Viewname에 대한 info 생성
    logger.info(viewName);
    
    // 가져온 list 배열의 값들을 eventdetailresult.jsp 페이지로 넘겨준다.
    mav.addObject("checkuser", checkuser);
    mav.addObject("id", id);
    
    // ModelAndView 객체에 viewName을 셋팅
    mav.setViewName(viewName);

    // ModelAndView 반환
    return mav;
  }
  
  // #3 ) 2차 주소 : http://localhost:8090/teamproject/event/detailresult.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/detailresult.do", method = RequestMethod.GET)
  public ModelAndView detailresult(@RequestParam("id")String id,@RequestParam("ticket")String ticket,HttpServletRequest request, HttpServletResponse response) {

	System.out.println("detailresult.do 호출!"); 
	 
	System.out.println(id);
	
	  // List 배열 객체 생성  
    List<EventVO> checkuser = null;
    
     // 응모권 없음에서 사용할 변수 초기화
    
    String member_id = null, a_cnt = null, u_cnt = null, d_cnt = null;
    
	  
    // @ 1) eventdetail.jsp에서 location.replace로 전달받은 값을 가져온다.
    // 1) 추가중 : login 구현 후 session id 가져오기,
    // 1-1) 무료배송권 : freeshipping
    // 1-2) 30일무료보관권 : freestore
    // 1-3) 수수료 1회 면제권 : freecharge
    // 1-4) 응모권이 없을때 : 0
    // 1-5) 꽝 : OTL
	  
	// @ 2) 로그인 되어있는 id(이메일주소)+ 물품정보(또는 거래번호) + oder_status(최종주문상태)를 가져와서
	
	// d_contents 형식을 " @@@ 체결정보에 대한 거래 완료에 따른 이벤트권 발급"으로 설정시키고,
	// 응모권 추첨 후 남아 있는 추첨권의 값을 - 시킨다.
    System.out.println(ticket);
    
    // ticket 내용에 따라서 각각 다른 메소드를 호출 시킨다.
    
    if(ticket.equals("freeshipping")){
    	
    	ticket = "무료배송권";
    	
    	System.out.println(ticket);
    	
    	eventservice.freeshipping(ticket);
    	
    	
    }else if(ticket.equals("freestore")) {
    	
    	ticket = "한달무료보관권";
    	
    	System.out.println(ticket);
    	
    	eventservice.freestore(ticket);
    	
    	
    }else if(ticket.equals("freecharge")) {
    	
    	ticket = "수수료1회무료권";
    	
    	System.out.println(ticket);
    	
    	eventservice.freestore(ticket);
    	
    	
    }else if(ticket.equals("0")) {
    	
    	
    	System.out.println(ticket);
    
    	checkuser = eventservice.checkuser(id);
    	
    	// 가져온 list타입의 eventvo에서 상부에 출력시킬 값들만 따로 변수에 저장시킨다.
    	member_id = checkuser.get(0).getMember_id();
    	a_cnt = checkuser.get(0).getA_cnt();
    	u_cnt = checkuser.get(0).getU_cnt();
    	d_cnt = checkuser.get(0).getD_cnt();
    
    }else {
    	
    	ticket = "꽝";
    	
    	System.out.println(ticket);
    	
    	eventservice.OTL(ticket);
    	
    }
    
	// ModelANdView 객체 생성
    ModelAndView mav = new ModelAndView();
    
    // Viewname 가져오기
    String viewName = (String) request.getAttribute("viewName");
    
    // Viewname에 대한 info 생성
    logger.info(viewName);
    
    // checkuser와 id를 mav에 저장 시켜서 전달한다.
    mav.addObject("member_id", member_id);
    mav.addObject("a_cnt", a_cnt);
    mav.addObject("u_cnt", u_cnt);
    mav.addObject("d_cnt", d_cnt);
    mav.addObject("checkuser", checkuser);
    mav.addObject("id", id);
    
    // ModelAndView 객체에 viewName을 셋팅
    mav.setViewName(viewName);
    
    // ModelAndView 반환
    return mav;
    

  }
  

  
  

}
