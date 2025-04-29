package kr.or.ktpn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ktpn.dto.tb_fs_1000ht_DTO;
import kr.or.ktpn.dto.tb_fs_1000mt_DTO;
import kr.or.ktpn.dto.tb_mr_1000ht_DTO;
import kr.or.ktpn.dto.tb_mr_1000mt_DTO;
import kr.or.ktpn.dto.tb_od_1000mt_DTO;
import kr.or.ktpn.service.KW_Svc_mb_1000mt;
import kr.or.ktpn.service.Svc_md_1000mt;
//import kr.or.ktpn.service.Svc_member;
import kr.or.ktpn.service.Svc_tb_fs_1000ht;
import kr.or.ktpn.service.Svc_tb_fs_1000mt;
import kr.or.ktpn.service.Svc_tb_mr_1000ht;
import kr.or.ktpn.service.Svc_tb_mr_1000mt;
import kr.or.ktpn.service.Svc_tb_od_1000mt;
import kr.or.ktpn.service.TAK_Svc_pr_1100mt;

@Controller
public class con_PMm {

	// 완제품, 원자재, 거래처 컨트롤러

	@Autowired
	Svc_tb_od_1000mt svc_od_1000mt;

	@Autowired
	Svc_tb_mr_1000mt svc_mr_1000mt;

	@Autowired
	Svc_tb_mr_1000ht svc_mr_1000ht;

	@Autowired
	Svc_tb_fs_1000mt svc_fs_1000mt;

	@Autowired
	Svc_tb_fs_1000ht svc_fs_1000ht;
	
	
	
	// 멤버 서비스
	@Autowired
	KW_Svc_mb_1000mt svc_mb_1000mt;
	//Svc_member svc_member;
	
	// 기준관리 서비스
	@Autowired
	Svc_md_1000mt svc_md_1000mt;
	
	// 생산 서비스
	@Autowired
	TAK_Svc_pr_1100mt tak_Svc_pr_1100mt;
	

	// 검색한 거래처 보여주는 메소드
	@RequestMapping(value = "/searchorder", method = RequestMethod.GET)
	public String searchCompany(Model model, tb_od_1000mt_DTO dto) {

		System.out.println("type : " + dto.getType());
		System.out.println("keyword : " + dto.getKeyword());
			
		List list = svc_od_1000mt.testSearchCompanyList(dto);
		model.addAttribute("companyList", list);
		model.addAttribute("dto", dto);

		return "TestMM_order_park.tiles";
	}
	
	// 거래처 보여주는 메소드
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String showCompany(Model model) {

		List list = svc_od_1000mt.getCompanyList();
		model.addAttribute("companyList", list);

		return "TestMM_order_park.tiles";
	}
	
	// 검색한 완제품 로그 보여주는 메소드
	@RequestMapping(value = "/searchplog", method = RequestMethod.GET)
	public String searchPlog(Model model, tb_fs_1000ht_DTO dto, String Pday) {

		System.out.println("type : " + dto.getType());
		System.out.println("keyword : " + dto.getKeyword());
		System.err.println("Pday : " + Pday);
		Pday = Pday.replace("-", "");
		System.err.println("Pday : " + Pday);
		dto.setChng_dt(Pday);
		System.out.println("dto.Chng_dt : " + dto.getChng_dt());
		
		List list = svc_fs_1000ht.testSearchPlog(dto);
		model.addAttribute("plogList", list);
		model.addAttribute("dto", dto);
		
		return "TestMM_main_park_pLog.tiles";
	}

	// 완제품 로그 보여주는 메소드
	@RequestMapping(value = "/plog", method = RequestMethod.GET)
	public String showPlog(Model model) {

		List list = svc_fs_1000ht.getPlog();
		model.addAttribute("plogList", list);

		return "TestMM_main_park_pLog.tiles";
	}
	
	// 검색한 원자재 로그 보여주는 메소드
	@RequestMapping(value = "/searchmlog", method = RequestMethod.GET)
	public String searchMlog(Model model, tb_mr_1000ht_DTO dto, String Mday) {

		System.out.println("type : " + dto.getType());
		System.out.println("keyword : " + dto.getKeyword());
		System.err.println("Mday : " + Mday);
		Mday = Mday.replace("-", "");
		System.err.println("Mday : " + Mday);
		dto.setChng_dt(Mday);
		System.out.println("dto.Chng_dt : " + dto.getChng_dt());
		
		List list = svc_mr_1000ht.testSearchMlog(dto);
		model.addAttribute("mLogList", list);
		model.addAttribute("dto", dto);
		
		return "TestMM_main_park_mLog.tiles";
	}

