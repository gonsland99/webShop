package ex.pro09.sec02.ex01;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/get")
public class GetCookieValue extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		Cookie[] c = req.getCookies();
		for(int i=0; i<c.length; i++) {
			if(c[i].getName().equals("ctest")) {
				System.out.println(URLDecoder.decode(c[i].getValue(),"utf-8"));
			}
		}
	}
}
