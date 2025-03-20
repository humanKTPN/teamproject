package testMM.v01_park;

public class TB_MR_1000MT_DTO {

	// 원자재 현재 재고 테이블

	private String mtrl_cd; // 원자재코드
	private String mtrl_nm; // 원자재명
	private int stn_cnt; // 기준수량
	private int crnt_aftr_cnt; // 변동 후 수량
	private String ordr_rqrd_yn; // 주문필요여부
	private String mtrl_loc_nm; // 원자재위치

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

	public int getCrnt_aftr_cnt() {
		return crnt_aftr_cnt;
	}

	public void setCrnt_aftr_cnt(int crnt_aftr_cnt) {
		this.crnt_aftr_cnt = crnt_aftr_cnt;
	}

	public String getOrdr_rqrd_yn() {
		return ordr_rqrd_yn;
	}

	public void setOrdr_rqrd_yn(String ordr_rqrd_yn) {
		this.ordr_rqrd_yn = ordr_rqrd_yn;
	}

	public String getMtrl_loc_nm() {
		return mtrl_loc_nm;
	}

	public void setMtrl_loc_nm(String mtrl_loc_nm) {
		this.mtrl_loc_nm = mtrl_loc_nm;
	}

	@Override
	public String toString() {
		return "TB_MR_1000MT_DTO [mtrl_cd=" + mtrl_cd + ", mtrl_nm=" + mtrl_nm + ", stn_cnt=" + stn_cnt
				+ ", crnt_aftr_cnt=" + crnt_aftr_cnt + ", ordr_rqrd_yn=" + ordr_rqrd_yn + ", mtrl_loc_nm=" + mtrl_loc_nm
				+ "]";
	}

}
