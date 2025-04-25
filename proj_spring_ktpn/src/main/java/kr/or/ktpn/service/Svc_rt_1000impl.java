package kr.or.ktpn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.DAO_rt_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_mr_insert;
import kr.or.ktpn.dto.DTO_rt_1000mt;
import kr.or.ktpn.dto.DTO_rt_desc;


@Service
public class Svc_rt_1000impl implements Svc_rt_1000mt {

	@Autowired
	DAO_rt_1000mt mdDAO;
		
	@Override
	 public List<DTO_rt_1000mt> getRtList(DTO_rt_1000mt dto) {
        // DAO 메소드에 dto를 전달합니다.
        List<DTO_rt_1000mt> list = mdDAO.selectRtList(dto);
        return list;
    }
	 @Override
	 public List<DTO_rt_desc> getRtDesc(DTO_rt_desc dto) {
		 List<DTO_rt_desc> list = mdDAO.selectRtDesc(dto);
		 return list;
	 }
    @Override
    public List<DTO_md_1000mt> addRt(DTO_md_1000mt dto) {
    	List<DTO_md_1000mt> list = mdDAO.insertRt(dto);
		return list;
	}
    
    @Override
    public int insertRt(DTO_rt_1000mt dto) {
		int countUpdate = mdDAO.addRt(dto);
		return countUpdate;
	}
    
    @Override
    public int modRt(DTO_rt_desc dto) {
        String rtCd            = dto.getRt_cd();
        List<String>  descs    = dto.getRt_descList();
        List<Integer> sns      = dto.getSnList();

        int totalUpdated = 0;
        for (int i = 0; i < descs.size(); i++) {
            DTO_rt_desc single = new DTO_rt_desc();
            single.setRt_cd(rtCd);
            single.setRt_desc(descs.get(i));  // 단일 String
            single.setSn(sns.get(i));         // 단일 Integer
            totalUpdated += mdDAO.updateRt(single);
        }
        return totalUpdated;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public int insertRt(Map<String,Object> mrMap) {
        // AJAX 페이로드에서 꺼낼 값들
        List<Map<String,Object>> comps = (List<Map<String,Object>>) mrMap.get("components");
        String rtCd   = (String) mrMap.get("rtCd");
        String rtNm   = (String) mrMap.get("rtNm");
        String itemCd = (String) mrMap.get("itemCd");

        int totalInserted = 0;
        for (Map<String,Object> comp : comps) {
            // 매퍼 파라미터 이름과 정확히 일치시키기
            comp.put("rt_cd",   rtCd);               // 공정코드
            comp.put("rt_nm",   rtNm);               // 공정명
            comp.put("item_cd", itemCd);             // 품목코드
            comp.put("rt_desc", comp.get("desc"));   // 설명(desc → rt_desc)

            // DAO 호출: mapper.rt_1000mt.insertRt2
            int cnt = mdDAO.addRt(comp);
            totalInserted += cnt;
            System.out.println("insert params: " + comp);
        }
        return totalInserted;
    }
    
    @Override
    public int delRt(DTO_rt_desc dto) {
    	int countUpdate = mdDAO.delRt(dto);
    	return countUpdate;
    }
    
	    
}
