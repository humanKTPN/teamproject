package tb_pr_1100mt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class test_TB_PR_1000MT_DAO {
	
	// 조회
	List selectTestWorkList(){
		System.out.println("selectTestWorkList 실행");
		List list = new ArrayList();

        try {
            // [DB 접속] 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            // [SQL 준비]
            String query = "SELECT * FROM TB_PR_1000MT";
            PreparedStatement ps = con.prepareStatement(query);
            
            // [SQL 실행] 및 [결과 확보]
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	test_TB_PR_1000MT_DTO dto1 = new test_TB_PR_1000MT_DTO();
                
                dto1.setProd_cd(rs.getString("PROD_CD"));
                dto1.setLlun_cd(rs.getString("LIUN_CD"));
                dto1.setLiun_nm(rs.getString("LIUN_NM"));
                dto1.setItem_cd(rs.getString("ITEM_CD"));
                dto1.setIndc_qntt(rs.getInt("INDC_QNTT"));
                
                
                list.add(dto1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
