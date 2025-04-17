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
	
}
