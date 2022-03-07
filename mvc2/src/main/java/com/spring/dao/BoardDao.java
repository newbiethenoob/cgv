package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardDto;
import com.spring.dto.BoardDto;

@Repository
public class BoardDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.board";
	
	/**
	 * R : 게시글 상세보기 select
	 */
	public BoardDto select(String bid) {
		return sqlSession.selectOne(namespace+".content", bid);
		/*BoardDto dto = new BoardDto();
		String sql = "select bid, btitle, bcontent, bhit, to_char(bdate, 'yyyy/mm/dd') bdate"
				+"from board where bid=?";
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setBid(rs.getString(1));
				dto.setBtitle(rs.getString(2));
				dto.setBcontent(rs.getString(3));
				dto.setBhit(rs.getString(4));
				dto.setBdate(rs.getString(5));
			}
			close();
		} catch (Exception e) {
			e.printStackTrace()	;
		}
		return dto;*/
	}
	
	/**
	 * R : 게시글 전체 select
	 */
	public ArrayList<BoardDto> select(){
		List<BoardDto> list = new ArrayList<BoardDto>();
		list = sqlSession.selectList(namespace+".listAll");
		
		return (ArrayList<BoardDto>)list;
	}

	/**
	 * C : 게시글 삭제 delete
	 */
	public int delete(String bid) {
		return sqlSession.delete(namespace+".delete",bid);
	}
	
	/**
	 * C : 게시글 update
	 */
	public int update(BoardDto dto) {
		return sqlSession.update(namespace+".update",dto);
		/*
		 * int result = 0; String sql =
		 * "update board set btitle=?, bcontent=? where bid=?";
		 * 
		 * try { pstmt = getPreparedStatement(sql); pstmt.setString(1, dto.getBtitle());
		 * pstmt.setString(2, dto.getBcontent()); pstmt.setString(3, dto.getBid());
		 * 
		 * result = pstmt.executeUpdate();
		 * 
		 * close(); } catch (Exception e) { e.printStackTrace(); } return result;
		 */

	}
	/**
	 * C : 게시글 조회수 update
	 */
	public void updateHit(String bid) {
		sqlSession.update(namespace+".updateHit", bid);
	}
	
	/**
	 * C:게시글 insert
	 */
	public int insert(BoardDto dto) {
		return sqlSession.insert(namespace+".write",dto);
		
		/*
		  int result = 0;
		  String sql = "INSERT INTO BOARD VALUES('b_'||SEQU_BOARD_BID.nextval,?,?,0,sysdate)";
		  
		  try{
		  	pstmt = getPreparedStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			
			result = pstmt.executeUpdate();
			
			close();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		 */
	}
	
}