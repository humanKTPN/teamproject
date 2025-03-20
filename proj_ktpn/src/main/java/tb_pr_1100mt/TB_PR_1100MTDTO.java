package tb_pr_1100mt;

public class TB_PR_1100MTDTO {

	private String prod_cd;                   	//생산코드
	private String mt_mng_cd;					//라인호기코드	
	private String liun_nm;					    //라인호기명	
	private String item_nm;						//품목명
	private String item_cd;						//품목코드
	private String prod_strt_time;				//생산시작시간
	private String prod_end_time;				//생산완료시간
	private int    indc_qntt;						//지시수량
	private int    prod_qntt;						//생산량
	private String work_nm;						//작업자명
	private String eqpm_oprt_stts_val;			//장비가동상태값
	private String prod_end_yn;					//생산완료여부
	private String dfc_rt;						//불량률
	public String getProd_cd() {
		return prod_cd;
	}
	public void setProd_cd(String prod_cd) {
		this.prod_cd = prod_cd;
	}
	public String getMt_mng_cd() {
		return mt_mng_cd;
	}
	public void setMt_mng_cd(String mt_mng_cd) {
		this.mt_mng_cd = mt_mng_cd;
	}
	public String getLiun_nm() {
		return liun_nm;
	}
	public void setLiun_nm(String liun_nm) {
		this.liun_nm = liun_nm;
	}
	public String getItem_nm() {
		return item_nm;
	}
	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}
	public String getItem_cd() {
		return item_cd;
	}
	public void setItem_cd(String item_cd) {
		this.item_cd = item_cd;
	}
	public String getProd_strt_time() {
		return prod_strt_time;
	}
	public void setProd_strt_time(String prod_strt_time) {
		this.prod_strt_time = prod_strt_time;
	}
	public String getProd_end_time() {
		return prod_end_time;
	}
	public void setProd_end_time(String prod_end_time) {
		this.prod_end_time = prod_end_time;
	}
	public int getIndc_qntt() {
		return indc_qntt;
	}
	public void setIndc_qntt(int indc_qntt) {
		this.indc_qntt = indc_qntt;
	}
	public int getProd_qntt() {
		return prod_qntt;
	}
	public void setProd_qntt(int prod_qntt) {
		this.prod_qntt = prod_qntt;
	}
	public String getWork_nm() {
		return work_nm;
	}
	public void setWork_nm(String work_nm) {
		this.work_nm = work_nm;
	}
	public String getEqpm_oprt_stts_val() {
		return eqpm_oprt_stts_val;
	}
	public void setEqpm_oprt_stts_val(String eqpm_oprt_stts_val) {
		this.eqpm_oprt_stts_val = eqpm_oprt_stts_val;
	}
	public String getProd_end_yn() {
		return prod_end_yn;
	}
	public void setProd_end_yn(String prod_end_yn) {
		this.prod_end_yn = prod_end_yn;
	}
	public String getDfc_rt() {
		return dfc_rt;
	}
	public void setDfc_rt(String dfc_rt) {
		this.dfc_rt = dfc_rt;
	}
	
	
	
	@Override
	public String toString() {
		return "TB_PR_1100MTDTO [prod_cd=" + prod_cd + ", mt_mng_cd=" + mt_mng_cd + ", liun_nm=" + liun_nm
				+ ", item_nm=" + item_nm + ", item_cd=" + item_cd + ", prod_strt_time=" + prod_strt_time
				+ ", prod_end_time=" + prod_end_time + ", indc_qntt=" + indc_qntt + ", prod_qntt=" + prod_qntt
				+ ", work_nm=" + work_nm + ", eqpm_oprt_stts_val=" + eqpm_oprt_stts_val + ", prod_end_yn=" + prod_end_yn
				+ ", dfc_rt=" + dfc_rt + "]";
	}
	
	

	
	
	
}
