package com.spring.service;

import java.util.List;

import com.spring.dto.BoardDto;

public interface BoardService {
	int getDelete(String bid);
	int getUpdate(BoardDto dto);
	BoardDto getContent(String bid);
	void getUpdateHit(String bid);
	int getWrite(BoardDto dto);
	int getTotalCount();
	List<BoardDto> getList(int startCount, int endCount);
}
