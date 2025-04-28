package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1200MTDTO;

public interface TAK_PR_1200MTDAO {

	//일별 데이터
//	public List<TAK_PR_1200MTDTO> selectDayDTO();
	
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
}
