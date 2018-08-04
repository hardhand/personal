package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

//	@RequestMapping("test.do")
//	public ModelAndView dummy() {
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", service.getData());
//		mav.setViewName("test");
//		return mav;
//	}
//
	@RequestMapping("memberList.do")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberList", service.getMemberList());
		mav.setViewName("memberList");
		return mav;
	}
	// Spring MVC 컨트롤러에서 사용할 수 있는 반환유형의 종류

		// 데이터와 페이지 정보가 둘 다 있는 경우
		// -ModelAndView
		// 데이터에 대한 정보만 있는 경우
		// Model or Map
		// 페이지에 대한 정보만 있는경우
		// String
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "loginForm";
	}
	
	// 둘 다 없을 때
		// void
	@RequestMapping("joinForm.do")
	public void joinForm() {
		
	}
	
	/*
	 * 매개변수 받아내기
	 * join.do는 회원정보 데이터들을 파라미터로 받아서 디비에 저장하고, loginForm.do로 리다이렉할 것
	 */
	
//	@RequestMapping("join.do")
//	public String join(String id) {
//		System.out.println(id);
//		return "redirect:loginForm.do";
//	}
	
//	@RequestMapping("join.do")
//	public String join(@RequestParam("id") String uid) {
//		System.out.println(uid);
//		return "redirect:loginForm.do";
//	}
	
	// 매개변수 받아내기

		// join.do는 회원정보 데이터들을 파라미터로 받아서
		// 디비에 저장하고, loginForm.do로 리다이렉 해줄꺼임
	@RequestMapping("join.do")
	public String join(@RequestParam Map<String, Object> params) {
		System.out.println(params);
		return "redirect:loginForm.do";
	}
	
	@RequestMapping("login.do")
	public String login(HttpSession session, String id, String pwd) {
		if(service.login(id, pwd))
		{
			session.setAttribute("userid", id);
			return "redirect:main.do";
		} else
			return "redirect:loginForm.do";
	}
	
	@RequestMapping("main.do")
	public String main(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		
		if(userid == null)
			return "redirect:loginForm.do";
		else {
//			model.addAllAttributes(arg0); <- map 통째로 싣기
//			model.addAttribute(arg0); <- 모델객체 통째
//			model.addAttribute(arg0, arg1); <- 키값 지정한 하나의 데이터
			model.addAllAttributes(service.getMemberinfo(userid));
			return "main";
		}
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userid");
		return "redirect:loginFrom.do";
	}
	
	@RequestMapping("memberUpdateFrom.do")
	public String memberUpdateFrom(Model model, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		
		if(userid == null)
			return "redirect:loginForm.do";
		model.addAllAttributes(service.getMemberinfo(userid));
		return "memberUpdateFrom";
	}
	@RequestMapping("memberUpdate.do")
	public String memberUpdate(@RequestParam HashMap<String, Object> params) {
		service.memberUpdate(params);		
		return "redirect:main.do";
	}

}
