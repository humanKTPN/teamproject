package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;

public interface KW_Svc_mb_1000mt {

	public List<KW_DTO_MB_1000MT> getMemberlist();
	public KW_DTO_MB_1000MT getMemberId(String id);
	
}
