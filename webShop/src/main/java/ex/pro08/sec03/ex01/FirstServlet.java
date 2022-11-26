package ex.pro08.sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		RequestDispatcher dispatch = req.getRequestDispatcher("second");
		dispatch.forward(req, resp);
	}
}
