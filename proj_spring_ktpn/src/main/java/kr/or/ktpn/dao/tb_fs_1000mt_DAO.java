package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.tb_fs_1000mt_DTO;

public interface tb_fs_1000mt_DAO {

	public List selectProducts();
	
	public List selectProducts(String code);	
	
	public int insertProducts(tb_fs_1000mt_DTO dto);

	public int updateProducts(tb_fs_1000mt_DTO dto);
	
	public int deleteProducts(tb_fs_1000mt_DTO dto);
	
	public List selectProductsSearchList(tb_fs_1000mt_DTO dto);
}
