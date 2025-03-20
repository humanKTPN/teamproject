package testQA.v01_park;

import java.sql.Date;

public class TB_QA_1100DT_DTO {

	// 생산코드빼고 생산 부분이 없는 QA리포트 테이블 // 생산 코드로 생산테이블과 조인해서 조회
	
	private String prod_cd;					   // 생산코드
	private String item_cd;                   // 품목코드
	private String item_nm;                   // 품목명
	private String chckr_nm;                  // 검수자명
	private Date   chckr_dttm;                  // 검수일시
	private int    strth_val;                    // 강도값
	private int    sz_val;                       // 크기값
	private String Clrl_val;                  // 색상값
	private int    qlty_val;                     // 픔질값
	private String fail_caus_desc;            // 불합격사유내용
	private String rmrk;                      // 비고
	
	
	public String getProd_cd() {
		return prod_cd;
	}
	public void setProd_cd(String prod_cd) {
		this.prod_cd = prod_cd;
	}
	public String getItem_cd() {
		return item_cd;
	}
	public void setItem_cd(String item_cd) {
		this.item_cd = item_cd;
	}
	public String getItem_nm() {
		return item_nm;
	}
	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}
	public String getChckr_nm() {
		return chckr_nm;
	}
	public void setChckr_nm(String chckr_nm) {
		this.chckr_nm = chckr_nm;
	}
	public Date getChckr_dttm() {
		return chckr_dttm;
	}
	public void setChckr_dttm(Date chckr_dttm) {
		this.chckr_dttm = chckr_dttm;
	}
	public int getStrth_val() {
		return strth_val;
	}
	public void setStrth_val(int strth_val) {
		this.strth_val = strth_val;
	}
	public int getSz_val() {
		return sz_val;
	}
	public void setSz_val(int sz_val) {
		this.sz_val = sz_val;
	}
	public String getClrl_val() {
		return Clrl_val;
	}
	public void setClrl_val(String Clrl_val) {
		this.Clrl_val = Clrl_val;
	}
	public int getQlty_val() {
		return qlty_val;
	}
	public void setQlty_val(int qlty_val) {
		this.qlty_val = qlty_val;
	}
	public String getFail_caus_desc() {
		return fail_caus_desc;
	}
	public void setFail_caus_desc(String fail_caus_desc) {
		this.fail_caus_desc = fail_caus_desc;
	}
	public String getRmrk() {
		return rmrk;
	}
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
	
	
	@Override
	public String toString() {
		return "TB_QA_1100DT_DTO [prod_cd=" + prod_cd + ", item_cd=" + item_cd + ", item_nm=" + item_nm + ", chckr_nm="
				+ chckr_nm + ", chckr_dttm=" + chckr_dttm + ", strth_val=" + strth_val + ", sz_val=" + sz_val
				+ ", Clrl_val=" + Clrl_val + ", qlty_val=" + qlty_val + ", fail_caus_desc=" + fail_caus_desc + ", rmrk="
				+ rmrk + "]";
	}
	
	
	
	
}
