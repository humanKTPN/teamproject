package tb_bm_1000mt;

public class DTO_BM_Kwak {
	
	private String bom_cd;
	private String item_cd;
	private String bom_nm;
	private String img_path_adr;
	private String bom_desc;
	
	public DTO_BM_Kwak(String bom_cd2, String bom_nm2) {
		// TODO Auto-generated constructor stub
		bom_cd = bom_cd2;
		bom_nm = bom_nm2;
	}
	public DTO_BM_Kwak(String bom_cd2) {
		bom_cd = bom_cd2;
	}
	public DTO_BM_Kwak() {
		// TODO Auto-generated constructor stub
	}
	public DTO_BM_Kwak(String bom_cd2, String bom_nm2, String item_cd2, String bom_desc2) {
		// TODO Auto-generated constructor stub
		bom_cd = bom_cd2;
		bom_nm = bom_nm2;
		item_cd= item_cd2;
		bom_desc = bom_desc2;
	}
	public String getBom_cd() {
		return bom_cd;
	}
	public void setBom_cd(String bom_cd) {
		this.bom_cd = bom_cd;
	}
	public String getItem_cd() {
		return item_cd;
	}
	public void setItem_cd(String item_cd) {
		this.item_cd = item_cd;
	}
	public String getBom_nm() {
		return bom_nm;
	}
	public void setBom_nm(String bom_nm) {
		this.bom_nm = bom_nm;
	}
	public String getImg_path_adr() {
		return img_path_adr;
	}
	public void setImg_path_adr(String img_path_adr) {
		this.img_path_adr = img_path_adr;
	}
	public String getBom_desc() {
		return bom_desc;
	}
	public void setBom_desc(String bom_desc) {
		this.bom_desc = bom_desc;
	}

}
