package kr.or.ktpn.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class tb_qa_1000dt_DTO {

	// QA리포트 테이블 - 품질 테이블과 생산 테이블 조인

	private String prod_cd; // 생산코드
	private String item_cd; // 품목코드
	private String item_nm; // 품목명
	private String work_nm; // 작업자명
	private String prod_end_time; // 생산완료시간
	private int indc_qntt; // 지시수량
	private int prod_qntt; // 생산량
	private int dfc_rt; // 불량률
	private String chckr_nm; // 검수자명
	private Date chckr_dttm; // 검수일시
	private int strth_val; // 강도값
	private int sz_val; // 크기값
	private String clrl_val; // 색상값
	private int qlty_val; // 픔질값
	private String fail_caus_desc; // 불합격사유내용
	private String rmrk; // 비고
}
