package ex.pro09.sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession s = req.getSession();
		out.print("세션id: "+s.getId()+"<br>");
		out.print("최근세션 생성시각: "+new Date(s.getCreationTime())+"<br>");
		out.print("최근세션 접근시각: "+new Date(s.getLastAccessedTime())+"<br>");
		out.print("세션 유효시간: "+s.getMaxInactiveInterval()+"<br>");
		if(s.isNew()) {
			out.print("새 세션 입니다");
		}
//		s.invalidate();
		
	}
}
