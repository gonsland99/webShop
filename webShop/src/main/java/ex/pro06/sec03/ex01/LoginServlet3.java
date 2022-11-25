package ex.pro06.sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex/pro06/login3")
public class LoginServlet3 extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String addr = req.getParameter("address");
		
		String data = "<html>";
			data += "<body>";
			data += "아이디: "+id;
			data += "<br/>";
			data += "비번: "+pw;
			data += "<br/>";
			data += "주소: "+addr;
			data += "<br/>";
			data += "</body>";
			data += "</html>";
		out.print(data);
	}
}
