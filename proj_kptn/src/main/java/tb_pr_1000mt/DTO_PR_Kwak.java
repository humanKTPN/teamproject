package tb_pr_1000mt;

public class DTO_PR_Kwak {

	private String PROD_CD;
	private String PROD_PLN_CD;
	private String LIUN_CD;
	private int LIUN_NM;
	private String ITEM_CD;
	private String ITEM_NM;
	private String MNGR_NM;
	private String PROD_DT;
	private String INDC_QNTT;
	private String PR_MB_NM;
	private String LINE_CD;
	private String LINE_NM;
	
	private String BOM_CD2;
	private String BOM_DESC;
	private String RT_CD2;
	private String RT_DESC;
	
	private String cate;
	private String sch;
	
	
	


	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getSch() {
		return sch;
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	public DTO_PR_Kwak(String pr_mb_nm2) {
		// TODO Auto-generated constructor stub
		PR_MB_NM = pr_mb_nm2;
	}
	public DTO_PR_Kwak(String line_cd, String line_nm) {
		// TODO Auto-generated constructor stub
		LINE_CD = line_cd;
		LINE_NM = line_nm;
	}
	public DTO_PR_Kwak(String pr_pln_cd, String item_nm2, String trg_cnt, String item_cd2, String bom_cd2,
			String bom_desc, String rt_cd2, String rt_desc) {
		PROD_PLN_CD = pr_pln_cd;
		ITEM_NM = item_nm2;
		INDC_QNTT = trg_cnt;
		ITEM_CD = item_cd2;
		BOM_CD2 = bom_cd2;
		BOM_DESC = bom_desc;
		RT_CD2 = rt_cd2;
		RT_DESC = rt_desc;
	}
	
	public DTO_PR_Kwak() {
		// TODO Auto-generated constructor stub
	}
	public String getBOM_CD2() {
		return BOM_CD2;
	}
	public void setBOM_CD2(String bOM_CD2) {
		BOM_CD2 = bOM_CD2;
	}
	public String getBOM_DESC() {
		return BOM_DESC;
	}
	public void setBOM_DESC(String bOM_DESC) {
		BOM_DESC = bOM_DESC;
	}
	public String getRT_CD2() {
		return RT_CD2;
	}
	public void setRT_CD2(String rT_CD2) {
		RT_CD2 = rT_CD2;
	}
	public String getRT_DESC() {
		return RT_DESC;
	}
	public void setRT_DESC(String rT_DESC) {
		RT_DESC = rT_DESC;
	}
	public String getLINE_CD() {
		return LINE_CD;
	}
	public void setLINE_CD(String lINE_CD) {
		LINE_CD = lINE_CD;
	}
	public String getLINE_NM() {
		return LINE_NM;
	}
	public void setLINE_NM(String lINE_NM) {
		LINE_NM = lINE_NM;
	}
	public String getPR_MB_NM() {
		return PR_MB_NM;
	}
	public void setPR_MB_NM(String pR_MB_NM) {
		PR_MB_NM = pR_MB_NM;
	}
	public String getITEM_NM() {
		return ITEM_NM;
	}
	public void setITEM_NM(String iTEM_NM) {
		ITEM_NM = iTEM_NM;
	}
	public String getPROD_CD() {
		return PROD_CD;
	}
	public void setPROD_CD(String pROD_CD) {
		PROD_CD = pROD_CD;
	}
	public String getPROD_PLN_CD() {
		return PROD_PLN_CD;
	}
	public void setPROD_PLN_CD(String pROD_PLN_CD) {
		PROD_PLN_CD = pROD_PLN_CD;
	}
	public String getLIUN_CD() {
		return LIUN_CD;
	}
	public void setLIUN_CD(String lIUN_CD) {
		LIUN_CD = lIUN_CD;
	}
	public int getLIUN_NM() {
		return LIUN_NM;
	}
	public void setLIUN_NM(int lIUN_NM) {
		LIUN_NM = lIUN_NM;
	}
	public String getITEM_CD() {
		return ITEM_CD;
	}
	public void setITEM_CD(String iTEM_CD) {
		ITEM_CD = iTEM_CD;
	}
	public String getMNGR_NM() {
		return MNGR_NM;
	}
	public void setMNGR_NM(String mNGR_NM) {
		MNGR_NM = mNGR_NM;
	}
	public String getPROD_DT() {
		return PROD_DT;
	}
	public void setPROD_DT(String pROD_DT) {
		PROD_DT = pROD_DT;
	}
	public String getINDC_QNTT() {
		return INDC_QNTT;
	}
	public void setINDC_QNTT(String iNDC_QNTT) {
		INDC_QNTT = iNDC_QNTT;
	}
	public String getBOM_CD() {
		return BOM_CD;
	}
	public void setBOM_CD(String bOM_CD) {
		BOM_CD = bOM_CD;
	}
	public String getRT_CD() {
		return RT_CD;
	}
	public void setRT_CD(String rT_CD) {
		RT_CD = rT_CD;
	}
	private String BOM_CD;
	private String RT_CD;
	
}
