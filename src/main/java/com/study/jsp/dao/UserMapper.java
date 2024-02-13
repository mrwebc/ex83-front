package com.study.jsp.dao;

import java.util.List;
import java.util.Map;

import com.study.jsp.model.UserVO;

public interface UserMapper {
  List<UserVO> findAll();
  
  UserVO getOne(Map<String,String> loginInfo);
  
  UserVO selectedById(String userid);

  int chkid(String userid);
  
  int save(UserVO vo);
  
  int update(UserVO vo);
  
  int delete(String userid);
}
