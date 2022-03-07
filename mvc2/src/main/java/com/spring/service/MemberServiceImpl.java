package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDao;
import com.spring.dto.MemberDto;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberDto> getList(){ //MemberService�� method �״�� ���
		return memberDao.select(); //memberDao�� �ִ� select() ȣ��
	}
	
	@Override
	public int getLogin(MemberDto dto) {
		return memberDao.select(dto);
	}
	
	@Override 
	public int getJoin(MemberDto dto) {
		return memberDao.insert(dto);
	}
}
