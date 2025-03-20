package tb_pr_1100mt;

public class TB_PR_1110MTDTO {

	String prod_pln_cd;   			//생산일정코드
	String item_nm;					//품목명
	int    trg_prod_cnt;				//목표생산수량
	String prod_strt_dt;			//생산시작일자
	String prod_end_dt;				//생산완료일자
	String item_cd;				//품목코드
	
	
	public String getProd_pln_cd() {
		return prod_pln_cd;
	}
	public void setProd_pln_cd(String prod_pln_cd) {
		this.prod_pln_cd = prod_pln_cd;
	}
	public String getItem_nm() {
		return item_nm;
	}
	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}
	public int getTrg_prod_cnt() {
		return trg_prod_cnt;
	}
	public void setTrg_prod_cnt(int trg_prod_cnt) {
		this.trg_prod_cnt = trg_prod_cnt;
	}
	public String getProd_strt_dt() {
		return prod_strt_dt;
	}
	public void setProd_strt_dt(String prod_strt_dt) {
		this.prod_strt_dt = prod_strt_dt;
	}
	public String getProd_end_dt() {
		return prod_end_dt;
	}
	public void setProd_end_dt(String prod_end_dt) {
		this.prod_end_dt = prod_end_dt;
	}
	public String getItem_cd() {
		return item_cd;
	}
	public void setItem_cd(String item_cd) {
		this.item_cd = item_cd;
	}
	
	
	@Override
	public String toString() {
		return "TB_PR_1110MTDTO [prod_pln_cd=" + prod_pln_cd + ", item_nm=" + item_nm + ", trg_prod_cnt=" + trg_prod_cnt
				+ ", prod_strt_dt=" + prod_strt_dt + ", prod_end_dt=" + prod_end_dt + ", item_cd=" + item_cd + "]";
	}
	
	
	
	

}
