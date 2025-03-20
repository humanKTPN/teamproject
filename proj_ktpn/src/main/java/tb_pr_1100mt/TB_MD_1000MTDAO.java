package tb_pr_1100mt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_MD_1000MTDAO {

	// 조회
		List selectTestStandardList(){
			System.out.println("selectTestStandardList 실행");
			List list = new ArrayList();

	        try {
	            // [DB 접속] 시작
	            Context ctx = new InitialContext();
	            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	            Connection con = ds.getConnection();

	            // [SQL 준비]
	            String query = "SELECT * FROM TB_MD_1000MT WHERE MT_MNG_CD LIKE 'P%'";
	            PreparedStatement ps = con.prepareStatement(query);
	            
	            // [SQL 실행] 및 [결과 확보]
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	            	TB_MD_1000MTDTO dto = new TB_MD_1000MTDTO();
	                
	                dto.setMt_mng_cd(rs.getString("mt_mng_cd"));
	                dto.setMt_mng_nm(rs.getString("mt_mng_nm"));
	                
	                
	                list.add(dto);
	            }

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
		// 조회
		List selectTestLineList(){
			System.out.println("selectTestStandardList 실행");
			List list = new ArrayList();
			
			try {
				// [DB 접속] 시작
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
				Connection con = ds.getConnection();
				
				// [SQL 준비]
				String query = "SELECT * FROM TB_MD_1000MT WHERE MT_MNG_CD LIKE 'L%'";
				PreparedStatement ps = con.prepareStatement(query);
				
				// [SQL 실행] 및 [결과 확보]
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					TB_MD_1000MTDTO dto = new TB_MD_1000MTDTO();
					
					dto.setMt_mng_cd(rs.getString("mt_mng_cd"));
					dto.setMt_mng_nm(rs.getString("mt_mng_nm"));
					
					
					list.add(dto);
				}
				
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
	
}
