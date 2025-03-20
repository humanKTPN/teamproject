package tb_bm_1000mt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import tb_md_1000mt.DTO_MD_add_Kwak;
import tb_md_1000mt.DTO_MD_main_Kwak;

public class DAO_BM_Kwak {
// 추가할때 나오는 데이터
    public List<DTO_BM_Kwak> getData() throws SQLException {
    System.out.println("get");
    
    List<DTO_BM_Kwak> dto = new ArrayList<>();
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;
    
    try {
        // DB 접속 시작
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        conn = ds.getConnection();
        
        // SQL 준비
        String query = "SELECT A.*"
        		     + "  FROM TB_MD_1000MT A"
        		     + "     , TB_BM_1000MT B"
        		     + " WHERE A.USE_YN = 'Y'"
        		     + "   AND A.MT_MNG_CD = B.BOM_CD(+)"
        		     + "   AND B.BOM_CD IS NULL"
        		     + "   AND A.MT_MNG_CD LIKE 'B%'";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
        	String bom_cd = rs.getString("MT_MNG_CD");
        	String bom_nm = rs.getString("MT_MNG_NM");

//        	String bom_nm= rs.getString("img_path_adr");
        	dto.add(new DTO_BM_Kwak(bom_cd,bom_nm)); //dto 데이터를 리스트에 저장
//        	System.out.println(MT_MNG_CD);
        }
//        System.out.println("저장했음");
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace(); // SQLException 처리
    } catch (Exception e) {
        e.printStackTrace(); // 일반 예외 처리
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	return dto;
    }
    
    public List<DTO_BM_Kwak> listData() throws SQLException {
    	System.out.println("get");
    	
    	List<DTO_BM_Kwak> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "select *"
    				     + "  from TB_BM_1000MT"
    					 + " where use_yn = 'Y'";
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while (rs.next()) {
    			String bom_cd = rs.getString("BOM_CD");
    			String bom_nm = rs.getString("BOM_NM");
    			String item_cd = rs.getString("ITEM_CD");
    			String bom_desc = rs.getString("BOM_DESC");
    			
//        	String bom_nm= rs.getString("img_path_adr");
    			dto.add(new DTO_BM_Kwak(bom_cd,bom_nm, item_cd,bom_desc)); //dto 데이터를 리스트에 저장
//        	System.out.println(MT_MNG_CD);
    		}
//        System.out.println("저장했음");
    		conn.close();
    	} catch (SQLException e) {
    		e.printStackTrace(); // SQLException 처리
    	} catch (Exception e) {
    		e.printStackTrace(); // 일반 예외 처리
    	} finally {
    		try {
    			if (rs != null) rs.close();
    			if (ps != null) ps.close();
    			if (conn != null) conn.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	return dto;
    }
    
    // 게시글 클릭 후 보이는 화면
    public List<DTO_BM_Kwak> getDataInfo(String bom_cd) throws SQLException {
        System.out.println(bom_cd);
        
        List<DTO_BM_Kwak> dto = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            // DB 접속 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            conn = ds.getConnection();
            
            // SQL 준비
            String query = "SELECT * FROM TB_BM_1000MT WHERE BOM_CD = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, bom_cd);
            
            rs = ps.executeQuery();
            while (rs.next()) {
	            	String rebom_cd = rs.getString("BOM_CD");
	    			String rebom_nm = rs.getString("BOM_NM");
	    			String reitem_cd = rs.getString("ITEM_CD");
	    			String rebom_desc = rs.getString("BOM_DESC");
                dto.add(new DTO_BM_Kwak(rebom_cd,rebom_nm,reitem_cd,rebom_desc)); // dto 데이터를 리스트에 저장
//                System.out.println(reMT_MNG_CD);
            }
            System.out.println("저장했음");
        } catch (SQLException e) {
            e.printStackTrace(); // SQLException 처리
        } catch (Exception e) {
            e.printStackTrace(); // 일반 예외 처리
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close(); // 연결을 finally 블록에서 닫음
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }
    // 게시글 삭제
    public void delData(String bom_cd) throws SQLException {
    	System.out.println(bom_cd);
    	
    	List<DTO_BM_Kwak> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "DELETE FROM TB_BM_1000MT WHERE bom_cd = ?";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, bom_cd);
    		
    		rs = ps.executeQuery();
//    		while (rs.next()) {
//    			String reMT_MNG_CD = rs.getString("MT_MNG_CD");
//    			dto.add(new DTO_MD_main_Kwak(reMT_MNG_CD)); // dto 데이터를 리스트에 저장
////                System.out.println(reMT_MNG_CD);
//    		}
    		System.out.println("값 삭제 완료");
    	} catch (SQLException e) {
    		e.printStackTrace(); // SQLException 처리
    	} catch (Exception e) {
    		e.printStackTrace(); // 일반 예외 처리
    	} finally {
    		try {
    			if (rs != null) rs.close();
    			if (ps != null) ps.close();
    			if (conn != null) conn.close(); // 연결을 finally 블록에서 닫음
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }

    public void modData(DTO_BM_Kwak dto) throws SQLException {
    	System.out.println("도착");
    	
//    	DTO_MD_main_Kwak dto = new DTO_MD_main_Kwak();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "UPDATE TB_BM_1000MT "
    						+ "SET BOM_NM = ? "
    						+ ", BOM_DESC = ?"
    						+ ", ITEM_CD = ?"
    					  + "WHERE BOM_CD = ?";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, dto.getBom_nm());
    		ps.setString(2, dto.getBom_desc());
    		ps.setString(3, dto.getItem_cd());
    		ps.setString(4, dto.getBom_cd());
    		
    		
    		rs = ps.executeQuery();
//    		while (rs.next()) {
//    			String reMT_MNG_CD = rs.getString("MT_MNG_CD");
//    			dto.add(new DTO_MD_main_Kwak(reMT_MNG_CD)); // dto 데이터를 리스트에 저장
////                System.out.println(reMT_MNG_CD);
//    		}
    		System.out.println("값 수정 완료");
    	} catch (SQLException e) {
    		e.printStackTrace(); // SQLException 처리
    	} catch (Exception e) {
    		e.printStackTrace(); // 일반 예외 처리
    	} finally {
    		try {
    			if (rs != null) rs.close();
    			if (ps != null) ps.close();
    			if (conn != null) conn.close(); // 연결을 finally 블록에서 닫음
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public void addData(DTO_BM_Kwak addDTO) throws SQLException,IOException {
    	System.out.println("dao");
    	try {
			
			// db 접속 시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로...
			// import 필수
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/oracle");
			//커넥션 풀에서 접속 정보를 가져오기
			//접속안되면 null 출력
			Connection conn = ds.getConnection();
			//db접속 완료
			System.out.println("BOM_DESC : "+addDTO.getBom_desc());
			//SQL 준비
//			String query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD, CSTMR_NM,MT_MNG_DESC,    TP_CLS_CD,USE_YN,REG_DT, MOD_DT ) VALUES (?,?,'','M','Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'))";
			
			String query = "INSERT INTO TB_BM_1000MT (BOM_CD,BOM_NM,ITEM_CD,BOM_DESC,REG_DT,MOD_DT, USE_YN)"
						+ " VALUES (?,?,?,?,TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'), 'Y')";					

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,addDTO.getBom_cd());
			ps.setString(2,addDTO.getBom_nm());
			ps.setString(3,addDTO.getItem_cd());
			ps.setString(4,addDTO.getBom_desc());
			ps.executeUpdate();
			
			
			// 컴파일 된 sql을 받음
			
			conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
}
