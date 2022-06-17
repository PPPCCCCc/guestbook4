package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	
	@Autowired
	private GuestBookService guestbookService;

	// 리스트
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("addList");

		List<GuestBookVo> guestList = guestbookService.gList();

		model.addAttribute("gList", guestList);

		return "addList";
	}

	// 등록
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestBookVo guestBookVo) {
		System.out.println("add");

		guestbookService.gbinsert(guestBookVo);
		
		return "redirect:/addList";
	}

	// 삭제품
	@RequestMapping(value = "/deleteForm/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(Model model, @PathVariable("no") int no) {
		System.out.println("deleteForm");
		model.addAttribute("no", no);
		return "deleteForm";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestBookVo guestbookVo, @RequestParam("no") int no,
			@RequestParam("password") String password) {
		System.out.println("delete");

		no = guestbookVo.getNo();
		password = guestbookVo.getPassword();
		guestbookService.gbdelete(no, password);

		return "redirect:/addList";
	}

}