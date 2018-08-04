package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import commons.Constant.Member;
import service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping("memberList.do")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberList", service.getMemberList());
		mav.setViewName("memberList");
		return mav;
	}

	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping("joinForm.do")
	public void joinForm(HttpSession session, Model model) {
		model.addAttribute("msg", "회원가입이 완료되었습니다.");
		model.addAttribute("url", "joinOk.jsp");

	}

	@RequestMapping("join.do")
	public String join(@RequestParam HashMap<String, Object> params) {
		service.joinMember(params);
		
		return "redirect:loginForm.do";
	}

	@RequestMapping("login.do")
	public String login(HttpSession session, String id, String pwd) {
		if (service.login(id, pwd)) {
			session.setAttribute("userid", id);
			return "redirect:main.do";
		} else
			return "redirect:loginForm.do";
	}
		
	@RequestMapping("main.do")
	public String main(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		if (userid == null)
			return "redirect:loginForm.do";
		else {
		model.addAllAttributes(service.getMemberInfo(userid));
			return "main";
		}
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userid");
		return "redirect:loginForm.do";
	}

	@RequestMapping("memberUpdateForm.do")
	public String memberUpdateForm(HttpSession session, Model model) {
		String id = (String) session.getAttribute("userid");
		if (id == null)
			return "redirect:loginForm.do";
		else {
			model.addAllAttributes(service.getMemberInfo(id));
			return "memberUpdateForm";
		}
	}

	@RequestMapping("memberUpdate.do")
	public String memberUpdate(@RequestParam HashMap<String, Object> params) {
		service.memberUpdate(params);
		return "redirect:main.do";
	}
}
