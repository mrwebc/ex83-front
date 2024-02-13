package com.study.jsp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.study.jsp.model.UserVO;

public class UserMapperDAO implements UserMapper {

  private SqlSession sqlSession;  
  public UserMapperDAO(SqlSession sqlSession) {
    this.sqlSession = sqlSession;   
  }
  
  public UserMapper mp() {
    return sqlSession.getMapper(UserMapper.class);
  }

  @Override
	public UserVO getOne(Map<String,String> loginInfo) {	  
	  return mp().getOne(loginInfo);
	}

  @Override
  public UserVO selectedById(String userid) {
    return mp().selectedById(userid);
  }
  
  @Override
  public List<UserVO> findAll() {
    return mp().findAll();
  }
  
  

  @Override
  public int chkid(String userid) {
    return mp().chkid(userid);
  }

  @Override
  public int save(UserVO vo) {
    int result = 0; 
    
    try {
      result = mp().save(vo);
      sqlSession.commit();
    }catch(Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }
    
    return result;
  }

  @Override
  public int update(UserVO vo) {
    int result = 0; 
    
    try {
      result = mp().update(vo);
      sqlSession.commit();
    }catch(Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }
    
    return result;    
  }

  @Override
  public int delete(String userid) {
    return mp().delete(userid);
  }

}
