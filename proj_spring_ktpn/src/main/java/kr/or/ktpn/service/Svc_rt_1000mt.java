package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_rt_1000mt;

public interface Svc_rt_1000mt {
	
	public List<DTO_rt_1000mt> getRtList(DTO_rt_1000mt dto);
	public List<DTO_md_1000mt> addBm(DTO_md_1000mt dto);
	public int insertBm(DTO_bm_1000mt dto);
	public int modBm(DTO_bm_1000mt dto);

	
}
 