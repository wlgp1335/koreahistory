package kr.ac.kopo.korea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.korea.model.Grade;
import kr.ac.kopo.korea.model.History;
import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.model.Notice;
import kr.ac.kopo.korea.model.Often;
import kr.ac.kopo.korea.model.QA;
import kr.ac.kopo.korea.pager.Pager;
import kr.ac.kopo.korea.service.GradeService;
import kr.ac.kopo.korea.service.HistoryService;
import kr.ac.kopo.korea.service.MemberService;
import kr.ac.kopo.korea.service.NoticeService;
import kr.ac.kopo.korea.service.OftenqaService;
import kr.ac.kopo.korea.service.QAService;

@Controller
@RequestMapping("/member")
public class MemberController {
	final String path = "member/";

	@Autowired
	MemberService service;

	@Autowired
	GradeService gradeService;
	
	@Autowired
	HistoryService historyService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	OftenqaService oftenqaService;
	
	@Autowired
	QAService qaService;

	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Member> list = service.list(pager);
		model.addAttribute("list", list);

		List<Grade> grades = gradeService.list();
		model.addAttribute("grades", grades);

		return path + "list";
	}

	// 등급변화에 따른 리스트
	@RequestMapping("/changeGrade")
	public String changeGrade(Member item) {
		System.out.println(item.getId());
		System.out.println(item.getGradeId());

		service.changeGrade(item);

		return "redirect:list";
	}

	@RequestMapping("/mypage")
	public String mypage(){
		return path + "mypage";
	}

	@RequestMapping("/post")
	public String post(Model model, Pager pager) {
		pager.setPerPage(5);

		List<History> history = historyService.list(pager);
		model.addAttribute("history", history);
		
		List<Notice> notice = noticeService.list(pager);
		model.addAttribute("notice", notice);
		
		List<Often> often = oftenqaService.list(pager);
		model.addAttribute("often", often);
		
		List<QA> qa = qaService.list(pager);
		model.addAttribute("qa", qa);
		
		return path + "post";
	}
	
	@GetMapping("/profile")
	public String profile(Model model, @SessionAttribute Member member) {
		Member item = service.item(member.getId());

		model.addAttribute("item", item);
		System.out.println("item정보: "+item);
			
		return path + "profile";
	}
	@PostMapping("/profile")
	public String profile(Member item, @SessionAttribute Member member) {
		item.setId(member.getId());
		
		service.profile(item);
		
		return path + "mypage";
	}
	
	//회원탈퇴=>데이터베이스에 모든 외래키를 CASCADE를 설정해서 전체 삭제
	@RequestMapping("/delete")
	public String delete(@SessionAttribute Member member) {
		service.delete(member.getId());
		
		member.setId(member.getId());
		
		return "/";
	}

}
