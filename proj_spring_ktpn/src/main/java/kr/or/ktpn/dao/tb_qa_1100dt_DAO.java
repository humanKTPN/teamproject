package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.tb_qa_1100dt_DTO;

public interface tb_qa_1100dt_DAO {

	public List selectQC();
	
	public int insertQC(tb_qa_1100dt_DTO dto);
	
	public int updateQC(tb_qa_1100dt_DTO dto);
	
	public int deleteQC(tb_qa_1100dt_DTO dto);
	
	public List joinQC(String pcode);
	
	public tb_qa_1100dt_DTO selectQCone(String code);
	
	public List selectSearchQCList(tb_qa_1100dt_DTO dto);
}
