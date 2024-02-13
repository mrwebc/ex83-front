package com.study.jsp.ctrl.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

public class UserLoginCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    
    String userid = req.getParameter("userid");
    String userpw = req.getParameter("userpw");
    
    Map<String, String> loginInfo = new HashMap<String, String>();
    loginInfo.put("userid",userid);
    loginInfo.put("userpw",userpw);
    
    UserService userService = Factory.INSTANCE.getUserService();
    UserDTO dto = userService.getOne(loginInfo);
    
    if(dto != null) {
      HttpSession session = req.getSession();
      session.setAttribute("userid", dto.getUserid());
      session.setAttribute("name", dto.getName());
      viewInfo.put("path", "/board/list.do");
    }else{
      viewInfo.put("path", "/views/user/login.jsp");
    }
    
    return viewInfo;
  }

}
