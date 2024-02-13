package com.study.jsp.ctrl.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.srv.UserService;

public class UserDeleteCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/user/list.do");
    
    String userid = req.getParameter("userid");

    UserService userSrv = Factory.INSTANCE.getUserService();
    userSrv.delete(userid);
    


    return viewInfo; 
  }

}
