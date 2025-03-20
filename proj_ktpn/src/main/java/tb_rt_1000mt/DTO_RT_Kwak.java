package tb_rt_1000mt;

public class DTO_RT_Kwak {

	private String RT_CD;
	private String ITEM_CD;
	private String RT_NM;
	private String IMG_PATH_ADR;
	private String RT_DESC;
	
	public DTO_RT_Kwak(String rt_cd2, String rt_nm2) {
		RT_CD = rt_cd2;
		RT_NM = rt_nm2;
	}
	public DTO_RT_Kwak() {
		// TODO Auto-generated constructor stub
	}
	public DTO_RT_Kwak(String rt_cd2, String rt_nm2, String item_cd2, String rt_desc2) {
		// TODO Auto-generated constructor stub
		RT_CD = rt_cd2;
		RT_NM = rt_nm2;
		ITEM_CD = item_cd2;
		RT_DESC = rt_desc2;
	}
	public String getRT_CD() {
		return RT_CD;
	}
	public void setRT_CD(String rT_CD) {
		RT_CD = rT_CD;
	}
	public String getITEM_CD() {
		return ITEM_CD;
	}
	public void setITEM_CD(String iTEM_CD) {
		ITEM_CD = iTEM_CD;
	}
	public String getRT_NM() {
		return RT_NM;
	}
	public void setRT_NM(String rT_NM) {
		RT_NM = rT_NM;
	}
	public String getIMG_PATH_ADR() {
		return IMG_PATH_ADR;
	}
	public void setIMG_PATH_ADR(String iMG_PATH_ADR) {
		IMG_PATH_ADR = iMG_PATH_ADR;
	}
	public String getRT_DESC() {
		return RT_DESC;
	}
	public void setRT_DESC(String rT_DESC) {
		RT_DESC = rT_DESC;
	}
	
	
	
}
