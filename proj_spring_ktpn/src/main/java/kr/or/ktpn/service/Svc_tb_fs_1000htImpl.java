package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_fs_1000ht_DAO;
import kr.or.ktpn.dto.tb_fs_1000ht_DTO;

@Service
public class Svc_tb_fs_1000htImpl implements Svc_tb_fs_1000ht{

	@Autowired
	tb_fs_1000ht_DAO tb_fs_1000ht_dao;
	
	@Override
	public List getPlog() {
		// TODO Auto-generated method stub
		
		System.out.println("service_fs_1000ht");
		List list = tb_fs_1000ht_dao.selectPlog();
		System.out.println("service list all : " + list);
		
		return list;
	}

	@Override
	public int insertPlog(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub
		
		System.out.println("service_fs_1000ht");
		int i = tb_fs_1000ht_dao.insertPlog(dto);
		System.out.println("service insert i : " + i);
		
		return i;
	}

	@Override
	public int updatePlog(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub
		
		System.out.println("service_fs_1000ht");
		int i = tb_fs_1000ht_dao.updatePlog(dto);
		System.out.println("service update i : " + i);
		
		return i;
	}

	@Override
	public List getLastPlog(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_fs_1000ht");
		List list = tb_fs_1000ht_dao.selectLastPlog(dto);
		System.out.println("service last list : " + list);
		
		return list;
	}

	@Override
	public List testSearchPlog(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub
		
		if ("Fcode".equals(dto.getType())) {
			dto.setFnsh_code(dto.getKeyword());
		} else if ("Fname".equals(dto.getType())) {
			dto.setFnshd_item_nm(dto.getKeyword());
		} else if ("EA".equals(dto.getType())) {
			try {
				int ea = Integer.parseInt(dto.getKeyword());
				dto.setCrnt_aftr_cnt(ea);
				System.out.println("dto.crnt_aftr_cnt" + dto.getCrnt_aftr_cnt());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("Pcode".equals(dto.getType())) {
			dto.setProd_cd(dto.getKeyword());
		}
		
		List list = tb_fs_1000ht_dao.selectPlogSearchList(dto);
		
		return list;
	}

}
