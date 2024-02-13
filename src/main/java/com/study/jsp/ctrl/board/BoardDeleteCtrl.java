package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.srv.BoardService;

public class BoardDeleteCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/board/list.do");
    
    int seq = 0;
    String seq_ = req.getParameter("seq");
    if(!seq_.isEmpty()){
      seq = Integer.valueOf(seq_);
    } 

    BoardService boardService = Factory.INSTANCE.getBoardService();
    int cnt = boardService.delete(seq);
    
    return viewInfo;
  }


}
