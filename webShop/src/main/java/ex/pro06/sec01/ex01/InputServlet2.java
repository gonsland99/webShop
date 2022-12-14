package ex.pro06.sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex/pro06/input2")
public class InputServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setCharacterEncoding("utf-8"); 
		Enumeration enu = req.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String[] values = req.getParameterValues(name);
			for(String v:values) {
				System.out.println("name: "+name+", value: "+v);
			}
		}
		
	}
}
