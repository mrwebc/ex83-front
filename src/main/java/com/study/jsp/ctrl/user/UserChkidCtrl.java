package com.study.jsp.ctrl.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ioc.Factory;
import com.study.jsp.srv.UserService;


@WebServlet("/user/chkid")
public class UserChkidCtrl extends HttpServlet{
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    res.setContentType("text/html;charset=utf-8");

    String userid = req.getParameter("userid");
    System.out.printf("userid 아이디 = %s\n", userid);
    
    UserService userSrv = Factory.INSTANCE.getUserService();    
    int cnt = userSrv.chkid(userid);

    PrintWriter out = res.getWriter();
    out.print(cnt);// 클라이언트에 응답텍스트 보냄
  }

}
