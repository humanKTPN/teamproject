package kr.or.ktpn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.dto.DTO_mr_insert;
import kr.or.ktpn.dto.DTO_rt_1000mt;
import kr.or.ktpn.dto.DTO_rt_desc;

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
     public List<DTO_rt_desc> selectRtDesc(DTO_rt_desc dto) {
    	 List<DTO_rt_desc> result = sqlSession.selectList("mapper.rt_1000mt.selectDesc", dto);
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

 	 public int updateRt(DTO_rt_desc dto) {
	        // namespace 가 mapper.rt_1000mt, id 가 updateRt 여야 합니다
	        return sqlSession.update("mapper.rt_1000mt.updateRt", dto);
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
     
     @Override
	  public int addRt(Map<String,Object> mrMap) { 
		  int count = -1;
		  
		  try {
//	 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
			  count = sqlSession.insert("mapper.rt_1000mt.insertRt", mrMap);
			  count = sqlSession.insert("mapper.rt_1000mt.insertRt2", mrMap);
			  System.out.println("DAO : "+mrMap); // empno가 채워져 있음
			  // 그러면 아래 같은데에서 재사용 가능
//	 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  
		  return count;
	  }
     @Override
     public int delRt(DTO_rt_desc dto) {
    	 int count = -1;
    	 
    	 try {
// 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
    		 count = sqlSession.delete("mapper.rt_1000mt.delRt", dto);
    		 System.out.println(dto); // empno가 채워져 있음
    		 // 그러면 아래 같은데에서 재사용 가능
// 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 }
    	 
    	 return count;
     }


}
