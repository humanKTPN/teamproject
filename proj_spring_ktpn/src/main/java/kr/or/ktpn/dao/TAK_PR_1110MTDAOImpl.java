package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

@Repository
public class TAK_PR_1110MTDAOImpl implements TAK_PR_1110MTDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<TAK_PR_1110MTDTO> selectDTO() {

		List<TAK_PR_1110MTDTO> PR_1110MTDAO = sqlSession.selectList("mapper.TAK_PR_1110MTDTO.PR_1110MT");
		System.out.println("PR_1110MTDAO : " + PR_1110MTDAO);
		
		return PR_1110MTDAO;
	}

}
