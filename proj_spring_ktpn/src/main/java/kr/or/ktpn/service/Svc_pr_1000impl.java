package kr.or.ktpn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.or.ktpn.dao.DAO_pr_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_pr_1000mt;
import kr.or.ktpn.dto.DTO_pr_insert;


@Service
public class Svc_pr_1000impl implements Svc_pr_1000mt {

	@Autowired
	DAO_pr_1000mt mdDAO;
		
	@Override
	 public List<DTO_pr_1000mt> getPrList(DTO_pr_1000mt dto) {
        // DAO 메소드에 dto를 전달합니다.
        List<DTO_pr_1000mt> list = mdDAO.selectPrList(dto);
        return list;
    }
	 @Override
	 public List<DTO_pr_1000mt> getdePrList(Map<String,String> dto) {
	     return mdDAO.dePrList(dto);
	 }
	 
	 @Override 
    public List<Map<String,Object>>getAddListMap () {
        return mdDAO.selectAddListAsList();
    }
	 @Override
	 public List<Map<String,Object>> getLineMap() {
		 return mdDAO.selectLineList();
	 }
	 @Override
	 public List<Map<String,Object>> selectMbList() {
		 return mdDAO.selectMbList();
	 }
	  
	  
	 @Override
	 public int insertPr(DTO_pr_insert dto) {
		 int countUpdate = mdDAO.addPr(dto);
		 return countUpdate;
	 }
	 
    @Override
    public int delMd(DTO_pr_insert dto) {
    	int countUpdate = mdDAO.delPr(dto);
    	return countUpdate;
    }
 
//	 작업전
	 @Override
		public List selectDAO_N() {

			List PR_1000MTSVC = mdDAO.selectDTO_N();
			System.out.println("PR_1000MTSVC : "+PR_1000MTSVC);
			return PR_1000MTSVC;
		}
   
	 
		 
}
