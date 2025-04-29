package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1200MTDTO;

public interface TAK_PR_1200MTDAO {

	//일별 데이터
//	public List<TAK_PR_1200MTDTO> selectDayDTO();
	
	//가동현황 데이터
	public List selectNYDTO();
	
	//원형 그래프 데이터
	public TAK_PR_1100MTDTO selectSSDTO();
	public TAK_PR_1100MTDTO selectSS_DRDTO();
	public TAK_PR_1100MTDTO selectSS_IQDTO();
	
	//품목별 데이터
	//일별
	public TAK_PR_1100MTDTO selectSSGDTO();
	public TAK_PR_1100MTDTO selectHHDTO();
	//주별
	public TAK_PR_1100MTDTO selectSSG_weekDTO();
	public TAK_PR_1100MTDTO selectHH_weekDTO();
	//월별
	public TAK_PR_1100MTDTO selectSSG_monthDTO();
	public TAK_PR_1100MTDTO selectHH_monthDTO();
	
	
	//라인별호기 금일 셀렉
	public TAK_PR_1100MTDTO selectLineA1DTO();
	public TAK_PR_1100MTDTO selectLineA2DTO();
	public TAK_PR_1100MTDTO selectLineA3DTO();
	public TAK_PR_1100MTDTO selectLineB1DTO();
	public TAK_PR_1100MTDTO selectLineB2DTO();
	public TAK_PR_1100MTDTO selectLineB3DTO();
	public TAK_PR_1100MTDTO selectLineC1DTO();
	public TAK_PR_1100MTDTO selectLineC2DTO();
	public TAK_PR_1100MTDTO selectLineC3DTO();
	
	//라인별호기 금주 셀렉
	public TAK_PR_1100MTDTO selectLineA1_weekDTO();
	public TAK_PR_1100MTDTO selectLineA2_weekDTO();
	public TAK_PR_1100MTDTO selectLineA3_weekDTO();
	public TAK_PR_1100MTDTO selectLineB1_weekDTO();
	public TAK_PR_1100MTDTO selectLineB2_weekDTO();
	public TAK_PR_1100MTDTO selectLineB3_weekDTO();
	public TAK_PR_1100MTDTO selectLineC1_weekDTO();
	public TAK_PR_1100MTDTO selectLineC2_weekDTO();
	public TAK_PR_1100MTDTO selectLineC3_weekDTO();

	
	//라인별호기 금월 셀렉
	public TAK_PR_1100MTDTO selectLineA1_monthDTO();
	public TAK_PR_1100MTDTO selectLineA2_monthDTO();
	public TAK_PR_1100MTDTO selectLineA3_monthDTO();
	public TAK_PR_1100MTDTO selectLineB1_monthDTO();
	public TAK_PR_1100MTDTO selectLineB2_monthDTO();
	public TAK_PR_1100MTDTO selectLineB3_monthDTO();
	public TAK_PR_1100MTDTO selectLineC1_monthDTO();
	public TAK_PR_1100MTDTO selectLineC2_monthDTO();
	public TAK_PR_1100MTDTO selectLineC3_monthDTO();

	
	//라인별호기 금월 불량룰 셀렉
	public TAK_PR_1100MTDTO selectLineA1_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineA2_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineA3_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineB1_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineB2_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineB3_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineC1_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineC2_month_DRDTO();
	public TAK_PR_1100MTDTO selectLineC3_month_DRDTO();
	
	
}
