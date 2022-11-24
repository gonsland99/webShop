package ex.pro05.sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	@Override
	public void init() throws ServletException{
		System.out.println("init 실행2");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		System.out.println("doGet 호출2");
	}
	@Override
	public void destroy() {
		System.out.println("destory 호출2");
	}
}
