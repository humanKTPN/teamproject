package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1200MTDTO;

public interface TAK_PR_1200MTDAO {

	//일별 데이터
	public List<TAK_PR_1200MTDTO> selectDayDTO();
}
