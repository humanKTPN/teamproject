package kr.or.ktpn.service;

import java.util.List;
import java.util.Map;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_pr_insert;

public interface Svc_md_1000mt {
	
	public List<DTO_md_1000mt> getMdList(DTO_md_1000mt dto);
	public int addMd(DTO_md_1000mt dto);
	public int modMd(DTO_md_1000mt dto);
	public int delMd(DTO_md_1000mt dto);

	//생산관리관련 데이터
	public List<DTO_md_1000mt> selectDAO_P();
	public List<DTO_md_1000mt> selectDAO_L();
	
	
	
	
	// 원자재 코드, 원자재명 가져오는 메소드
	public List getMcodeList();
		
	// 완제품 코드, 완제품명 가져오는 메소드
	public List getPcodeList();
	
}
