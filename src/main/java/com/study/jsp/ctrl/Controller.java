package com.study.jsp.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {  
  Map<String, String> execute(HttpServletRequest req, HttpServletResponse res);
}
