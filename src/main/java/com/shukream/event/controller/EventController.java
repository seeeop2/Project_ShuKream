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
	  
	  HttpSession session = request.getSession();
	  String  id = (String)session.getAttribute("email");
	  
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html; charset=utf-8");

	  System.out.println("main.do 호출!"); 
	  
	  System.out.println(id);
	  
	  String contextPath = request.getContextPath();
	  
	  //PrintWirter 객체 out 생성 및 초기화
		PrintWriter out = response.getWriter();
	  
	  if(id == null) {
		  
			out.println("<script>alert('로그인 후 이용가능합니다!, 로그인 페이지로 이동합니다');");
			out.println("window.location.replace('"+contextPath+"/member/loginForm.do');</script>");
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
    mav.addObject("id", id);

    // ModelAndView 반환
    return mav;
  }
  
  
  
  // #2 ) 2차 주소 : http://localhost:8090/teamproject/event/detail.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/detail.do", method = RequestMethod.GET)
  public ModelAndView detail(HttpSession session,HttpServletRequest request, HttpServletResponse response)throws Exception {
	  
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html; charset=utf-8");
		
	  System.out.println("detail.do 호출!"); 

	  String contextPath = request.getContextPath();
	  
	  //PrintWirter 객체 out 생성 및 초기화
		PrintWriter out = response.getWriter();
	
	  // ModelANdView 객체 생성
	    ModelAndView mav = new ModelAndView();
	  // List 배열 객체 생성  
	    List<EventVO> checkuser = null;
		  
	  
	// @ 1) 로그인이 안되어있을 경우 로그인 페이지로 이동 시킨다.
	    String id = (String)session.getAttribute("email");
	    
		System.out.println("email 값은 : "+id);

			
		// @ 2) 응모권이 없을 경우(null), 추첨을 할 수 없도록 설정 한다.
		// #1. service -> dao로 id 값을 보내서 dao에서 조회 시킨다.
		
		checkuser = eventservice.checkuser(id);
		 
		int i = checkuser.size()-1;
		// checkuser에 저장된 d_cnt만 꺼낸다.

		String d_cnt = checkuser.get(i).getD_cnt();

		System.out.println(d_cnt);

		
			 // 만약에 응모권이 한개도 없다면
			if(d_cnt.equals("0")) {
				
				// msg 변수에 로그인 해야한다는 문구 저장
				//	String msg = "보유하신 응모권이 없습니다!, 상세페이지로 이동합니다!";
				
				
				// PrinterWriter 클래스를 이용하여 JAVASCRIPT 구문으로 alert를 발생시키고, location.replace 메소드를 통해서 바로 상세페이지로 이동 시킬 때,
				// ticket 값을 0으로 입력하여 eventdetailresult.jsp에 ticket값이 0일 경우 jstl을 이용하여 소지하고있는 응모권이 없습니다를 생성시킨다!
				out.println("<script>alert('보유하신 응모권이 없습니다!, 상세페이지로 이동합니다');");
//					out.println("window.location.replace('http://localhost:8090/shuKream/event/detailresult.do?ticket=0');</script>");
				out.println("window.location.href='"+contextPath+"/event/detailresult.do?ticket=0&id="+id+"';</script>");
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
  
  // #3 ) 2차 주소 : http://localhost:8090/teamproject/event/redirect.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/redirect.do", method = RequestMethod.GET)
  public ModelAndView redirect(@RequestParam("id")String id,@RequestParam("ticket")String ticket,HttpServletRequest request, HttpServletResponse response) {

	System.out.println("redirect.do 호출!"); 
	 
	System.out.println(id);
	
	// List 배열 객체 생성  
    List<EventVO> checkuser = null;
    
	EventVO coupon =  new EventVO();

    
     // 응모권 없음에서 사용할 변수 초기화
    
    String member_id = null;
    
    // @ 1) eventdetail.jsp에서 location.replace로 전달받은 값을 가져온다.
    // 1) 추가중 : login 구현 후 session id 가져오기,
    // 1-1) 무료배송권 : freeshipping
    // 1-2) 30일무료보관권 : freestore
    // 1-3) 수수료 1회 면제권 : freecharge
    // 1-4) 응모권이 없을때 : 0
    // 1-5) 꽝 : OTL
	  
	// @ 2) 로그인 되어있는 id(이메일주소)+ 물품정보(또는 거래번호) + oder_status(최종주문상태)를 가져와서
	
	// d_contents 형식을 " @@@ 체결정보에 대한 거래 완료에 따른 이벤트권 발급"으로 설정시키고,
	// 응모권을 사용할 경우 추첨권의 사용을 +1 증가시키고, 남은 사용권을 -1 감소시킨다.

    // ticket 내용에 따라서 각각 다른 메소드를 호출 시킨다.
    
    // #1) 공통 1 = 기존에 저장 된 값 조회해오기
    
		// 1) 해당 아이디의 db를 먼저 조회 해온다.
		checkuser = eventservice.checkuser(id);

    	// 2) 해당 db에 값을 추가한다.
    	// 2-1) 총 응모권 횟수와 미사용 응모권 횟수의 값을 int로 변환시킨다.
		int i = checkuser.size()-1;
    	int a_cnt = Integer.parseInt(checkuser.get(i).getA_cnt());
    	int d_cnt = Integer.parseInt(checkuser.get(i).getD_cnt());
    	// uc_cnt는 그냥 가져온다( null 방지 )
    	String u_cnt = checkuser.get(i).getU_cnt();

	    	//ac_cnt와 dc_cnt의 값을 1 증가 시킨다.
	    	a_cnt += 1;
	    	d_cnt += 1;
    
    // #1) 무료배송권에 당첨 되었을 때,
    if(ticket.equals("freeshipping")){
    	
    	ticket = null;

    	System.out.println(ticket);
    	
	    	// 티켓명을 저장한다.
	    	ticket = "무료배송권";
	    	// 응모당첨 내역을 저장한다.
	    	// 임시로 넣어놓고, 나중에는 주문번호를 따와서 추가 시킨다.<작성중>
	        String contents = "(주문번호2)의 주문완료에 대한 응모권 발생";
	        String confirm = "아니오";
	        
	        //EventVO로 전달한 값들을 저장시킨다.
	        coupon.setMember_id(id);
	    	coupon.setA_cnt(Integer.toString(a_cnt));
	    	coupon.setU_cnt(u_cnt);
	    	coupon.setD_cnt(Integer.toString(d_cnt));
	    	coupon.setD_ticket(ticket);
	    	coupon.setD_contents(contents);
	    	coupon.setD_confirm(confirm);
	    	
// check!) d_contents = order_status를 조회해와서 주문완료 complete로 추가가 될 때,
//      상품 거래가 끝난것으로 보고, 응모권을 추가 시키도록 한다. (order_status에 member_id를 엮어줘야 할듯)
// check!) d_confirm = 살때 혹은 팔때 무료배송권을 사용할 경우, count에 날짜를 표시하도록 한다.

    	// 저장이 완료되었으면, 서비스로 전달시킨다.
    	eventservice.addcoupon(coupon, id);
    	
    // #2) 무료30일보관권에 당첨 되었을 때,
    }else if(ticket.equals("freestore")) {
    	
    	ticket = null;
    	
    	System.out.println(ticket);

	    	// 티켓명을 저장한다.
	    	ticket = "한달무료입고권";
	    	// 응모당첨 내역을 저장한다.
	    	// 임시로 넣어놓고, 나중에는 주문번호를 따와서 추가 시킨다.<작성중>
	        String contents = "(주문번호2)의 주문완료에 대한 응모권 발생";
	        String confirm = "아니오";
	    	
    	
	        //EventVO로 전달한 값들을 저장시킨다.
	        coupon.setMember_id(id);
	    	coupon.setA_cnt(Integer.toString(a_cnt));
	    	coupon.setU_cnt(u_cnt);
	    	coupon.setD_cnt(Integer.toString(d_cnt));
	    	coupon.setD_ticket(ticket);
	    	coupon.setD_contents(contents);
	    	coupon.setD_confirm(confirm);
	    	
// check!) d_contents = order_status를 조회해와서 주문완료 complete로 추가가 될 때,
//      상품 거래가 끝난것으로 보고, 응모권을 추가 시키도록 한다. (order_status에 member_id를 엮어줘야 할듯)
// check!) d_confirm = 살때 혹은 팔때 무료배송권을 사용할 경우, count에 날짜를 표시하도록 한다.

    	System.out.println(ticket);

    	// 저장이 완료되었으면, 서비스로 전달시킨다.
    	eventservice.addcoupon(coupon, id);
    	
    	// 다시 리스트를 조회한다.
    	checkuser = eventservice.checkuser(id);
    	
	// #3) 수수료무료권에 당첨 되었을 때,	
    }else if(ticket.equals("freecharge")) {
    	
    	ticket = null;
    	
	    	// 티켓명을 저장한다.
	    	ticket = "수수료1회무료권";
	    	// 응모당첨 내역을 저장한다.
	    	// 임시로 넣어놓고, 나중에는 주문번호를 따와서 추가 시킨다.<작성중>
	        String contents = "(주문번호2)의 주문완료에 대한 응모권 발생";
	        String confirm = "아니오";
	    	
    	
	        //EventVO로 전달한 값들을 저장시킨다.
	        coupon.setMember_id(id);
	    	coupon.setA_cnt(Integer.toString(a_cnt));
	    	coupon.setU_cnt(u_cnt);
	    	coupon.setD_cnt(Integer.toString(d_cnt));
	    	coupon.setD_ticket(ticket);
	    	coupon.setD_contents(contents);
	    	coupon.setD_confirm(confirm);

// check!) d_contents = order_status를 조회해와서 주문완료 complete로 추가가 될 때,
//      상품 거래가 끝난것으로 보고, 응모권을 추가 시키도록 한다. (order_status에 member_id를 엮어줘야 할듯)
// check!) d_confirm = 살때 혹은 팔때 무료배송권을 사용할 경우, count에 날짜를 표시하도록 한다.

    	System.out.println(ticket);

    	// 저장이 완료되었으면, 서비스로 전달시킨다.
    	eventservice.addcoupon(coupon, id);
    	
    
    // 응모권이 없을 경우에는, 그대로 DB에 있는 내역만 조회해서 전달한다.
    }else if(ticket.equals("0")) {

    	checkuser = eventservice.checkuser(id);

    // 꽝일 경우 insert 문으로 티켓을 꽝으로 적립시킨다.
    }else {
    	
    	ticket = null;

    	System.out.println(ticket);
    
	    	// 티켓명을 저장한다.
	    	ticket = "꽝";
	    	// 응모당첨 내역을 저장한다.
	    	// 임시로 넣어놓고, 나중에는 주문번호를 따와서 추가 시킨다.<작성중>
	        String contents = "(주문번호2)의 주문완료에 대한 응모권 발생";
	        String confirm = "예";
	    	
	        // 이미 사용 된 응모권으로 처리하고
	        // 보유중인 응모권에서 -1 한다.
	        int u = Integer.parseInt(u_cnt);
	        u += 1;
	        d_cnt -= 1;
    	
	        //EventVO로 전달한 값들을 저장시킨다.
	        coupon.setMember_id(id);
	    	coupon.setA_cnt(Integer.toString(a_cnt));
	    	coupon.setU_cnt(Integer.toString(u));
	    	coupon.setD_cnt(Integer.toString(d_cnt));
	    	coupon.setD_ticket(ticket);
	    	coupon.setD_contents(contents);
	    	coupon.setD_confirm(confirm);
	    	
// check!) d_contents = order_status를 조회해와서 주문완료 complete로 추가가 될 때,
//      상품 거래가 끝난것으로 보고, 응모권을 추가 시키도록 한다. (order_status에 member_id를 엮어줘야 할듯)
// check!) d_confirm = 살때 혹은 팔때 무료배송권을 사용할 경우, count에 날짜를 표시하도록 한다.

    	System.out.println(ticket);

    	// 저장이 완료되었으면, 서비스로 전달시킨다.
    	eventservice.addcoupon(coupon, id);
    	
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
  
  // #4 ) 2차 주소 : http://localhost:8090/teamproject/event/detailresult.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/detailresult.do", method = RequestMethod.GET)
  public ModelAndView detailresult(@RequestParam("id")String id,String ticket,HttpServletRequest request, HttpServletResponse response) throws Exception {

	  System.out.println("detailresult.do 호출!"); 
	  
	  // List 배열 객체 생성  
	    List<EventVO> checkuser = eventservice.checkuser(id);
	  	
	    int idx = checkuser.size()-1;
	  	
	    String a_cnt = checkuser.get(idx).getA_cnt();
	    String u_cnt = checkuser.get(idx).getU_cnt();
	    String d_cnt = checkuser.get(idx).getD_cnt();
	  
	// ModelANdView 객체 생성
    ModelAndView mav = new ModelAndView();
    
    // Viewname 가져오기
    String viewName = (String) request.getAttribute("viewName");
    
    // Viewname에 대한 info 생성
    logger.info(viewName);
    
    mav.addObject("checkuser", checkuser);
    mav.addObject("id", id);
    mav.addObject("a_cnt", a_cnt);
    mav.addObject("u_cnt", u_cnt);
    mav.addObject("d_cnt", d_cnt);
    
    // ModelAndView 객체에 viewName을 셋팅
    mav.setViewName(viewName);

    // ModelAndView 반환
    return mav;
  }
  
  // #1 ) 2차 주소 : http://localhost:8090/shukream/event/coupon.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/coupon.do", method = RequestMethod.GET)
  public ModelAndView coupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html; charset=utf-8");

	  System.out.println("coupon.do 호출!"); 
	  
	  //PrintWirter 객체 out 생성 및 초기화
		PrintWriter out = response.getWriter();
		
	    String contextPath = request.getContextPath();

	  // 세션값 가져오기
	  HttpSession session = request.getSession();
	  
	  // id로 세션값 저장
	  String id = (String)session.getAttribute("email");
	  
	  System.out.println(id);
	  
	  // 쿠폰을 조회해 온다.
	  List<EventVO> checkcoupon = eventservice.checkcoupon(id);
	  
	  // ModelANdView 객체 생성
	  ModelAndView mav = new ModelAndView();
	    
	  
	  // 쿠폰이 없다면?
	  if(checkcoupon.isEmpty()) {
		 
		  
		  
		out.println("<script>alert('보유하신 쿠폰이 없습니다!, 마이페이지로 이동합니다');");
		out.println("window.location.href='"+contextPath+"/member/mypage.do?id="+id+"';</script>");
		out.flush();
		out.close();
		  
	  // 쿠폰이 있다면?
	  }else{
		  
		 
		  // 가져온 값들을 전달한다.
		  mav.addObject("checkcoupon", checkcoupon);
		  
	  }
	  
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
