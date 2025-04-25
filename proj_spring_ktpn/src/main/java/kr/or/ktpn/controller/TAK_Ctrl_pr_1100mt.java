package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.service.TAK_Svc_pr_1100mt;

@Controller
public class TAK_Ctrl_pr_1100mt {

	@Autowired
	TAK_Svc_pr_1100mt svc_pr_1100mt;
	
	@RequestMapping(value="/tb_pr_mt", method = RequestMethod.GET)
	public String viewPr_1100mt(Model model) {
		
		List<TAK_PR_1100MTDTO> selectList = svc_pr_1100mt.selectDAO();
		
		model.addAttribute("pr_1100mt", selectList);
		
		System.out.println("selectList : "+selectList);
		return "Production management_tak.tiles";
	}
	
	
}
