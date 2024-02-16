package com.study.jsp.ctrl.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

public class UserReadCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("viewName", "/views/user/read.jsp");
    
    String userid = req.getParameter("userid");
    
    //System.out.println("userid = "+userid);

    UserService userSrv = Factory.INSTANCE.getUserService();
    UserDTO dto = userSrv.selectedById(userid);
    
    req.setAttribute("dto", dto);
    
    return viewInfo; 
  }

}
