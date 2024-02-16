package com.study.jsp.model;

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
public class UserDTO{

  private String userid;
	private String password;
	private String name;
	private String role;
	
	public int comparePwd(String dbPassword) {
	  return this.password.compareTo(dbPassword);
	}

}
