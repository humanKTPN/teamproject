package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

public interface KW_DAO_fboard_1000mt {
	
	List<KW_DTO_BR_1000MT> selectFBoard();
	public KW_DTO_BR_1000MT selectnbnum(int tl);
	public int update(KW_DTO_BR_1000MT dto);
	int insert(KW_DTO_BR_1000MT dto);
	public int delete(int BRD_NO);

    // 전체 게시글 수 조회 (페이지 수 계산용)
    int getTotalBoardCount();
	
	List<KW_DTO_BR_1000MT> getBoardPagingList(int page);
	public KW_DTO_BR_1000MT selectfn(String BOARDFN);
}
