package com.study.jsp.ctrl.user;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

public class UserEditCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/user/list.do");

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
    

    //패스워드 확인
    String dbPassword = userSrv.selectedById(dto.getUserid()).getPassword();
    if(dto.compareIdPwd(dbPassword)==0) {
      userSrv.update(dto);
    }
    
    return viewInfo; 
  }

}