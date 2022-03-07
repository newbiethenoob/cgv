package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.MemberDto;

@Repository
public class MemberDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.member";
	
	/*
	 * R(select) : 회원리스트 select
	 */
	public ArrayList<MemberDto> select(){
		System.out.println("회원 리스트 ---> select"+"    "+sqlSession);
		List<MemberDto> list = new ArrayList<MemberDto>();
		list = sqlSession.selectList(namespace+".listAll");
		return (ArrayList<MemberDto>)list;
	}
	
	/*
	 * R(select) : 로그인 select
	 */
	public int select(MemberDto dto) {
		return sqlSession.selectOne(namespace+".login", dto); //dot : parameter
	}
	
	/*
	 * c(Insert) : 회원데이터 insert
	 */
	public int insert(MemberDto dto) {
		return sqlSession.insert(namespace+".join", dto);
	}

//	/*
//	 * R(select) : 로그인 select
//	 */
//	public int select(MemberDto dto){
//		int result = 0;
//		String sql = "SELECT COUTN(id) FROM MEMBER WHERE ID=? AND PASS=?";
//		try {
//			pstmt = getPreparedStatement(sql);
//			
//			pstmt.setString(1, dto.getId());
//			pstmt.setString(2, dto.getPass());
//			
//			rs = pstmt.executeQuery(); //select ---> excuteQuery || insert, update, delete --> executeUpdate
//			
//			while(rs.next()) {
//				result = rs.getInt(1); //index로 사용
//			}
//			
//			close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}



	

	
	/*	
	ArrayList<MemberDto> list = new ArrayList<MemberDto>();
	String sql = " select rownum rno,id, name, email, hp_num, hobby "
			+ " from (select id, name, email, hp_num, hobby "
			+ "        from member  order by id) ";
	
	try {
		pstmt = getPreparedStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			MemberDto dto = new MemberDto();
			dto.setRno(rs.getInt(1));
			dto.setId(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setEmail(rs.getString(4));
			dto.setHp_num(rs.getString(5));
			dto.setHobby(rs.getString(6));
			
			list.add(dto);
		}
		
		close();
	} catch (Exception e) {
		e.printStackTrace();
	}		
	
	return list;
	*/
}
