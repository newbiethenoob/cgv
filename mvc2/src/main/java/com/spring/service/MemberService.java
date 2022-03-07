package com.spring.service;

import java.util.List;

import com.spring.dto.MemberDto;

public interface MemberService {

	List<MemberDto> getList(); //전체 리스트 호출
	int getLogin(MemberDto dto);
	int getJoin(MemberDto dto);
}
