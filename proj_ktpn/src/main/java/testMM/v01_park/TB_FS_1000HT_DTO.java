package testMM.v01_park;

import java.sql.Date;

public class TB_FS_1000HT_DTO {

	// 완제품 로그 테이블
	
	private String sn;						// 순번
	private String prod_cd;					// 생산코드
	private String fnsh_code;           	// 완제품코드
	private String fnshd_item_nm;       	// 완제품명
	private int    crnt_cnt;               	// 변동수량
	private int    crnt_aftr_cnt;          	// 변동 후 수량
	private String chng_dt;             	// 변동일자
	private String iob_se_cd;           	// 변동(입출고)구분코드
	private String work_nm;             	// 작업자명
	private String fnshl_loc_nm;        	// 완제품위치명
	private String rmrk;                	// 비고
	private Date   reg_dttm;              	// 입력일시
	
	
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getProd_cd() {
		return prod_cd;
	}
	public void setProd_cd(String prod_cd) {
		this.prod_cd = prod_cd;
	}
	public String getFnsh_code() {
		return fnsh_code;
	}
	public void setFnsh_code(String fnsh_code) {
		this.fnsh_code = fnsh_code;
	}
	public String getFnshd_item_nm() {
		return fnshd_item_nm;
	}
	public void setFnshd_item_nm(String fnshd_item_nm) {
		this.fnshd_item_nm = fnshd_item_nm;
	}
	public int getCrnt_cnt() {
		return crnt_cnt;
	}
	public void setCrnt_cnt(int crnt_cnt) {
		this.crnt_cnt = crnt_cnt;
	}
	public int getCrnt_aftr_cnt() {
		return crnt_aftr_cnt;
	}
	public void setCrnt_aftr_cnt(int crnt_aftr_cnt) {
		this.crnt_aftr_cnt = crnt_aftr_cnt;
	}
	public String getChng_dt() {
		return chng_dt;
	}
	public void setChng_dt(String chng_dt) {
		this.chng_dt = chng_dt;
	}
	public String getIob_se_cd() {
		return iob_se_cd;
	}
	public void setIob_se_cd(String iob_se_cd) {
		this.iob_se_cd = iob_se_cd;
	}
	public String getWork_nm() {
		return work_nm;
	}
	public void setWork_nm(String work_nm) {
		this.work_nm = work_nm;
	}
	public String getFnshl_loc_nm() {
		return fnshl_loc_nm;
	}
	public void setFnshl_loc_nm(String fnshl_loc_nm) {
		this.fnshl_loc_nm = fnshl_loc_nm;
	}
	public String getRmrk() {
		return rmrk;
	}
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
	public Date getReg_dttm() {
		return reg_dttm;
	}
	public void setReg_dttm(Date reg_dttm) {
		this.reg_dttm = reg_dttm;
	}
	
	
	@Override
	public String toString() {
		return "TB_FS_1000HT_DTO [sn=" + sn + ", prod_cd=" + prod_cd + ", fnsh_code=" + fnsh_code + ", fnshd_item_nm="
				+ fnshd_item_nm + ", crnt_cnt=" + crnt_cnt + ", crnt_aftr_cnt=" + crnt_aftr_cnt + ", chng_dt=" + chng_dt
				+ ", iob_se_cd=" + iob_se_cd + ", work_nm=" + work_nm + ", fnshl_loc_nm=" + fnshl_loc_nm + ", rmrk="
				+ rmrk + ", reg_dttm=" + reg_dttm + "]";
	}
	
	
}
