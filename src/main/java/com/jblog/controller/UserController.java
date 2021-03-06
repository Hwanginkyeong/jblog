package com.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jblog.service.UserService;
import com.jblog.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	
//로그인폼
		@RequestMapping(value="/user/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
		public String loginForm() {
			System.out.println("[UserController.loginForm()");
			
			return "user/loginForm";
			
		}
	
//로그인
		@RequestMapping(value="/user/login", method = {RequestMethod.GET, RequestMethod.POST})
		public String login(@ModelAttribute UserVo userVo, HttpSession session) {
			System.out.println("[UserController.login()");
			System.out.println(userVo);
			
			UserVo authUser = userService.login(userVo);   
			System.out.println(authUser);
			
			if(authUser !=null) {//로그인 성공 
				System.out.println("로그인성공");
				//세션에 저장
				session.setAttribute("authUser", authUser);	
				
				//리다이렉트 메인
				return "redirect:/";
			}else { //로그인 실패 
				System.out.println("로그인실패");
				//리다이렉트 로그인폼 
				return "redirect:/user/loginForm?result=fail";
			}
	
		}

//로그아웃 
		@RequestMapping(value="/user/logout", method = {RequestMethod.GET, RequestMethod.POST})
		public String logout(HttpSession session) {	
			System.out.println("[UserController.logout()");
			
			//세션의 정보 삭제 
			session.removeAttribute("authUser");
			session.invalidate();
			
			return "redirect:/";
	
		}
		
		
//회원가입폼 
		@RequestMapping(value ="/user/joinForm", method = {RequestMethod.GET, RequestMethod.POST})
		public String joinForm(@ModelAttribute UserVo userVo, HttpSession session) {
			System.out.println("[UserController.joinForm()");
			
			return "user/joinForm";
		}


//회원가입 
		@RequestMapping(value ="/user/join", method = {RequestMethod.GET, RequestMethod.POST})
		public String join(@ModelAttribute UserVo userVo, HttpSession session) {
			System.out.println("[UserController.join()");
			System.out.println(userVo);
			
			
			
			return "user/joinSuccess";
			
			
			/*
		
			if(authUser !=null) {//로그인 성공 
				System.out.println("로그인성공");
				//세션에 저장
				session.setAttribute("authUser", authUser);	
				
				//리다이렉트 메인
				return "redirect:/";
			}else { //로그인 실패 
				System.out.println("로그인실패");
				//리다이렉트 로그인폼 
				return "redirect:/user/loginForm?result=fail";
			}
			*/
		}
		
		
		
		
		
		
}
