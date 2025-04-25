package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_pr_1000mt;
import kr.or.ktpn.dto.KW_DTO_MB_1000MT;
import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;
import kr.or.ktpn.service.KW_Svc_mb_1000mt;
import kr.or.ktpn.service.Svc_md_1000mt;
import kr.or.ktpn.service.Svc_pr_1000mt;
import kr.or.ktpn.service.TAK_Svc_pr_1100mt;
import kr.or.ktpn.service.TAK_Svc_pr_1110mt;

@Controller 
public class TAK_Ctrl_pr_1100mt {

	@Autowired
	TAK_Svc_pr_1100mt svc_pr_1100mt;
	@Autowired
	TAK_Svc_pr_1110mt svc_pr_1110mt;
	@Autowired
	Svc_md_1000mt svcMd;
	@Autowired
	Svc_pr_1000mt svc_pr_1000mt;
	@Autowired
	KW_Svc_mb_1000mt svc_mb_1000mt;

	@RequestMapping(value = "/tb_pr_mt", method = RequestMethod.GET)
	public String viewPr_1100mt(Model model) {

		List<TAK_PR_1100MTDTO> selectList = svc_pr_1100mt.selectDAO();
		List<TAK_PR_1100MTDTO> selectList_a = svc_pr_1100mt.selectDAO_A();
		List<TAK_PR_1100MTDTO> selectList_b = svc_pr_1100mt.selectDAO_B();
		List<TAK_PR_1100MTDTO> selectList_c = svc_pr_1100mt.selectDAO_C();
		List<TAK_PR_1110MTDTO> selectList_1110 = svc_pr_1110mt.selectDAO();

		model.addAttribute("pr_1100mt", selectList);
		model.addAttribute("pr_1100mt_a", selectList_a);
		model.addAttribute("pr_1100mt_b", selectList_b);
		model.addAttribute("pr_1100mt_c", selectList_c);
		model.addAttribute("pr_1110mt", selectList_1110);

		System.out.println("selectList : " + selectList);
		return "Production management_tak.tiles";
	}

	@RequestMapping(value = "pm_popup", method = RequestMethod.GET)
	public String viewPM_popup(Model model) {

		List<TAK_PR_1100MTDTO> selectList = svc_pr_1100mt.selectDAO();
		List<DTO_md_1000mt> list_P = svcMd.selectDAO_P();
		List<DTO_md_1000mt> list_L = svcMd.selectDAO_L();
		List<DTO_pr_1000mt> pm_1000mt_N = svc_pr_1000mt.selectDAO_N();
		List<TAK_PR_1100MTDTO> pm_1100mt_Y = svc_pr_1100mt.selectDAO_Y();
		List<KW_DTO_MB_1000MT> mb_1000mt = svc_mb_1000mt.getMemberlist();


		model.addAttribute("pm_1100mt", selectList);
		model.addAttribute("md_1000mt_P", list_P);
		model.addAttribute("md_1000mt_L", list_L);
		model.addAttribute("pm_1000mt_N", pm_1000mt_N);
		model.addAttribute("pm_1100mt_Y", pm_1100mt_Y);
		model.addAttribute("mb_1000mt", mb_1000mt);
		return "popup/pm_popup_tak";
	}
	//pm_popup insert
	@RequestMapping(value = "/pm_popup_insert", method = RequestMethod.PUT)
	@ResponseBody
	public int insertPM_popup(
			Model model,
			@RequestBody
			TAK_PR_1100MTDTO dto
			) {
		
		System.out.println("insertPM_popup dto : " + dto);
		int insert= svc_pr_1100mt.insertDAO(dto);
		return insert;
	}
	
	//pr_popup insert
	@RequestMapping(value = "/pr_popup_insert", method = RequestMethod.PUT)
	@ResponseBody
	public int insertPR_popup(
			Model model,
			@RequestBody
			TAK_PR_1110MTDTO dto
			) {
		
		System.out.println("insertPR_popup dto : " + dto);
		int insert= svc_pr_1110mt.insertDAO(dto);
		return insert;
	}
	
//	pm_popup 수정
	@RequestMapping(value = "/pm_popup", method = RequestMethod.PUT)
	@ResponseBody
	public int modifyPM_popup(
			Model model,
			@RequestBody
			TAK_PR_1100MTDTO dto
			) {
		
		System.out.println("modifyPM_popup dto : " + dto);
		int update= svc_pr_1100mt.updateDAO(dto);
		return update;
	}
//	pm_popup 완료
	@RequestMapping(value = "/pm_popup_complete", method = RequestMethod.PUT)
	@ResponseBody
	public int completePM_popup(
			Model model,
			@RequestBody
			TAK_PR_1100MTDTO dto
			) {
		
		System.out.println("completePM_popup dto : " + dto);
		int update= svc_pr_1100mt.completeDAO(dto);
		return update;
	}
	
//	pr_popup 수정
	@RequestMapping(value = "/pr_popup", method = RequestMethod.PUT)
	@ResponseBody
	public int modifyPR_popup(
			Model model,
			@RequestBody
			TAK_PR_1110MTDTO dto
			) {
		
		System.out.println("modifyPR_popup dto : " + dto);
		int update= svc_pr_1110mt.updateDAO(dto);
		return update;
	}
//	pr_popup 완료
	@RequestMapping(value = "/pr_popup_complete", method = RequestMethod.PUT)
	@ResponseBody
	public int completePR_popup(
			Model model,
			@RequestBody
			TAK_PR_1110MTDTO dto
			) {
		
		System.out.println("completePR_popup dto : " + dto);
		int update= svc_pr_1110mt.completeDAO(dto);
		return update;
	}

	@RequestMapping(value = "pr_popup", method = RequestMethod.GET)
	public String viewPR_popup(Model model) {

		List<TAK_PR_1110MTDTO> selectList = svc_pr_1110mt.selectDAO();
		List<DTO_md_1000mt> list_P = svcMd.selectDAO_P();

		model.addAttribute("pr_1110mt", selectList);
		model.addAttribute("md_1000mt_P", list_P);
		return "popup/pr_popup_tak";
	}
	
//  일정조회
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String searchSchedule(@RequestParam("startDate") String startDate,
	                             @RequestParam("endDate") String endDate,
	                             Model model) {

	    // 날짜 범위 설정
	    TAK_PR_1110MTDTO dto = new TAK_PR_1110MTDTO();
	    dto.setSearchStartDate(startDate);
	    dto.setSearchEndDate(endDate);
	    
	    //기존 생산 셀렉
	    List<TAK_PR_1100MTDTO> selectList = svc_pr_1100mt.selectDAO();
		List<TAK_PR_1100MTDTO> selectList_a = svc_pr_1100mt.selectDAO_A();
		List<TAK_PR_1100MTDTO> selectList_b = svc_pr_1100mt.selectDAO_B();
		List<TAK_PR_1100MTDTO> selectList_c = svc_pr_1100mt.selectDAO_C();

		model.addAttribute("pr_1100mt", selectList);
		model.addAttribute("pr_1100mt_a", selectList_a);
		model.addAttribute("pr_1100mt_b", selectList_b);
		model.addAttribute("pr_1100mt_c", selectList_c);
	    

	    // 날짜 범위로 일정 조회
	    List<TAK_PR_1110MTDTO> result = svc_pr_1110mt.searchByDateRange(dto);
	    model.addAttribute("pr_1110mt", result);

	    return "Production management_tak.tiles";
	}
}
