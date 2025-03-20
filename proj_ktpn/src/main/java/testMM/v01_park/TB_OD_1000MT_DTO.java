package testMM.v01_park;


public class TB_OD_1000MT_DTO {

	// 거래처 테이블
	
	
	private String cstmr_code;					// 거래처 코드
	private String cmp_nm;						// 회사명			
	private String mngr_nm;						// 담당자명
	private String tel_no;						// 연락처번호
	private String trn_itm_item_nm;				// 거래품목명
	private String reg_dt;						// 입력일자
	private String mod_dt;						// 수정일자
	
	public String getCstmr_code() {
		return cstmr_code;
	}
	public void setCstmr_code(String cstmr_code) {
		this.cstmr_code = cstmr_code;
	}
	public String getCmp_nm() {
		return cmp_nm;
	}
	public void setCmp_nm(String cmp_nm) {
		this.cmp_nm = cmp_nm;
	}
	public String getMngr_nm() {
		return mngr_nm;
	}
	public void setMngr_nm(String mngr_nm) {
		this.mngr_nm = mngr_nm;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getTrn_itm_item_nm() {
		return trn_itm_item_nm;
	}
	public void setTrn_itm_item_nm(String trn_itm_item_nm) {
		this.trn_itm_item_nm = trn_itm_item_nm;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getMod_dt() {
		return mod_dt;
	}
	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}
	
	
	@Override
	public String toString() {
		return "TB_OD_1000MT_DTO [cstmr_code=" + cstmr_code + ", cmp_nm=" + cmp_nm + ", mngr_nm=" + mngr_nm
				+ ", tel_no=" + tel_no + ", trn_itm_item_nm=" + trn_itm_item_nm + ", reg_dt=" + reg_dt + ", mod_dt="
				+ mod_dt + "]";
	}
	
	
	
	
}
