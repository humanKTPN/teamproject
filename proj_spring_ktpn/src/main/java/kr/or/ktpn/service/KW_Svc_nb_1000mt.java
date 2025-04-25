package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

public interface KW_Svc_nb_1000mt {

//	List<KW_DTO_BR_1000MT> getnboardlist();
	public KW_DTO_BR_1000MT getnbnum(int tl);
	public int getnbupdate(KW_DTO_BR_1000MT dto);
	public int insert(KW_DTO_BR_1000MT dto);
	public int delete(int BRD_NO);
	List<KW_DTO_BR_1000MT> getBoardPagingList(int page);
    int getTotalBoardCount();
	
}
