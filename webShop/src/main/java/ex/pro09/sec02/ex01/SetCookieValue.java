package ex.pro09.sec02.ex01;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/set")
public class SetCookieValue extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		Date d = new Date();
		Cookie c = new Cookie("ctest", URLEncoder.encode("쿠키 test", "utf-8"));
//		c.setMaxAge(24*60*60);
		c.setMaxAge(-1);
		resp.addCookie(c);
		System.out.println("현재시간: "+d);
	}
}
