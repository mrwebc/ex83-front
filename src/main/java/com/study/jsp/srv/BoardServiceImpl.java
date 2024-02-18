package com.study.jsp.srv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.BoardVO;
import com.study.jsp.persistence.BoardMapper;
import com.study.jsp.util.MapperUtil;

public class BoardServiceImpl implements BoardService {

  // 필요한 객체를 Factory에서 주입(DI)
  private BoardMapper boardDao;
  private ModelMapper modelMapper;//모델매퍼 라이브러리 객체
  
  public BoardServiceImpl(BoardMapper boardDao) {
    this.boardDao = boardDao;
    this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
  }

  @Override
  public List<BoardDTO> findAll() {   

    List<BoardVO> daoList = boardDao.findAll();
    List<BoardDTO> list = null;

    if (daoList != null) {
      list = new ArrayList<BoardDTO>();

      // 방법2
      //VO->DTO, VO->DTO 변환은 ModelMapper 라이브러리를 이용해서 처리
      list = daoList.stream().map(vo -> modelMapper.map(vo, BoardDTO.class))
          .collect(Collectors.toList());

      // 방법1
//      for (BoardVO vo : daoList) {
//
//        BoardDTO dto = new BoardDTO();
//        dto.setCnt(vo.getCnt());
//        dto.setContent(vo.getContent());
//        dto.setNickname(vo.getNickname());
//        dto.setRegdate(vo.getRegdate());
//        dto.setSeq(vo.getSeq());
//        dto.setTitle(vo.getTitle());
//        dto.setUserid(vo.getUserid());
//
//        list.add(dto);
//
//      } // for

    } // if
    
    return list;    
  }

  @Override
  public BoardDTO getOne(int seq) {    

    increaseCnt(seq);

    BoardVO vo = boardDao.getOne(seq);

    // VO를 DTO로 변환
    // 방법2
    BoardDTO dto = modelMapper.map(vo, BoardDTO.class);

    // 방법1
//    BoardDTO dto = new BoardDTO();
//    dto.setCnt(vo.getCnt());
//    dto.setContent(vo.getContent());
//    dto.setNickname(vo.getNickname());
//    dto.setRegdate(vo.getRegdate());
//    dto.setSeq(vo.getSeq());
//    dto.setTitle(vo.getTitle());
//    dto.setUserid(vo.getUserid());

    return dto;
  }

  @Override
  public int save(BoardDTO dto) { 

    // DTO를 VO로 변환하는 작업
    // 방법2
    BoardVO vo = modelMapper.map(dto, BoardVO.class);

    // 방법1
//    BoardVO vo = new BoardVO();
//    vo.setUserid(dto.getUserid());
//    vo.setTitle(dto.getTitle());
//    vo.setContent(dto.getContent());
//    vo.setNickname(dto.getNickname());

    return boardDao.save(vo);
  }

  @Override
  public int update(BoardDTO dto) {

    // DTO를 VO로 변환하는 작업
    // 방법2
    BoardVO vo = modelMapper.map(dto, BoardVO.class);

    // 방법1
//    BoardVO vo = new BoardVO();
//    vo.setSeq(dto.getSeq());
//    vo.setUserid(dto.getUserid());
//    vo.setTitle(dto.getTitle());
//    vo.setContent(dto.getContent());
//    vo.setNickname(dto.getNickname());

    return boardDao.update(vo);
  }

  @Override
  public int delete(int seq) {
    int result = boardDao.delete(seq);    

    return result;
  }

  @Override
  public int increaseCnt(int seq) {
    int result = boardDao.increaseCnt(seq);   
    return result;
  }
  
}
