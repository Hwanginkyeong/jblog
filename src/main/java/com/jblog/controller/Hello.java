package com.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {
	
	@RequestMapping(value="/hello", method= {RequestMethod.GET, RequestMethod.POST})
	public String hello() {
		System.out.println("아아아 테스트입니다.");
		
		return "/WEB-INF/views/hello.jsp";
	}
	

	

}
