package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;

public interface KW_DAO_mb_1000mt {

	public List<KW_DTO_MB_1000MT> selectMember();
	KW_DTO_MB_1000MT selectMemberId(String id);
	public int update(KW_DTO_MB_1000MT dto);
	public int delete(String id);
	
	
	
	// 작업자(일반회원) 가져오는 메소드
	public List selectWorker();
}
