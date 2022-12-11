package ex.pro26.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	@RequestMapping(value= {"/test/loginForm.do", "/test/loginForm2.do"},
			method= {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginForm");
		return mv;
	}
	@RequestMapping(value="/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(@RequestParam("id") String id,
			@RequestParam("name") String name,
			HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
//		req.setCharacterEncoding("utf-8");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		/*
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		*/
		mv.addObject("id", id);
		mv.addObject("name", name);
		return mv;
	}
	@RequestMapping(value="/test/login2.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login2(@ModelAttribute("info") LoginVO vo,
			HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
	@RequestMapping(value="/test/login3.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login3(Model model,
			HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		model.addAttribute("id", "hong");
		model.addAttribute("name", "홍길동");
		return "result";
	}

}
