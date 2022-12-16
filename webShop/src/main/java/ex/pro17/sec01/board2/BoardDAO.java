package ex.pro17.sec01.board2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	private Connection con;
	private PreparedStatement pstmt;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticle(){
		List<ArticleVO> articleList = new ArrayList<>();
		try {
			con = dataFactory.getConnection();
			String sql = "select LEVEL, articleNO, parentNO, title, content, id, writeDate"
					+" from t_board"
					+" start with parentNO=0"
					+" connect by prior articleNO=parentNO"
					+" order siblings by articleNO desc";
			
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articleList.add(article);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleList;
	}
	public int getNewArticleNO() {
		try {
			con = dataFactory.getConnection();
			String sql = "select max(articleNO) from t_board";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				return (rs.getInt(1)+1);
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void insertArticle(ArticleVO article) {
		try {
			con = dataFactory.getConnection();
			//외부에서 prepared되어지는 sql문 관련 메서드는 먼저 호출하여 값을 가져올것
			//add메서드 내 sql문이 먼저 prepared 되어지면 getNewArticleNO의 sql문 호출과 관련해 에러발생(SQLException)
			int articleNO = getNewArticleNO();
			
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			String imageFileName = article.getImageFileName();
			
			String sql = "insert into t_board (articleNO, parentNO, title, content, imageFileName, id)"
					+" values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
