package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardEditCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("mode", "redirect");
    viewInfo.put("viewName", "/board/list.do");
    
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    
    int seq = 0;
    String seq_ = req.getParameter("seq");
    if(!seq_.isEmpty()){
      seq = Integer.valueOf(seq_);
    }

    //클라이언트가 보내온 정보를 DTO로 패키징
    //방법2 - 롬복으로...
    BoardDTO dto = BoardDTO.builder()
        .title(title)
        .content(content)
        .seq(seq)
        .build();
    
    //방법1
//  BoardDTO dto = new BoardDTO();
//  dto.setTitle(title);
//  dto.setContent(content);
//  dto.setSeq(seq);

    BoardService boardService = Factory.INSTANCE.getBoardService();
    boardService.update(dto);
    
    return viewInfo;
  }

}
