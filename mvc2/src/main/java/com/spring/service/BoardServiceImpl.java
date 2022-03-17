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
	
	//게시글 삭제
	@Override
	public int getDelete(String bid) {
		return boardDao.delete(bid);
	}
	
	//게시글 업데이트 
	@Override
	public int getUpdate(BoardDto dto) {
		return boardDao.update(dto);
	}
	
//	게시글 상세
	@Override
	public BoardDto getContent(String bid) {
		return boardDao.select(bid);
	}
	
//	게시글 조회수 업데이트
	@Override
	public void getUpdateHit(String bid) {
		boardDao.updateHit(bid); 
	}
	
//	게시글 등록
	@Override
	public int getWrite(BoardDto dto) {
		return boardDao.insert(dto);
	}
	
	/** 게시글 전체 카운트 **/
	@Override
	public int getTotalCount() {
		return boardDao.selectCount();
	}
	
	/** 전체 리스트 */
	@Override
	public List<BoardDto> getList(int startCount, int endCount){
		return boardDao.select(startCount, endCount);
	}
}
