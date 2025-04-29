package kr.or.ktpn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

@Repository
public class KW_DAO_fboard_1000mtimpl implements KW_DAO_fboard_1000mt {

	@Autowired
	SqlSession sqls;
	
	@Override
	public List<KW_DTO_BR_1000MT> selectFBoard(){
		List<KW_DTO_BR_1000MT> list = sqls.selectList("mapper.TB_fBR_1000MT1.selectfbc");
		System.out.println("fb list : " + list);
		return list;
	}
	
	@Override
	public KW_DTO_BR_1000MT selectnbnum(int BRD_NO) {
		KW_DTO_BR_1000MT cn = sqls.selectOne("mapper.TB_fBR_1000MT.selectfbdetail", BRD_NO);
		System.out.println("fb cn : "+ cn);
		return cn;
	}
	
	@Override
	public KW_DTO_BR_1000MT selectfn(String BOARDFN) {
		KW_DTO_BR_1000MT cn = sqls.selectOne("mapper.TB_fBR_1000MT.selectnbdetail", BOARDFN);
		System.out.println("fb cn : "+ cn);
		return cn;
	}
	
	@Override
	public int update(KW_DTO_BR_1000MT dto) {
		int cn = sqls.update("mapper.TB_fBR_1000MT.updatefbc", dto);
		System.out.println("nb1 cn : "+ cn);
		return cn;
	}
	
	@Override
    public int insert(KW_DTO_BR_1000MT dto) {
		System.out.println("너가 괴롭히는 "+ dto);
        return sqls.insert("mapper.TB_fBR_1000MT.insertfbc", dto);
    }
	
	 @Override
	 public int delete(int BRD_NO) {
		 System.out.println("너가 괴롭히는 "+ BRD_NO);
        return sqls.delete("mapper.TB_fBR_1000MT.deletefbc", BRD_NO);
    }
	 
	 @Override
	 /**
	     * 페이징 처리된 게시글 목록 조회
	     * @param page 현재 페이지 번호
	     * @return 게시글 리스트 (10개씩)
	     */
	    public List<KW_DTO_BR_1000MT> getBoardPagingList(int page) {
	        int pageSize = 10;
	        int start = (page - 1) * pageSize + 1;
	        int end = page * pageSize;

	        Map<String, Integer> param = new HashMap<String, Integer>();
	        param.put("start", start);
	        param.put("end", end);

	        return sqls.selectList("mapper.TB_fBR_1000MT.getBoardPagingList", param);
	    }

	    /**
	     * 전체 게시글 수 가져오기
	     * @return 총 게시글 수
	     */
	    public int getTotalBoardCount() {
	        return sqls.selectOne("mapper.TB_fBR_1000MT.getTotalBoardCount");
	    }
}


