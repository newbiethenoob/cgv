package com.spring.mvc2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.MemberDto;
import com.spring.service.MemberService;

@Controller
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	/*
	 * 제목 : 회원리스트 페이지
	 * @return 
	 */
	@RequestMapping(value="/admin/member_list", method=RequestMethod.GET)
	public ModelAndView member_list() {
		ModelAndView mv = new ModelAndView();
//		MemberDao dao = new MemverDao();
//		ArrayList<MemberDto> list = dao.select();
		
		ArrayList<MemberDto> list = 
				(ArrayList<MemberDto>)memberService.getList();
		
		System.out.println("list size-------->>" + list.size());
		
		mv.setViewName("/admin/member/member_list");
		mv.addObject("list", list);
				
		return mv;
	}
	
	/**
	 * 제목 : 관리자 메인화면
	 */
	
	
}
