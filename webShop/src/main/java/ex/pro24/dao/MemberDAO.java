package ex.pro24.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ex.pro24.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
}
