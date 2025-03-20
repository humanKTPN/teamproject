package testMM.v01_park;

import java.sql.Date;

public class TB_MR_1000HT_DTO {
	
	// 원자재 로그 테이블
	
	private String sn;					// 순번
	private String mtrl_cd;				// 원자재코드
	private String mtrl_nm;            // 원자재명
	private int    stn_cnt;               // 기준수량
	private int    crnt_cnt;              // 변동수량
	private int    crnt_aftr_cnt;         // 변동 후 수량
	private String chng_dt;            // 변동일자	
	private String iob_se_cd;          // 변동(입출고)구분코드
	private String ordr_rqrd_yn;       // 주문필요여부
	private String work_nm;            // 작업자명
	private String mtrl_cd_nm;         // 원자재위치명
	private String rmrk;               // 비고
	private Date   reg_dttm;             // 입력일시
	
	
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getMtrl_cd() {
		return mtrl_cd;
	}
	public void setMtrl_cd(String mtrl_cd) {
		this.mtrl_cd = mtrl_cd;
	}
	public String getMtrl_nm() {
		return mtrl_nm;
	}
	public void setMtrl_nm(String mtrl_nm) {
		this.mtrl_nm = mtrl_nm;
	}
	public int getStn_cnt() {
		return stn_cnt;
	}
	public void setStn_cnt(int stn_cnt) {
		this.stn_cnt = stn_cnt;
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
	public String getOrdr_rqrd_yn() {
		return ordr_rqrd_yn;
	}
	public void setOrdr_rqrd_yn(String ordr_rqrd_yn) {
		this.ordr_rqrd_yn = ordr_rqrd_yn;
	}
	public String getWork_nm() {
		return work_nm;
	}
	public void setWork_nm(String work_nm) {
		this.work_nm = work_nm;
	}
	public String getMtrl_cd_nm() {
		return mtrl_cd_nm;
	}
	public void setMtrl_cd_nm(String mtrl_cd_nm) {
		this.mtrl_cd_nm = mtrl_cd_nm;
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
		return "TB_MR_1000HT_DTO [sn=" + sn + ", mtrl_cd=" + mtrl_cd + ", mtrl_nm=" + mtrl_nm + ", stn_cnt=" + stn_cnt
				+ ", crnt_cnt=" + crnt_cnt + ", crnt_aftr_cnt=" + crnt_aftr_cnt + ", chng_dt=" + chng_dt
				+ ", iob_se_cd=" + iob_se_cd + ", ordr_rqrd_yn=" + ordr_rqrd_yn + ", work_nm=" + work_nm
				+ ", mtrl_cd_nm=" + mtrl_cd_nm + ", rmrk=" + rmrk + ", reg_dttm=" + reg_dttm + "]";
	}
	
	
	
	
}
