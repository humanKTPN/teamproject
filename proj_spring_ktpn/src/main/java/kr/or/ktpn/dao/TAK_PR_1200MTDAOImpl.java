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

	//가동현황 데이터
	@Override
	public List selectNYDTO() {
		List PR_1200MTDAO = sqlSession.selectList("mapper.TAK_PR_1200MTDTO.pr_1100MT_NY");
		System.out.println("PR_1200MTDAO_NY : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	//라인별호기 금일 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1DTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA1");
		System.out.println("PR_1200MTDAOLineA1 : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	//품목별 데이터
	
	//일별
	@Override
	public TAK_PR_1100MTDTO selectSSGDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_SSG");
		System.out.println("PR_1200MTDAO_SSG : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectHHDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_HH");
		System.out.println("PR_1200MTDAO_HH : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	//주별
	@Override
	public TAK_PR_1100MTDTO selectSSG_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_SSG_week");
		System.out.println("PR_1200MTDAOSSG_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectHH_weekDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_HH_week");
		System.out.println("PR_1200MTDAOHH_week : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	//월별
	@Override
	public TAK_PR_1100MTDTO selectSSG_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_SSG_month");
		System.out.println("PR_1200MTDAOSSG_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectHH_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_HH_month");
		System.out.println("PR_1200MTDAOHH_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	
	
	//원형 그래프 데이터
		@Override
		public TAK_PR_1100MTDTO selectSSDTO() {
			
			TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_SS");
			System.out.println("PR_1200MTDAO_SS : " + PR_1200MTDAO);
			
			return PR_1200MTDAO;
		}
		@Override
		public TAK_PR_1100MTDTO selectSS_IQDTO() {
			
			TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_SS_IQ");
			System.out.println("PR_1200MTDAO_SS_IQ : " + PR_1200MTDAO);
			
			return PR_1200MTDAO;
		}
		@Override
		public TAK_PR_1100MTDTO selectSS_DRDTO() {
			
			TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_SS_DR");
			System.out.println("PR_1200MTDAO_SS_DR : " + PR_1200MTDAO);
			
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
	
	
	//라인별호기 금월 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA1_month");
		System.out.println("PR_1200MTDAOLineA1_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA2_month");
		System.out.println("PR_1200MTDAOLineA2_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA3_month");
		System.out.println("PR_1200MTDAOLineA3_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB1_month");
		System.out.println("PR_1200MTDAOLineB1_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB2_month");
		System.out.println("PR_1200MTDAOLineB2_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB3_month");
		System.out.println("PR_1200MTDAOLineB3_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC1_month");
		System.out.println("PR_1200MTDAOLineC1_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC2_month");
		System.out.println("PR_1200MTDAOLineC2_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3_monthDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC3_month");
		System.out.println("PR_1200MTDAOLineC3_month : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	//라인별호기 금월 불량률 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA1_month_DR");
		System.out.println("PR_1200MTDAOLineA1_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA2_month_DR");
		System.out.println("PR_1200MTDAOLineA2_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineA3_month_DR");
		System.out.println("PR_1200MTDAOLineA3_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB1_month_DR");
		System.out.println("PR_1200MTDAOLineB1_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB2_month_DR");
		System.out.println("PR_1200MTDAOLineB2_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineB3_month_DR");
		System.out.println("PR_1200MTDAOLineB3_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC1_month_DR");
		System.out.println("PR_1200MTDAOLineC1_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC2_month_DR");
		System.out.println("PR_1200MTDAOLineC2_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3_month_DRDTO() {
		
		TAK_PR_1100MTDTO PR_1200MTDAO = sqlSession.selectOne("mapper.TAK_PR_1200MTDTO.pr_1100MT_lineC3_month_DR");
		System.out.println("PR_1200MTDAOLineC3_month_DR : " + PR_1200MTDAO);
		
		return PR_1200MTDAO;
	}
	
	
	
}
