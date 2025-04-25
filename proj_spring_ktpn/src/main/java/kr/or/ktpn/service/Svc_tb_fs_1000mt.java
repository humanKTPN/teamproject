package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.tb_fs_1000mt_DTO;

public interface Svc_tb_fs_1000mt {

	public List getProducts();
	
	public List getProducts(String code);

	public int insertProducts(tb_fs_1000mt_DTO dto);
	
	public int updateProducts(tb_fs_1000mt_DTO dto);
	
	public int deleteProducts(tb_fs_1000mt_DTO dto);
	
	public List testgetProductSearchList(tb_fs_1000mt_DTO dto);
}
