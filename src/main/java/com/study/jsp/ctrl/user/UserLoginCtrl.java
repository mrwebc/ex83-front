package com.study.jsp.ctrl.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

public class UserLoginCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("mode", "redirect");

    // 클라이언트가 보내온 로그인 정보 수신
    String userid = req.getParameter("userid");
    String password = req.getParameter("password");
    
    Map<String, String> loginInfo = new HashMap<String, String>();
    loginInfo.put("userid",userid);
    loginInfo.put("password",password);
    
    UserService userService = Factory.INSTANCE.getUserService();
    UserDTO dto = userService.getOne(loginInfo);

    // 로그인 성공 -> list.do
    if(dto != null) {
      HttpSession session = req.getSession();
      session.setAttribute("userid", dto.getUserid());
      session.setAttribute("name", dto.getName());
      viewInfo.put("viewName", "/board/list.do");
      
    }else{// 로그인 실패 -> login.jsp
      viewInfo.put("viewName", "/views/user/login.jsp");
    }
    
    return viewInfo;
  }

}
