package kr.or.ktpn.dao;

import java.util.List;
import java.util.Map;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_rt_1000mt;
import kr.or.ktpn.dto.DTO_rt_desc;

public interface DAO_rt_1000mt {

//	public List<DTO_md_1000mt> selectMdList();
	public List<DTO_rt_1000mt> selectRtList(DTO_rt_1000mt dto);
	public List<DTO_md_1000mt> insertRt(DTO_md_1000mt dto);
	public int addRt(DTO_rt_1000mt dto);
	public int updateRt(DTO_rt_desc dto);
	public int delMd(DTO_md_1000mt dto);
	public int addRt(Map<String,Object> mrMap);
	public List<DTO_rt_desc> selectRtDesc(DTO_rt_desc dto);
	public int delRt(DTO_rt_desc dto);
}
