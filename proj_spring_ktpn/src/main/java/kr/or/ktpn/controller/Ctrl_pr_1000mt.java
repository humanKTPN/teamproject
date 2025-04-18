package kr.or.ktpn.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ktpn.dto.DTO_pr_1000mt;
import kr.or.ktpn.dto.DTO_pr_insert;
import kr.or.ktpn.service.Svc_pr_1000mt;


 
@Controller
public class Ctrl_pr_1000mt {
	
	@Autowired
	Svc_pr_1000mt svcMd;
	
	@RequestMapping(value="/pr", method = RequestMethod.GET)
	public String list(DTO_pr_1000mt dto,
					   Model model,
					   HttpServletRequest req) {
		
		List<DTO_pr_1000mt> list = svcMd.getPrList(dto);
//		System.out.println(map);
		
		model.addAttribute("list", list);
		
		return "workManage_main_kwak.tiles";
	}
	
	@RequestMapping(value="/prDetail", method=RequestMethod.GET)
	public String listDetail(
	        @RequestParam Map<String,String> params,
	        Model model
	) {
	    // 서비스에도 Map<String,String> 넘김
	    List<DTO_pr_1000mt> list = svcMd.getdePrList(params);
	    model.addAttribute("list", list);
	    System.out.print(list);
	    return "workManage_select_kwak.tiles";
	}
	
//	@RequestMapping(value="/addDetail", method=RequestMethod.GET)
//	public String addDetail() {
//
//		return "workManage_add_kwak.tiles";
//	}
	

	@RequestMapping(value="/addDetail")
    public String showAddForm(Model model, HttpServletRequest req) {
        List<Map<String,Object>> addMap = svcMd.getAddListMap();
        List<Map<String,Object>> LineMap = svcMd.getLineMap();
        List<Map<String,Object>> mbMap = svcMd.selectMbList();
        
//        List<Map<String,Object>> list = new ArrayList(LineMap.values());

        // 
        model.addAttribute("addMap", addMap);
        model.addAttribute("LineMap", LineMap);
        model.addAttribute("mbMap", mbMap);
        System.out.println(mbMap);
        return "workManage_add_kwak.tiles";
    }
			
//		
//		return "processDesc_add_kwak.tiles";
//	}
//	@RequestMapping(value="/rtAdd", method = RequestMethod.GET)
//	public String listForm() {
//		
//		return "processDesc_add_kwak.tiles";
//	} 
//	
	@RequestMapping(value="/insertPr", method = RequestMethod.POST)
	public String insertRtPost(DTO_pr_insert dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] bm : " + dto);
	    int count = svcMd.insertPr(dto);
	    System.out.println("추가 결과 : " + count);
	    
	    return "redirect:/pr";
	}
////	
////	
//	@RequestMapping(value="/rtMod", method = RequestMethod.GET)
//	public String bmMod(DTO_rt_1000mt dto,
//			Model model,
//			HttpServletRequest req) {
//		
//		List<DTO_rt_1000mt> li = svcMd.getRtList(dto);
////		System.out.println(li);
//		model.addAttribute("dt", li);
//		
//		return "processDesc_mod.tiles";
//	}
//	
//	@RequestMapping(value="/rtMod", method = RequestMethod.POST)
//	public String modBmPost(DTO_rt_1000mt dto) {
//	    // 전달받은 데이터를 출력 후 db입력
//	    System.out.println("[POST] joinEmp empDTO : " + dto);
//	    int count = svcMd.modRt(dto);
//	    System.out.println("업데이트 결과 : " + count);
//	    
//	    return "redirect:/rt";
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
