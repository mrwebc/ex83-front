package com.study.jsp.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

//모델매퍼 사용을 위해 생성자 필요
@NoArgsConstructor
@AllArgsConstructor
//mapper.xml 에서 캐시를 사용할 경우 Serializable 이어야 한다.
public class UserVO implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private String userid;
	private String password;
	private String name;
	private String role;

}
