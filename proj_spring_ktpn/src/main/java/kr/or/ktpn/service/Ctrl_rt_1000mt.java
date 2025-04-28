package kr.or.ktpn.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_mr_insert;
import kr.or.ktpn.dto.DTO_rt_1000mt;
import kr.or.ktpn.dto.DTO_rt_desc;
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
			DTO_rt_desc desc,
			HttpServletRequest req) {
		
		List<DTO_rt_1000mt> li = svcMd.getRtList(dto);
		List<DTO_rt_desc> de = svcMd.getRtDesc(desc);
		System.out.println("desc : "+de);
		model.addAttribute("dt", li);
		model.addAttribute("dc", de);
//		System.out.println(map);
		
		model.addAttribute("list", li);
		
		return "processDesc_select.tiles";
	}
//	
	@RequestMapping(value="/rtAddDetail", method = RequestMethod.GET)
	public String addDetail(DTO_md_1000mt dto,
			Model model,
			HttpServletRequest req) { 
		
		List<DTO_md_1000mt> li = svcMd.addRt(dto);
		System.out.println(li);
		
		model.addAttribute("list", li);
		
		
		return "processDesc_add_kwak.tiles";
	}
	@RequestMapping(value="/rtAdd", method = RequestMethod.GET)
	public String listForm() {
		
		return "processDesc_add_kwak.tiles";
	}
	
	@RequestMapping(value="/rtAdd", method = RequestMethod.POST)
	public String insertRtPost(DTO_rt_1000mt dto
			,DTO_rt_desc desc) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] r : " + desc);
	    int count = svcMd.insertRt(dto);
	    
	    System.out.println("추가 결과 : " + count);
	    
	    return "redirect:/rt";
	}
//	
//	
	@RequestMapping(value="/rtMod", method = RequestMethod.GET)
	public String bmMod(DTO_rt_1000mt dto,
			Model model,
			DTO_rt_desc desc,
			HttpServletRequest req) {
		
		List<DTO_rt_1000mt> li = svcMd.getRtList(dto);
		List<DTO_rt_desc> de = svcMd.getRtDesc(desc);
		model.addAttribute("dt", li);
		model.addAttribute("dc", de);

		
		return "processDesc_mod.tiles";
	}
	
	@RequestMapping(value="/rtMod", method = RequestMethod.POST)
	public String modBmPost(DTO_rt_desc dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] joinEmp empDTO : " + dto);
	    int count = svcMd.modRt(dto);
	    System.out.println("업데이트 결과 : " + count);
	    
	    return "redirect:/rt";
	}
	
	@ResponseBody
	@RequestMapping
	(value="/bmAddRt", method = RequestMethod.POST)
	public String insertBmMr(@RequestBody Map<String,Object> mrMap) {
		// 전달받은 데이터를 출력 후 db입력
		System.out.println("rt : " + mrMap);
		int count = svcMd.insertRt(mrMap);
		System.out.println("추가 결과 : " + count);
		
		return "redirect:/rt";	
	}
	
	
	
	@ResponseBody
	@RequestMapping
	(value="/rtDel", method = RequestMethod.DELETE)
	public void delRtMr(@RequestBody DTO_rt_desc dto) {
		// 전달받은 데이터를 출력 후 db입력
		System.out.println("del"+dto);
		int count = svcMd.delRt(dto);
		
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
