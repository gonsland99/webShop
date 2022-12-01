package ex.pro17.sec01.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
    BoardService boardService;
    ArticleVO articleVO;
	
    public void init() throws ServletException{
    	boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		
		try {
			List<ArticleVO> articleList = new ArrayList<>();
			if(action == null) {
				articleList = boardService.listArticle();
				request.setAttribute("articleList", articleList);
				nextPage = "/ex/pro17/board/list.jsp";
			}else if(action.equals("/list")) {
				articleList = boardService.listArticle();
				request.setAttribute("articleList", articleList);
				nextPage = "/ex/pro17/board/list.jsp";
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
