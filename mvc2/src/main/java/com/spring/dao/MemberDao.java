package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.member";
	
	/**
	 * R(Select) : 회원리스트 select 
	 */
	public ArrayList<MemberDto> select(){
		List<MemberDto> list = new ArrayList<MemberDto>();
		list = sqlSession.selectList(namespace +".listAll");
		return (ArrayList<MemberDto>)list;	
	}
		
	
	/**
	 * R(Select) : 로그인 처리 select 
	 */
	public int select(MemberDto dto) {
		return sqlSession.selectOne(namespace+".login", dto);		
	}
	
	
	/**
	 * C(Insert) : 회원데이터 insert
	 */
	public int insert(MemberDto dto) {
		return sqlSession.insert(namespace+".join", dto);		
	}
	
}
