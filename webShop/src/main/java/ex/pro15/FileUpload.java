package ex.pro15;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		File currentDirPath = new File("C:\\file_repo");	//업로드 경로
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);	//경로
		factory.setSizeThreshold(1024 * 1024);	//업로드가능한 파일크기

		ServletFileUpload upload = new ServletFileUpload(factory);	
		try {
			List items = upload.parseRequest(request);	//requset 매개변수 List로 가져오기
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {	//파일형태가 아닐때(폼필드일때)
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
				} else { //파일형태이면 업로드진행
					System.out.println("파라미터명:" + fileItem.getFieldName());
					System.out.println("파일명:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + " bytes");
					System.out.println("--------------------");
					//업로드한 파일이름 가져오기
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						//C:\file_repo\test01.jpg인 경우 슬러쉬포함 test01.jpg의 index번호를 가져옴
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);	//슬러쉬 빼고 파일이름만 가져옴
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						System.out.println(uploadFile);
						fileItem.write(uploadFile);	//저장소에 파일 업로드
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}