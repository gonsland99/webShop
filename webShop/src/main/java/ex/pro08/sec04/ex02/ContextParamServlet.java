package ex.pro08.sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		ServletContext context = getServletContext();
		String member = context.getInitParameter("menu_member");
		String order = context.getInitParameter("menu_order");
		String goods = context.getInitParameter("menu_goods");
		
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>메뉴명</tr>");
		out.print("<tr><td>"+member+"</td></tr>");
		out.print("<tr><td>"+order+"</td></tr>");
		out.print("<tr><td>"+goods+"</td></tr>");
		out.print("</table></body></html>");
	}
}
