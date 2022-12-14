package ex.pro26.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")
@RequestMapping("/test")
public class MainController {
	@RequestMapping(value="/main1.do", method=RequestMethod.GET)
	public ModelAndView main1(HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "main1");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping(value="/main2.do", method=RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest req, HttpServletResponse resp)
			throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "main2");
		mv.setViewName("main");
		return mv;
	}
}
