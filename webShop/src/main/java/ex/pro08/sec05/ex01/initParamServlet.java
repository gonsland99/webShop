package ex.pro08.sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/sInit", "/sInit2" }, 
		initParams = { @WebInitParam(name = "email", value = "son@gmail.com"), 
					@WebInitParam(name = "tel", value = "010-1111-1111") })
public class initParamServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		out.print("<html><body>");
		out.print("<table>");
		out.print("<tr><td>email: </td><td>"+email+"</td></tr>");
		out.print("<tr><td>tel: </td><td>"+tel+"</td></tr>");
		out.print("</table></body></html>");
	}

}
