package kr.or.ktpn.dto;

import lombok.Data;

@Data
public class TAK_PR_1100MTDTO {

	private String prod_cd;                   	//생산코드
	private String mt_mng_cd;					//라인호기코드	
	private String liun_nm;					    //라인호기명	
	private String item_nm;						//품목명
	private String item_cd;						//품목코드
	private String prod_strt_time;				//생산시작시간
	private String prod_end_time;				//생산완료시간
	private int    indc_qntt;						//지시수량
	private int    prod_qntt;						//생산량
	private String work_nm;						//작업자명
	private String eqpm_oprt_stts_val;			//장비가동상태값
	private String prod_end_yn;					//생산완료여부
	private int dfc_rt;						//불량률

	private int total_prod_qntt; //일별 생산량
	private int total_prod_qntt_ssg; // 싹싹  생산량
	private int total_prod_qntt_hh; // 하츄핑 생산량
	private int total_dfc_rt;
	private int defect_rate;
}
