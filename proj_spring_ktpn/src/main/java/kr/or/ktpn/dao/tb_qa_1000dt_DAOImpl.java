package kr.or.ktpn.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class tb_qa_1000dt_DAOImpl implements tb_qa_1000dt_DAO {

	@Autowired
	SqlSession sqlSession;
	
	// 안쓰는 파일
}
