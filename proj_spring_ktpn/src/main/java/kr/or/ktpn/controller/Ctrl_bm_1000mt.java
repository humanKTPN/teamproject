package kr.or.ktpn.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_mr_detail;
import kr.or.ktpn.dto.DTO_mr_insert;
import kr.or.ktpn.service.Svc_bm_1000mt;


 
@Controller
public class Ctrl_bm_1000mt {
	
	@Autowired
	Svc_bm_1000mt svcMd;
	
	@RequestMapping(value="/bm", method = RequestMethod.GET)
	public String list(DTO_bm_1000mt dto,
					   Model model,
					   HttpServletRequest req) {
		
		List<DTO_bm_1000mt> list = svcMd.getBmList(dto);
//		System.out.println(req.getParameter("categories"));
//		System.out.println(req.getParameter("key"));
		
		model.addAttribute("list", list);
		
		return "bom_main_kwak.tiles";
	}
	
	@RequestMapping(value="/bmDetail", method = RequestMethod.GET)
	public String listDetail(DTO_bm_1000mt dto,
			DTO_mr_detail mrDTO,
			Model model,
			@RequestParam("bom_cd") String bomCd,
			HttpServletRequest req) {
		
		List<DTO_bm_1000mt> li = svcMd.getBmList(dto);
		List<DTO_mr_detail> mrLi = svcMd.detailBm(mrDTO);
//		System.out.println(map);
		
		model.addAttribute("list", li);
		model.addAttribute("mrlist", mrLi);
		
		return "bom_select_kwak.tiles";
	}
	
	@RequestMapping(value="/bmAddDetail", method = RequestMethod.GET)
	public String addDetail(DTO_md_1000mt dto,
			Model model,
			HttpServletRequest req) { 
		
		List<DTO_md_1000mt> li = svcMd.addBm(dto);
		List<DTO_md_1000mt> mrlist = svcMd.callList(dto);
		
		model.addAttribute("list", li);
		model.addAttribute("mrlist", mrlist);
//		System.out.println(mrlist);
		
		
		return "bom_add_kwak.tiles";
	}
	
	@RequestMapping(value="/bmAdd", method = RequestMethod.GET)
	public String listForm() {
		
		return "bom_add_kwak.tiles";
	}
	
	@RequestMapping(value="/bmAdd", method = RequestMethod.POST)
	public String insertBmPost(DTO_bm_1000mt dto) {
	    // 전달받은 데이터를 출력 후 db입력
//	    System.out.println("[POST] bm : " + dto);
	    int count = svcMd.insertBm(dto);
//	    System.out.println("추가 결과 : " + count);
	    
	    
	    return "redirect:/bm";
	}
	@ResponseBody
	@RequestMapping
	(value="/bmAddMr", method = RequestMethod.POST)
	public void insertBmMr(@RequestBody Map<String,Object> mrMap) {
		// 전달받은 데이터를 출력 후 db입력
//		System.out.println("Mr : " + mrMap);
		int count = svcMd.insertMr(mrMap);
//		System.out.println("추가 결과 : " + count);
		
	}
	
	
	@RequestMapping(value="/bmMod", method = RequestMethod.GET)
	public String bmMod(DTO_bm_1000mt dto,
			DTO_mr_detail mrDTO,
			DTO_md_1000mt ldto,
			Model model,
			HttpSession session,
			HttpServletRequest req) {
		
		List<DTO_bm_1000mt> li = svcMd.getBmList(dto);
		List<DTO_mr_detail> mrLi = svcMd.detailBm(mrDTO);
		List<DTO_md_1000mt> mrlist = svcMd.callList(ldto);
		
		model.addAttribute("dt", li);
		session.setAttribute("mrlist", mrLi);
		model.addAttribute("mrl", mrlist);
		
		return "bom_mod_kwak.tiles";
	}
	
	@RequestMapping(value="/bmMod", method = RequestMethod.POST)
	public String modBmPost(DTO_mr_insert dto
			) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] detail : " + dto);
	    int count = svcMd.modBm(dto);
	    
	    System.out.println("업데이트 결과 : " + count);
	    
	    return "redirect:/bm";
	}
	
	
	@ResponseBody
	@RequestMapping
	(value="/bmDel", method = RequestMethod.DELETE)
	public void delBmMr(@RequestBody DTO_mr_insert dto) {
		// 전달받은 데이터를 출력 후 db입력
		System.out.println("del"+dto);
		int count = svcMd.delMr(dto);
		
//		System.out.println("추가 결과 : " + count);
		
	}
	
	
	
//	@RequestMapping(value="/bmAdd", method = RequestMethod.GET)
//	public String listForm() {
//		
//		return "bom_add_kwak.tiles";
//	}
//	
//	@RequestMapping(value="/bmAdd", method = RequestMethod.POST)
//	public String joinMdPost(DTO_bm_1000mt dto) {
//	    // 전달받은 데이터를 출력 후 db입력
//	    System.out.println("[POST] bm: " + dto);
//	    int count = svcMd.addBm(dto);
//	    System.out.println("추가 결과 : " + count);
//	    
//	    return "redirect:/bm";
//	}
}
