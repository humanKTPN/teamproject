package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ktpn.dto.TAK_PR_1200MTDTO;

public class TAK_PR_1200MTDAOImpl implements TAK_PR_1200MTDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<TAK_PR_1200MTDTO> selectDTO() {

		List<TAK_PR_1200MTDTO> PR_1200MTDAO = sqlSession.selectList("mapper.TAK_PR_1200MTDTO.PR_1200MT");
		System.out.println("PR_1200MTDAO : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
}
