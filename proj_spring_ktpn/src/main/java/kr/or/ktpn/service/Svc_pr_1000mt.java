package kr.or.ktpn.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ktpn.dto.DTO_pr_1000mt;
import kr.or.ktpn.dto.DTO_pr_insert;

public interface Svc_pr_1000mt {
	
	public List<DTO_pr_1000mt> getPrList(DTO_pr_1000mt dto);
	public List<DTO_pr_1000mt> getdePrList(Map<String,String> dto);
	public List<Map<String,Object>> getAddListMap();
	public List<Map<String,Object>> getLineMap();
	public List<Map<String,Object>> selectMbList();
	public int insertPr(DTO_pr_insert dto);
	public int delMd(DTO_pr_insert dto);

	
	//생산관리 데이터
	public List<DTO_pr_1000mt> selectDAO_N();
	
}
 