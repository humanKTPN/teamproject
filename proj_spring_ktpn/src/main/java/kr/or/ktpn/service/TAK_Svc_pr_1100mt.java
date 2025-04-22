package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;

public interface TAK_Svc_pr_1100mt {

	public List selectDAO();
	public List selectDAO_A();
	public List selectDAO_B();
	public List selectDAO_C();
// insert
	public int insertDAO(TAK_PR_1100MTDTO dto);
//	pm_popup 수정,완료
	public int updateDAO(TAK_PR_1100MTDTO dto);
	public int completeDAO(TAK_PR_1100MTDTO dto);
}
