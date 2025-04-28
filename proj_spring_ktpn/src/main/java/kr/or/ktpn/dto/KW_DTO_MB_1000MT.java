package kr.or.ktpn.dto;
import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
public class KW_DTO_MB_1000MT {

	String id;
	String pw;
	String mbr_nm;
	String ytn_yn;
	Date reg_dttm;
	Date mod_dttm;
	String mbr_senm;
	
}


