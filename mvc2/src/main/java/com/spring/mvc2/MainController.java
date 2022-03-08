package com.spring.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	//	main ȭ�� ���� �ּ�
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "/main";
	}
	
//	header ȭ�� ���� �ּ�
	@RequestMapping(value="/header", method=RequestMethod.GET)
	public String header() {
		return "/header";
	}
	
//	footer ȭ�� ���� �ּ�
	@RequestMapping(value="/footer", method=RequestMethod.GET)
	public String footer() {
		return "/footer";
	}
}
