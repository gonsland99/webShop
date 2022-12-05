package ex.pro19.ex03;

public class MemberServiceImpl implements MemberService{
	private MemberDAO dao;
	
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void list(){
		dao.listMember();
	}
}
