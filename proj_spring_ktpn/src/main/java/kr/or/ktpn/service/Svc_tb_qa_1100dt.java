package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.tb_qa_1100dt_DTO;

public interface Svc_tb_qa_1100dt {

	public List getSelectQC();
	
	public int getInsertQC(tb_qa_1100dt_DTO dto);
	
	public int getUpdateQC(tb_qa_1100dt_DTO dto);
	
	public int getDeleteQC(tb_qa_1100dt_DTO dto);
	
	public List getJoinQC(String pcode);
	
	public tb_qa_1100dt_DTO getSelectQCone(String code);
	
	public List testSearchQCList(tb_qa_1100dt_DTO dto);
}
