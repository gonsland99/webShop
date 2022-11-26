package ex.pro08.sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/set")
public class SetServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		ServletContext context = getServletContext();
		List member = new ArrayList();
		member.add("손흥민");
		member.add(30);
		context.setAttribute("member", member);
		out.print("<html><body>");
		out.print("ServletContext 정보저장");
		out.print("</body></html>");
	}
}
