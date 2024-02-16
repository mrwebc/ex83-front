package com.study.jsp.srv;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.study.jsp.dao.UserMapper;
import com.study.jsp.model.UserDTO;
import com.study.jsp.model.UserVO;
import com.study.jsp.util.MapperUtil;

public class UserServiceImpl implements UserService{

  // userDao 객체를 이용해서 작업
  private UserMapper userDao;
  private ModelMapper modelMapper;
  
  public UserServiceImpl(UserMapper userDao) {
    this.userDao = userDao;
    this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
  }
  
  public UserDTO getOne(Map<String,String> loginInfo) {  

    System.out.println(loginInfo.get("userid"));
    System.out.println(loginInfo.get("password"));

    UserVO vo = userDao.getOne(loginInfo);

    UserDTO dto = null;

    // vo를 dto로 변환해서 리턴
    if (vo != null) {

      // 방법2
      dto = modelMapper.map(vo, UserDTO.class);// 앞의것을 뒤의 형식으로 변환

      // 방법1
//      dto = new UserDTO();
//      dto.setName(vo.getName());
//      dto.setPassword(vo.getPassword());
//      dto.setUserid(vo.getUserid());
//      dto.setRole(vo.getRole());

    }

    return dto;
  }

  @Override
  public UserDTO selectedById(String userid) {
    return modelMapper.map(userDao.selectedById(userid), UserDTO.class);
  }
  
  @Override
  public List<UserDTO> findAll() {
    //VO->DTO, VO->DTO 변환은 ModelMapper 라이브러리를 이용해서 처리
    List<UserDTO> list = userDao.findAll().stream()
        .map(vo->modelMapper.map(vo, UserDTO.class))
        .collect(Collectors.toList()); 
    
    return list;   
  }

  @Override
  public int chkid(String userid) {
    return userDao.chkid(userid);
  }

  @Override
  public int save(UserDTO dto) {    
    UserVO vo = modelMapper.map(dto, UserVO.class);    
    System.out.println(vo.toString());
    return userDao.save(vo);
  }

  @Override
  public int update(UserDTO dto) {
    UserVO vo = modelMapper.map(dto, UserVO.class);
    return userDao.update(vo);
  }

  @Override
  public int delete(String userid) {
    return userDao.delete(userid);
  }

}
