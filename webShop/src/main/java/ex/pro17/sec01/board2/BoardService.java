package ex.pro17.sec01.board2;

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
	public void addArticle(ArticleVO article) {
		boardDAO.insertArticle(article);
	}
}
