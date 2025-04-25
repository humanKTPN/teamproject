package kr.or.ktpn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.DAO_md_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;


@Service
public class Svc_md_1000impl implements Svc_md_1000mt {

	@Autowired
	DAO_md_1000mt mdDAO;
		
	 @Override
	    public List<DTO_md_1000mt> getMdList(DTO_md_1000mt dto) {
	        // DAO 메소드에 dto를 전달합니다.
	        List<DTO_md_1000mt> list = mdDAO.selectMdList(dto);
	        return list;
	    }
	    @Override
	    public int addMd(DTO_md_1000mt dto) {
    		int countUpdate = mdDAO.insertEmp(dto);
    		return countUpdate;
    	}
	    @Override
	    public int modMd(DTO_md_1000mt dto) {
	    	int countUpdate = mdDAO.updateMd(dto);
	    	return countUpdate;
	    }
	    
	    @Override
	    public int delMd(DTO_md_1000mt dto) {
	    	int countUpdate = mdDAO.delMd(dto);
	    	return countUpdate;
	    }
	    
	  //생산관리관련 데이터    
	    @Override
	    public List<DTO_md_1000mt> selectDAO_P() {
	        // DAO 메소드에 dto를 전달합니다.
	        List<DTO_md_1000mt> list = mdDAO.selectDTO_P();
	        return list;
	    }
	    @Override
	    public List<DTO_md_1000mt> selectDAO_L() {
	    	// DAO 메소드에 dto를 전달합니다.
	    	List<DTO_md_1000mt> list = mdDAO.selectDTO_L();
	    	return list;
	    }
	    
	    
	    
	    
	 // 원자재 코드, 원자재명 가져오는 메소드
	 @Override
	 public List getMcodeList() {
	 	// TODO Auto-generated method stub
	 			
	 	System.out.println("service md_1000mt");
	 	List list = mdDAO.selectMcodeList();
	 	System.out.println("list : " + list);
	 		
	 	return list;
	 }
	 		
	 		
	 // 완제품 코드, 완제품명 가져오는 메소드
	 @Override
	 public List getPcodeList() {
	 	// TODO Auto-generated method stub
	 			
	 	System.out.println("service md_1000mt");
	 	List list = mdDAO.selectPcodeList();
	 	System.out.println("list : " + list);
	 		
	 	return list;
	 }
}
