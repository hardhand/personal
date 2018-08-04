package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import model.Board;
import service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bService;

	@RequestMapping("boardList.do")
	public ModelAndView boardList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String keyword, @RequestParam(defaultValue = "0") int type,
			@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate) {

		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("type", type);
		params.put("keyword", keyword);

		if (startDate != null && endDate != null) {
			params.put("startdate", startDate);
			params.put("enddate", endDate);
		}

		if (type == 1) {
			params.put("title", keyword);
		} else if (type == 2) {
			params.put("content", keyword);
		} else if (type == 3) {
			params.put("title", keyword);
			params.put("content", keyword);
		} else if (type == 4) {
			params.put("name", keyword);
		}

		HashMap<String, Object> result = bService.getBoardListPage(params, page);

		mav.addAllObjects(result);
		mav.addAllObjects(params);
		mav.setViewName("boardList");
		return mav;
	}

	@RequestMapping("view.do")
	public String view(Model model, int num) {
		model.addAttribute("board", bService.readBoard(num));
		return "view";
	}

	@RequestMapping("modifyForm.do")
	public void modifyForm(Model model, int num) {
		model.addAttribute("board", bService.getBoard(num));

	}

	@RequestMapping("modify.do")
	public String modify(Board board) {
		bService.modifyBoard(board);
		return "redirect:view.do?num=" + board.getNum();

	}
	
	@RequestMapping("delete.do")
	public String delete(int num, String pass) {
		bService.deleteBoard(num, pass);
		return "redirect:boardList.do";
	}
	
	@RequestMapping("write.do")
	public String write(Board board, @RequestParam("ufile") MultipartFile ufile)
	{
		bService.writeBoard(board, ufile);
		if(board.getTitle() == null || board.getPass() == null || board.getName() == null || board.getEmail() == null) {
			return "writeForm";
		}
		return "redirect:view.do?num=" + board.getNum();
	}
	
	@RequestMapping("writeForm.do")
	public String writeForm(HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
		model.addAttribute("id", userid);
		return "writeForm";
		
	}
	
	@RequestMapping("download.do")
	public View download(int num) {
		
		View view = new DownloadView(bService.getAttachFile(num));
		return view;
	}
	
	@RequestMapping("daumMap.do")
	public View daumMap() {
		return null;
		
	}


}
/*
 * //게시글 리스트 조회
 * 
 * @RequestMapping("boardList") public ModelAndView boardList(
 * 
 * @RequestParam (defaultValue="1") int page,
 * 
 * @RequestParam (required=false) String keyword,
 * 
 * @RequestParam (defaultValue="0") int type,
 * 
 * @RequestParam (required=false) Date startDate,
 * 
 * @RequestParam (required=false) Date endDate) {
 * 
 * ModelAndView mav = new ModelAndView(); HashMap<String, Object> params = new
 * HashMap<String, Object>();
 * 
 * 
 * if(type == 0) { HashMap<String, Object> result =
 * bService.getBoardListPage(params, page); mav.addAllObjects(result); }
 * 
 * // mav.addAllObjects(result); // mav.addAllObjects(params);
 * mav.setViewName("boardList");
 * 
 * return mav;
 * 
 * }
 */
