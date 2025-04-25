package kr.or.ktpn.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.tb_qa_1000dt_DTO;
import kr.or.ktpn.dto.tb_qa_1100dt_DTO;

@Repository
public class tb_qa_1100dt_DAOImpl implements tb_qa_1100dt_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectQC() {
		// TODO Auto-generated method stub
		
		List result = sqlSession.selectList("mapper.tb_qa_1100dt.selectQC");
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public int insertQC(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = -1;
		i = sqlSession.insert("mapper.tb_qa_1100dt.insertQCreport", dto);
		System.out.println("insert i : " + i);
		
		return i;
	}

	@Override
	public int updateQC(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = -1;
		i = sqlSession.update("mapper.tb_qa_1100dt.updateQCreport", dto);
		System.out.println("update i : " + i);
		
		return i;
	}

	@Override
	public int deleteQC(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub
		
		int i = -1;
		i = sqlSession.delete("mapper.tb_qa_1100dt.deleteQCreport", dto);
		System.out.println("delete i : " + i);
		
		return i;
	}

	@Override
	public List joinQC(String pcode) {
		// TODO Auto-generated method stub
		
		tb_qa_1000dt_DTO result = sqlSession.selectOne("mapper.tb_qa_1100dt.selectJoinQC", pcode);
		System.out.println("result : " + result);
		
		List list = new ArrayList();
		list.add(result);
		
		return list;
	}

	@Override
	public tb_qa_1100dt_DTO selectQCone(String code) {
		// TODO Auto-generated method stub
		
		tb_qa_1100dt_DTO result = sqlSession.selectOne("mapper.tb_qa_1100dt.selectQCone", code);
		System.out.println("result : " + result);
		
		return result;
	}

	@Override
	public List selectSearchQCList(tb_qa_1100dt_DTO dto) {
		// TODO Auto-generated method stub

		List result = sqlSession.selectList("mapper.tb_qa_1100dt.selectQC", dto);
		System.out.println("result : " + result);
		
		return result;
	}
}
