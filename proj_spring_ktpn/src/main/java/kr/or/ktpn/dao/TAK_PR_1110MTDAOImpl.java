package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

@Repository
public class TAK_PR_1110MTDAOImpl implements TAK_PR_1110MTDAO {

	private final String namespace = "ProductionScheduleMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<TAK_PR_1110MTDTO> selectDTO() {

		List<TAK_PR_1110MTDTO> PR_1110MTDAO = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1110MT");
		System.out.println("PR_1110MTDAO : " + PR_1110MTDAO);
		
		return PR_1110MTDAO;
	}
//  insert
	@Override
	public int insertDTO(TAK_PR_1110MTDTO dto) {
		int insertCount  = sqlSession.insert("mapper.TAK_PR_1100MTDTO.PR_1110MT_insert", dto);
		System.out.println("insertCount  : " + insertCount );
		
		return insertCount;
	}
//	pr_popup 수정
	@Override
	public int updateDTO(TAK_PR_1110MTDTO dto) {
		int updateCount  = sqlSession.update("mapper.TAK_PR_1100MTDTO.PR_1110MT_update", dto);
		System.out.println("updateCount  : " + updateCount );
		
		return updateCount;
	}
//	pr_popup 완료
	@Override
	public int completeDTO(TAK_PR_1110MTDTO dto) {
		int updateCount  = sqlSession.update("mapper.TAK_PR_1100MTDTO.PR_1110MT_complete", dto);
		System.out.println("updateCount  : " + updateCount );
		
		return updateCount;
	}
//	일정조회
	@Override
    public List<TAK_PR_1110MTDTO> findByDateRange(TAK_PR_1110MTDTO dto) {
        return sqlSession.selectList("mapper.TAK_PR_1100MTDTO.findByDateRange", dto);
    }
	
	
	


}
