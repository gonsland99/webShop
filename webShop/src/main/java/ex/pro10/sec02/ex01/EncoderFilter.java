package ex.pro10.sec02.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class EncoderFilter implements Filter{
	ServletContext context;
	public void init(FilterConfig fconfig)throws ServletException{
		System.out.println("utf-8 인코딩 filter");
		context = fconfig.getServletContext();
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
	throws ServletException, IOException{
		//System.out.println("doFilter 호출");
		req.setCharacterEncoding("utf-8");
		/*
		String context = ((HttpServletRequest)req).getContextPath();
		String pathinfo = ((HttpServletRequest)req).getRequestURI();
		String realpath = req.getRealPath(pathinfo);
		String msg = " context: "+context+"\n URI: "+pathinfo+"\n 물리적경로: "+realpath;
		System.out.println(msg);
		*/
		chain.doFilter(req, resp);
		
		
	}
	public void destroy() {
		System.out.println("destory 호출");
	}
}
