package ex.pro07.sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDrvier";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:ex";
	private static final String user = "gon";
	private static final String pwd = "1234";
	PreparedStatement pstmt;
	Connection con;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<>();
		try {
			connDB();
			String query = "select * from t_member";
			ResultSet rs = pstmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
