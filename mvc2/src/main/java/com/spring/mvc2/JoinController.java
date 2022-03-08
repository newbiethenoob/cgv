package com.spring.mvc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.MemberDto;
import com.spring.service.MemberService;

@Controller
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	
	/**회원가입 폼**/
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/join/join";
	}
	
	/**회원가입 처리**/
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberDto dto) {
		ModelAndView mv = new ModelAndView();
//		MemberDao dao = new MemberDao();
//		int result = dao.insert(dto);
		System.out.println("1111");
		int result = memberService.getJoin(dto);
		System.out.println("2222");
		String result_page = "";
		
		if(result == 1) {
			result_page="/login/login";
			mv.setViewName(result_page);
			mv.addObject("result", "ok");
		}
		
		
		return result_page;
	}
}


/**
String[] hobby_list = dto.getHobby_list();
//System.out.println("---> 데이터 전송");
//System.out.println("id ---> " + dto.getId());
//System.out.println("pass ---> " + dto.getPass());
//System.out.println("name ---> " + dto.getName());
//System.out.println("gender ---> " + dto.getGender());
//System.out.println("email1 ---> " + dto.getEmail1());
//System.out.println("email2 ---> " + dto.getEmail2());
System.out.println("email ---> " + dto.getEmail());
//System.out.println("addr1 ---> " + dto.getAddr1());
System.out.println("address ---> " + dto.getAddress());
//System.out.println("tel ---> " + dto.getTel());
System.out.println("hp_num ---> " + dto.getHp_num());
System.out.println("hobby ---> " + dto.getHobby()); **/
