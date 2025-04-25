package kr.or.ktpn.dto;

import lombok.Data;

@Data
public class TAK_PR_1200MTDTO {

	String liun_nm;			//라인호기명
	String item_nm;			//품목명
	String unit_no;			//호기번호
	int    dly_prdc_qntt;		//일별생산량
	int    dly_dfc_rt;			//일별불량률
	int    indc_qntt;			//지시수량
}
