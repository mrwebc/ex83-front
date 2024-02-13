package com.study.jsp.dao;

import java.util.List;

import com.study.jsp.model.BoardVO;

public interface BoardMapper {

  List<BoardVO> findAll();
  
  BoardVO getOne(int seq);
  
  int save(BoardVO vo);
  
  int update(BoardVO vo);
  
  int delete(int seq);
  
  int increaseCnt(int seq);
  
}
