package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ktpn.dto.TAK_MB_1000MTDTO;

public class TAK_MB_1000MTDAOImpl implements TAK_MB_1000MTDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<TAK_MB_1000MTDTO> selectDTO() {

		List<TAK_MB_1000MTDTO> MB_1000MTDAO = sqlSession.selectList("mapper.TAK_MB_1000MTDTO.MB_1000MT");
		System.out.println("MB_1000MTDAO : " + MB_1000MTDAO);
		
		return MB_1000MTDAO;
	}
}
