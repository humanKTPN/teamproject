package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;

@Repository
public class KW_DAO_mb_1000mtimpl implements KW_DAO_mb_1000mt {

	@Autowired
	SqlSession sqls;
	
	@Override
	public List<KW_DTO_MB_1000MT> selectMember() {
		List<KW_DTO_MB_1000MT> list = sqls.selectList("mapper.TB_MB_1000MT.selectMb");
		System.out.println("mb list : "+ list);
		return list;
	}
	
	@Override
	public KW_DTO_MB_1000MT selectMemberId(String id) {
		KW_DTO_MB_1000MT result = sqls.selectOne("mapper.TB_MB_1000MT.selectMbOne", id);
		System.out.println("mbone result : "+ result);
		return result;
	}
	
	@Override
	public int update(KW_DTO_MB_1000MT dto) {
		int cn = sqls.update("mapper.TB_MB_1000MT.updatemb", dto);
		System.out.println("nb1 cn : "+ cn);
		return cn;
	}

	public int delete(String id){
		 System.out.println("너가 괴롭히는 "+id);
	        return sqls.delete("mapper.TB_BR_1000MT.deletemb", id);
	}
	
	
	
	
	
	
	// 작업자(일반회원) 가져오는 메소드
	@Override
	public List selectWorker() {
		// TODO Auto-generated method stub
			
		List result = sqls.selectList("mapper.tb_mr_1000mt.selectAllWorker");
		System.out.println("result : " + result);
			
		return result;
	}
}
