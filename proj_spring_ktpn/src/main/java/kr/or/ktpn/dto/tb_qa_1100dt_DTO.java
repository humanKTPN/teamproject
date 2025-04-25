package kr.or.ktpn.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class tb_qa_1100dt_DTO {

	// 생산코드빼고 생산 부분이 없는 QA리포트 테이블 // 생산 코드로 생산테이블과 조인해서 조회

	private String prod_cd; // 생산코드
	private String item_cd; // 품목코드
	private String item_nm; // 품목명
	private String chckr_nm; // 검수자명
	private Date chckr_dttm; // 검수일시
	private int strth_val; // 강도값
	private int sz_val; // 크기값
	private String clrl_val; // 색상값
	private int qlty_val; // 픔질값
	private String fail_caus_desc; // 불합격사유내용
	private String rmrk; // 비고
	
	
	private String type;		// 검색할 타입
	private String keyword;		// 검색할 키워드
	
	private int page = 1;		// 현재 페이지
	private int viewCount = 10;	// 페이지당 보여줄 수 countPerPage rowPerPage
	private int indexStart;
	private int indexEnd;
}
