package kr.or.ktpn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KW_Ctrl_main {

//	@RequestMapping(value = "/")
//	public String mainPage(HttpSession session, KW_DTO_MB_1000MT dto) {
////	    KW_DTO_MB_1000MT loginUser = (KW_DTO_MB_1000MT) session.getAttribute("loginUser");
//
//		String mb_nm = dto.getMbr_nm();
//		
//		System.out.println("mb_nm : "+ mb_nm);
//		
//	    if (mb_nm == null) {
//	        return "redirect:/login";
//	    }
//
//	    session.setAttribute("mb_nm", mb_nm);
//	    return "dashBoard_kwak.tiles"; // 로그인 성공 후 홈으로
//	}
	@RequestMapping(value = "/")
	public String mainPage() {
		

		return "dashBoard_kwak.tiles"; // 로그인 성공 후 홈으로
	}
}
