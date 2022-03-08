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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.BoardDto;
import com.spring.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	/**
	 * ���� : �Խ��� ����Ʈ
	 * @return
	 */
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public ModelAndView board_list() {
		ModelAndView mv = new ModelAndView();
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)boardService.getList();
		
		mv.setViewName("/board/board_list");
		mv.addObject("list", list);
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� �۾��� ȭ��
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String board_write() {
		return "/board/board_write";
	}
	
	
	/**
	 * ���� : ���� �ٿ�ε�
	 * @return
	 */	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	@ResponseBody
	public byte[] downlod(HttpServletResponse response, HttpServletRequest request,
			      @RequestParam String filename) throws IOException{
		
		//String FILE_PATH = "C:\\dev\\spring_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\model2\\\\resources\\upload\\";
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";	
		
		
		File file = new File(root_path+attach_path, filename);
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		String fn = new String(file.getName().getBytes(), "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);
		
		return bytes;
	}
	
	
	
	
	/**
	 * ���� : �Խ��� �۾��� ���
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String board_write(BoardDto dto, HttpServletRequest request) throws Exception {
		int result = 0;
	
		//1. ���ϸ���Ʈ �迭 ---> for�� �ݺ�
		for(int i=0; i<dto.getFileList().length;i++) {
			
			//1-1. �ݺ� �������� ���� ���� üũ �� ���ϸ�, �ߺ����� ���ϸ� ����
			if(!dto.getFileList()[i].getOriginalFilename().equals("")){
				//���� ���� ���ϸ� �ߺ����� ó��
				UUID uuid = UUID.randomUUID();
				String file = dto.getFileList()[i].getOriginalFilename();
				String sfile = uuid +"_"+dto.getFileList()[i].getOriginalFilename();
				
				//1-2. �ε��� üũ �� ������ ������ ����
				if(i==0) {
					dto.setBfile(file);
					dto.setBsfile(sfile);
				}else {
					dto.setBfile2(file);
					dto.setBsfile2(sfile);
				}
			}else {
				if(i==0) {
					dto.setBfile("");
					dto.setBsfile("");
				}else {
					dto.setBfile2("");
					dto.setBsfile2("");
				}
			}
			
		}
		
		//2. DB ����
		result = boardService.getWrite(dto);
		
		//3. DB ���� ���� --> ������ upload ������ ����
		if(result==1) {
			//���� ���� - ���� ������ ������ġ ��������
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\upload\\";
			
			
			//DB���� �Ϸ� �� ������ �����ϱ�
			System.out.println(root_path + attach_path + dto.getBsfile());
			System.out.println(root_path + attach_path + dto.getBsfile2());
			
			if(!dto.getBsfile().equals("")){
				File save_file1 = new File(root_path + attach_path + dto.getBsfile());
				dto.getFile1().transferTo(save_file1);
			}
			
			if(!dto.getBsfile2().equals("")){
				File save_file2 = new File(root_path + attach_path + dto.getBsfile2());
				dto.getFile2().transferTo(save_file2);
			}
		}
				
	/*	
	 * ���� ���� ���ε�
	 * 	
		if(!dto.getFile1().getOriginalFilename().equals("")){
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
			//DB���� - ���� ����
			dto.setBfile("");
			dto.setBsfile("");
			result = boardService.getWrite(dto);
		}
	*/			
		
		String result_page = "";
		if(result == 1) {
			result_page = "redirect:/board_list";
		}
		
		return result_page;
	}
	
	
	
	/**
	 * ���� : �Խ��� �󼼺���
	 * @return
	 */
	@RequestMapping(value="/board_content", method=RequestMethod.GET)
	public ModelAndView board_content(String bid) {
		ModelAndView mv = new ModelAndView();
		boardService.getUpdateHit(bid);
		BoardDto dto = boardService.getContent(bid);
		
		mv.setViewName("/board/board_content");
		mv.addObject("board", dto);
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ���� ȭ�� 
	 * @return
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.GET)
	public ModelAndView board_update(String bid) {
		ModelAndView mv = new ModelAndView();
		BoardDto dto = boardService.getContent(bid);
		
		mv.setViewName("/board/board_update");
		mv.addObject("board", dto);		
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ���� ó�� 
	 * @return
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.POST)
	public ModelAndView board_update(BoardDto dto) {
		ModelAndView mv = new ModelAndView();
		int result = boardService.getUpdate(dto);
		
		if(result ==1) {
			mv.setViewName("redirect:/board_list");
		}			
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ����ȭ�� 
	 * @return
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public ModelAndView board_delete(String bid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/board_delete");
		mv.addObject("bid",bid);
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ���� ó�� ������ 
	 * @return
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
	public ModelAndView board_delete_proc(String bid) {
		ModelAndView mv = new ModelAndView();
		int result = boardService.getDelete(bid);
		
		if(result == 1) {
			mv.setViewName("redirect:/board_list");
		}
		
		return mv;
	}	
	
}











