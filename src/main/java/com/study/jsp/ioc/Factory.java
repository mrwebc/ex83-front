package com.study.jsp.ioc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.jsp.persistence.BoardMapper;
import com.study.jsp.persistence.BoardMapperDAO;
import com.study.jsp.persistence.UserMapper;
import com.study.jsp.persistence.UserMapperDAO;
import com.study.jsp.srv.BoardService;
import com.study.jsp.srv.BoardServiceImpl;
import com.study.jsp.srv.UserService;
import com.study.jsp.srv.UserServiceImpl;

import myBatis.MyBatisManager;

//enum은 조금 특별한 class 이다. 
//싱글톤 객체를 쉽게 생성하는데 활용하기도 한다.
public enum Factory {
  
  //싱글톤
  INSTANCE;

  // 마이바티즈 SqlSession 객체 생성
  private SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
  private SqlSession sqlSession = sqlSessionFactory.openSession(false);
  

  BoardMapper boardDao = new BoardMapperDAO(sqlSession);    
  UserMapper userDao = new UserMapperDAO(sqlSession);    

  BoardService boardService = new BoardServiceImpl(boardDao);
  UserService userService = new UserServiceImpl(userDao);
  
  // jsp나 컨트롤러에서 서비스객체가 필요할 경우 Factory의 get서비스() 이용
  public BoardService getBoardService() {
    return boardService;
  }

  public UserService getUserService() {
    return userService;
  }
  
}
