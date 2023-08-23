package kr.ac.kopo.korea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.model.QA;
import kr.ac.kopo.korea.model.Reply;
import kr.ac.kopo.korea.pager.Pager;
import kr.ac.kopo.korea.service.QAService;
import kr.ac.kopo.korea.service.ReplyService;

@Controller
@RequestMapping("/qa")
public class QAController {
	final String path = "qa/";

	@Autowired
	QAService service;
	
	@Autowired
	ReplyService replyService;

	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<QA> list = service.list(pager);
		model.addAttribute("list", list);

		return path + "list";
	}

	@GetMapping("/add")
	public String add() {
		return path + "add";
	}

	@PostMapping("/add")
	public String add(QA item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());

		service.add(item);

		return "redirect:list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @SessionAttribute Member member) {
		QA item = service.item(id);

		if (member.getId().equals(item.getMemberId())) {
			model.addAttribute("item", item);

			return path + "update";
		} else
			return "redirect:../list";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, QA item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());

		item.setId(id);

		service.update(item);

		return "redirect:../list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @SessionAttribute Member member) {
		service.delete(id, member.getId());

		return "redirect:../list";
	}

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		QA item = service.item(id);

		model.addAttribute("item", item);

		/* 댓글 조회 : 이현주 */
		int qaId = id;
		List<Reply> reply = replyService.qaList(qaId);
		model.addAttribute("reply", reply);

		return path + "detail";
	}

	/* 댓글 추가 */
	@RequestMapping("/replyAdd")
	public String replyAdd(Reply reply, Model model, @SessionAttribute Member member) throws Exception {
		reply.setMemberId(member.getId());

		replyService.qaAdd(reply);

		return "redirect:detail/" + reply.getQaId();
	}

	/* 댓글 삭제 */
	@RequestMapping("/replyDelete/{id}")
	public String replyDelete(@PathVariable int id, @RequestParam(value = "id") int qaId) throws Exception {

		System.out.println(qaId);

		replyService.qaDelete(id);

		return "redirect:../detail/" + qaId;
	}

}
