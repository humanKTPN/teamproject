package testMM.v01_park;

public class testMember_DTO {
	
	// 회원 테이블 - 작업자
	
	private String ID;					// id
	private String PW;					// pw
	private String MBR_NM;				// 회원이름
	private String MBR_SENM;			// 회원구분명
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getMBR_NM() {
		return MBR_NM;
	}
	public void setMBR_NM(String mBR_NM) {
		MBR_NM = mBR_NM;
	}
	public String getMBR_SENM() {
		return MBR_SENM;
	}
	public void setMBR_SENM(String mBR_SENM) {
		MBR_SENM = mBR_SENM;
	}
	
	
	@Override
	public String toString() {
		return "testMember_DTO [ID=" + ID + ", PW=" + PW + ", MBR_NM=" + MBR_NM + ", MBR_SENM=" + MBR_SENM + "]";
	}
	
}
