package ex.pro21.ex04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{
	public ModelAndView memberInfo(HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		req.setCharacterEncoding("utf-8");
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		mv.addObject("id",id);
		mv.addObject("pw",pw);
		mv.addObject("name",name);
		mv.addObject("email",email);
		mv.setViewName("memberInfo");
		
		return mv;
	}

}
