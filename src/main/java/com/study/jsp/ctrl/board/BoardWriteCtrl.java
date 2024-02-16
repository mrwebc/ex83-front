package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardWriteCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {

    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "redirect");
    viewInfo.put("viewName", "/board/list.do");
    
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String nickname = req.getParameter("nickname");
    String userid = req.getParameter("userid");

    //클라언트가 보내온 정보를 DTO로 패키징
    //방법2 - 롬복의 @Builder를 이용
    BoardDTO dto = BoardDTO.builder()
        .title(title)
        .userid(userid)
        .content(content)
        .nickname(nickname)
        .build();
    
    
    //방법1
//    BoardDTO dto = new BoardDTO();
//    dto.setUserid(userid);
//    dto.setTitle(title);
//    dto.setContent(content);
//    dto.setNickname(nickname);

    BoardService boardService= Factory.INSTANCE.getBoardService();
    boardService.save(dto);

    return viewInfo;
  }

}
