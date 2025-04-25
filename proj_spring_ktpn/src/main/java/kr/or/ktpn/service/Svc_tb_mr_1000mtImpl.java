package kr.or.ktpn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_mr_1000mt_DAO;
import kr.or.ktpn.dto.tb_mr_1000mt_DTO;

@Service
public class Svc_tb_mr_1000mtImpl implements Svc_tb_mr_1000mt {

	@Autowired
	tb_mr_1000mt_DAO tb_mr_1000mt_dao;

	@Override
	public List getMaterials() {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		List list = tb_mr_1000mt_dao.selectMaterials();
		System.out.println("service list all : " + list);

		return list;
	}

	@Override
	public List getMaterials(String code) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		List list = tb_mr_1000mt_dao.selectMaterials(code);
		System.out.println("service list one : " + list);

		return list;
	}

	@Override
	public int insertMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		int i = tb_mr_1000mt_dao.insertMaterials(dto);
		System.out.println("service insert i : " + i);

		return i;
	}

	@Override
	public int updateMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		int i = tb_mr_1000mt_dao.updateMaterials(dto);
		System.out.println("service update i : " + i);

		return i;
	}

	@Override
	public int deleteMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		System.out.println("service_mr_1000mt");
		int i = tb_mr_1000mt_dao.deleteMaterials(dto);
		System.out.println("service delete i : " + i);

		return i;
	}

	@Override
	public Map<String, Object> getMataterialSearchList(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		if ("Mcode".equals(dto.getType())) {
			dto.setMtrl_cd(dto.getKeyword());
		} else if ("Mname".equals(dto.getType())) {
			dto.setMtrl_nm(dto.getKeyword());
		} else if ("EA".equals(dto.getType())) {
			try {
				int mea = Integer.parseInt(dto.getKeyword());
				dto.setCrnt_aftr_cnt(mea);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 보여줄 시작, 끝 index 찾기
		int page = dto.getPage();
		int viewCount = dto.getViewCount();

		int indexStart = (viewCount * (page - 1)) + 1;
		int indexEnd = page * viewCount;

		dto.setIndexStart(indexStart);
		dto.setIndexEnd(indexEnd);
		
		// 한 페이지의 내용만 있는 리스트
		List list = tb_mr_1000mt_dao.selectMaterialsSearchList(dto);
				
		// 전체 글 개수
		int total = tb_mr_1000mt_dao.totalMaterials();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("total", total);
		
		return map;
	}

	@Override
	public List testgetMataterialSearchList(tb_mr_1000mt_DTO dto) {
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
		
		List list = tb_mr_1000mt_dao.selectMaterialsSearchList(dto);
		
		return list;
	}
}
