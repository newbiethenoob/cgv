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
	 * R(Select) : ȸ������Ʈ select 
	 */
	public ArrayList<MemberDto> select(){
		List<MemberDto> list = new ArrayList<MemberDto>();
		list = sqlSession.selectList(namespace +".listAll");
		return (ArrayList<MemberDto>)list;	
	}
		
	
	/**
	 * R(Select) : �α��� ó�� select 
	 */
	public int select(MemberDto dto) {
		return sqlSession.selectOne(namespace+".login", dto);		
	}
	
	
	/**
	 * C(Insert) : ȸ�������� insert
	 */
	public int insert(MemberDto dto) {
		return sqlSession.insert(namespace+".join", dto);		
	}
	
}
