package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.DTO_bm_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_rt_1000mt;

@Repository
public class DAO_rt_1000impl implements DAO_rt_1000mt{
	
	@Autowired
	SqlSession sqlSession;
	
	 @Override 
     public List<DTO_rt_1000mt> selectRtList(DTO_rt_1000mt dto) {
         List<DTO_rt_1000mt> result = sqlSession.selectList("mapper.rt_1000mt.selectRt", dto);
         System.out.println("result : " + result);
         return result;
     }
     
     @Override
 	public List<DTO_md_1000mt> insertRt(DTO_md_1000mt dto) {
 		
 			List<DTO_md_1000mt> result = sqlSession.selectList("mapper.rt_1000mt.addRt", dto);
 			System.out.println("쿼리에서 꺼내온것 : " + result);
 		
 		return result;
 	}
 	
 	  @Override
 	 	public int addRt(DTO_rt_1000mt dto) { 
 	 		int count = -1;
 	 		
 	 		try {
// 	 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
 	 			count = sqlSession.insert("mapper.rt_1000mt.insertRt", dto);
 	 			System.out.println(dto); // empno가 채워져 있음
 	 			// 그러면 아래 같은데에서 재사용 가능
// 	 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
 	 		} catch (Exception e) {
 	 			e.printStackTrace();
 	 		}
 	 		
 	 		return count;
 	 	}

     @Override
     public int updateRt(DTO_rt_1000mt dto) {
    	 int count = -1;
    	 
    	 try {
// 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
    		 count = sqlSession.update("mapper.rt_1000mt.updateRt", dto);
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
