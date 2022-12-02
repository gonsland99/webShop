package ex.pro17.sec01.board3;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public List<ArticleVO> listArticle(){
		List<ArticleVO> articleList = boardDAO.selectAllArticle();
		return articleList;
	}
	public int addArticle(ArticleVO article) {
		return boardDAO.insertArticle(article);
	}
}
