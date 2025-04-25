package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.tb_od_1000mt_DTO;

public interface tb_od_1000mt_DAO {

	public List selectCompanyList();
	
	public List selectCompanySearchList(tb_od_1000mt_DTO dto);
}
