package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ktpn.dto.tb_qa_1100dt_DTO;
import kr.or.ktpn.service.KW_Svc_mb_1000mt;
//import kr.or.ktpn.service.Svc_member;
import kr.or.ktpn.service.Svc_tb_qa_1000dt;
import kr.or.ktpn.service.Svc_tb_qa_1100dt;
import kr.or.ktpn.service.TAK_Svc_pr_1100mt;

@Controller
public class con_QC {

	// 품질관리 컨트롤러

	@Autowired
	Svc_tb_qa_1000dt svc_qa_1000dt;

	@Autowired
	Svc_tb_qa_1100dt svc_qa_1100dt;

	// 멤버 서비스
	@Autowired
	KW_Svc_mb_1000mt svc_mb_1000mt;
	// Svc_member svc_member;

	// 생산 서비스
	@Autowired
	TAK_Svc_pr_1100mt tak_Svc_pr_1100mt;

	// 문제 : 추가 할때 뒤로가기를 한다던가하면 같은 값이 또 입력되서 중복값이 생긴다
	// 해결 : 테이블에 기본키 설정이 안되있었다. 기본키 설정할 것

	// 검색한 품질관리 목록 보여주는 메소드
	@RequestMapping(value = "/searchqc", method = RequestMethod.GET)
	public String searchQc(Model model, tb_qa_1100dt_DTO dto) {

		System.out.println("type : " + dto.getType());
		System.out.println("keyword : " + dto.getKeyword());
		
		List list = svc_qa_1100dt.testSearchQCList(dto);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		

		// 작업자
		List workerList = svc_mb_1000mt.getWorker();

		// 생산완료인 생산코드
		List PcodeList = tak_Svc_pr_1100mt.getPcode();

		model.addAttribute("mList", workerList);
		model.addAttribute("pList", PcodeList);

		return "TestQA_main_park2.tiles";
	}
	
	// 품질관리 목록 보여주는 메소드
	@RequestMapping(value = "/mainqc", method = RequestMethod.GET)
	public String showQc(Model model) {

		List list = svc_qa_1100dt.getSelectQC();
		model.addAttribute("list", list);

		// 작업자
		List workerList = svc_mb_1000mt.getWorker();

		// 생산완료인 생산코드
		List PcodeList = tak_Svc_pr_1100mt.getPcode();

		model.addAttribute("mList", workerList);
		model.addAttribute("pList", PcodeList);

		return "TestQA_main_park2.tiles";
	}

	// 품질관리와 생산을 조인한 결과를 보여주는 메소드
	@RequestMapping(value = "/showjoin", method = RequestMethod.GET)
	public String showJoin(Model model, String pcode) {

		System.out.println("pcode : " + pcode);
		// 소문자로 인식해서 검색이 안된다 s0001 => S0001 대문자로 바꾸기 -> 완료

		List list = svc_qa_1100dt.getJoinQC(pcode);
		System.out.println("list : " + list);

		model.addAttribute("QcList", list);

		return "TestQA_report_park_table_show2.tiles";
	}

	// 품질관리에서 목록에 추가하는 메소드
	@RequestMapping(value = "/addqc", method = RequestMethod.POST)
	public String addQc(Model model, tb_qa_1100dt_DTO dto) {

		System.out.println("dto : " + dto);

		int i = svc_qa_1100dt.getInsertQC(dto);
		System.out.println("QC테이블에 " + i + "행이 삽입되었습니다");

//		return "TestQA_report_park_table_show2.tiles";
		return "redirect: mainqc";
	}

	// 품질관리에서 수정 페이지로 이동하는 메소드
	@RequestMapping(value = "/updateqc", method = RequestMethod.POST)
	public String updateQc(Model model,

			tb_qa_1100dt_DTO dto, String updateCode) {

		System.out.println("수정 할 updateCode : " + updateCode);

		// System.out.println("수정 할 데이터 dto : " + dto);

		dto = svc_qa_1100dt.getSelectQCone(updateCode);
		System.out.println("수정 할 데이터 dto : " + dto);
		model.addAttribute("dto", dto);

		// 작업자
		List workerList = svc_mb_1000mt.getWorker();

		// 생산완료인 생산코드
		// List PcodeList = tak_Svc_pr_1100mt.getPcode();

		model.addAttribute("mList", workerList);
		// model.addAttribute("pList", PcodeList);

		return "TestQA_report_park_table_update2.tiles";
	}

	// 품질관리에서 목록에 수정하는 메소드
	@RequestMapping(value = "/updateqc1", method = RequestMethod.POST)
	public String updateQc1(Model model, tb_qa_1100dt_DTO dto) {

		System.out.println("dto : " + dto);

		int i = svc_qa_1100dt.getUpdateQC(dto);
		System.out.println("QC테이블에 " + i + "행이 수정되었습니다");

//		return "TestQA_report_park_table_show2.tiles";
		return "redirect: mainqc";
	}

	// 품질관리에서 목록에 삭제하는 메소드
	@ResponseBody
	@RequestMapping(value = "/deleteqc", method = RequestMethod.POST)
	public int removeQc(tb_qa_1100dt_DTO dto, 
			
			@RequestBody
			String[] delcode) {

		// System.out.println("delcode : " + delcode);
		System.out.println("delcode.length : " + delcode.length);

		int cnt = 0;
		for (int j = 0; j < delcode.length; j++) {

			dto.setProd_cd(delcode[j]);
			System.out.println("dto : " + dto);
			int i = svc_qa_1100dt.getDeleteQC(dto);
			cnt++;
		}

		System.out.println("QC테이블에 " + cnt + "행이 삭제되었습니다");

//		return "TestQA_report_park_table_show2.tiles";
		return cnt;
	}

}
