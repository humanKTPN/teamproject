package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.KW_DAO_fboard_1000mt;
import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

@Service
public class KW_Svc_fb_1000mtimpl implements KW_Svc_fb_1000mt {

	@Autowired
	KW_DAO_fboard_1000mt mfb;
	
	@Override
	public KW_DTO_BR_1000MT getfbnum(int tl) {
		KW_DTO_BR_1000MT cn = mfb.selectnbnum(tl);
		return cn;
	}
	
	@Override
	public KW_DTO_BR_1000MT getfn(String bOARDFN) {
		KW_DTO_BR_1000MT cn = mfb.selectfn(bOARDFN);
		return cn;
	}
	
	@Override
	public int getfbupdate(KW_DTO_BR_1000MT dto) {
		int cn = mfb.update(dto);
		return cn;
	}
	
	// 페이지에 맞는 게시글 10개 조회
    @Override
    public List<KW_DTO_BR_1000MT> getBoardPagingList(int page) {
        return mfb.getBoardPagingList(page);
    }

    // 전체 게시글 수 조회
    @Override
    public int getTotalBoardCount() {
        return mfb.getTotalBoardCount();
    }
	
	@Override
    public int insert(KW_DTO_BR_1000MT dto) {
        return mfb.insert(dto);
	}
	
	@Override
	public int delete(int BRD_NO) {
        return mfb.delete(BRD_NO);
    }
}
