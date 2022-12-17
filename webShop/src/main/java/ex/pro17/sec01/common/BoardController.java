package ex.pro17.sec01.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.apache.commons.io.FileUtils;
 
@WebServlet("/download")
public class BoardController extends HttpServlet {
    private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String imageFileName = request.getParameter("imageFileName");
		String articleNO = request.getParameter("articleNO");
		OutputStream ops = response.getOutputStream();
		String path = ARTICLE_IMAGE_REPO+"\\"+articleNO+"\\"+imageFileName;
		File imageFile = new File(path);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+imageFileName);
		FileInputStream in = new FileInputStream(imageFile);
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1)
				break;
			ops.write(buffer, 0, count);
		}
		in.close();
		ops.close();
	}
}
