package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.KW_DAO_nboard_1000mt;
import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

@Service
public class KW_Svc_nb_1000mtimpl implements KW_Svc_nb_1000mt {

	@Autowired
	KW_DAO_nboard_1000mt mnb;
	
//	@Override
//	public List<KW_DTO_BR_1000MT> getnboardlist(){
//		List list = mnb.selectnBoard();
//		return list;
//	}
	
	@Override
	public KW_DTO_BR_1000MT getnbnum(int tl) {
		KW_DTO_BR_1000MT cn = mnb.selectnbnum(tl);
		return cn;
	}
	
	@Override
	public int getnbupdate(KW_DTO_BR_1000MT dto) {
		int cn = mnb.update(dto);
		return cn;
	}
	
	// 페이지에 맞는 게시글 10개 조회
    @Override
    public List<KW_DTO_BR_1000MT> getBoardPagingList(int page) {
        return mnb.getBoardPagingList(page);
    }

    // 전체 게시글 수 조회
    @Override
    public int getTotalBoardCount() {
        return mnb.getTotalBoardCount();
    }
	
	@Override
    public int insert(KW_DTO_BR_1000MT dto) {
        return mnb.insert(dto);
	}
	
	@Override
	public int delete(int BRD_NO) {
        return mnb.delete(BRD_NO);
    }
}
