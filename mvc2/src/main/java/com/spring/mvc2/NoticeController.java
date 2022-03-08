package com.spring.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {

	//notice_content 매핑화면
	@RequestMapping(value="/notice_content", method=RequestMethod.GET)
	public String notice_content() {
		return "/notice_content";
	}
	
	//notice_list 매핑화면
	@RequestMapping(value="/notice_list", method=RequestMethod.GET)
	public String notice_list() {
		return "/notice_list";
	}
}
