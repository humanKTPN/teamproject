package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.tb_od_1000mt_DTO;

public interface Svc_tb_od_1000mt {

	public List getCompanyList();
	
	public List testSearchCompanyList(tb_od_1000mt_DTO dto);
}
