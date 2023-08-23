package kr.ac.kopo.korea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.korea.model.Grade;
import kr.ac.kopo.korea.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	final String path = "grade/";

	@Autowired
	GradeService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Grade> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	@PostMapping("/add")
	public String add(Grade item) {
		//grade에 값이 없으면 1:사용자, 2:작성자, 3:관리자 추가(초기설정)
		if(item==null) {
			service.firstAdd(item);
		} 
		else {
			service.add(item);
		}
		return "redirect:list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		Grade item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "update";		
	}
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, Grade item) {
		item.setId(id);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		
		return "redirect:../list";
	}
	
}
