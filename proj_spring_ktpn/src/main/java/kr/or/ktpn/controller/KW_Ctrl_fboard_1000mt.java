package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;
import kr.or.ktpn.service.KW_Svc_fb_1000mt;

@Controller
public class KW_Ctrl_fboard_1000mt {

	@Autowired
	KW_Svc_fb_1000mt serv;
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	
	public String listcontents() {
		System.out.println("notice 작동테스트");

		List<KW_DTO_BR_1000MT> list = serv.getfboardlist();
		
		return "FreeBoard_Nam.tiles";
	}
}
