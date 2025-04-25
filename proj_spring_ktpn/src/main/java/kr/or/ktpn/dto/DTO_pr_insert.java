package kr.or.ktpn.dto;
 
import java.sql.Date;

import lombok.Data;

@Data
public class DTO_pr_insert {
	
	private String mb_nm;
	private String ln_nm;
	private String h_pln_cd;
	private String h_item_cd;
	private String item_nm;
	private String indc_qntt;
	private Date prod_dt;
	private String h_ln_cd;
	private String bom_cd;
	private String bom_desc;
	private String rt_cd;
	private String rt_desc;
	private String prod_cd;

}
