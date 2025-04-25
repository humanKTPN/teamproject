package kr.or.ktpn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_pr_1000mt;
import kr.or.ktpn.dto.DTO_pr_insert;
import kr.or.ktpn.dto.DTO_rt_1000mt;

@Repository
public class DAO_pr_1000impl implements DAO_pr_1000mt{
	
	@Autowired
	SqlSession sqlSession;
	
	 @Override 
     public List<DTO_pr_1000mt> selectPrList(DTO_pr_1000mt dto) {
         List<DTO_pr_1000mt> result = sqlSession.selectList("mapper.pr_1000mt.selectPr", dto);
//         System.out.println("result : " + result);
         return result;
     }
     
     @Override
     public List<DTO_pr_1000mt> dePrList(Map<String,String> dto) {
    	    return sqlSession.selectList("mapper.pr_1000mt.dePrList", dto);
//         System.out.println("맵으로 꺼내온것 : " + result);
    	}
     

     /**
      * addList 쿼리 결과를
      * Map< item_cd, Map<컬럼명, 값> > 으로 반환합니다.
      */
     @Override
     public List<Map<String,Object>> selectAddListAsList() {
         return sqlSession.selectList("mapper.pr_1000mt.addList",null);
     }
     @Override
     public List<Map<String,Object>> selectLineList() {
    	 // "mapper.pr_1000mt.addList" 에서 반환된 각 로우의 item_cd 값을
    	 // 바깥 Map의 key로, 그 행 전체를 Map<String,Object>로 묶습니다.
    	 return sqlSession.selectList("mapper.pr_1000mt.LineList",null);
     }
     
     @Override
     public List<Map<String,Object>> selectMbList() {
    	 // "mapper.pr_1000mt.addList" 에서 반환된 각 로우의 item_cd 값을
    	 // 바깥 Map의 key로, 그 행 전체를 Map<String,Object>로 묶습니다.
    	 return sqlSession.selectList("mapper.pr_1000mt.mbList",null);
     }
     
	  @Override
	 	public int addPr(DTO_pr_insert dto) { 
	 		int count = -1;
	 		
	 		try {
//	 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
	 			count = sqlSession.insert("mapper.pr_1000mt.insertPr", dto);
	 			System.out.println(dto); // empno가 채워져 있음
	 			// 그러면 아래 같은데에서 재사용 가능
//	 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		
	 		return count;
	 	}

     
     
     @Override
 	public List<DTO_md_1000mt> insertRt(DTO_md_1000mt dto) {
 			
 			List<DTO_md_1000mt> result = sqlSession.selectList("mapper.rt_1000mt.addRt", dto);
 			System.out.println("쿼리에서 꺼내온것 : " + result);
 		
 		return result;
 	}
 	
 	  @Override
      public int delPr(DTO_pr_insert dto) {
     	 int count = -1;
     	 
     	 try {
//  			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
     		 count = sqlSession.delete("mapper.pr_1000mt.delPr", dto);
     		 System.out.println(dto); // empno가 채워져 있음
     		 // 그러면 아래 같은데에서 재사용 가능
//  			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
     	 } catch (Exception e) {
     		 e.printStackTrace();
     	 }
     	 
     	 return count;
      }

// 	 	생산관리 데이터 작업전
      @Override
    	public List<DTO_pr_1000mt> selectDTO_N() {
    		
    		List<DTO_pr_1000mt> PR_1000MTDAO = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.PR_1000MT_N");
    		System.out.println("PR_1000MTDAO : " + PR_1000MTDAO);
    		
    		return PR_1000MTDAO;
    	}
    

}
