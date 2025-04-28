package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

public interface TAK_Svc_pr_1200mt {

//	public List selectDayDAO();
	
	//라인별호기 금일 셀렉
	public TAK_PR_1100MTDTO selectLineA1DAO();
	public TAK_PR_1100MTDTO selectLineA2DAO();
	public TAK_PR_1100MTDTO selectLineA3DAO();
	public TAK_PR_1100MTDTO selectLineB1DAO();
	public TAK_PR_1100MTDTO selectLineB2DAO();
	public TAK_PR_1100MTDTO selectLineB3DAO();
	public TAK_PR_1100MTDTO selectLineC1DAO();
	public TAK_PR_1100MTDTO selectLineC2DAO();
	public TAK_PR_1100MTDTO selectLineC3DAO();
	
	
	//라인별호기 금일 셀렉
	public TAK_PR_1100MTDTO selectLineA1_weekDAO();
	public TAK_PR_1100MTDTO selectLineA2_weekDAO();
	public TAK_PR_1100MTDTO selectLineA3_weekDAO();
	public TAK_PR_1100MTDTO selectLineB1_weekDAO();
	public TAK_PR_1100MTDTO selectLineB2_weekDAO();
	public TAK_PR_1100MTDTO selectLineB3_weekDAO();
	public TAK_PR_1100MTDTO selectLineC1_weekDAO();
	public TAK_PR_1100MTDTO selectLineC2_weekDAO();
	public TAK_PR_1100MTDTO selectLineC3_weekDAO();
	
	
	//라인별호기 금월 셀렉
	public TAK_PR_1100MTDTO selectLineA1_monthDAO();
	public TAK_PR_1100MTDTO selectLineA2_monthDAO();
	public TAK_PR_1100MTDTO selectLineA3_monthDAO();
	public TAK_PR_1100MTDTO selectLineB1_monthDAO();
	public TAK_PR_1100MTDTO selectLineB2_monthDAO();
	public TAK_PR_1100MTDTO selectLineB3_monthDAO();
	public TAK_PR_1100MTDTO selectLineC1_monthDAO();
	public TAK_PR_1100MTDTO selectLineC2_monthDAO();
	public TAK_PR_1100MTDTO selectLineC3_monthDAO();

	
	//라인별호기 금월 불량률 셀렉
	public TAK_PR_1100MTDTO selectLineA1_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineA2_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineA3_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineB1_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineB2_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineB3_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineC1_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineC2_month_DRDAO();
	public TAK_PR_1100MTDTO selectLineC3_month_DRDAO();

}
