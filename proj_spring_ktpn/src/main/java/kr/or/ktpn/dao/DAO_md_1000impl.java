package kr.or.ktpn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.DTO_md_1000mt;

@Repository
public class DAO_md_1000impl implements DAO_md_1000mt{
	
	@Autowired
	SqlSession sqlSession;
	
	 @Override
     public List<DTO_md_1000mt> selectMdList(DTO_md_1000mt dto) {
         List<DTO_md_1000mt> result = sqlSession.selectList("mapper.md_1000mt.selectMd", dto);
//         System.out.println("result : " + result);
         return result;
     }
     
     @Override
 	public int insertEmp(DTO_md_1000mt dto) {
 		int count = -1;
 		
 		try {
// 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
 			count = sqlSession.insert("mapper.md_1000mt.insertMd", dto);
 			System.out.println(dto); // empno가 채워져 있음
 			// 그러면 아래 같은데에서 재사용 가능
// 			count = sqlSession.insert("mapper.emp.insertEmp4", empDTO);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		return count;
 	}
     @Override
     public int updateMd(DTO_md_1000mt dto) {
    	 int count = -1;
    	 
    	 try {
// 			count = sqlSession.insert("mapper.emp.insertEmp", empDTO);
    		 count = sqlSession.update("mapper.md_1000mt.updateMd", dto);
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
     
   //생산관리관련 데이터
     @Override
     public List<DTO_md_1000mt> selectDTO_P() {
    	 List<DTO_md_1000mt> result = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.MD_1000MT_P");
    	 System.out.println("result : " + result);
    	 return result;
     }
     @Override
     public List<DTO_md_1000mt> selectDTO_L() {
    	 List<DTO_md_1000mt> result = sqlSession.selectList("mapper.TAK_PR_1100MTDTO.MD_1000MT_L");
    	 System.out.println("result : " + result);
    	 return result;
     }

     
     
     
    // 원자재 코드, 원자재명 가져오는 메소드
 	@Override
 	public List selectMcodeList() {
 		// TODO Auto-generated method stub
 		
 		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectAllMCode");
 		System.out.println("result : " + result);
 		
 		return result;
 	}

 	
 	// 완제품 코드, 완제품명 가져오는 메소드
 	@Override
 	public List selectPcodeList() {
 		// TODO Auto-generated method stub

 		List result = sqlSession.selectList("mapper.tb_mr_1000mt.selectAllPCode");
 		System.out.println("result : " + result);
 		
 		return result;
 	}

}
