package com.shukream.common.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//데이터를 이용하며 오류가 났을 경우, 오류 내용을 알 수 있는 java파일
//팀프로젝트 완성 후, web.xml에서 오류페이지 통일 가능
@ControllerAdvice
public class CommonExceptionAdvice {
  private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
  
  @ExceptionHandler(RuntimeException.class)
  public String errorException(Model model, Exception e) {
    logger.info("@ControllerAdvice 방식 \n###exeption : " + e.getMessage());
    model.addAttribute("exception", e);
    return "error/exception";
  }
  
}
