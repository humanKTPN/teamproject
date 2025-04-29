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

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;
import kr.or.ktpn.dto.KW_DTO_MB_1000MT;
import kr.or.ktpn.service.KW_Svc_nb_1000mt;

@Controller
public class KW_Ctrl_nboard_1000mt {

	@Autowired
	KW_Svc_nb_1000mt serv;
	
	@RequestMapping(value = "/nwriteview_Nam", method = RequestMethod.GET)
	public String detailcontents(@RequestParam("BRD_NO") int BRD_NO, String BOARDFN, Model model) {
		KW_DTO_BR_1000MT dto = serv.getnbnum(BRD_NO);
		System.out.println("게시글조회 작동테스트");
		
		System.out.println("bn = " +BRD_NO);
//		System.out.println("bn = " +BOARDFN);

		model.addAttribute("dto", dto);
//		model.addAttribute("dto2", dto2);
		
		return "nwriteview_Nam.tiles";
	}
	
	@RequestMapping(value = "/nedit_Nam", method = RequestMethod.GET)
	public String detailctedit(
			@RequestParam("BRD_NO")
			int BRD_NO,
			Model model) {
		KW_DTO_BR_1000MT dto = serv.getnbnum(BRD_NO);
		System.out.println("게시글수정 작동테스트");
		
//		System.out.println("bn = " +tl);

		model.addAttribute("dto", dto);
//		
		return "edit_Nam.tiles";
	}
	
	@RequestMapping(value = "/nedit_Nam", method = RequestMethod.POST)
	public String editprocess(Model model,
			@ModelAttribute	KW_DTO_BR_1000MT dto
//			@RequestParam int BRD_NO
			) {
		
		System.out.println("📥 받은 DTO: " + dto);
	    System.out.println("BRD_NO: " + dto.getBRD_NO());
	    System.out.println("제목: " + dto.getTTL_NM());
	    System.out.println("내용: " + dto.getBRD_DESC());
	    
//		KW_DTO_BR_1000MT dto = serv.getnbnum(BRD_NO);
	    int result = serv.getnbupdate(dto);
		model.addAttribute("dto", dto);
		
		System.out.println("🔧 업데이트 결과: " + result);

		return "redirect:/nwriteview_Nam?BRD_NO=" + dto.getBRD_NO();
	}
	
	@RequestMapping(value = "nwriteprocess_nam", method = RequestMethod.GET)
	public String showWriteForm(
			Model model
			,HttpSession ses
//			@RequestParam("BOARDFN")
//			String BOARDFN
			) {
		KW_DTO_MB_1000MT loginUser = (KW_DTO_MB_1000MT) ses.getAttribute("loginUser");
		model.addAttribute("ID", loginUser);
//	    model.addAttribute("dto", new KW_DTO_BR_1000MT()); // 빈 DTO 넘기기
	    return "writeprocess_nam.tiles"; // 글쓰기 폼 JSP
	}
	
	@RequestMapping(value = "nwriteprocess_nam", method = RequestMethod.POST)
	public String insert(
//			@ModelAttribute KW_DTO_BR_1000MT dto
			@RequestParam("ID")	String ID,
			@RequestParam("BOARDFN") String BOARDFN,
			@RequestParam("TTL_NM")	String TTL_NM,
			@RequestParam("BRD_DESC") String BRD_DESC
			,Model model
			) 
			{
		
		KW_DTO_BR_1000MT dto = new KW_DTO_BR_1000MT();

		dto.setID(ID);
		dto.setBOARDFN(BOARDFN);
		dto.setTTL_NM(TTL_NM);
		dto.setBRD_DESC(BRD_DESC);
		
		dto.setVW_CNT(0);
		dto.setDLT_YN("N");
		
		System.out.println("🌟 글쓰기할 때 DTO에 들어간 ID: " + dto.getID());
		
		int result = serv.insert(dto);  // DB에 글 등록
		
		System.out.println("📥 받은 DTO: " + dto);
		System.out.println("BOARDFN: " + dto.getBOARDFN());
	    System.out.println("BRD_NO: " + dto.getBRD_NO());
	    System.out.println("제목: " + dto.getTTL_NM());
	    System.out.println("내용: " + dto.getBRD_DESC());
	    
	    System.out.println("작성된 글 번호 = " + dto.getBRD_NO()); // null이면 selectKey 안 먹힌 거!
	    
	    System.out.println("🔧 작성 결과: " + result);
	    
	    return "redirect:/nwriteview_Nam?BRD_NO=" + dto.getBRD_NO();  	// 게시판 목록으로 리다이렉트
	    																	// 업데이트한 글을 받은 상세글페이지로 가야할거 같은데...
	}
	
	@RequestMapping(value = "ndelete_Nam", method = RequestMethod.GET)
	public String delete(@RequestParam("BRD_NO") int BRD_NO) {
		int result = serv.delete(BRD_NO);  // 글 삭제
		System.out.println("넘어온 BRD_NO: " + BRD_NO);
		System.out.println("result : " + result);
	    return "redirect:/notice"; // 목록으로 이동
	}
	
	@RequestMapping("/notice")
    public String noticeList(@RequestParam(defaultValue = "1") int page, Model model) {
//		List<KW_DTO_BR_1000MT> list = serv.getnboardlist();
		
		List<KW_DTO_BR_1000MT> list = serv.getBoardPagingList(page);
		System.out.println("list.size : " + list.size());
		
        int totalCount = serv.getTotalBoardCount(); // 전체 글 수
        int pageSize = 10;
        int totalPages = (int) Math.ceil((double) totalCount / pageSize); // 전체 페이지 수 계산
       

        model.addAttribute("list", list);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        
        System.out.println("list : " + list);
        System.out.println("currentPage"+ page);
        System.out.println("totalPages"+ totalPages);

        return "noticeBoard_Nam.tiles"; // JSP 경로
    }
}