	// 원자재 로그 보여주는 메소드
	@RequestMapping(value = "/mlog", method = RequestMethod.GET)
	public String showMlog(Model model) {

		List list = svc_mr_1000ht.getMlog();
		model.addAttribute("mLogList", list);

		return "TestMM_main_park_mLog.tiles";
	}
	
	// 검색한 원자재, 완제품 목록 보여주는 메소드
	@RequestMapping(value = "/searchList", method = RequestMethod.GET)
	public String searchM_P(tb_mr_1000mt_DTO dto, 
							 tb_fs_1000mt_DTO dto1,
							 Model model) {

		
		
		System.out.println("type : " + dto.getType());
		System.out.println("keyword : " + dto.getKeyword());
		
		System.out.println("type : " + dto1.getType());
		System.out.println("keyword : " + dto1.getKeyword());
		
		List list1 = svc_mr_1000mt.testgetMataterialSearchList(dto);
		//Map<String, Object> map = svc_mr_1000mt.getMataterialSearchList(dto);
			
			
		//dto = (tb_mr_1000mt_DTO) list1.get(0);

		List list2 = svc_fs_1000mt.testgetProductSearchList(dto1);

		model.addAttribute("MtableSelect", list1);
		model.addAttribute("dto", dto);
		model.addAttribute("PtableSelect", list2);

		return "TestMM_main2_park.tiles";
	}

	// 원자재, 완제품 목록 보여주는 메소드
	@RequestMapping(value = "/mainmp", method = RequestMethod.GET)
	public String showM_P(tb_mr_1000mt_DTO dto, Model model) {

		//Map<String, Object> map
		
		List list1 = svc_mr_1000mt.getMaterials();
		//List list1 = svc_mr_1000mt.getMataterialSearchList(dto);
		
		
		//dto = (tb_mr_1000mt_DTO) list1.get(0);

		List list2 = svc_fs_1000mt.getProducts();

		model.addAttribute("MtableSelect", list1);
		//model.addAttribute("dto", dto);
		model.addAttribute("PtableSelect", list2);

		return "TestMM_main2_park.tiles";
	}

	
	
	
	
	
	
	
	
	
	// 테스트 페이지(원자재추가) - 작업자, 원자재 코드, 원자재명 보여주는 메소드
	@RequestMapping(value = "/addm1", method = RequestMethod.GET)
	public String addM1(Model model) {
		
		// 작업자
		List workerList = svc_mb_1000mt.getWorker();
		
		// 기준관리 - 원자재 코드, 원자재명
		List McodeList = svc_md_1000mt.getMcodeList();
		
		model.addAttribute("mList", workerList);
		model.addAttribute("mcList", McodeList);

		return "TestMM_add2_park.tiles";
	}
	
