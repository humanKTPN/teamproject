package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

@Repository
public class KW_DAO_fboard_1000mtimpl implements KW_DAO_fboard_1000mt {

	@Autowired
	SqlSession sqls;
	
	@Override
	public List<KW_DTO_BR_1000MT> selectFBoard(){
		List<KW_DTO_BR_1000MT> list = sqls.selectList("mapper.TB_BR_1000MT1.selectfbc");
		System.out.println("fb list : " + list);
		return list;
	}
	
	
}
