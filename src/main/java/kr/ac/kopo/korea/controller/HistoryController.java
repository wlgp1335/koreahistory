package kr.ac.kopo.korea.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.korea.model.Attach;
import kr.ac.kopo.korea.model.History;
import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.model.Reply;
import kr.ac.kopo.korea.pager.Pager;
import kr.ac.kopo.korea.service.HistoryService;
import kr.ac.kopo.korea.service.ReplyService;
import kr.ac.kopo.korea.service.WishService;

@Controller
@RequestMapping("/history")
public class HistoryController {
	final String path = "history/";
	private String uploadPath = "d://upload/history";

	@Autowired
	HistoryService service;
	
	@Autowired
	ReplyService replyService;

	@Autowired
	WishService wishService;

	@RequestMapping("/index")
	public String index() {

		return path + "index";
	}

	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<History> list = service.list(pager);
		model.addAttribute("list", list);

		return path + "list";
	}

	@GetMapping("/add")
	public String add() {
		return path + "add";
	}

	@PostMapping("/add")
	public String add(History item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());

		try {
			List<Attach> list = new ArrayList<Attach>();

			for (MultipartFile attach : item.getAttach()) {
				if (attach != null && !attach.isEmpty()) {
					String filename = attach.getOriginalFilename();

					attach.transferTo(new File(uploadPath + filename));

					Attach attachItem = new Attach();
					attachItem.setFilename(filename);

					list.add(attachItem);
				}
			}
			item.setAttachs(list);

			service.add(item);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @SessionAttribute Member member) {
		History item = service.item(id);

		if (member.getId().equals(item.getMemberId())) {
			model.addAttribute("item", item);

			return path + "update";
		} else
			return "redirect:../list";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, History item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());

		item.setId(id);

		try {
			List<Attach> list = new ArrayList<Attach>();

			for (MultipartFile attach : item.getAttach()) {
				if (attach != null && !attach.isEmpty()) {
					String filename = attach.getOriginalFilename();

					attach.transferTo(new File(uploadPath + filename));

					Attach attachItem = new Attach();
					attachItem.setFilename(filename);

					list.add(attachItem);
				}
			}
			item.setAttachs(list);

			service.update(item);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @SessionAttribute Member member) {
		service.delete(id, member.getId());

		return "redirect:../list";
	}
	
	@ResponseBody
	@RequestMapping("/delete_attach/{id}")
	public String deleteAttach(@PathVariable int id) {
		if(service.deleteAttach(id))
			return "OK";
		else
			return "FAIL";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		History item = service.item(id);

		model.addAttribute("item", item);
		
		/* 댓글 조회 : 이현주 */
		int historyId = id;
		List<Reply> reply = replyService.historyList(historyId);
		model.addAttribute("reply", reply);

		return path + "detail";
	}
	
	/* 댓글 추가 */
	@RequestMapping("/replyAdd")
	public String replyAdd(Reply reply, Model model, @SessionAttribute Member member) throws Exception {
		reply.setMemberId(member.getId());

		replyService.historyAdd(reply);		
		
		return "redirect:detail/" + reply.getHistoryId();
	}

	/* 댓글 삭제 */
	@RequestMapping("/replyDelete/{id}")
	public String replyDelete(@PathVariable int id, @RequestParam(value = "id") int historyId) throws Exception {

		System.out.println(historyId);

		replyService.historyDelete(id);

		return "redirect:../detail/" + historyId;
	}

	@ResponseBody
	@PutMapping("/wish/{id}")
	public String addWish(@PathVariable int id, @SessionAttribute Member member) {
		if (wishService.add(id)) {
			return "OK";
		} else
			return "FAIL";
	}

	@ResponseBody
	@DeleteMapping("/wish/{id}")
	public String deleteWish(@PathVariable int id, @SessionAttribute Member member) {
		if (wishService.delete(id)) {
			return "OK";
		} else
			return "FAIL";
	}
}
