package testMM.v01_park;

public class testSM_DTO {
	
	// 테스트 기준관리 테이블
	
	private String MT_MNG_CD;		// 기준관리코드 
	private String MT_MNG_NM;		// 기준관리명
	private String TP_CLS_VAL;		// 유형분류코드
	
	public String getMT_MNG_CD() {
		return MT_MNG_CD;
	}
	public void setMT_MNG_CD(String mT_MNG_CD) {
		MT_MNG_CD = mT_MNG_CD;
	}
	public String getMT_MNG_NM() {
		return MT_MNG_NM;
	}
	public void setMT_MNG_NM(String mT_MNG_NM) {
		MT_MNG_NM = mT_MNG_NM;
	}
	public String getTP_CLS_VAL() {
		return TP_CLS_VAL;
	}
	public void setTP_CLS_VAL(String tP_CLS_VAL) {
		TP_CLS_VAL = tP_CLS_VAL;
	}
	
	@Override
	public String toString() {
		return "testSM_DTO [MT_MNG_CD=" + MT_MNG_CD + ", MT_MNG_NM=" + MT_MNG_NM + ", TP_CLS_VAL=" + TP_CLS_VAL + "]";
	}
	
	
}
