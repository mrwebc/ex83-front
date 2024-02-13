package com.study.jsp.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter   //VO는 주로 읽기 전용으로 사용하는 경우가 많다.
@Setter
@Builder  //객체 생성시 BoardVO.builder().build()와 같은 빌더패턴으로 사용하기 위함 

//모델매퍼 사용을 위해 생성자 필요
@NoArgsConstructor
@AllArgsConstructor
//mapper.xml 에서 캐시를 사용할 경우 Serializable 이어야 한다.
public class BoardVO implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private int seq;
	private String title;
	private String nickname;
	private String content;
	private Date regdate;
	private int cnt;
	private String userid;
}


