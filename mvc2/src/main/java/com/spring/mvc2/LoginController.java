package com.spring.mvc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.MemberDao;
import com.spring.dto.MemberDto;
import com.spring.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
//	login 拳搁 概俏 林家
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
//	login 单捞磐 贸府
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(String id, String pass, MemberDto dto) {
		ModelAndView mv = new ModelAndView();
//		MemberDao dao = new MemberDao();
//		String result = dao.select(dto);
		
		int result = memberService.getLogin(dto);
		System.out.println("mybatis ---->>");
		
		if(result == 1) {
			mv.setViewName("/main");
			mv.addObject("login_result", "succ");
		}else {
			mv.setViewName("/login/login");
			mv.addObject("login_result", "fail");
		}
		return mv;
		
//		System.out.println("id-->"+dto.getId());
//		System.out.println("pass-->"+dto.getPass());
//		return "/login/login
	}
	
//	login 单捞磐 贸府
	@RequestMapping(value="/login_proc", method=RequestMethod.POST)
	public String login_proc(String id, String pass) {
		System.out.println("id ---> "+id);
		System.out.println("pass ---> "+pass);
		
		return "/login/login";
	}
	
//	LOGIN 贸府
	
}
