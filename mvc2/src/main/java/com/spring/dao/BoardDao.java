package com.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDto;

@Repository
public class BoardDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.board";
	
	/** 
	 * R : �Խñ� �󼼺��� select
	 */
	public BoardDto select(String bid){
		return sqlSession.selectOne(namespace + ".content", bid);	
	}
	
	/** 
	 * R : �Խñ� ��ü count
	 */
	public int selectCount(){
		return sqlSession.selectOne(namespace + ".count");	
	}
	
	/** 
	 * R : �Խñ� ��ü select
	 */
	public List<BoardDto> select(int startCount, int endCount){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", startCount);
		map.put("end", endCount);
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		list = sqlSession.selectList(namespace + ".listAll", map);
		
		return list;		
	}
	
	
	/** 
	 * C : �Խñ� update
	 */
	public int update(BoardDto dto) {
		return sqlSession.update(namespace+".update",dto);		
	}
	
	
	/** 
	 * C : �Խñ� ��ȸ�� update
	 */
	public void updateHit(String bid) {
		sqlSession.update(namespace+".updateHit", bid);		
	}
	
	
	/** 
	 * C : �Խñ� delete
	 */
	public int delete(String bid) {
		return sqlSession.delete(namespace+".delete",bid);		
	}
	
	
	/** 
	 * C : �Խñ� insert
	 */
	public int insert(BoardDto dto) {
		return sqlSession.insert(namespace +".write", dto);		
	}
}








