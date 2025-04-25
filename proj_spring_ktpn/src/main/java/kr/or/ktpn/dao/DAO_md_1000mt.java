package kr.or.ktpn.dao;

import java.util.List;
import java.util.Map;

import kr.or.ktpn.dto.DTO_md_1000mt;

public interface DAO_md_1000mt {

//	public List<DTO_md_1000mt> selectMdList();
	public List<DTO_md_1000mt> selectMdList(DTO_md_1000mt dto);
	public int insertEmp(DTO_md_1000mt dto);
	public int updateMd(DTO_md_1000mt dto) ;
	public int delMd(DTO_md_1000mt dto);
	
	
	//생산관리관련 데이터
	public List<DTO_md_1000mt> selectDTO_P();
	public List<DTO_md_1000mt> selectDTO_L();
		
		
	
	// 원자재 코드, 원자재명 가져오는 메소드
	public List selectMcodeList();
	
	// 완제품 코드, 완제품명 가져오는 메소드
	public List selectPcodeList();
}
