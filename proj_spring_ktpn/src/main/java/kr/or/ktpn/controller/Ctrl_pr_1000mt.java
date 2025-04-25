package kr.or.ktpn.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_mr_detail;
import kr.or.ktpn.dto.DTO_pr_1000mt;
import kr.or.ktpn.dto.DTO_pr_insert;
import kr.or.ktpn.service.Svc_bm_1000mt;
import kr.or.ktpn.service.Svc_pr_1000mt;


 
@Controller
public class Ctrl_pr_1000mt {
	
	@Autowired
	Svc_pr_1000mt svcMd;
	@Autowired
	Svc_bm_1000mt svcBm;
	
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
	    System.out.print("LIST : "+list);
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
			

	@RequestMapping(value="/insertPr", method = RequestMethod.POST)
	public String insertRtPost(DTO_pr_insert dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] bm : " + dto);
	    int count = svcMd.insertPr(dto);
	    System.out.println("추가 결과 : " + count);
	    
	    return "redirect:/pr";
	}
	
	
	@RequestMapping(value="/prDel", method = RequestMethod.POST)
	public String DelMdPost(DTO_pr_insert dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] del : " + dto);
	    int count = svcMd.delMd(dto);
	    System.out.println("삭제 결과 : " + count);
	    
	    return "redirect:/pr";
	}
	
	



}
