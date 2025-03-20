package testMM.v01_park;

public class testProduct_DTO {
	
	// 생산 테이블 테스트
	
	private String PROD_CD;				// 생산코드
	private int PROD_QNTT;				// 생산량
	private String PROD_END_YN;			// 생산 완료 여부 - 자바에서 필요없음
	
	public String getProd_cd() {
		return PROD_CD;
	}
	public void setProd_cd(String pROD_CD) {
		PROD_CD = pROD_CD;
	}
	public int getPROD_QNTT() {
		return PROD_QNTT;
	}
	public void setProd_qntt(int pROD_QNTT) {
		PROD_QNTT = pROD_QNTT;
	}
	public String getPROD_END_YN() {
		return PROD_END_YN;
	}
	public void setPROD_END_YN(String pROD_END_YN) {
		PROD_END_YN = pROD_END_YN;
	}
	
	
	@Override
	public String toString() {
		return "testProduct_DTO [PROD_CD=" + PROD_CD + ", PROD_QNTT=" + PROD_QNTT + ", PROD_END_YN=" + PROD_END_YN
				+ "]";
	}
	
}
