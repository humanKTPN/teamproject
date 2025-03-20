import java.sql.Date;

public class BoardDTO {

	int BRD_NO;
	String BRD_SENM;
	String TTL_NM;
	String BRD_DESC;
	String BLND_YN;
	int VW_CNT;
	String DLT_YN;
	Date REG_DTTM;
	Date MOD_DTTM;
	String ID;

// this. 이게 왜 생기는 지 알아볼것
	public int getBRD_NO() {
		return BRD_NO;
	}

	public void setBRD_NO(int bRD_NO) {
		BRD_NO = bRD_NO;
	}

	public String getBRD_SENM() {
		return BRD_SENM;
	}

	public void setBRD_SENM(String bRD_SENM) {
		BRD_SENM = bRD_SENM;
	}

	public String getTTL_NM() {
		return TTL_NM;
	}

	public void setTTL_NM(String tTL_NM) {
		TTL_NM = tTL_NM;
	}

	public String getBRD_DESC() {
		return BRD_DESC;
	}

	public void setBRD_DESC(String bRD_DESC) {
		BRD_DESC = bRD_DESC;
	}

	public String getBLND_YN() {
		return BLND_YN;
	}

	public void setBLND_YN(String bLND_YN) {
		BLND_YN = bLND_YN;
	}

	public int getVW_CNT() {
		return VW_CNT;
	}

	public void setVW_CNT(int vW_CNT) {
		VW_CNT = vW_CNT;
	}

	public String getDLT_YN() {
		return DLT_YN;
	}

	public void setDLT_YN(String dLT_YN) {
		DLT_YN = dLT_YN;
	}

	public Date getREG_DTTM() {
		return REG_DTTM;
	}

	public void setREG_DTTM(Date rEG_DTTM) {
		REG_DTTM = rEG_DTTM;
	}

	public Date getMOD_DTTM() {
		return MOD_DTTM;
	}

	public void setMOD_DTTM(Date mOD_DTTM) {
		MOD_DTTM = mOD_DTTM;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "BoardDTO [BRD_NO=" + BRD_NO + ", BRD_SENM=" + BRD_SENM + ", TTL_NM=" + TTL_NM + ", BRD_DESC=" + BRD_DESC
				+ ", BLND_YN=" + BLND_YN + ", VW_CNT=" + VW_CNT + ", DLT_YN=" + DLT_YN + ", REG_DTTM=" + REG_DTTM
				+ ", MOD_DTTM=" + MOD_DTTM + ", ID=" + ID + "]";
	}

}
