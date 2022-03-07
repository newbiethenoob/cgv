package com.spring.service;

import java.util.List;

import com.spring.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> getList();
	int getWrite(BoardDto dto);
	void getUpdateHit(String bid);
	BoardDto getContent(String bid);
	int getUpdate(BoardDto dto);
	int getDelete(String bid);
}
