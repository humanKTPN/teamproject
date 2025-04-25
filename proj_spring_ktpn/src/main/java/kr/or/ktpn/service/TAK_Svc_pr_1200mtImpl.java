package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.TAK_PR_1110MTDAO;
import kr.or.ktpn.dao.TAK_PR_1200MTDAO;
import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

@Service
public class TAK_Svc_pr_1200mtImpl implements TAK_Svc_pr_1200mt {

	@Autowired
	TAK_PR_1200MTDAO tb_pr_1200MTDAO;
	
	@Override
	public List selectDayDAO() {
		List PR_1200MTSVC = tb_pr_1200MTDAO.selectDayDTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}


}

