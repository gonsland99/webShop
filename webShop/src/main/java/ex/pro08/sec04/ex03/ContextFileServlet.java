package ex.pro08.sec04.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu=null;
		String member=null;
		String order=null;
		String goods=null;
		while((menu=buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			member = tokens.nextToken();
			order = tokens.nextToken();
			goods = tokens.nextToken();
		}
		out.print("<html><body>");
		out.print(member+"<br/>");
		out.print(order+"<br/>");
		out.print(goods+"<br/>");
		out.print("</body></html>");
		out.close();
	}
}
