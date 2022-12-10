package ex.pro25;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AccountController extends MultiActionController{
	
	private AccountService accService;
	public void setAccService(AccountService accService) {
		this.accService = accService;
	}
	
	public ModelAndView sendMoney(HttpServletRequest req, HttpServletResponse resp)
	throws Exception{
		ModelAndView mv = new ModelAndView();
		accService.sendMoney();
		mv.setViewName("result");
		return mv;
	}

}
