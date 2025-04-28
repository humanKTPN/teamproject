package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

public interface TAK_Svc_pr_1200mt {

//	public List selectDayDAO();
	
	//라인별호기 셀렉
	public TAK_PR_1100MTDTO selectLineA1DAO();
	public TAK_PR_1100MTDTO selectLineC3DAO();

}
