package tb_pr_1100mt;

public class TB_PR_1200MTDTO {

	String liun_nm;			//라인호기명
	String item_nm;			//품목명
	String unit_no;			//호기번호
	int    dly_prdc_qntt;		//일별생산량
	int    dly_dfc_rt;			//일별불량률
	int    indc_qntt;			//지시수량
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
	public String getUnit_no() {
		return unit_no;
	}
	public void setUnit_no(String unit_no) {
		this.unit_no = unit_no;
	}
	public int getDly_prdc_qntt() {
		return dly_prdc_qntt;
	}
	public void setDly_prdc_qntt(int dly_prdc_qntt) {
		this.dly_prdc_qntt = dly_prdc_qntt;
	}
	public int getDly_dfc_rt() {
		return dly_dfc_rt;
	}
	public void setDly_dfc_rt(int dly_dfc_rt) {
		this.dly_dfc_rt = dly_dfc_rt;
	}
	public int getIndc_qntt() {
		return indc_qntt;
	}
	public void setIndc_qntt(int indc_qntt) {
		this.indc_qntt = indc_qntt;
	}
	
	
	@Override
	public String toString() {
		return "TB_PR_1200MTDTO [liun_nm=" + liun_nm + ", item_nm=" + item_nm + ", unit_no=" + unit_no
				+ ", dly_prdc_qntt=" + dly_prdc_qntt + ", dly_dfc_rt=" + dly_dfc_rt + ", indc_qntt=" + indc_qntt + "]";
	}
	
	
	
	
	
}
