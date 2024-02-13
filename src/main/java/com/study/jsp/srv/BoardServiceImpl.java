package com.study.jsp.srv;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.study.jsp.conf.MapperUtil;
import com.study.jsp.dao.BoardMapper;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.BoardVO;

public class BoardServiceImpl implements BoardService {
  
  private BoardMapper dao;
  private ModelMapper modelMapper;//모델매퍼 라이브러리 객체
  
  public BoardServiceImpl(BoardMapper dao) {
    this.dao = dao;
    this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
  }

  @Override
  public List<BoardDTO> findAll() {   

    //VO->DTO, VO->DTO 변환은 ModelMapper 라이브러리를 이용해서 처리
    List<BoardDTO> list = dao.findAll().stream()
        .map(vo->modelMapper.map(vo, BoardDTO.class))
        .collect(Collectors.toList()); 
    
    return list;    
  }

  @Override
  public BoardDTO getOne(int seq) {    
    increaseCnt(seq);   
    BoardVO vo = dao.getOne(seq);
    return modelMapper.map(vo, BoardDTO.class);
  }

  @Override
  public int save(BoardDTO dto) { 
    
    //BoardDTODTO 파라미터를 받아서 BoardVO로 변환
    //모델매퍼를 이용할때는 대상 클래스의 생성자를 이용한다.
    BoardVO vo = modelMapper.map(dto, BoardVO.class);
    int result = dao.save(vo); 

    return result;
  }

  @Override
  public int update(BoardDTO dto) {
    BoardVO vo = modelMapper.map(dto, BoardVO.class);
    int result = dao.update(vo);       

    return result;
  }

  @Override
  public int delete(int seq) {
    int result = dao.delete(seq);    

    return result;
  }

  @Override
  public int increaseCnt(int seq) {
    int result = dao.increaseCnt(seq);   
    return result;
  }
  
}
