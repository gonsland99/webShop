package ex.pro23.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem2.do")
public class MemberServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		doHandle(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doHandle(req, resp);
	}
	private void doHandle(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		String name = dao.selectName();
		int pw  = dao.selectPw();
		PrintWriter out = resp.getWriter();
		out.write("<script>");
		out.write("alert('이름: "+name+"');");
		out.write("alert('이름: "+pw+"');");
		out.write("</script>");
		
	}

}
