package kr.or.ktpn.dao;

import java.util.List;
import java.util.Map;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_mr_detail;
import kr.or.ktpn.dto.DTO_mr_insert;

public interface DAO_bm_1000mt {

//	public List<DTO_md_1000mt> selectMdList();
	public List<DTO_bm_1000mt> selectBmList(DTO_bm_1000mt dto);
	public List<DTO_md_1000mt> insertBm(DTO_md_1000mt dto);
	public int addBm(DTO_bm_1000mt dto);
	public int updateBm(DTO_mr_insert dto) ;
	public int addMr(Map<String,Object> mrMap);
	public List<DTO_mr_detail> detailBm(DTO_mr_detail dto);
	public List<DTO_md_1000mt> listMr(DTO_md_1000mt dto);
	public int delMr(DTO_mr_insert dto);
	
}
