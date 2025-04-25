package kr.or.ktpn.dto;

import lombok.Data;

@Data
public class TAK_PR_1110MTDTO {

	String prod_pln_cd;   			//생산일정코드
	String item_nm;					//품목명
	int    trg_prod_cnt;				//목표생산수량
	String prod_strt_dt;			//생산시작일자
	String prod_end_dt;				//생산완료일자
	String item_cd;
}
