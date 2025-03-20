package tb_pr_1100mt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class test_TB_MB_1000MT_DAO {

	
	// 조회
		List selectTestMemberList(){
			System.out.println("selectTestMemberList 실행");
			List list = new ArrayList();

	        try {
	            // [DB 접속] 시작
	            Context ctx = new InitialContext();
	            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	            Connection con = ds.getConnection();

	            // [SQL 준비]
	            String query = "SELECT * FROM TB_MB_1000MT";
	            PreparedStatement ps = con.prepareStatement(query);
	            
	            // [SQL 실행] 및 [결과 확보]
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	            	test_TB_MB_1000MT_DTO dto2 = new test_TB_MB_1000MT_DTO();
	                
	            	dto2.setMbr_nm(rs.getString("MBR_NM"));
	                
	                
	                
	                list.add(dto2);
	            }

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
}
