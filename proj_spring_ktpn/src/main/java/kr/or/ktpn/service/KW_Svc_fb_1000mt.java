package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

public interface KW_Svc_fb_1000mt {

	public KW_DTO_BR_1000MT getfbnum(int tl);
//	List<KW_DTO_BR_1000MT> getfboardlist();
	public int getfbupdate(KW_DTO_BR_1000MT dto);
	public int insert(KW_DTO_BR_1000MT dto);
	public int delete(int BRD_NO);
	List<KW_DTO_BR_1000MT> getBoardPagingList(int page);
    int getTotalBoardCount();
	KW_DTO_BR_1000MT getfn(String bOARDFN);
}
