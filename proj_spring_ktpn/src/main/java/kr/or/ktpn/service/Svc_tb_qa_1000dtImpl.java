package kr.or.ktpn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.tb_qa_1000dt_DAO;

@Service
public class Svc_tb_qa_1000dtImpl implements Svc_tb_qa_1000dt {

	@Autowired
	tb_qa_1000dt_DAO tb_qa_1000dt_dao;
	
	// 안쓰는 파일
}
