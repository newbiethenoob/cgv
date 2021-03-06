package com.spring.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	//	main 화면 매핑 주소
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "/main";
	}
	
//	header 화면 매핑 주소
	@RequestMapping(value="/header", method=RequestMethod.GET)
	public String header() {
		return "/header";
	}
	
//	footer 화면 매핑 주소
	@RequestMapping(value="/footer", method=RequestMethod.GET)
	public String footer() {
		return "/footer";
	}
}
