package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.tb_fs_1000ht_DTO;

public interface tb_fs_1000ht_DAO {

	public List selectPlog();
	
	public int insertPlog(tb_fs_1000ht_DTO dto);
	
	public int updatePlog(tb_fs_1000ht_DTO dto);
	
	public List selectLastPlog(tb_fs_1000ht_DTO dto);
	
	public List selectPlogSearchList(tb_fs_1000ht_DTO dto);
}
