package com.study.jsp.ctrl.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

public class UserRegistCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
   
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("viewName", "/user/list.do");

    String userid = req.getParameter("userid");
    String password = req.getParameter("password");
    String name = req.getParameter("name");
    String role = req.getParameter("role");
    
    UserDTO dto = UserDTO.builder()
        .userid(userid)
        .password(password)
        .name(name)
        .role(role)
        .build();
    
    System.out.println(dto.toString());
    
    UserService userSrv = Factory.INSTANCE.getUserService();
    userSrv.save(dto);
    
    return viewInfo;    
  }

}
