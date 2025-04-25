package kr.or.ktpn.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class tb_fs_1000ht_DTO {

	// 완제품 로그 테이블

	private String sn; // 순번
	private String prod_cd; // 생산코드
	private String fnsh_code; // 완제품코드
	private String fnshd_item_nm; // 완제품명
	private int crnt_cnt; // 변동수량
	private int crnt_aftr_cnt; // 변동 후 수량
	private String chng_dt; // 변동일자
	private String iob_se_cd; // 변동(입출고)구분코드
	private String work_nm; // 작업자명
	private String fnshl_loc_nm; // 완제품위치명
	private String rmrk; // 비고
	private Date reg_dttm; // 입력일시
	
	private int findlognum; // 잘못된 로그찾는 변수
	
	
	private String type;		// 검색할 타입
	private String keyword;		// 검색할 키워드
	
	private int page = 1;		// 현재 페이지
	private int viewCount = 10;	// 페이지당 보여줄 수 countPerPage rowPerPage
	private int indexStart;
	private int indexEnd;
}