	// 원자재 현황, 원자재로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/addm2", method = RequestMethod.POST)
	public String addM2(tb_mr_1000ht_DTO mlogdto) {
		
		List list = new ArrayList();
		tb_mr_1000mt_DTO mdto = new tb_mr_1000mt_DTO();
		boolean check = false;		// true면 로그 작동
		int i = 0;
		
		// 받는 dto는 로그 dto
		System.out.println("받은 데이터 : " + mlogdto);
		
		if("i".equals(mlogdto.getIob_se_cd())) {		// 입고일 경우
			list = svc_mr_1000mt.getMaterials(mlogdto.getMtrl_cd());
			
			if(list.size() == 0) {		// 원자재 현황테이블에 데이터가 없을 경우
				mdto.setMtrl_cd(mlogdto.getMtrl_cd());
				mdto.setMtrl_nm(mlogdto.getMtrl_nm());
				mdto.setStn_cnt(1000);
				mdto.setCrnt_aftr_cnt(0 + mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
				
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				
				i = svc_mr_1000mt.insertMaterials(mdto);
				System.out.println("입력한 데이터 : " + mdto);
				System.out.println("원자재 현황 테이블에 " + i + "행이 삽입되었습니다");
				
				if(i > 0) {
					check = true;
				}
			} else {					// 원자재 현황테이블에 데이터가 있을 경우
				mdto = (tb_mr_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터 : " + mdto);
				
				mdto.setMtrl_nm(mlogdto.getMtrl_nm());
				mdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt() + mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
				
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				System.out.println("수정 후 데이터 : " + mdto);

				if(mdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(mdto.getCrnt_aftr_cnt() >= 0) {
					i = svc_mr_1000mt.updateMaterials(mdto);
					System.out.println("원자재 현황 테이블에 " + i + "행이 수정되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
		}
		else if("o".equals(mlogdto.getIob_se_cd())) { 		// 출고일 경우
			list = svc_mr_1000mt.getMaterials(mlogdto.getMtrl_cd());
			
			if(list.size() == 0) {
				System.out.println("오류! 데이터가 없습니다");
			} else {
				mdto = (tb_mr_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터 : " + mdto);
				
				mdto.setMtrl_nm(mlogdto.getMtrl_nm());
				mdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt() - mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
			
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				System.out.println("수정 후 데이터 : " + mdto);
				
				if(mdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(mdto.getCrnt_aftr_cnt() >= 0) {
					i = svc_mr_1000mt.updateMaterials(mdto);
					System.out.println("원자재 현황 테이블에 " + i + "행이 수정되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
			
		}
		
		if(check == true) {
			mlogdto.setStn_cnt(mdto.getStn_cnt());
			mlogdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt());
			mlogdto.setOrdr_rqrd_yn(mdto.getOrdr_rqrd_yn());
			
			mlogdto.setChng_dt(mlogdto.getChng_dt().replace("-", ""));
			
			System.out.println("Mlog 데이터 : " + mlogdto);

			i = svc_mr_1000ht.insertMlog(mlogdto);
			System.out.println("원자재 로그테이블에 " + i + "행이 삽입되었습니다");

		}
		

		return "redirect: mainmp";
	}
	
	// 테스트 페이지(원자재수정) - 작업자, 원자재 코드, 원자재명 보여주는 메소드
	@RequestMapping(value = "/updatem1", method = RequestMethod.GET)
	public String updateM1(Model model, String mcode) {
		
		System.out.println("mcode : " + mcode);
		
		// 작업자
		List workerList = svc_mb_1000mt.getWorker();
			
		// 수정할 리스트
		List materials = svc_mr_1000mt.getMaterials(mcode);
		System.out.println("materials : " + materials);

		// 수정할 dto
		tb_mr_1000mt_DTO dto = new tb_mr_1000mt_DTO();
		dto = (tb_mr_1000mt_DTO) materials.get(0);
		System.out.println("dto : " + dto);
		
		
		model.addAttribute("mList", workerList);
		model.addAttribute("dto", dto);
		

		return "TestMM_update_park.tiles";
	}
		
	// 원자재 현황 수정, 원자재로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/updatem2", method = RequestMethod.POST)
	public String updateM2(tb_mr_1000ht_DTO mlogdto) {
			
		List list = new ArrayList();
		tb_mr_1000mt_DTO mdto = new tb_mr_1000mt_DTO();
		boolean check = false;		// true면 로그 작동
		int i = 0;
		
		// 받는 dto는 로그 dto
		System.out.println("받은 데이터 : " + mlogdto);
		
		if("i".equals(mlogdto.getIob_se_cd())) {		// 입고일 경우
			list = svc_mr_1000mt.getMaterials(mlogdto.getMtrl_cd());
			
			if(list.size() == 0) {		// 원자재 현황테이블에 데이터가 없을 경우
				mdto.setMtrl_cd(mlogdto.getMtrl_cd());
				mdto.setMtrl_nm(mlogdto.getMtrl_nm());
				mdto.setStn_cnt(1000);
				mdto.setCrnt_aftr_cnt(0 + mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
				
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				
				i = svc_mr_1000mt.insertMaterials(mdto);
				System.out.println("입력한 데이터 : " + mdto);
				System.out.println("원자재 현황 테이블에 " + i + "행이 삽입되었습니다");
				
				if(i > 0) {
					check = true;
				}
			} else {					// 원자재 현황테이블에 데이터가 있을 경우
				mdto = (tb_mr_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터 : " + mdto);
				
				mdto.setMtrl_nm(mlogdto.getMtrl_nm());
				mdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt() + mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
				
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				System.out.println("수정 후 데이터 : " + mdto);

				if(mdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(mdto.getCrnt_aftr_cnt() >= 0) {
					i = svc_mr_1000mt.updateMaterials(mdto);
					System.out.println("원자재 현황 테이블에 " + i + "행이 수정되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
		}
		else if("o".equals(mlogdto.getIob_se_cd())) { 		// 출고일 경우
			list = svc_mr_1000mt.getMaterials(mlogdto.getMtrl_cd());
			
			if(list.size() == 0) {
				System.out.println("오류! 데이터가 없습니다");
			} else {
				mdto = (tb_mr_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터 : " + mdto);
				
				mdto.setMtrl_nm(mlogdto.getMtrl_nm());
				mdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt() - mlogdto.getCrnt_cnt());
				mdto.setMtrl_loc_nm(mlogdto.getMtrl_cd_nm());
			
				if(mdto.getCrnt_aftr_cnt() <= mdto.getStn_cnt()) {
					mdto.setOrdr_rqrd_yn("Y");
				} else {
					mdto.setOrdr_rqrd_yn("N");					
				}
				System.out.println("수정 후 데이터 : " + mdto);
				
				if(mdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(mdto.getCrnt_aftr_cnt() > 0) {
					i = svc_mr_1000mt.updateMaterials(mdto);
					System.out.println("원자재 현황 테이블에 " + i + "행이 수정되었습니다");
					
					if(i > 0) {
						check = true;
					}
				} else {		// 변동 후 수량이 0이면 삭제
					i = svc_mr_1000mt.deleteMaterials(mdto);
					System.out.println("원자재 현황 테이블에 " + i + "행이 삭제되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
			
		}
		
		if(check == true) {
			mlogdto.setStn_cnt(mdto.getStn_cnt());
			mlogdto.setCrnt_aftr_cnt(mdto.getCrnt_aftr_cnt());
			mlogdto.setOrdr_rqrd_yn(mdto.getOrdr_rqrd_yn());
			
			mlogdto.setChng_dt(mlogdto.getChng_dt().replace("-", ""));
			
			System.out.println("Mlog 데이터 : " + mlogdto);

			i = svc_mr_1000ht.insertMlog(mlogdto);
			System.out.println("원자재 로그테이블에 " + i + "행이 삽입되었습니다");

		}

		return "redirect: mainmp";
	}
	
	
	
	
	// 테스트 페이지(완제품추가) - 작업자, 생산완료인 완제품 코드, 완제품명 보여주는 메소드
	@RequestMapping(value = "/addp1", method = RequestMethod.GET)
	public String addP1(Model model) {
			
		// 작업자
		List workerList = svc_mb_1000mt.getWorker();
			
		// 생산 - 생산코드, 완제품 코드, 완제품명
		List PcodeList = tak_Svc_pr_1100mt.getPcode();
		
		model.addAttribute("mList", workerList);
		model.addAttribute("pList", PcodeList);

		return "TestMM_addP2_park.tiles";
	}
	
	// 생산완료인 완제품 현황, 완제품로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/addp2", method = RequestMethod.POST)
	public String addP2(tb_fs_1000ht_DTO plogdto) {
				
		List list = new ArrayList();
		tb_fs_1000mt_DTO pdto = new tb_fs_1000mt_DTO();
		boolean check = false;		// true면 로그 작동
		int i = 0;
		
		// 받는 dto는 로그 dto
		System.out.println("받은 데이터 : " + plogdto);
		
		if("i".equals(plogdto.getIob_se_cd())) {
			list = svc_fs_1000mt.getProducts(plogdto.getFnsh_code());
			System.out.println("list : " + list);
			
			if(list.get(0) == null) {
				pdto.setFnsh_code(plogdto.getFnsh_code());
				pdto.setFnsh_nm(plogdto.getFnshd_item_nm());
				pdto.setCrnt_aftr_cnt(0 + plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				System.out.println("pdto : " + pdto);
				
				i = svc_fs_1000mt.insertProducts(pdto);
				System.out.println("완제품 현황 테이블에 " + i + "행이 삽입되었습니다");

				if(i > 0) {
					check = true;
				}
			} else {				
				pdto = (tb_fs_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터: " + pdto);

				pdto.setFnsh_nm(plogdto.getFnshd_item_nm());
				pdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt() + plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				i = svc_fs_1000mt.updateProducts(pdto);
				System.out.println("완제품 현황 테이블에 " + i + "행이 수정되었습니다");
				System.out.println("수정 후 데이터: " + pdto);

				
				if(i > 0) {
					check = true;
				}
			}
				
		} else if("o".equals(plogdto.getIob_se_cd())) {
			list = svc_fs_1000mt.getProducts(plogdto.getFnsh_code());

			if(list.size() == 0) {
				System.out.println("오류! 데이터가 없습니다");
			} else {
				pdto = (tb_fs_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터: " + pdto);

				pdto.setFnsh_nm(plogdto.getFnshd_item_nm());
				pdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt() - plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				if(pdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(pdto.getCrnt_aftr_cnt() > 0) {
					i = svc_fs_1000mt.updateProducts(pdto);
					System.out.println("완제품 현황 테이블에 " + i + "행이 수정되었습니다");
				
					if(i > 0) {
						check = true;
					}
				} else {
					i = svc_fs_1000mt.deleteProducts(pdto);
					System.out.println("완제품 현황 테이블에 " + i + "행이 삭제되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
		}
			
		if(check == true) {
			plogdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt());
			plogdto.setChng_dt(plogdto.getChng_dt().replace("-", ""));
			
			System.out.println("Plog 데이터 : " + plogdto);

			i = svc_fs_1000ht.insertPlog(plogdto);
			System.out.println("완제품 로그테이블에 " + i + "행이 삽입되었습니다");

		}
		
		return "redirect: mainmp";
	}
	
	// 테스트 페이지(완제품수정) - 작업자, 생산완료인 완제품 코드, 완제품명 보여주는 메소드
	@RequestMapping(value = "/updatep1", method = RequestMethod.GET)
	public String updateP1(Model model, String fcode) {
				
		System.out.println("fcode : " + fcode);
		
		// 작업자
		List workerList = svc_mb_1000mt.getWorker();
				
		// 생산 - 완제품코드가 fcode인 생산이 완료된 생산코드
		List PFcodeList = tak_Svc_pr_1100mt.getPFcode(fcode);
		
		// 선택한 완제품코드
		List fpList = svc_fs_1000mt.getProducts(fcode);
		System.out.println("fpList : " + fpList);
		tb_fs_1000mt_DTO dto = (tb_fs_1000mt_DTO) fpList.get(0);
		System.out.println("dto : " + dto);
			
		model.addAttribute("mList", workerList);
		model.addAttribute("pList", PFcodeList);
		model.addAttribute("dto", dto);

		return "TestMM_updateP_park.tiles";
	}
		
	// 생산완료인 완제품 현황 수정, 완제품로그 추가하는 메소드 - 테스트 페이지
	@RequestMapping(value = "/updatep2", method = RequestMethod.POST)
	public String updateP2(tb_fs_1000ht_DTO plogdto) {
				
		List list = new ArrayList();
		tb_fs_1000mt_DTO pdto = new tb_fs_1000mt_DTO();
		boolean check = false;		// true면 로그 작동
		int i = 0;
		
		// 받는 dto는 로그 dto
		System.out.println("받은 데이터 : " + plogdto);
		
		if("i".equals(plogdto.getIob_se_cd())) {
			list = svc_fs_1000mt.getProducts(plogdto.getFnsh_code());
			
			if(list == null) {
				pdto.setFnsh_code(plogdto.getFnsh_code());
				pdto.setFnsh_nm(plogdto.getFnshd_item_nm());
				pdto.setCrnt_aftr_cnt(0 + plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				i = svc_fs_1000mt.insertProducts(pdto);
				System.out.println("완제품 현황 테이블에 " + i + "행이 삽입되었습니다");

				if(i > 0) {
					check = true;
				}
			} else {				
				pdto = (tb_fs_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터: " + pdto);

				pdto.setFnsh_nm(plogdto.getFnshd_item_nm());
				pdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt() + plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				i = svc_fs_1000mt.updateProducts(pdto);
				System.out.println("완제품 현황 테이블에 " + i + "행이 수정되었습니다");
				System.out.println("수정 후 데이터: " + pdto);

				
				if(i > 0) {
					check = true;
				}
			}
				
		} else if("o".equals(plogdto.getIob_se_cd())) {
			list = svc_fs_1000mt.getProducts(plogdto.getFnsh_code());

			if(list.size() == 0) {
				System.out.println("오류! 데이터가 없습니다");
			} else {
				pdto = (tb_fs_1000mt_DTO) list.get(0);
				System.out.println("수정 전 데이터: " + pdto);

				pdto.setFnsh_nm(plogdto.getFnshd_item_nm());
				pdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt() - plogdto.getCrnt_cnt());
				pdto.setFnsh_loc_nm(plogdto.getFnshl_loc_nm());
				
				if(pdto.getCrnt_aftr_cnt() < 0) {
					System.out.println("오류! 출고할 수량이 현재 수량보다 많습니다");
				} else if(pdto.getCrnt_aftr_cnt() > 0) {
					i = svc_fs_1000mt.updateProducts(pdto);
					System.out.println("완제품 현황 테이블에 " + i + "행이 수정되었습니다");
				
					if(i > 0) {
						check = true;
					}
				} else {
					i = svc_fs_1000mt.deleteProducts(pdto);
					System.out.println("완제품 현황 테이블에 " + i + "행이 삭제되었습니다");
					
					if(i > 0) {
						check = true;
					}
				}
			}
		}
			
		if(check == true) {
			plogdto.setCrnt_aftr_cnt(pdto.getCrnt_aftr_cnt());
			plogdto.setChng_dt(plogdto.getChng_dt().replace("-", ""));
			
			System.out.println("Plog 데이터 : " + plogdto);

			i = svc_fs_1000ht.insertPlog(plogdto);
			System.out.println("완제품 로그테이블에 " + i + "행이 삽입되었습니다");

		}

		return "redirect: mainmp";
	}
	
	
	
	
	
	
	
	
	

	// 원자재 현황, 원자재로그 추가하는 메소드
	@RequestMapping(value = "/addm", method = RequestMethod.POST)
	public String addM() {

		return "redirect: mainmp";
	}

	// 원자재 현황 수정, 원자재로그 추가하는 메소드
	@RequestMapping(value = "/updatem", method = RequestMethod.POST)
	public String updateM() {

		return "redirect: mainmp";
	}

	// 원자재 현황 입력취소(undo), 원자재로그 수정, 원자재로그 추가하는 메소드
	@ResponseBody
	@RequestMapping(value = "/undom", method = RequestMethod.POST)
	public int undoM(
			@RequestBody
			String undoCheck) {
		
		undoCheck = undoCheck.substring(1, 6);
		System.out.println("Mcode : " + undoCheck);
		System.out.println("Mcode.length : " + undoCheck.length());
		
		int i = 0;
		tb_mr_1000ht_DTO dto = new tb_mr_1000ht_DTO();
		tb_mr_1000mt_DTO mdto = new tb_mr_1000mt_DTO();
		
		// 잘못 입력한 로그의 원자재code 
		dto.setMtrl_cd(undoCheck);
		// 마지막 로그 
		dto.setFindlognum(1);
		
		System.out.println("dto : " + dto);
		// 마지막 로그 찾기
		List list = svc_mr_1000ht.getLastMlog(dto);
		System.out.println("잘못 입력한 데이터 로그 : " + list.get(0));
		
		// 잘못 입력한 로그의 비고 데이터 수정
		dto = (tb_mr_1000ht_DTO) list.get(0);
		dto.setRmrk("데이터 입력이 잘못되었음");
		i = svc_mr_1000ht.updateMlog(dto);
		
		// dto 초기화
		//dto = null;
		System.out.println("dto : " + dto);
		
		// 잘못 입력한 로그의 원자재code
		dto.setMtrl_cd(undoCheck);
		// 마지막 로그의 바로 전 로그
		dto.setFindlognum(2);
		
		// 마지막 로그의 바로 전 로그 찾기
		list = svc_mr_1000ht.getLastMlog(dto);
		System.out.println("잘못 입력한 로그의 전 로그 : " + list.get(0));
		// 잘못 입력한 로그의 전 로그 데이터 복사
		dto = (tb_mr_1000ht_DTO) list.get(0);
		dto.setRmrk("이전 로그로 롤백");
		
		// 원자재 현황 dto에 복사한 원자재 로그 dto의 값 넣기
		mdto.setMtrl_cd(dto.getMtrl_cd());
		mdto.setMtrl_nm(dto.getMtrl_nm());
		mdto.setStn_cnt(dto.getStn_cnt());
		mdto.setOrdr_rqrd_yn(dto.getOrdr_rqrd_yn());
		mdto.setMtrl_loc_nm(dto.getMtrl_cd_nm());
		mdto.setCrnt_aftr_cnt(dto.getCrnt_aftr_cnt());
		
		System.out.println("정상 입력값 - 로그 : " + dto);
		System.out.println("정상 입력값 - 현황 : " + mdto);
		
		i = svc_mr_1000mt.updateMaterials(mdto);
		System.out.println("원자재 현황테이블에 " + i + "행이 수정되었습니다");

		i = svc_mr_1000ht.insertMlog(dto);
		System.out.println("원자재 로그테이블에 " + i + "행이 삽입되었습니다");
		
		return i;
		//return "redirect: mainmp";
	}

	// 원자재 현황 삭제, 원자재로그 추가하는 메소드
	@RequestMapping(value = "/deletem", method = RequestMethod.POST)
	public String deleteM() {

		return "redirect: mainmp";
	}

	// 완제품 현황, 완제품로그 추가하는 메소드
	@RequestMapping(value = "/addp", method = RequestMethod.POST)
	public String addP() {

		return "redirect: mainmp";
	}

	// 완제품 현황 수정, 완제품로그 추가하는 메소드
	@RequestMapping(value = "/updatep", method = RequestMethod.POST)
	public String updateP() {

		return "redirect: mainmp";
	}

	// 완제품 현황 입력취소(undo), 완제품로그 수정, 완제품로그 추가하는 메소드
	@ResponseBody
	@RequestMapping(value = "/undop", method = RequestMethod.POST)
	public int undoP(
			@RequestBody
			String undoCheck) {
		
		undoCheck = undoCheck.substring(1, 6);
		System.out.println("fcode : " + undoCheck);
		System.out.println("fcode.length : " + undoCheck.length());
		
		int i = 0;
		tb_fs_1000ht_DTO dto = new tb_fs_1000ht_DTO();
		tb_fs_1000mt_DTO pdto = new tb_fs_1000mt_DTO();
		
		// 잘못 입력한 로그의 완제품code
		dto.setFnsh_code(undoCheck);
		// 마지막 로그
		dto.setFindlognum(1);
		
		System.out.println("dto : " + dto);
		List list = svc_fs_1000ht.getLastPlog(dto);
		System.out.println("잘못 입력한 데이터 로그 : " + list.get(0));

		// 잘못 입력한 로그의 비고 데이터 수정
		dto = (tb_fs_1000ht_DTO) list.get(0);
		dto.setRmrk("데이터 입력이 잘못되었음");
		i = svc_fs_1000ht.updatePlog(dto);
		
		// dto 초기화
		//dto = null;
		System.out.println("dto : " + dto);
		
		// 잘못 입력한 로그의 완제품code
		dto.setFnsh_code(undoCheck);
		// 마지막 로그의 바로 전 로그
		dto.setFindlognum(2);
		
		// 마지막 로그의 바로 전 로그 찾기
		list = svc_fs_1000ht.getLastPlog(dto);
		System.out.println("잘못 입력한 로그의 전 로그 : " + list.get(0));
		// 잘못 입력한 로그의 전 로그 데이터 복사
		dto = (tb_fs_1000ht_DTO) list.get(0);
		dto.setRmrk("이전 로그로 롤백");
		
		// 완제품 현황 dto에 복사한 완제품 로그 dto의 값 넣기
		pdto.setFnsh_code(dto.getFnsh_code());
		pdto.setFnsh_nm(dto.getFnshd_item_nm());
		pdto.setFnsh_loc_nm(dto.getFnshl_loc_nm());
		pdto.setCrnt_aftr_cnt(dto.getCrnt_aftr_cnt());
		
		System.out.println("정상 입력값 - 로그 : " + dto);
		System.out.println("정상 입력값 - 현황 : " + pdto);
		
		i = svc_fs_1000mt.updateProducts(pdto);
		System.out.println("완제품 현황테이블에 " + i + "행이 수정되었습니다");
		
		i = svc_fs_1000ht.insertPlog(dto);
		System.out.println("완제품 로그테이블에 " + i + "행이 삽입되었습니다");
		
		
		//return "redirect: mainmp";
		return i;
	}

	// 완제품 현황 삭제, 완제품로그 추가하는 메소드
	@RequestMapping(value = "/deletep", method = RequestMethod.POST)
	public String deleteP() {

		return "redirect: mainmp";
	}
	
	/* 
	 * 입력한(add, update) 데이터 받을 때 어느 dto로 받아올지 생각, 
	 * 또는 2차 프로젝트처럼 httprequestparam으로 받아서 dto에 따로 넣을지
	 *  ajax 사용할 곳 찾아보기
	 *  */ 
	// crud 끝나고 해야할 것 -> 검색 기능, 페이징 처리
}
