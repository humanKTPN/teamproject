package kr.or.ktpn.dto;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KW_DTO_BR_1000MT {

	Integer BRD_NO;
	String BOARDFN;
	String TTL_NM;
	String BRD_DESC;
	String BLND_YN;
	Integer VW_CNT;
	String DLT_YN;
	Date REG_DTTM;
	Date MOD_DTTM;
	String ID;

// this. 이게 왜 생기는 지 알아볼것


}
