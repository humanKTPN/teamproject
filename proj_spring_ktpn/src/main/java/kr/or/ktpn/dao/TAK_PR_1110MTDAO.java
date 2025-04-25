package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

public interface TAK_PR_1110MTDAO {

	public List<TAK_PR_1110MTDTO> selectDTO();
	//insert
	public int insertDTO(TAK_PR_1110MTDTO dto);
	
	
//	pr_popup 수정,완료
	public int updateDTO(TAK_PR_1110MTDTO dto);
	public int completeDTO(TAK_PR_1110MTDTO dto);
	
	//일정 조회
	
	
	public List<TAK_PR_1110MTDTO> findByDateRange(TAK_PR_1110MTDTO dto);
	
	
	
	
	
}
