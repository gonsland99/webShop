package ex.pro24.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ex.pro24.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO membeVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
}
