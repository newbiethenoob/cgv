package com.spring.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
	
//	mypage ȭ�� ���� �ּ�
	@RequestMapping(value="/mycgv", method=RequestMethod.GET)
	public String mypage() {
		return "/mypage/mycgv";
	}

}
