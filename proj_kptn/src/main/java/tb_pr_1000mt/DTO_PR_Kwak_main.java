package tb_pr_1000mt;

public class DTO_PR_Kwak_main {
	private String PROD_CD;
	private String PROD_PLN_CD;
	private String LIUN_CD;
	private String LIUN_NM;
	private String ITEM_CD;
	private String ITEM_NM;
	private String MNGR_NM;
	private String PROD_DT;
	private int INDC_QNTT;
	
	private String BOM_CD;
	private String BOM_DESC;
	private String RT_CD;
	private String RT_DESC;
	
	private String cate;
	private String sch;
	private String str_dt;
	private String end_dt;
	
	public String getStr_dt() {
		return str_dt;
	}


	public void setStr_dt(String str_dt) {
		this.str_dt = str_dt;
	}


	public String getEnd_dt() {
		return end_dt;
	}


	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}


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


	public DTO_PR_Kwak_main() {
	
	}
	
	
	public String getBOM_CD() {
		return BOM_CD;
	}
	public void setBOM_CD(String bOM_CD) {
		BOM_CD = bOM_CD;
	}
	public String getBOM_DESC() {
		return BOM_DESC;
	}
	public void setBOM_DESC(String bOM_DESC) {
		BOM_DESC = bOM_DESC;
	}
	public String getRT_CD() {
		return RT_CD;
	}
	public void setRT_CD(String rT_CD) {
		RT_CD = rT_CD;
	}
	public String getRT_DESC() {
		return RT_DESC;
	}
	public void setRT_DESC(String rT_DESC) {
		RT_DESC = rT_DESC;
	}
	public String getINDC_QNTT1() {
		return INDC_QNTT1;
	}
	public void setINDC_QNTT1(String iNDC_QNTT1) {
		INDC_QNTT1 = iNDC_QNTT1;
	}
	public void setLIUN_NM(String lIUN_NM) {
		LIUN_NM = lIUN_NM;
	}
	public void setINDC_QNTT(int iNDC_QNTT) {
		INDC_QNTT = iNDC_QNTT;
	}
	public DTO_PR_Kwak_main(String prod_cd2, String prod_pln_cd2, String liun_cd2, String liun_nm2, String item_cd2,
			String mngr_nm2, String prod_dt2, int indc_qntt2) {
		
		PROD_CD = prod_cd2;
		PROD_PLN_CD = prod_pln_cd2;
		LIUN_CD = liun_cd2;
		LIUN_NM = liun_nm2;
		ITEM_CD = item_cd2;
		MNGR_NM = mngr_nm2; 
		PROD_DT = prod_dt2;
		INDC_QNTT = indc_qntt2;
		
	}
	public DTO_PR_Kwak_main(String prod_cd2, String prod_pln_cd2, String liun_cd2, String liun_nm2, String item_cd2,
			String mngr_nm2, String prod_dt2, int indc_qntt2, String bom_cd, String bom_desc, String rt_cd2,
			String rt_desc) {
		
		PROD_CD = prod_cd2;
		PROD_PLN_CD = prod_pln_cd2;
		LIUN_CD = liun_cd2;
		LIUN_NM = liun_nm2;
		ITEM_CD = item_cd2;
		MNGR_NM = mngr_nm2; 
		PROD_DT = prod_dt2;
		INDC_QNTT = indc_qntt2;
		
		BOM_CD = bom_cd;
		BOM_DESC = bom_desc;
		RT_CD = rt_cd2;
		RT_DESC = rt_desc;
		
		
		
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
	public String getLIUN_NM() {
		return LIUN_NM;
	}
	public void setLIUN_NM1(String lIUN_NM) {
		LIUN_NM = lIUN_NM;
	}
	public String getITEM_CD() {
		return ITEM_CD;
	}
	public void setITEM_CD(String iTEM_CD) {
		ITEM_CD = iTEM_CD;
	}
	public String getITEM_NM() {
		return ITEM_NM;
	}
	public void setITEM_NM(String iTEM_NM) {
		ITEM_NM = iTEM_NM;
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
	public int getINDC_QNTT() {
		return INDC_QNTT;
	}
	public void setINDC_QNTT1(int iNDC_QNTT) {
		INDC_QNTT = iNDC_QNTT;
	}
	public String getPR_MB_NM() {
		return PR_MB_NM;
	}
	public void setPR_MB_NM(String pR_MB_NM) {
		PR_MB_NM = pR_MB_NM;
	}
	private String INDC_QNTT1;
	private String PR_MB_NM;
		
}
