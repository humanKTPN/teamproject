package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.tb_fs_1000ht_DTO;

public interface Svc_tb_fs_1000ht {

	public List getPlog();
	
	public int insertPlog(tb_fs_1000ht_DTO dto);
	
	public int updatePlog(tb_fs_1000ht_DTO dto);
	
	public List getLastPlog(tb_fs_1000ht_DTO dto);
	
	public List testSearchPlog(tb_fs_1000ht_DTO dto);
}
