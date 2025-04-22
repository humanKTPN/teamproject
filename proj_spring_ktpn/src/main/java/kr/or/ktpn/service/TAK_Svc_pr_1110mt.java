package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

public interface TAK_Svc_pr_1110mt {

	public List selectDAO();
//  insert
	public int insertDAO(TAK_PR_1110MTDTO dto);
	
//	pr_popup 수정,완료
	public int updateDAO(TAK_PR_1110MTDTO dto);
	public int completeDAO(TAK_PR_1110MTDTO dto);
}
