package com.spring.service;

import java.util.List;

import com.spring.dto.MemberDto;

public interface MemberService {

	List<MemberDto> getList(); //��ü ����Ʈ ȣ��
	int getLogin(MemberDto dto);
	int getJoin(MemberDto dto);
}
