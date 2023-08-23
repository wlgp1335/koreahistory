package kr.ac.kopo.korea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.model.Often;
import kr.ac.kopo.korea.pager.Pager;
import kr.ac.kopo.korea.service.OftenqaService;

@Controller
@RequestMapping("/oftenqa")
public class OftenqaController {
	final String path = "oftenqa/";
	
	@Autowired
	OftenqaService service;
	
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Often> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@RequestMapping("/detail/{id}")
	public String deltail(@PathVariable int id, Model model) {
		Often item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "detail";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	@PostMapping("/add")
	public String add(Often item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());
		
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @SessionAttribute Member member) {
		Often item = service.item(id);
		
		if(member.getId().equals(item.getMemberId())) {
			model.addAttribute("item", item);
			
			return path + "update";
		} else
			return "redirect:../list";
	}
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, Often item, @SessionAttribute Member member) {
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
}
