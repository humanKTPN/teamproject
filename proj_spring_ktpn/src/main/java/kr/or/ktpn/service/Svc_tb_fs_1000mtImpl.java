package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_fs_1000mt_DAO;
import kr.or.ktpn.dto.tb_fs_1000mt_DTO;

@Service
public class Svc_tb_fs_1000mtImpl implements Svc_tb_fs_1000mt {

	@Autowired
	tb_fs_1000mt_DAO tb_fs_1000mt_dao;

	@Override
	public List getProducts() {
		// TODO Auto-generated method stub
		
		System.out.println("service_fs_1000mt");
		List list = tb_fs_1000mt_dao.selectProducts();
		System.out.println("service list all : " + list);

		return list;
	}

	@Override
	public List getProducts(String code) {
		// TODO Auto-generated method stub

		System.out.println("service_fs_1000mt");
		List list = tb_fs_1000mt_dao.selectProducts(code);
		System.out.println("service list one : " + list);

		return list;
	}

	@Override
	public int insertProducts(tb_fs_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_fs_1000mt");
		int i = tb_fs_1000mt_dao.insertProducts(dto);
		System.out.println("service insert i : " + i);

		return i;
	}

	@Override
	public int updateProducts(tb_fs_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_fs_1000mt");
		int i = tb_fs_1000mt_dao.updateProducts(dto);
		System.out.println("service update i : " + i);

		return i;
	}

	@Override
	public int deleteProducts(tb_fs_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_fs_1000mt");
		int i = tb_fs_1000mt_dao.deleteProducts(dto);
		System.out.println("service delete i : " + i);

		return i;
	}

	@Override
	public List testgetProductSearchList(tb_fs_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		if ("Fcode".equals(dto.getType())) {
			dto.setFnsh_code(dto.getKeyword());
		} else if ("Fname".equals(dto.getType())) {
			dto.setFnsh_nm(dto.getKeyword());
		} else if ("EA".equals(dto.getType())) {
			try {
				int ea = Integer.parseInt(dto.getKeyword());
				dto.setCrnt_aftr_cnt(ea);
				System.out.println("dto.crnt_aftr_cnt" + dto.getCrnt_aftr_cnt());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		List list = tb_fs_1000mt_dao.selectProductsSearchList(dto);
		
		return list;
	}
	
}
