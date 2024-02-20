package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardListCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("mode", "forward");
    
    //로그인한 사용자만 접근 가능하도록 설정 -> LoginCheckFilter 필터 처리함
    
    /*
      HttpSession session = req.getSession();
      System.out.println("BoardListCtrl 실행됨");
  
      if(session.getAttribute("userid") == null) {
        viewInfo.put("viewName", "/views/user/login.jsp");
        return viewInfo;
      }
    */

    BoardService boardService = Factory.INSTANCE.getBoardService();
    List<BoardDTO> list = boardService.findAll();
    
    req.setAttribute("list", list);
    viewInfo.put("viewName", "/views/board/list.jsp");
    
    return viewInfo;

  }

}
