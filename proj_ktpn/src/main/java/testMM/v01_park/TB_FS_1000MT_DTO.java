package testMM.v01_park;

public class TB_FS_1000MT_DTO {

	// 완제품 현재 재고 테이블
	
	private String fnsh_code;            // 완제품 코드
	private String fnsh_nm;              // 완제품명
	private int    crnt_aftr_cnt;           // 변동 후 수량
	private String fnsh_loc_nm;          // 완제품 위치
	
	
	public String getFnsh_code() {
		return fnsh_code;
	}
	public void setFnsh_code(String fnsh_code) {
		this.fnsh_code = fnsh_code;
	}
	public String getFnsh_nm() {
		return fnsh_nm;
	}
	public void setFnsh_nm(String fnsh_nm) {
		this.fnsh_nm = fnsh_nm;
	}
	public int getCrnt_aftr_cnt() {
		return crnt_aftr_cnt;
	}
	public void setCrnt_aftr_cnt(int crnt_aftr_cnt) {
		this.crnt_aftr_cnt = crnt_aftr_cnt;
	}
	public String getFnsh_loc_nm() {
		return fnsh_loc_nm;
	}
	public void setFnsh_loc_nm(String fnsh_loc_nm) {
		this.fnsh_loc_nm = fnsh_loc_nm;
	}
	
	
	@Override
	public String toString() {
		return "TB_FS_1000MT_DTO [fnsh_code=" + fnsh_code + ", fnsh_nm=" + fnsh_nm + ", crnt_aftr_cnt=" + crnt_aftr_cnt
				+ ", fnsh_loc_nm=" + fnsh_loc_nm + "]";
	}
	
	
	
	
	
}
