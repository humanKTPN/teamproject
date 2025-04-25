package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;
//테스트
public interface TAK_Svc_pr_1110mt {
 	
	public List selectDAO(); 
//  insert
	public int insertDAO(TAK_PR_1110MTDTO dto);
	
//	pr_popup 수정,완료
	public int updateDAO(TAK_PR_1110MTDTO dto);
	public int completeDAO(TAK_PR_1110MTDTO dto);
	
	public List<TAK_PR_1110MTDTO> searchByDateRange(TAK_PR_1110MTDTO dto);
}
