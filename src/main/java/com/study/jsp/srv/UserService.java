package com.study.jsp.srv;

import java.util.List;
import java.util.Map;

import com.study.jsp.model.UserDTO;

public interface UserService {

  UserDTO getOne(Map<String,String> loginInfo);

  
  UserDTO selectedById(String userid);
  
  
  List<UserDTO> findAll();

  
  int chkid(String userid);

  
  int save(UserDTO dto);

  
  int update(UserDTO dto);

  
  int delete(String userid);

}
