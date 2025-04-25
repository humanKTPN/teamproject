package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.tb_mr_1000mt_DTO;

public interface tb_mr_1000mt_DAO {

	public List selectMaterials();
	
	public List selectMaterials(String code);
	
	public int insertMaterials(tb_mr_1000mt_DTO dto);
	
	public int updateMaterials(tb_mr_1000mt_DTO dto);
	
	public int deleteMaterials(tb_mr_1000mt_DTO dto);
	
	public List selectMaterialsSearchList(tb_mr_1000mt_DTO dto);
	
	public int totalMaterials();
}
