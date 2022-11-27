package ex.pro10.sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/get")
public class GetAttribute extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		ServletContext c = getServletContext();
		HttpSession s = req.getSession();
		
		String context = (String)c.getAttribute("context");
		String session = (String)s.getAttribute("session");
		String request = (String)req.getAttribute("request");
		
		out.print("context: "+context+"<br>");
		out.print("session: "+session+"<br>");
		out.print("request: "+request+"<br>");
	}
}
