import java.sql.Date;

public class WriteprocessDTO {

	String TTL_NM;
	String DRD_DESC;
	Date REG_DTTM;
	String ID;

	public String getTTL_NM() {
		return TTL_NM;
	}

	public void setTTL_NM(String tTL_NM) {
		TTL_NM = tTL_NM;
	}

	public String getDRD_DESC() {
		return DRD_DESC;
	}

	public void setDRD_DESC(String dRD_DESC) {
		DRD_DESC = dRD_DESC;
	}

	public Date getREG_DTTM() {
		return REG_DTTM;
	}

	public void setREG_DTTM(Date rEG_DTTM) {
		REG_DTTM = rEG_DTTM;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "WriteprocessDTO [TTL_NM=" + TTL_NM + ", DRD_DESC=" + DRD_DESC + ", REG_DTTM=" + REG_DTTM + ", ID=" + ID
				+ "]";
	}

}
