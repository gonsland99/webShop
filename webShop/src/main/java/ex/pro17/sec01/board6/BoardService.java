package ex.pro17.sec01.board6;

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
	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article = boardDAO.selectArticle(articleNO);
		return article;
	}
	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}
	public List<Integer> removeArticle(int articleNO){
		List<Integer> list = boardDAO.selectRemoveArticle(articleNO);
		boardDAO.deleteArticle(articleNO);
		return list;
	}
}
