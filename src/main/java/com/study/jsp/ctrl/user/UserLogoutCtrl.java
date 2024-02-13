package com.study.jsp.ctrl.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.ctrl.Controller;

public class UserLogoutCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {

    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/index.jsp");
    
    HttpSession session = req.getSession();
    session.invalidate();
    
    return viewInfo;
  }

}
