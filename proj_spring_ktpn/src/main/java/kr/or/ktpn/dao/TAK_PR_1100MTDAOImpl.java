package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;

@Repository
public class TAK_PR_1100MTDAOImpl implements TAK_PR_1100MTDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<TAK_PR_1100MTDTO> selectDTO() {
		
		List<TAK_PR_1100MTDTO> PR_1100MTDAO = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT");
		System.out.println("PR_1100MTDAO : " + PR_1100MTDAO);
		
		return PR_1100MTDAO;
	}

//	@Override
//	public List<TAK_PR_1100MTDTO> selectDTO_A() {
//		List<TAK_PR_1100MTDTO> PR_1100MTDAO_A = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT_A");
//		System.out.println("PR_1100MTDAO_A : " + PR_1100MTDAO_A);
//		
//		return PR_1100MTDAO_A;
//	}
//
//	@Override
//	public List<TAK_PR_1100MTDTO> selectDTO_B() {
//		List<TAK_PR_1100MTDTO> PR_1100MTDAO_B = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT_B");
//		System.out.println("PR_1100MTDAO_B : " + PR_1100MTDAO_B);
//		
//		return PR_1100MTDAO_B;
//	}
//
//	@Override
//	public List<TAK_PR_1100MTDTO> selectDTO_C() {
//		List<TAK_PR_1100MTDTO> PR_1100MTDAO_C = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT_C");
//		System.out.println("PR_1100MTDAO_C : " + PR_1100MTDAO_C);
//		
//		return PR_1100MTDAO_C;
//	}

}
