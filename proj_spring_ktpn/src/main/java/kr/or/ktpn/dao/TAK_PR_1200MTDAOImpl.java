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

	
	//라인별호기 금일 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA1");
		System.out.println("PR_1200MTDAOLineA1 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA2");
		System.out.println("PR_1200MTDAOLineA2 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA3");
		System.out.println("PR_1200MTDAOLineA3 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB1");
		System.out.println("PR_1200MTDAOLineB1 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB2");
		System.out.println("PR_1200MTDAOLineB2 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB3");
		System.out.println("PR_1200MTDAOLineB3 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC1");
		System.out.println("PR_1200MTDAOLineC1 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC2");
		System.out.println("PR_1200MTDAOLineC2 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC3");
		System.out.println("PR_1200MTDAOLineC3 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	
	
	//라인별호기 금주 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA1_week");
		System.out.println("PR_1200MTDAOLineA1_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA2_week");
		System.out.println("PR_1200MTDAOLineA2_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA3_week");
		System.out.println("PR_1200MTDAOLineA3_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB1_week");
		System.out.println("PR_1200MTDAOLineB1_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB2_week");
		System.out.println("PR_1200MTDAOLineB2_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB3_week");
		System.out.println("PR_1200MTDAOLineB3_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC1_week");
		System.out.println("PR_1200MTDAOLineC1_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC2_week");
		System.out.println("PR_1200MTDAOLineC2_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC3_week");
		System.out.println("PR_1200MTDAOLineC3_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	
	
}
