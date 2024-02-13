package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardListCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    
    //login page를 거쳐오면 session에 id와 name 속성이 존재한다
    HttpSession session = req.getSession();
    System.out.println("BoardListCtrl 실행됨");

    if(session.getAttribute("userid") == null) {
      viewInfo.put("path", "/views/user/login.jsp");
    }

    BoardService boardService = Factory.INSTANCE.getBoardService();
    List<BoardDTO> list = boardService.findAll();
    
    req.setAttribute("list", list);
    viewInfo.put("path", "/views/board/list.jsp");
    
    return viewInfo;

  }

}
