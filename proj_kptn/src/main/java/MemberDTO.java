import java.sql.Date;

public class MemberDTO {

	String id;
	String pw;
	String mbr_nm;
	String ytn_yn;
	Date reg_dttm;
	Date mod_dttm;
	String mbr_senm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMbr_nm() {
		return mbr_nm;
	}
	public void setMbr_nm(String mbr_nm) {
		this.mbr_nm = mbr_nm;
	}
	public String getYtn_yn() {
		return ytn_yn;
	}
	public void setYtn_yn(String ytn_yn) {
		this.ytn_yn = ytn_yn;
	}
	public Date getReg_dttm() {
		return reg_dttm;
	}
	public void setReg_dttm(Date reg_dttm) {
		this.reg_dttm = reg_dttm;
	}
	public Date getMod_dttm() {
		return mod_dttm;
	}
	public void setMod_dttm(Date mod_dttm) {
		this.mod_dttm = mod_dttm;
	}
	public String getMbr_senm() {
		return mbr_senm;
	}
	public void setMbr_senm(String mbr_senm) {
		this.mbr_senm = mbr_senm;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", mbr_nm=" + mbr_nm + ", ytn_yn=" + ytn_yn + ", reg_dttm="
				+ reg_dttm + ", mod_dttm=" + mod_dttm + ", mbr_senm=" + mbr_senm + "]";
	}
	
	
}


