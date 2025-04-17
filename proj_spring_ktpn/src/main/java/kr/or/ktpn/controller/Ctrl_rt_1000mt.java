package kr.or.ktpn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_rt_1000mt;
import kr.or.ktpn.service.Svc_rt_1000mt;


 
@Controller
public class Ctrl_rt_1000mt {
	
	@Autowired
	Svc_rt_1000mt svcMd;
	
	@RequestMapping(value="/rt", method = RequestMethod.GET)
	public String list(DTO_rt_1000mt dto,
					   Model model,
					   HttpServletRequest req) {
		
		List<DTO_rt_1000mt> list = svcMd.getRtList(dto);
//		System.out.println(map);
		
		model.addAttribute("list", list);
		
		return "processDesc_main.tiles";
	}
	
	@RequestMapping(value="/rtDetail", method = RequestMethod.GET)
	public String listDetail(DTO_rt_1000mt dto,
			Model model,
			HttpServletRequest req) {
		
		List<DTO_rt_1000mt> li = svcMd.getRtList(dto);
//		System.out.println(map);
		
		model.addAttribute("list", li);
		
		return "processDesc_select.tiles";
	}
//	
//	@RequestMapping(value="/bmAddDetail", method = RequestMethod.GET)
//	public String addDetail(DTO_md_1000mt dto,
//			Model model,
//			HttpServletRequest req) { 
//		
//		List<DTO_md_1000mt> li = svcMd.addBm(dto);
//		System.out.println(li);
//		
//		model.addAttribute("list", li);
//		
//		
//		return "bom_add_kwak.tiles";
//	}
//	
//	@RequestMapping(value="/bmAdd", method = RequestMethod.GET)
//	public String listForm() {
//		
//		return "bom_add_kwak.tiles";
//	}
//	
//	@RequestMapping(value="/bmAdd", method = RequestMethod.POST)
//	public String insertBmPost(DTO_bm_1000mt dto) {
//	    // 전달받은 데이터를 출력 후 db입력
//	    System.out.println("[POST] bm : " + dto);
//	    int count = svcMd.insertBm(dto);
//	    System.out.println("추가 결과 : " + count);
//	    
//	    return "redirect:/md";
//	}
//	
//	
//	@RequestMapping(value="/bmMod", method = RequestMethod.GET)
//	public String bmMod(DTO_bm_1000mt dto,
//			Model model,
//			HttpServletRequest req) {
//		
//		List<DTO_bm_1000mt> li = svcMd.getBmList(dto);
////		System.out.println(li);
//		model.addAttribute("dt", li);
//		
//		return "bom_mod_kwak.tiles";
//	}
//	
//	@RequestMapping(value="/bmMod", method = RequestMethod.POST)
//	public String modBmPost(DTO_bm_1000mt dto) {
//	    // 전달받은 데이터를 출력 후 db입력
//	    System.out.println("[POST] joinEmp empDTO : " + dto);
//	    int count = svcMd.modBm(dto);
//	    System.out.println("업데이트 결과 : " + count);
//	    
//	    return "redirect:/bm";
//	}
	
	
	
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
