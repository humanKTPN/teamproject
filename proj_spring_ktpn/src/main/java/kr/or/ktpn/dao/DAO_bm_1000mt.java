package kr.or.ktpn.dao;

import java.util.List;
import java.util.Map;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;

public interface DAO_bm_1000mt {

//	public List<DTO_md_1000mt> selectMdList();
	public List<DTO_bm_1000mt> selectBmList(DTO_bm_1000mt dto);
	public List<DTO_md_1000mt> insertBm(DTO_md_1000mt dto);
	public int addBm(DTO_bm_1000mt dto);
	public int updateBm(DTO_bm_1000mt dto) ;
	public int delMd(DTO_md_1000mt dto);
	
}
