package com.study.jsp.ctrl;

import java.util.HashMap;
import java.util.Map;

import com.study.jsp.ctrl.board.BoardDeleteCtrl;
import com.study.jsp.ctrl.board.BoardEditCtrl;
import com.study.jsp.ctrl.board.BoardListCtrl;
import com.study.jsp.ctrl.board.BoardReadCtrl;
import com.study.jsp.ctrl.board.BoardWriteCtrl;
import com.study.jsp.ctrl.user.UserDeleteCtrl;
import com.study.jsp.ctrl.user.UserEditCtrl;
import com.study.jsp.ctrl.user.UserListCtrl;
import com.study.jsp.ctrl.user.UserLoginCtrl;
import com.study.jsp.ctrl.user.UserLogoutCtrl;
import com.study.jsp.ctrl.user.UserReadCtrl;
import com.study.jsp.ctrl.user.UserRegistCtrl;

public class HanderMapping {

  Map<String, Controller> urlMap = null;// url과 command 객체를 서로 연결시켜 주는 역할

  // 생성자에서 맵초기화
  public HanderMapping() {
    urlMap = new HashMap<String, Controller>();
    urlMap.put("/board/list.do", new BoardListCtrl());
    urlMap.put("/board/write.do", new BoardWriteCtrl());
    urlMap.put("/board/edit.do", new BoardEditCtrl());
    urlMap.put("/board/delete.do", new BoardDeleteCtrl());
    urlMap.put("/board/read.do", new BoardReadCtrl());
    
    urlMap.put("/user/login.do", new UserLoginCtrl());
    urlMap.put("/user/logout.do", new UserLogoutCtrl());
    urlMap.put("/user/list.do", new UserListCtrl());
    urlMap.put("/user/regist.do", new UserRegistCtrl());
    urlMap.put("/user/read.do", new UserReadCtrl());
    urlMap.put("/user/edit.do", new UserEditCtrl());
    urlMap.put("/user/delete.do", new UserDeleteCtrl());
  }

  public Controller getController(String path) {
    return urlMap.get(path);
  }
}
