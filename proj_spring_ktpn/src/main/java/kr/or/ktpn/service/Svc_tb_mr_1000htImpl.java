package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_mr_1000ht_DAO;
import kr.or.ktpn.dto.tb_mr_1000ht_DTO;

@Service
public class Svc_tb_mr_1000htImpl implements Svc_tb_mr_1000ht {

	@Autowired
	tb_mr_1000ht_DAO tb_mr_1000ht_dao;

	@Override
	public List getMlog() {
		// TODO Auto-generated method stub
		
		System.out.println("service_mr_1000ht");
		List list = tb_mr_1000ht_dao.selectMlog();
		System.out.println("service list all : " + list);

		return list;
	}

	@Override
	public int insertMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000ht");
		System.out.println("setvice dto : " + dto);
		int i = tb_mr_1000ht_dao.insertMlog(dto);
		System.out.println("service insert i : " + i);

		return i;
	}

	@Override
	public int updateMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000ht");
		int i = tb_mr_1000ht_dao.updateMlog(dto);
		System.out.println("service update i : " + i);

		return i;
	}

	@Override
	public List getLastMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000ht");
		List list = tb_mr_1000ht_dao.selectLastMlog(dto);
		System.out.println("service last list : " + list);

		return list;
	}

	@Override
	public List testSearchMlog(tb_mr_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		
		if ("Mcode".equals(dto.getType())) {
			dto.setMtrl_cd(dto.getKeyword());
		} else if ("Mname".equals(dto.getType())) {
			dto.setMtrl_nm(dto.getKeyword());
		} else if ("EA".equals(dto.getType())) {
			try {
				int ea = Integer.parseInt(dto.getKeyword());
				dto.setCrnt_aftr_cnt(ea);
				System.out.println("dto.crnt_aftr_cnt" + dto.getCrnt_aftr_cnt());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		List list = tb_mr_1000ht_dao.selectMlogSearchList(dto);
		
		return list;
	}
}
