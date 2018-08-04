package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

@WebServlet("*.do")
public class MemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//		System.out.println(req.getAsyncContext());
//		System.out.println(req.getRequestURI());
		String contextPath = req.getContextPath() + "/";
		if(req.getRequestURI().equals(contextPath+"joinForm.do")) {
			//join.do俊 措茄 夸没贸府
			req.getRequestDispatcher("joinForm.jsp").forward(req, resp);
		}
		
		if(req.getRequestURI().equals(contextPath + "idCheck.do")) {
			//idCheck.do 夸没贸府
			String id = req.getParameter("id");
			Member member = MemberDao.getInstance().selectOne(id);
			boolean result = member == null ? true : false;
			
			String resultStr = "{\"result\" : " + result + "}";
			resp.getWriter().println(resultStr);
		}
		
		if(req.getRequestURI().equals(contextPath + "nameCheck.do")) {
			//nameCheck.do 夸没贸府
			String name = req.getParameter("name");
			Member member = MemberDao.getInstance().selectOneName(name);
			boolean result = member == null ? true : false;
			
			String resultStr = "{\"result\" : " + result + "}";
			resp.getWriter().println(resultStr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		String contextPath = req.getContextPath() + "/";
		if(req.getRequestURI().equals(contextPath+"join.do")) {
			//join.do俊 措茄 夸没贸府
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			
			Member member = new Member();
			member.setId(id);
			member.setPwd(pwd);
			member.setName(name);
			MemberDao.getInstance().insertMember(member);
			resp.sendRedirect("join.do");
		}
	}
	
	

}
