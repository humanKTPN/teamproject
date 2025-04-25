package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.tb_mr_1000ht_DTO;

public interface Svc_tb_mr_1000ht {

	public List getMlog();
	
	public int insertMlog(tb_mr_1000ht_DTO dto);
	
	public int updateMlog(tb_mr_1000ht_DTO dto);
	
	public List getLastMlog(tb_mr_1000ht_DTO dto);
	
	public List testSearchMlog(tb_mr_1000ht_DTO dto);
}
