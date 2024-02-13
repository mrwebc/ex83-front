package com.study.jsp.srv;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.study.jsp.conf.MapperUtil;
import com.study.jsp.dao.UserMapper;
import com.study.jsp.model.UserDTO;
import com.study.jsp.model.UserVO;

public class UserServiceImpl implements UserService{

  private UserMapper dao;
  private ModelMapper modelMapper;
  
  public UserServiceImpl(UserMapper dao) {
    this.dao = dao;
    this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
  }
  
  public UserDTO getOne(Map<String,String> loginInfo) {  
    return modelMapper.map(dao.getOne(loginInfo), UserDTO.class);
  }

  @Override
  public UserDTO selectedById(String userid) {
    return modelMapper.map(dao.selectedById(userid), UserDTO.class);
  }
  
  @Override
  public List<UserDTO> findAll() {
    //VO->DTO, VO->DTO 변환은 ModelMapper 라이브러리를 이용해서 처리
    List<UserDTO> list = dao.findAll().stream()
        .map(vo->modelMapper.map(vo, UserDTO.class))
        .collect(Collectors.toList()); 
    
    return list;   
  }

  @Override
  public int chkid(String userid) {
    return dao.chkid(userid);
  }

  @Override
  public int save(UserDTO dto) {    
    UserVO vo = modelMapper.map(dto, UserVO.class);    
    System.out.println(vo.toString());
    return dao.save(vo);
  }

  @Override
  public int update(UserDTO dto) {
    UserVO vo = modelMapper.map(dto, UserVO.class);
    return dao.update(vo);
  }

  @Override
  public int delete(String userid) {
    return dao.delete(userid);
  }

}
