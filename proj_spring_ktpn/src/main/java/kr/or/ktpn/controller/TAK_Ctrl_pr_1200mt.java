package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;
import kr.or.ktpn.service.TAK_Svc_pr_1100mt;
import kr.or.ktpn.service.TAK_Svc_pr_1110mt;
import kr.or.ktpn.service.TAK_Svc_pr_1200mt;

@Controller
public class TAK_Ctrl_pr_1200mt {

	@Autowired
	TAK_Svc_pr_1200mt svc_pr_1200mt;

	
	@RequestMapping(value="/tb_pr_mt2", method = RequestMethod.GET)
	public String viewPr_1200mt(Model model) {
		
//		List<TAK_PR_1100MTDTO> selectDayList = svc_pr_1200mt.selectDayDAO();
		
		TAK_PR_1100MTDTO selectLineA1 = svc_pr_1200mt.selectLineA1DAO();
		TAK_PR_1100MTDTO selectLineC3 = svc_pr_1200mt.selectLineC3DAO();
		
//		model.addAttribute("pr_1200mt", selectDayList);
		
		
		model.addAttribute("LineA1", selectLineA1);
		model.addAttribute("LineC3", selectLineC3);
//		System.out.println("selectDayList : "+selectDayList);
		
		return "Production reporting_tak.tiles";
	}
	
	
}
