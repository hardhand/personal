package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{


	@Override	// 요청처리 컨트롤러에 전달되기 전에 수행할 작업.
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String userid = (String) session.getAttribute("userid");
		if(userid == null)
		{
			response.sendRedirect("loginForm.do");
			return false;
		}
		
		return true;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
