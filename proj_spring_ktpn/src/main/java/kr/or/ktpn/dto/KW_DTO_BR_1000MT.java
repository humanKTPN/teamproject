package kr.or.ktpn.dto;
import java.sql.Date;

import lombok.Data;

//@ToString
//@Getter
//@Setter
@Data
public class KW_DTO_BR_1000MT {

	int BRD_NO;
	String BRD_SENM;
	String TTL_NM;
	String BRD_DESC;
	String BLND_YN;
	int VW_CNT;
	String DLT_YN;
	Date REG_DTTM;
	Date MOD_DTTM;
	String ID;

// this. 이게 왜 생기는 지 알아볼것


}
