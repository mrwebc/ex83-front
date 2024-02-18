package com.study.jsp.persistence;

import java.util.List;
import java.util.Map;

import com.study.jsp.model.UserVO;

public interface UserMapper {
  List<UserVO> findAll();

  // 매퍼xml의 id값이 추상메소드 이름
  // resultType 값을 리턴타입으로 지정
  UserVO getOne(Map<String,String> loginInfo);
  
  UserVO selectedById(String userid);

  int chkid(String userid);
  
  int save(UserVO vo);
  
  int update(UserVO vo);
  
  int delete(String userid);
}
