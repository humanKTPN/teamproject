package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1200MTDTO;

@Repository
public class TAK_PR_1200MTDAOImpl implements TAK_PR_1200MTDAO {

	@Autowired
	SqlSession sqlSession;
	
//	@Override
//	public List<TAK_PR_1200MTDTO> selectDayDTO() {
//
//		List<TAK_PR_1200MTDTO> PR_1200MTDAO = sqlSession.selectList("mapper.TAK_PR_1200MTDTO.pr_1100MT_day");
//		System.out.println("PR_1200MTDAODay : " + PR_1200MTDAO);
//		
//		return PR_1200MTDAO;
//	}

	
	//라인별호기 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA1");
		System.out.println("PR_1200MTDAOLineA1 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC3");
		System.out.println("PR_1200MTDAOLineC3 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	
	
}
