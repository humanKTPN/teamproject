package kr.or.ktpn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ktpn.dto.DTO_pr_1000mt;
import kr.or.ktpn.dto.MrInventoryDto;
import kr.or.ktpn.dto.ProductionDto;
import kr.or.ktpn.service.Svc_dsboard;
import kr.or.ktpn.service.Svc_pr_1000mt;

@Controller
public class Ctrl_dsBoard {

	
	@Autowired
	Svc_dsboard svcMd;
	
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String home(Model model) {
		
		 List<ProductionDto> todayWorkList = svcMd.getTodayWorkOrders();
	     model.addAttribute("dayWorkList", todayWorkList);
		
		return "dashBoard_kwak.tiles";
	}
	
	
	
	 @GetMapping("/inventory")
	 @ResponseBody
     public List<MrInventoryDto> inventory() {
         // 파라미터 DTO 가 필요없다면 그냥 빈 객체 넘기거나 메소드 오버로드로 처리
         return svcMd.getMrList(new MrInventoryDto());
     }
	 
	 @GetMapping("/production")
     @ResponseBody
     public List<ProductionDto> production(
             @RequestParam(value="productName", required=false) String productName) {
         return svcMd.getProductionList(productName);
     }
}
