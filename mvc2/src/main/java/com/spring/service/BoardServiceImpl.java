package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BoardDao;
import com.spring.dto.BoardDto;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	//�Խñ� ����
	@Override
	public int getDelete(String bid) {
		return boardDao.delete(bid);
	}
	
	//�Խñ� ������Ʈ 
	@Override
	public int getUpdate(BoardDto dto) {
		return boardDao.update(dto);
	}
	
//	�Խñ� ��
	@Override
	public BoardDto getContent(String bid) {
		return boardDao.select(bid);
	}
	
//	�Խñ� ��ȸ�� ������Ʈ
	@Override
	public void getUpdateHit(String bid) {
		boardDao.updateHit(bid); 
	}
	
//	�Խñ� ���
	@Override
	public int getWrite(BoardDto dto) {
		return boardDao.insert(dto);
	}
	
	
//	��ü ����Ʈ
	@Override
	public List<BoardDto> getList(){
		return boardDao.select();
	}
}
