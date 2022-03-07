package com.spring.mvc2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.BoardDao;
import com.spring.dto.BoardDto;
import com.spring.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	/**
	 * 제목 : 게시판 상세보기 content
	 * @return
	 */
	@RequestMapping(value="/board_content", method=RequestMethod.GET)
	public ModelAndView board_content(String bid) {
		ModelAndView mv = new ModelAndView();
//		BoardDao dao = new BoardDao();
//		dao.deleteHit(bid);
//		BoardDto dto = dao.select(bid);
		
		boardService.getUpdateHit(bid);
		BoardDto dto = boardService.getContent(bid);
		
		mv.setViewName("/board/board_content");
		mv.addObject("board",dto);
		
		return mv;
	}
	
	/**
	 * 제목 : 게시판 수정 화면 delete
	 * @return 
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public ModelAndView board_delete(String bid) {
		ModelAndView mv = new ModelAndView();
//		BoardDao dao = new BoardDao();
		BoardDto dto = boardService.getContent(bid);
		System.out.println("mybatis getContent ---->> ");
		
		mv.setViewName("/board/board_delete");
		mv.addObject("board", dto);
		
		return mv;
	}
	
	/**
	 * 제목 : 회원 리스트 페이지 list
	 * @return
	 */
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public ModelAndView board_list() {
		ModelAndView mv = new ModelAndView();
		//BoardDao dao = new BoardDao();
		//ArrayList<BoardDto> list = dao.select();
		
		ArrayList<BoardDto> list = 
				(ArrayList<BoardDto>)boardService.getList();
		
		mv.setViewName("/board/board_list");
		mv.addObject("list", list);
				
		return mv;
	}
	
	/**
	 * 제목 : 게시판 수정 처리 update
	 * @return 
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.GET)
	public ModelAndView board_update(BoardDto dto) {
		ModelAndView mv = new ModelAndView();
		BoardDao dao = new BoardDao();
		int result = dao.update(dto);
		if(result == 1) {
			mv.setViewName("/board/board_update");
			mv.addObject("board", dto);
		}	
		
		return mv;
	}

	/**
	 * 제목 : 회원 리스트 페이지
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String board_write(BoardDto dto) {
		String result_page = "";
		
		int result = boardService.getWrite(dto);
		
		if(result == 1) {
			result_page = "redirect:/board_list";
		}
	
		return result_page;
	}
	

	

	

	
	




}
