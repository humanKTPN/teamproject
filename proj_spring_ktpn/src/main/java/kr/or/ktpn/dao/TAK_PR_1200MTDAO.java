package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1200MTDTO;

public interface TAK_PR_1200MTDAO {

	//일별 데이터
//	public List<TAK_PR_1200MTDTO> selectDayDTO();
	
	//라인별호기 셀렉
	public TAK_PR_1100MTDTO selectLineA1DTO();
	public TAK_PR_1100MTDTO selectLineC3DTO();
}
