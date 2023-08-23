package kr.ac.kopo.korea.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.korea.model.History;
import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.model.Notice;
import kr.ac.kopo.korea.model.Often;
import kr.ac.kopo.korea.model.QA;
import kr.ac.kopo.korea.service.HistoryService;
import kr.ac.kopo.korea.service.MemberService;
import kr.ac.kopo.korea.service.NoticeService;
import kr.ac.kopo.korea.service.OftenqaService;
import kr.ac.kopo.korea.service.QAService;


@Controller
public class RootController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	HistoryService historyService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	OftenqaService oftenqaService;
	
	@Autowired
	QAService qaService;
	
	@RequestMapping("/")
	public String index() {
		return "main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login") 
	public String login(Member member, HttpSession session) {
		if(service.login(member)) {
			session.setAttribute("member", member);
			
			//등록, 변경, 삭제 창을 눌렀을때 로그인을 해서 해당창으로 다시 돌아오는 기능
			String targetUrl = (String) session.getAttribute("target_url");
			session.removeAttribute("targetUrl");
			
			if(targetUrl == null)
				return "redirect:.";
			else
				return "redirect:" + targetUrl;
		} else
			return "redirect:login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session에 저장된 정보 전부 삭제
		session.invalidate();
		
		return "redirect:.";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	@PostMapping("/signup")
	public String signup(Member item) {
		service.signup(item);
		
		return "redirect:.";
	}
	
	//이메일 중복확인
	@ResponseBody
	@GetMapping("/checkId/{id}")
	public String checkId(@RequestParam("id") String id) {
		if(service.checkId(id))
			return "OK"; //true경우
		else
			return "FAIL"; //false경우
	}
	
	//검색 기능
	@GetMapping("/search")
	public String search(@RequestParam(value = "keyword") String keyword, Model model) {
		List<History> historyList = historyService.search(keyword);
		model.addAttribute("historyList", historyList);
		
		List<Notice> noticeList = noticeService.search(keyword);
		model.addAttribute("noticeList", noticeList);
		
		List<Often> oftenList = oftenqaService.search(keyword);		
		model.addAttribute("oftenList", oftenList);
		
		List<QA> qaList = qaService.search(keyword);
		model.addAttribute("qaList", qaList);
		
		//화면의 mode에 search를 담아서 화면에 구성 : main.jsp
		model.addAttribute("mode", "search");
		
		return "main";
	}
}
