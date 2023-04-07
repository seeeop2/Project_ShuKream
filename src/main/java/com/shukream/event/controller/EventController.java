package com.shukream.event.controller;

import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.event.service.EventService;

// 컨트롤러로 사용하기 위한 Bean 생성
// 1차 주소 : http://localhost:8090/teamproject/event/*.do
@Controller
@RequestMapping(value = "/event")
public class EventController {
	
	// Autowired 로 EventService 주입하기
	@Autowired
	EventService eventservice;
	

	
 // log4j 객체 생성
  private static final Logger logger = LoggerFactory.getLogger(EventController.class);
  
  // #1 ) 2차 주소 : http://localhost:8090/teamproject/event/main.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/main.do", method = RequestMethod.GET)
  public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  
	  
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
		
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html; charset=utf-8");

	  
	  //PrintWirter 객체 out 생성 및 초기화
		PrintWriter out = response.getWriter();
		
	  
	  
	// @ 1) 로그인이 안되어있을 경우 로그인 페이지로 이동 시킨다.
		// #1. session에 저장한 id 값을 가져와 id 변수에 저장 시킨다. 
		HttpSession session = request.getSession();
		String abcd = "admin";
		session.setAttribute("admin", abcd);
		
		String id = (String)session.getAttribute("admin");
		
		System.out.println("id값은 : "+id);
		
		//지역변수 d_cnt 설정
		int d_cnt = 0;
		
		
		// 로그인 되어있다면?

		if(!id.isEmpty()) {
			
			// @ 2) 응모권이 없을 경우(null), 추첨을 할 수 없도록 설정 한다.
			// #1. service -> dao로 id 값을 보내서 dao에서 조회 시킨다.
			d_cnt = eventservice.checkdcnt(id);
			
			System.out.println("d_cnt 값은 : "+d_cnt);
			
			// 만약에 응모권이 한개도 없다면
			if(d_cnt == 0) {
				
//				// msg 변수에 로그인 해야한다는 문구 저장
//				String msg = "보유하신 응모권이 없습니다!, 상세페이지로 이동합니다!";
				
				
//				out.println("<script>alert('보유하신 응모권이 없습니다!, 상세페이지로 이동합니다');");
//				out.println("var path ='${pageContext.request.contextPath}';");
//				out.println("window.location.replace('/shukream/event/detail.do?id="+id+"');</script>");
//				out.flush();
//				out.close();


				
			}
		


		// 만약에 로그인 하지 않았다면?
		}else {
			
			// msg 변수에 로그인 해야한다는 문구 저장
			String msg2 = "로그인 후 이용 가능합니다!, 로그인페이지로 이동합니다!";
	
			out.println("<script>alert(' "+ msg2+" ');</script>");
			
		}
		
		
	
	
	
	
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
  
  // #3 ) 2차 주소 : http://localhost:8090/teamproject/event/detailresult.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/detailresult.do", method = RequestMethod.GET)
  public ModelAndView detailresult(@RequestParam("ticket")String ticket,HttpServletRequest request, HttpServletResponse response) {

    // @ 1) eventdetail.jsp에서 location.replace로 전달받은 값을 가져온다.
    // 1) 추가중 : login 구현 후 session id 가져오기,
    // 1-1) 무료배송권 : freeshipping
    // 1-2) 30일무료보관권 : freestore
    // 1-3) 수수료 1회 면제권 : freecharge
    // 1-4) 꽝 : OTL
	  
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
    
    // ModelAndView 객체에 viewName을 셋팅
    mav.setViewName(viewName);

    // ModelAndView 반환
    return mav;
    

  }
  

  
  

}
