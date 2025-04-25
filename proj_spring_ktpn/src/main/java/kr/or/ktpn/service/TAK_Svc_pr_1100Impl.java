package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.TAK_PR_1100MTDAO;
import kr.or.ktpn.dto.TAK_PR_1100MTDTO;

@Service
public class TAK_Svc_pr_1100Impl implements TAK_Svc_pr_1100mt {

	@Autowired
	TAK_PR_1100MTDAO tb_pr_1100MTDAO;

	@Override
	public List selectDAO() {

		List PR_1100MTSVC = tb_pr_1100MTDAO.selectDTO();
		System.out.println("PR_1100MTSVC : "+PR_1100MTSVC);
		return PR_1100MTSVC;
	}

	@Override
	public List selectDAO_A() {
		List PR_1100MTSVC_A = tb_pr_1100MTDAO.selectDTO_A();
		System.out.println("PR_1100MTSVC_A : "+PR_1100MTSVC_A);
		return PR_1100MTSVC_A;
	}

	@Override
	public List selectDAO_B() {
		List PR_1100MTSVC_B = tb_pr_1100MTDAO.selectDTO_B();
		System.out.println("PR_1100MTSVC_B : "+PR_1100MTSVC_B);
		return PR_1100MTSVC_B;
	}

	@Override
	public List selectDAO_C() {
		List PR_1100MTSVC_C = tb_pr_1100MTDAO.selectDTO_C();
		System.out.println("PR_1100MTSVC_C : "+PR_1100MTSVC_C);
		return PR_1100MTSVC_C;
	}
//insert
	@Override
	public int insertDAO(TAK_PR_1100MTDTO dto) {
		int PR_1100MTSVC = tb_pr_1100MTDAO.insertDTO(dto);
		System.out.println("PR_1100MTSVC : "+PR_1100MTSVC);
		return PR_1100MTSVC;
	}
	
//	pm_popup 수정
	@Override
	public int updateDAO(TAK_PR_1100MTDTO dto) {
		int PR_1100MTSVC_update = tb_pr_1100MTDAO.updateDTO(dto);
		System.out.println("PR_1100MTSVC_update : "+PR_1100MTSVC_update);
		return PR_1100MTSVC_update;
	}
//	pm_popup 완료
	@Override
	public int completeDAO(TAK_PR_1100MTDTO dto) {
		int PR_1100MTSVC_update = tb_pr_1100MTDAO.completeDTO(dto);
		System.out.println("PR_1100MTSVC_update : "+PR_1100MTSVC_update);
		return PR_1100MTSVC_update;
	}
	
	//생산관리관련 데이터
//	 작업중
	 @Override
	 public List selectDAO_Y() {
		 
		 List PR_1000MTSVC = tb_pr_1100MTDAO.selectDTO_Y();
		 System.out.println("PR_1000MTSVC : "+PR_1000MTSVC);
		 return PR_1000MTSVC;
	 }
	
	
	 
	 
	 
	// 생산완료인 생산코드 가져오는 메소드
	@Override
	public List getPcode() {
		// TODO Auto-generated method stub
			
		System.out.println("service pr_1100mt selectPcode");
		List list = tb_pr_1100MTDAO.selectPcode();
		System.out.println("list : " + list);
			
		return list;
	}

	// 완제품코드가 x이고 생산이 완료된 생산코드 가져오는 메소드
	@Override
	public List getPFcode(String fcode) {
		// TODO Auto-generated method stub

		System.out.println("service pr_1100mt selectPFcode");
		List list = tb_pr_1100MTDAO.selectPFcode(fcode);
		System.out.println("list : " + list);
			
		return list;
	}
}
