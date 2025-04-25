package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.tb_fs_1000ht_DTO;

@Repository
public class tb_fs_1000ht_DAOImpl implements tb_fs_1000ht_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectPlog() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_fs_1000ht.selectPlog");
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public int insertPlog(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = -1;
		i = sqlSession.insert("mapper.tb_fs_1000ht.insertPlog", dto);
		System.out.println("insert i : " + i);
		
		return i;
	}

	@Override
	public int updatePlog(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = -1;
		i = sqlSession.update("mapper.tb_fs_1000ht.updatePlog", dto);
		System.out.println("update i : " + i);
		
		return i;
	}

	@Override
	public List selectLastPlog(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_fs_1000ht.selectLastPlog", dto);
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public List selectPlogSearchList(tb_fs_1000ht_DTO dto) {
		// TODO Auto-generated method stub

		List result = sqlSession.selectList("mapper.tb_fs_1000ht.selectPlog", dto);
		System.out.println("result : " + result);
		
		return result;
	}
}
