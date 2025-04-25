package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.tb_mr_1000ht_DTO;

public interface tb_mr_1000ht_DAO {

	public List selectMlog();
	
	public int insertMlog(tb_mr_1000ht_DTO dto);
	
	public int updateMlog(tb_mr_1000ht_DTO dto);
	
	public List selectLastMlog(tb_mr_1000ht_DTO dto);
	
	public List selectMlogSearchList(tb_mr_1000ht_DTO dto);
	
}
