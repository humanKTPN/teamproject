package kr.or.ktpn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;
import kr.or.ktpn.service.KW_Svc_mb_1000mt;

@Controller
public class KW_Ctrl_mb_1000mt {

	@Autowired
	KW_Svc_mb_1000mt serv;
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String listMember(Model model) {
		System.out.println("맴버관리창 들어간다능");

		List<KW_DTO_MB_1000MT> list = serv.getMemberlist();
		
		System.out.println("list.size : " + list.size());
		
		model.addAttribute("list", list);
		
		return "/login/memberManger";
	}
	
	@RequestMapping(value = "/memberdatail", method = RequestMethod.GET)
	public String detail(@RequestParam("id") String id, Model model) {
		KW_DTO_MB_1000MT dto = serv.getMemberId(id);
		
		System.out.println("id = " + id);
		System.out.println("dto = " + dto);
		
		model.addAttribute("dto", dto);
		
		return "/login/memberdatail";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String detailedit(
			@RequestParam("id")
			String id,
			Model model) {
		KW_DTO_MB_1000MT dto = serv.getMemberId(id);
		
		System.out.println("맴버정보수정 작동테스트");
				
		model.addAttribute("dto", dto);
		
		return "/login/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(
			@ModelAttribute	KW_DTO_MB_1000MT dto,
//			@RequestParam String id,
			Model model) {
		
//		KW_DTO_MB_1000MT dto = serv.getMemberId(id);
		
		System.out.println("dto = " + dto);
		
		int result = serv.updateMember(dto);
		model.addAttribute("dto", dto);
		System.out.println("🔧 업데이트 결과: " + result);
		
		return "redirect:/memberdatail?id=" + dto.getId();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") String id) {
		int result = serv.delete(id);  // 글 삭제
		System.out.println("result : " + result);
	    return "redirect:/member"; // 목록으로 이동
	}
	    
	@RequestMapping(value = "/login", method = RequestMethod.GET) // 로그인 인증프로세스 만들거임(미개봉)
	public String oneMember(
			@ModelAttribute
//			KW_DTO_MB_1000MT dto
			String id) {
		System.out.println("login창 들어간다능");
		
		KW_DTO_MB_1000MT result = serv.getMemberId(id);
		
		System.out.println("result : " + result);
		
		return "/login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProcess(
	        @RequestParam("id") String id,
	        @RequestParam("pw") String pw,
	        HttpSession session,
	        Model model) {

	    System.out.println("🛂 로그인 시도: " + id + "/" + pw);

	    KW_DTO_MB_1000MT user = serv.getMemberId(id); // DB에서 해당 ID 조회
	    System.out.println("user : "+user);

	    if (user != null && user.getPw().equals(pw)) {
	        System.out.println("✅ 로그인 성공");
	        session.setAttribute("ID", user); // 세션 저장
	        return "redirect:/"; // 로그인 후 메인 페이지로 이동
	    } else {
	        System.out.println("❌ 로그인 실패");
	        model.addAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
	        return "/login/login"; // 다시 로그인 페이지로
	    }
	}
}
