package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_qa_1100dt_DAO;
import kr.or.ktpn.dto.tb_qa_1100dt_DTO;

@Service
public class Svc_tb_qa_1100dtImpl implements Svc_tb_qa_1100dt {

	@Autowired
	tb_qa_1100dt_DAO tb_qa_1100dt_dao;

	@Override
	public List getSelectQC() {
		// TODO Auto-generated method stub
		
		System.out.println("service_qa_1100dt getSelectQC");
		List list = tb_qa_1100dt_dao.selectQC();
		System.out.println("service list all : " + list);
		
		return list;
	}

	@Override
	public int getInsertQC(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub
		
		System.out.println("service_qa_1100dt getInsertQC");
		int i = tb_qa_1100dt_dao.insertQC(dto);
		System.out.println("service insert i : " + i);
		
		return i;
	}

	@Override
	public int getUpdateQC(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub
		
		System.out.println("service_qa_1100dt getUpdateQC");
		int i = tb_qa_1100dt_dao.updateQC(dto);
		System.out.println("service update i : " + i);	
		
		return i;
	}

	@Override
	public int getDeleteQC(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub
		
		System.out.println("service_qa_1100dt getDeleteQC");
		int i = tb_qa_1100dt_dao.deleteQC(dto);
		System.out.println("service delete i : " + i);
		
		return i;
	}

	@Override
	public List getJoinQC(String pcode) {
		// TODO Auto-generated method stub
		
		System.out.println("service_qa_1100dt getJoinQC");
		List list = tb_qa_1100dt_dao.joinQC(pcode);
		System.out.println("service list join : " + list);
		
		return list;
	}

	@Override
	public tb_qa_1100dt_DTO getSelectQCone(String code) {
		// TODO Auto-generated method stub

		System.out.println("service_qa_1100dt getSelectQCone");
		tb_qa_1100dt_DTO dto = tb_qa_1100dt_dao.selectQCone(code);
		System.out.println("service dto : " + dto);
		
		return dto;
	}

	@Override
	public List testSearchQCList(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub
		
		if ("Fcode".equals(dto.getType())) {
			dto.setItem_cd(dto.getKeyword());
		} else if ("Fname".equals(dto.getType())) {
			dto.setItem_nm(dto.getKeyword());
		} else if ("Pcode".equals(dto.getType())) {
			dto.setProd_cd(dto.getKeyword());
		}
		
		List list = tb_qa_1100dt_dao.selectSearchQCList(dto);
		
		return list;
	}
	
}
