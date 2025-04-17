package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;

@Repository
public class DAO_bm_1000impl implements DAO_bm_1000mt{
	
	@Autowired
	SqlSession sqlSession;
	
	 @Override
     public List<DTO_bm_1000mt> selectBmList(DTO_bm_1000mt dto) {
         List<DTO_bm_1000mt> result = sqlSession.selectList("mapper.bm_1000mt.selectBm", dto);
         System.out.println("result : " + result);
         return result;
     }
     
     @Override
 	public List<DTO_md_1000mt> insertBm(DTO_md_1000mt dto) {
 		
 			List<DTO_md_1000mt> result = sqlSession.selectList("mapper.bm_1000mt.addBm", dto);
 			System.out.println("result : " + result);
 		
 		return result;
 	}
 	
 	  @Override
 	 	public int addBm(DTO_bm_1000mt dto) { 
 	 		int count = -1;
 	 		
 	 		try {
// 	 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
 	 			count = sqlSession.insert("mapper.bm_1000mt.insertBm", dto);
 	 			System.out.println(dto); // empno가 채워져 있음
 	 			// 그러면 아래 같은데에서 재사용 가능
// 	 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
 	 		} catch (Exception e) {
 	 			e.printStackTrace();
 	 		}
 	 		
 	 		return count;
 	 	}

     @Override
     public int updateBm(DTO_bm_1000mt dto) {
    	 int count = -1;
    	 
    	 try {
// 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
    		 count = sqlSession.update("mapper.bm_1000mt.updateBm", dto);
    		 System.out.println(dto); // empno가 채워져 있음
    		 // 그러면 아래 같은데에서 재사용 가능
// 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 }
    	 
    	 return count;
     }
     @Override
     public int delMd(DTO_md_1000mt dto) {
    	 int count = -1;
    	 
    	 try {
// 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
    		 count = sqlSession.update("mapper.md_1000mt.delMd", dto);
    		 System.out.println(dto); // empno가 채워져 있음
    		 // 그러면 아래 같은데에서 재사용 가능
// 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 }
    	 
    	 return count;
     }


}
