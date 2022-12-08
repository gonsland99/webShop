package ex.pro23.ex02;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper = null;
	private static SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			try {
				String resource = "ex/pro23/mappers/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public String selectName() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		String name = (String) session.selectOne("mapper.member.selectName");
		return name;
	}
	public int selectPw() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int pw = (int) session.selectOne("mapper.member.selectPw");
		return pw;
	}
}
