package ex.pro10.sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/set")
public class SetAttribute extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		String ctxMsg = "context 바인딩";
		String sesMsg = "session 바인딩";
		String reqMsg = "request 바인딩";
		
		ServletContext c = getServletContext();
		HttpSession s = req.getSession();
		c.setAttribute("context", ctxMsg);
		s.setAttribute("session", sesMsg);
		req.setAttribute("request", reqMsg);
	}
}
