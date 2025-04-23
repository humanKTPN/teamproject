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

}
