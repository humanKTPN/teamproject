package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.DAO_bm_1000mt;
import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;


@Service
public class Svc_bm_1000impl implements Svc_bm_1000mt {

	@Autowired
	DAO_bm_1000mt mdDAO;
		
	 @Override
    public List<DTO_bm_1000mt> getBmList(DTO_bm_1000mt dto) {
        // DAO 메소드에 dto를 전달합니다.
        List<DTO_bm_1000mt> list = mdDAO.selectBmList(dto);
        return list;
    }
    @Override
    public List<DTO_md_1000mt> addBm(DTO_md_1000mt dto) {
    	List<DTO_md_1000mt> list = mdDAO.insertBm(dto);
		return list;
	}
    
    @Override
    public int insertBm(DTO_bm_1000mt dto) {
		int countUpdate = mdDAO.addBm(dto);
		return countUpdate;
	}
    
    @Override
    public int modBm(DTO_bm_1000mt dto) {
    	int countUpdate = mdDAO.updateBm(dto);
    	return countUpdate;
    }
	    
}
