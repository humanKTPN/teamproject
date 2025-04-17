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
	
	
}
