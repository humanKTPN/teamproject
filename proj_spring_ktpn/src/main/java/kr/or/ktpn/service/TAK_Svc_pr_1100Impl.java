package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.TAK_PR_1100MTDAO;

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

//	@Override
//	public List selectDAO_A() {
//		List PR_1100MTSVC_A = tb_pr_1100MTDAO.selectDTO_A();
//		System.out.println("PR_1100MTSVC_A : "+PR_1100MTSVC_A);
//		return PR_1100MTSVC_A;
//	}
//
//	@Override
//	public List selectDAO_B() {
//		List PR_1100MTSVC_B = tb_pr_1100MTDAO.selectDTO_B();
//		System.out.println("PR_1100MTSVC_B : "+PR_1100MTSVC_B);
//		return PR_1100MTSVC_B;
//	}
//
//	@Override
//	public List selectDAO_C() {
//		List PR_1100MTSVC_C = tb_pr_1100MTDAO.selectDTO_C();
//		System.out.println("PR_1100MTSVC_C : "+PR_1100MTSVC_C);
//		return PR_1100MTSVC_C;
//	}
	
	
}
