package tb_md_1000mt;

public class DTO_MD_main_Kwak {
	
	private String MT_MNG_CD   ;
	private String MT_MNG_NM   ;
	private String IMG_PATH_ADR;
	private String MT_MNG_DESC ;
	
	public DTO_MD_main_Kwak(String mT_MNG_CD, String mT_MNG_NM, String mT_MNG_DESC) {
		// TODO Auto-generated constructor stub
		this.MT_MNG_CD = mT_MNG_CD;
        this.MT_MNG_NM = mT_MNG_NM;
        this.MT_MNG_DESC = mT_MNG_DESC;
        
	}
	public DTO_MD_main_Kwak(String MT_MNG_CD) {
		// TODO Auto-generated constructor stub
		this.MT_MNG_CD = MT_MNG_CD;
	}
	public DTO_MD_main_Kwak() {
		// TODO Auto-generated constructor stub
	}
	public DTO_MD_main_Kwak(String reMT_MNG_CD, String reMT_MNG_NM, String reMT_MNG_DESC, String reIMG_PATH_ADR) {
		this.MT_MNG_CD = reMT_MNG_CD;
        this.MT_MNG_NM = reMT_MNG_NM;
        this.MT_MNG_DESC = reMT_MNG_DESC;
        this.IMG_PATH_ADR = reIMG_PATH_ADR;
	}
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
	public String getIMG_PATH_ADR() {
		return IMG_PATH_ADR;
	}
	public void setIMG_PATH_ADR(String iMG_PATH_ADR) {
		IMG_PATH_ADR = iMG_PATH_ADR;
	}
	public String getMT_MNG_DESC() {
		return MT_MNG_DESC;
	}
	public void setMT_MNG_DESC(String mT_MNG_DESC) {
		MT_MNG_DESC = mT_MNG_DESC;
	}
	

}
