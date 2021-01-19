package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PhoneVo;

//컨트롤러라는 증거
@Controller
@RequestMapping(value="/phone")
public class PhoneController {

	// 메소드 단위로 기능을 정의
	// 필드
	// 생성자
	// 메소드 g/s
	
	/** 메소드 일반 **/
	// 메소드마다 기능 1개씩 --> 기능마다 url을 부여
	
	//테스트	
	
	// 리스트
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("list");
		
		//dao를 통해 리스트를 가져온다.
		PhoneDao phoneDao = new PhoneDao();
		List<PhoneVo> personList = phoneDao.getPersonList();
		
		System.out.println(personList.toString());
		
		//model --> data를 보내는 방법 -->담아 놓으면 된다.
		model.addAttribute("pList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	
	
	// 등록 폼
	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("writeForm");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	//http://localhost:8088/phonebook3/phone/write?name=채민식&hp=010-1234-1234&company=02-1234-1234
	// 등록
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write( @RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam("company")String company) {
		
		System.out.println("write");
		
		PhoneVo phoneVo = new PhoneVo(name, hp, company);
		
		System.out.println(phoneVo.toString());
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(phoneVo);
		
		//리다이렉트 사용법
		return "redirect:/phone/list";
	}
	
	
	// 수정폼--> modifyForm
	@RequestMapping(value = "modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, @RequestParam("id") int phoneId) {
		System.out.println("수정 폼");
		
		PhoneDao phoneDao = new PhoneDao();
		
		PhoneVo phoneVo = phoneDao.getPerson(phoneId);
		
		model.addAttribute("mVo", phoneVo );
		
		
		return "/WEB-INF/views/modifyForm.jsp";
	}
	
	// 수정 --> modify
	@RequestMapping(value = "modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@RequestParam("id") int phoneId, @RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam("company") String company) {
		System.out.println("수정");
		
		PhoneVo phoneVo = new PhoneVo(phoneId, name, hp, company);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(phoneVo);
		
		
		return "redirect:/phone/list";
	}
	// 삭제 --> delete
	@RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("id") int phoneId) {
		System.out.println("삭제");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.phoneDelete(phoneId);
		
		
		return "redirect:/phone/list";
	}

}
