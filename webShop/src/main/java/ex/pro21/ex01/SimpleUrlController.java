package ex.pro21.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		return new ModelAndView("/ex/pro21/index.jsp");
	}
}
