package com.study.jsp.ctrl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

public class UserListCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("path", "/views/user/list.jsp");
    
    UserService userSrv = Factory.INSTANCE.getUserService();
   
    List<UserDTO> list = userSrv.findAll();
    req.setAttribute("list", list);
    
    return viewInfo;
  }

}
