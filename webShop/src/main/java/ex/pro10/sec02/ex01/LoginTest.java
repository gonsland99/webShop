package ex.pro10.sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex/pro10/login")
public class LoginTest extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
//		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		out.print("id: "+id+"<br>");
		out.print("pw: "+pw+"<br>");
	}
}
