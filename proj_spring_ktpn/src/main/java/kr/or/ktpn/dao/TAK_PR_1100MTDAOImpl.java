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

	@Override
	public List<TAK_PR_1100MTDTO> selectDTO_A() {
		List<TAK_PR_1100MTDTO> PR_1100MTDAO_A = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT_A");
		System.out.println("PR_1100MTDAO_A : " + PR_1100MTDAO_A);
		
		return PR_1100MTDAO_A;
	}

	@Override
	public List<TAK_PR_1100MTDTO> selectDTO_B() {
		List<TAK_PR_1100MTDTO> PR_1100MTDAO_B = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT_B");
		System.out.println("PR_1100MTDAO_B : " + PR_1100MTDAO_B);
		
		return PR_1100MTDAO_B;
	}

	@Override
	public List<TAK_PR_1100MTDTO> selectDTO_C() {
		List<TAK_PR_1100MTDTO> PR_1100MTDAO_C = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT_C");
		System.out.println("PR_1100MTDAO_C : " + PR_1100MTDAO_C);
		
		return PR_1100MTDAO_C;
	}
//insert
	@Override
	public int insertDTO(TAK_PR_1100MTDTO dto) {
		int inserCount = sqlSession.insert("mapper.TAK_PR_1100MTDTO.PM_1100MT_insert", dto);
		System.out.println("insertPR_1100MTDAO : " + inserCount);
		
		return inserCount;
	}
//	pm_popup 수정
	@Override
	public int updateDTO(TAK_PR_1100MTDTO dto) {
		int updateCount  = sqlSession.update("mapper.TAK_PR_1100MTDTO.PM_1100MT_update", dto);
		System.out.println("updateCount  : " + updateCount );
		
		return updateCount;
	}
//	pm_popup 완료
	@Override
	public int completeDTO(TAK_PR_1100MTDTO dto) {
		int updateCount  = sqlSession.update("mapper.TAK_PR_1100MTDTO.PM_1100MT_complete", dto);
		System.out.println("updateCount  : " + updateCount );
		
		return updateCount;
	}
	
	//생산관리관련 데이터
//	작업중
	@Override
	public List<TAK_PR_1100MTDTO> selectDTO_Y() {
		
		List<TAK_PR_1100MTDTO> PR_1100MTDAO = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1100MT_Y");
		System.out.println("PR_1100MTDAO : " + PR_1100MTDAO);
		
		return PR_1100MTDAO;
	}
	
	
	
	
	
	
	// 생산완료인 생산코드 가져오는 메소드
	@Override
	public List selectPcode() {
		// TODO Auto-generated method stub
			
		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectFinishAllPCode");
		System.out.println("result : " + result);
			
		return result;
	}

	// 완제품코드가 x이고 생산완료인 생산코드 가져오는 메소드
	@Override
	public List selectPFcode(String fcode) {
		// TODO Auto-generated method stub

		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectFinishAllPCodeFcode", fcode);
		System.out.println("result : " + result);
			
		return result;
	}

}
