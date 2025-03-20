package tb_pr_1100mt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_PR_1200MTDAO {

    // 데이터 삽입 (Insert)
    public int insert(TB_PR_1200MTDTO dto) {
        System.out.println("TB_PR_1200MTDAO insert 실행");
        int result = -1;

        try {
            // [DB 접속] 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            // [SQL 준비]
            String query = "INSERT INTO TB_PR_1200MT (LIUN_NM, ITEM_NM, UNIT_NO, DLY_PRDC_QNTT, DLY_DFC_RT, INDC_QNTT) "
                         + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dto.getLiun_nm());
            ps.setString(2, dto.getItem_nm());
            ps.setString(3, dto.getUnit_no());
            ps.setInt(4, dto.getDly_prdc_qntt());
            ps.setInt(5, dto.getDly_dfc_rt());
            ps.setInt(6, dto.getIndc_qntt());

            // [SQL 실행] 및 [결과 확보]
            result = ps.executeUpdate();  // 영향받은 줄의 수

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

 // 데이터 조회 (Select)
 	List selectTBPRList() {
 		System.out.println("selectTBPRList 실행");
 		List list = new ArrayList();
 		
 		
        try {
            // [DB 접속] 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            // [SQL 준비]
            String query = "SELECT * FROM TB_PR_1200MT WHERE UNIT_NO = ?";
            PreparedStatement ps = con.prepareStatement(query);

            // [SQL 실행] 및 [결과 확보]
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TB_PR_1200MTDTO dto = new TB_PR_1200MTDTO();
                dto = new TB_PR_1200MTDTO();
                dto.setLiun_nm(rs.getString("LIUN_NM"));
                dto.setItem_nm(rs.getString("ITEM_NM"));
                dto.setUnit_no(rs.getString("UNIT_NO"));
                dto.setDly_prdc_qntt(rs.getInt("DLY_PRDC_QNTT"));
                dto.setDly_dfc_rt(rs.getInt("DLY_DFC_RT"));
                dto.setIndc_qntt(rs.getInt("INDC_QNTT"));
            
                list.add(dto);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    

    // 데이터 수정 (Update)
    public int update(TB_PR_1200MTDTO dto) {
        System.out.println("TB_PR_1200MTDAO update 실행");
        int result = -1;

        try {
            // [DB 접속] 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            // [SQL 준비]
            String query = "UPDATE TB_PR_1200MT SET "
                         + "LIUN_NM = ?, ITEM_NM = ?, DLY_PRDC_QNTT = ?, DLY_DFC_RT = ?, INDC_QNTT = ? "
                         + "WHERE UNIT_NO = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dto.getLiun_nm());
            ps.setString(2, dto.getItem_nm());
            ps.setInt(3, dto.getDly_prdc_qntt());
            ps.setInt(4, dto.getDly_dfc_rt());
            ps.setInt(5, dto.getIndc_qntt());
            ps.setString(6, dto.getUnit_no());

            // [SQL 실행] 및 [결과 확보]
            result = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    }
