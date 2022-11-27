package ex.pro09.sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ex/pro09/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		System.out.println("아이디: "+user_id);
		System.out.println("비밀번호: "+user_pw);
		System.out.println("주소: "+user_address);
		System.out.println("이메일: "+user_email);
		System.out.println("핸드폰: "+user_hp);
	}
	public void destroy() {
		System.out.println("destroy !!");
	}

}
