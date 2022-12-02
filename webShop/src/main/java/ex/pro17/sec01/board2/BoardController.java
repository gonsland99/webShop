package ex.pro17.sec01.board2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet("/board/*")
public class BoardController extends HttpServlet {
    private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	BoardService boardService;
    ArticleVO articleVO;
	
    public void init() throws ServletException{
    	boardService = new BoardService();
    	articleVO = new ArticleVO();
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
			}else if(action.equals("/articleForm")) {
				nextPage = "/ex/pro17/board/articleForm.jsp";
			}else if(action.equals("/add")) {
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				articleVO.setParentNO(0);
				articleVO.setId("hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.addArticle(articleVO);
				nextPage = "/board/list";
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		Map<String, String> articleMap = new HashMap<>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		//파일 저장소 경로 및 크기 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		//해당 매개변수를 다른객체형태로 받음
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for(int i=0; i<items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+" = "+fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				}else {
					System.out.println("파라미터명: "+fileItem.getFieldName());
					System.out.println("파일이름: "+fileItem.getName());
					System.out.println("파일크기: "+fileItem.getSize()+" bytes");
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleMap;
	}

}
