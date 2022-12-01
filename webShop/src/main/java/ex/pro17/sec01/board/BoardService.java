package ex.pro17.sec01.board;

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
}
