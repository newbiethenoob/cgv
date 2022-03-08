package com.spring.mvc2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.BoardDao;
import com.spring.dto.BoardDto;
import com.spring.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	/**
	 * ���� : �Խ��� �󼼺��� content
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
	 * ���� : ���� �ٿ�ε�
	 * @return
	 */	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	@ResponseBody
	public byte[] downlod(HttpServletResponse response,
			      @RequestParam String filename) throws IOException{
		
		String FILE_PATH = "C:\\dev\\sts-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\mvc2\\\\resources\\upload\\";
				
		File file = new File(FILE_PATH, filename);
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		String fn = new String(file.getName().getBytes(), "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);
		
		return bytes;
	}
	
	/**
	 * ���� : �Խ��� ���� ȭ�� delete
	 * @return 
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
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
	 * ���� : �Խ��� ���� ó�� ������ delete
	 * @return 
	 */
//	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
//	public ModelAndView board_delete_proc(String bid) {
//		ModelAndView mv = new ModelAndView();
//		BoardDao dao = new BoardDao();
//		int result = dao.delete(bid);
//		
//		if(result == 1) {
//			mv.setViewName("redirect:/board_delete");
//		}
//		
//		return mv;
//	}
//	
	/**
	 * ���� : �Խ��� ����Ʈ ������ list
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
	 * ���� : �Խ��� ���� ó�� update
	 * @return 
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.POST)
	public ModelAndView board_update(BoardDto dto) {
		ModelAndView mv = new ModelAndView();
		BoardDao dao = new BoardDao();
//		BoardDto dto = dao.select(bid);
		int result = dao.update(dto);
		if(result == 1) {
			mv.setViewName("/board/board_update");
			mv.addObject("board", dto);
		}	
		
		return mv;
	}

	/**
	 * ���� : �Խ��� �۾��� ȭ��
	 * @return
	 */
	@RequestMapping(value="/board_write",method=RequestMethod.GET)
	public String board_write() {
		return "/board/baord_write";
	}
	
	/**
	 * ���� : �Խ��� �۾��� ���
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
		public String board_write(BoardDto dto, HttpServletRequest request) throws Exception {
			int result = 0;
			
			if(!dto.getFile1().getOriginalFilename().equals(null)/* != null*/){ 
				//���� ���� - ���� ������ ������ġ ��������
				String root_path = request.getSession().getServletContext().getRealPath("/");
				String attach_path = "\\resources\\upload\\";
					
				//bsfile �ߺ����� ó��
				UUID uuid = UUID.randomUUID();
				String bfile = dto.getFile1().getOriginalFilename();
				String bsfile = uuid +"_"+dto.getFile1().getOriginalFilename();
				
				System.out.println(bfile);
				System.out.println(bsfile);
				
				//DB����
				dto.setBfile(bfile);
				dto.setBsfile(bsfile);
				result = boardService.getWrite(dto);
				
				//DB���� �Ϸ� �� ������ �����ϱ�
				System.out.println(root_path + attach_path + uuid +"_"+dto.getFile1().getOriginalFilename());
				File file 
				= new File(root_path + attach_path + uuid +"_"+dto.getFile1().getOriginalFilename());
				dto.getFile1().transferTo(file);
				
			}else{
				//���� ����
				System.out.println("���� ���� ����~");
			}
					
			
			String result_page = "";
			if(result == 1) {
				result_page = "redirect:/board_list";
			}
			
			return result_page;
		}
	

	

	

	
	




}
