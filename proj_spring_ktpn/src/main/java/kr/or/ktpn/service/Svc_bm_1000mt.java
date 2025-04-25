package kr.or.ktpn.service;

import java.util.List;
import java.util.Map;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_mr_detail;
import kr.or.ktpn.dto.DTO_mr_insert;

public interface Svc_bm_1000mt {
	
	public List<DTO_bm_1000mt> getBmList(DTO_bm_1000mt dto);
	public List<DTO_md_1000mt> addBm(DTO_md_1000mt dto);
	public int insertBm(DTO_bm_1000mt dto);
	public int modBm(DTO_mr_insert dto);
	public int insertMr(Map<String,Object> mrMap);
	public List<DTO_mr_detail> detailBm(DTO_mr_detail mrDTO);
	public List<DTO_md_1000mt> callList(DTO_md_1000mt dto);
	public int delMr(DTO_mr_insert dto);

	
}
