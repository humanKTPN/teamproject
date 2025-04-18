package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;
import kr.or.ktpn.service.KW_Svc_mb_1000mt;

@Controller
public class KW_Ctrl_mb_1000mt {

	@Autowired
	KW_Svc_mb_1000mt serv;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String listMember() {
		System.out.println("login창 들어간다능");

		List<KW_DTO_MB_1000MT> list = serv.getMemberlist();
		
		return "/login/login";
	}
	
	@RequestMapping(value = "/notice")
	public String listcontents() {
		System.out.println("notice 작동테스트");

		//List<KW_DTO_MB_1000MT> list = serv.getMemberlist();
		
		return "noticeBoard_Nam.tiles";
	}
	
}
