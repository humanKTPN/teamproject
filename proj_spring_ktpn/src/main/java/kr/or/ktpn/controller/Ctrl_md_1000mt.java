package kr.or.ktpn.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.service.Svc_md_1000mt;

 
@Controller
public class Ctrl_md_1000mt {
	
	@Autowired
	Svc_md_1000mt svcMd;
	
	@RequestMapping(value="/md", method = RequestMethod.GET)
	public String list(DTO_md_1000mt dto,
					   Model model,
					   HttpServletRequest req) {
		
		List<DTO_md_1000mt> list = svcMd.getMdList(dto);
//		System.out.println(map);
		
		model.addAttribute("list", list);
		
		return "masterdataManage_main_kwak.tiles";
	}
	
	@RequestMapping(value="/mdDetail", method = RequestMethod.GET)
	public String listDetail(DTO_md_1000mt dto,
			Model model,
			HttpServletRequest req) {
		
		List<DTO_md_1000mt> li = svcMd.getMdList(dto);
//		System.out.println(map);
		
		model.addAttribute("list", li);
		
		return "masterdataManage_select_kwak.tiles";
	}
	
	@RequestMapping(value="/mdAdd", method = RequestMethod.GET)
	public String listForm() {
		
		return "masterdataManage_add_kwak.tiles";
	}
	
	@RequestMapping(value="/mdAdd", method = RequestMethod.POST)
	public String joinMdPost(DTO_md_1000mt dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] joinEmp empDTO : " + dto);
	    int count = svcMd.addMd(dto);
	    System.out.println("추가 결과 : " + count);
	    
	    return "redirect:/md";
	}
	
	
	@RequestMapping(value="/mdMod", method = RequestMethod.GET)
	public String mdMod(DTO_md_1000mt dto,
			Model model,
			HttpServletRequest req) {
		
		List<DTO_md_1000mt> li = svcMd.getMdList(dto);
		
		model.addAttribute("dt", li);
		
		return "masterdataManage_mod_kwak.tiles";
	}
	
	@RequestMapping(value="/mdMod", method = RequestMethod.POST)
	public String modMdPost(DTO_md_1000mt dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] joinEmp empDTO : " + dto);
	    int count = svcMd.modMd(dto);
	    System.out.println("업데이트 결과 : " + count);
	    
	    return "redirect:/md";
	}
	
	@RequestMapping(value="/mdDel", method = RequestMethod.POST)
	public String DelMdPost(DTO_md_1000mt dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] del : " + dto);
	    int count = svcMd.delMd(dto);
	    System.out.println("삭제 결과 : " + count);
	    
	    return "redirect:/md";
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "dashBoard_kwak.tiles";
	}
	
}
