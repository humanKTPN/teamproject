package kr.or.ktpn.dto;

import lombok.Data;

@Data
public class ProductionDto {

	
	 private String period;      // 예: 날짜(“2025-04-20”)
	    private int targetQty;      // 목표량
	    private int actualQty;      // 생산량
	    
	    private String prod_cd;
	    private String item_cd;
	    private String indc_qntt;
	    
	    
}
