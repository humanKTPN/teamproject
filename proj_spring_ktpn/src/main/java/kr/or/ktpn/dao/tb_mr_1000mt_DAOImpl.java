package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.tb_mr_1000mt_DTO;

@Repository
public class tb_mr_1000mt_DAOImpl implements tb_mr_1000mt_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectMaterials() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectMaterials");
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public List selectMaterials(String code) {
		// TODO Auto-generated method stub

		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectCurrentM", code);
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public int insertMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		int i = -1;
		i = sqlSession.insert("mapper.tb_mr_1000mt.insertCurrentM", dto);
		System.out.println("insert i : " + i);
		
		return i;
	}

	@Override
	public int updateMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = -1;
		i = sqlSession.update("mapper.tb_mr_1000mt.updateCurrentM", dto);
		System.out.println("update i : " + i);
		
		return i;
	}

	@Override
	public int deleteMaterials(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		int i = -1;
		i = sqlSession.delete("mapper.tb_mr_1000mt.deleteCurrentM", dto);
		System.out.println("delete i : " + i);
		
		return i;
	}

	@Override
	public List selectMaterialsSearchList(tb_mr_1000mt_DTO dto) {
		// TODO Auto-generated method stub

		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectMaterials", dto);
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public int totalMaterials() {
		// TODO Auto-generated method stub
		
		int result = sqlSession.selectOne("mapper.tb_mr_1000mt.totalMaterials");
		System.out.println("count = " + result);
		
		return result;
	}
}
