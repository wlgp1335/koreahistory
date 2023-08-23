package kr.ac.kopo.korea.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.korea.model.Attach;
import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.model.Notice;
import kr.ac.kopo.korea.pager.Pager;
import kr.ac.kopo.korea.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	final String path = "notice/";
	private String uploadPath = "d://upload/notice";
	
	@Autowired
	NoticeService service;
	
	
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Notice> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@RequestMapping("/detail/{id}")
	public String deltail(@PathVariable int id, Model model) {
		Notice item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "detail";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	@PostMapping("/add")
	public String add(Notice item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());
		
		try {
			List<Attach> list = new ArrayList<Attach>();
			
			for(MultipartFile attach : item.getAttach()) {
				if(attach != null && !attach.isEmpty()) {
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
		Notice item = service.item(id);
		
		if(member.getId().equals(item.getMemberId())) {
			model.addAttribute("item", item);
			
			return path + "update";
		} else
			return "redirect:../list";
	}
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, Notice item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());
		
		item.setId(id);
		
		try {
			List<Attach> list = new ArrayList<Attach>();
			
			for(MultipartFile attach : item.getAttach()) {
				if(attach != null && !attach.isEmpty()) {
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
}
