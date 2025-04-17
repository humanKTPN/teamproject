package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ktpn.dto.TAK_MD_1000MTDTO;

public class TAK_MD_1000MTDAOImpl implements TAK_MD_1000MTDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<TAK_MD_1000MTDTO> selectDTO() {

		List<TAK_MD_1000MTDTO> MD_1000MTDAO = sqlSession.selectList("mapper.TAK_MD_1000MTDTO.MD_1000MT");
		System.out.println("MD_1000MTDAO : " + MD_1000MTDAO);
		
		return MD_1000MTDAO;
	}
	
}
