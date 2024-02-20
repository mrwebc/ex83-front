package com.study.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/board/*")
public class LoginCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	  HttpServletRequest req = (HttpServletRequest)request;
	  HttpServletResponse res = (HttpServletResponse)response;
	  
    //로그인한 사용자만 접근 가능하도록 설정
    HttpSession session = req.getSession();
    System.out.println("BoardListCtrl 실행됨");

    if(session.getAttribute("userid") == null) {
      res.sendRedirect(req.getContextPath()+"/views/user/login.jsp");
      return;
    }

		chain.doFilter(request, response);
	}

}
