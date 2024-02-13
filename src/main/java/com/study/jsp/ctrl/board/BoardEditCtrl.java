package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardEditCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/board/list.do");
    
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    
    int seq = 0;
    String seq_ = req.getParameter("seq");
    if(!seq_.isEmpty()){
      seq = Integer.valueOf(seq_);
    }
    
    BoardDTO dto = BoardDTO.builder()
        .title(title)
        .content(content)
        .seq(seq)
        .build();
    
    BoardService boardService = Factory.INSTANCE.getBoardService();
    boardService.update(dto);
    
    return viewInfo;
  }

}
