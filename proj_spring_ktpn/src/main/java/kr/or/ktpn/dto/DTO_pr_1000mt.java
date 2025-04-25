package kr.or.ktpn.dto;





import java.sql.Date;

import lombok.Data;

@Data
public class DTO_pr_1000mt {

	private String prod_cd;
	private String prod_pln_cd;
	private String liun_cd;
	private String liun_nm;
	private String item_cd;
	private String item_nm;
	private String mngr_nm;
	private String prod_dt;
	private int indc_qntt;
	
	private String bom_cd;
	private String bom_desc;
	private String rt_cd;
	private String rt_desc;
	
	private String categories;
	private String key;
	private String str_dt;
	private String end_dt;
	
}
