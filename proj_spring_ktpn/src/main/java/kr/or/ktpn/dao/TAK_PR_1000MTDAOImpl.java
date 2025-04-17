package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ktpn.dto.TAK_PR_1000MTDTO;

public class TAK_PR_1000MTDAOImpl implements TAK_PR_1000MTDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<TAK_PR_1000MTDTO> selectDTO() {

		List<TAK_PR_1000MTDTO> PR_1000MTDAO = sqlSession.selectList("mapper.TAK_PR_1000MTDTO.PR_1000MT");
		System.out.println("PR_1000MTDAO : " + PR_1000MTDAO);
		
		return PR_1000MTDAO;
	}
}
