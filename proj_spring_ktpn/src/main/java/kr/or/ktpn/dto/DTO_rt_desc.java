package kr.or.ktpn.dto;

import java.util.List;

import lombok.Data;

@Data
public class DTO_rt_desc {

	 private String        rt_cd;            // 공정코드 (한 건 공통)
	    private List<String>  rt_descList;      // 폼에서 배열 바인딩용
	    private List<Integer> snList;           // 폼에서 배열 바인딩용

	    // ← 아래 두 필드는 매퍼 호출용 스칼라 프로퍼티
	    private String        rt_desc;          // 단일 설명
	    private Integer       sn;  

	
	
	
}
