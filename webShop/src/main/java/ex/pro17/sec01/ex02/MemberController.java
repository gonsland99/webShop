package ex.pro17.sec01.ex02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	MemberDAO memberDAO;
	 
    public MemberController() {
    	memberDAO = new MemberDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nextPage = null;
		String action = request.getPathInfo();
		
		if(action==null || action.equals("/list")) {
			List<MemberVO> memberList = memberDAO.listMember();
			request.setAttribute("memberList", memberList);
			nextPage = "/ex/pro17/ex02/listMember.jsp";
		}else if(action.equals("/add")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pw, name, email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/list";
		}else if(action.equals("/memberForm")) {
			nextPage = "/ex/pro17/ex02/memberForm.jsp";
		}else if(action.equals("/modMemberForm")) {
			String id = request.getParameter("id");
			MemberVO memInfo = memberDAO.findMember(id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/ex/pro17/ex02/modMemberForm.jsp";
		}else if(action.equals("/mod")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pw, name, email);
			memberDAO.modMember(memberVO);
			request.setAttribute("msg", "modified");
			nextPage = "/member/list";
		}else if(action.equals("/del")) {
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "deleted");
			nextPage = "/member/list";
		}else {
			List<MemberVO> memberList = memberDAO.listMember();
			request.setAttribute("memberList", memberList);
			nextPage = "/ex/pro17/ex02/listMember.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
