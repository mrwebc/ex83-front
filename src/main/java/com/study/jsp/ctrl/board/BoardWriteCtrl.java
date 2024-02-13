package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardWriteCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {

    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/board/list.do");
    
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String nickname = req.getParameter("nickname");
    String userid = req.getParameter("userid");
    
    BoardDTO dto = BoardDTO.builder()
        .title(title)
        .content(content)
        .nickname(nickname)
        .userid(userid)
        .build();
    
    BoardService boardService= Factory.INSTANCE.getBoardService();
    boardService.save(dto);

    return viewInfo;
  }

}
