package tb_md_1000mt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import tb_bm_1000mt.DTO_BM_Kwak;

public class DAO_MD_main_Kwak {
	
    public List<DTO_MD_main_Kwak> getData() throws SQLException {
    System.out.println("get");
    
    List<DTO_MD_main_Kwak> dto = new ArrayList<>();
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;
    
    try {
        // DB 접속 시작
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        conn = ds.getConnection();
        
        // SQL 준비
        String query = "SELECT * FROM TB_MD_1000MT WHERE USE_YN = 'Y'";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
        	String MT_MNG_CD = rs.getString("MT_MNG_CD");
        	String MT_MNG_NM = rs.getString("MT_MNG_NM");
        	String MT_MNG_DESC = rs.getString("MT_MNG_DESC");
        	dto.add(new DTO_MD_main_Kwak(MT_MNG_CD,MT_MNG_NM,MT_MNG_DESC)); //dto 데이터를 리스트에 저장
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
    public List<DTO_MD_main_Kwak> getDataInfo(String MT_MNG_CD) throws SQLException {
        System.out.println(MT_MNG_CD);
        
        List<DTO_MD_main_Kwak> dto = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            // DB 접속 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            conn = ds.getConnection();
            
            // SQL 준비
            String query = "SELECT * FROM TB_MD_1000MT WHERE MT_MNG_CD = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, MT_MNG_CD);
            System.out.println(MT_MNG_CD);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                String reMT_MNG_CD = rs.getString("MT_MNG_CD");
                String reIMG_PATH_ADR = rs.getString("IMG_PATH_ADR");
                System.out.println(reMT_MNG_CD);
                String reMT_MNG_NM = rs.getString("MT_MNG_NM");
                String reMT_MNG_DESC = rs.getString("MT_MNG_DESC");
                dto.add(new DTO_MD_main_Kwak(reMT_MNG_CD,reMT_MNG_NM,reMT_MNG_DESC,reIMG_PATH_ADR)); // dto 데이터를 리스트에 저장
//                System.out.println(reMT_MNG_CD);
            }
//            System.out.println("저장했음");
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
    public void delData(String MT_MNG_CD) throws SQLException {
    	System.out.println(MT_MNG_CD);
    	
    	List<DTO_MD_main_Kwak> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "UPDATE TB_MD_1000MT SET USE_YN = 'N' WHERE MT_MNG_CD = ?";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, MT_MNG_CD);
    		
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
    public void modData(DTO_MD_main_Kwak dto) throws SQLException {
    	System.out.println("도착");
    	
//    	DTO_MD_main_Kwak dto = new DTO_MD_main_Kwak();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	System.out.println("dto.getMT_MNG_NM:"+dto.getMT_MNG_NM());
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "UPDATE TB_MD_1000MT "
    						+ "SET MT_MNG_NM = ? "
    						+ ", MT_MNG_DESC = ?"
    					  + "WHERE MT_MNG_CD = ?";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, dto.getMT_MNG_NM());
    		ps.setString(2, dto.getMT_MNG_DESC());
    		ps.setString(3, dto.getMT_MNG_CD());
    		
    		
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
}

 
   
    
    
    
//public void deleteTask(int id) throws SQLException,IOException {
//	System.out.println("delete");
//	try {
//		
//		// db 접속 시작
//		// context.xml의 Resource 중에 jdbc/oracle 가져오기
//		// JNDI 방식으로...
//		// import 필수
//		Context ctx = new InitialContext();
//		DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/oracle");
//		//커넥션 풀에서 접속 정보를 가져오기
//		//접속안되면 null 출력
//		Connection conn = ds.getConnection();
//		//db접속 완료
//		
//		//SQL 준비
//		String query = "DELETE FROM TB_TEMP_TODO where ID = ?";			
//		// 컴파일 된 sql을 받음
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1,id);
//		ps.executeUpdate();
//		
//		conn.close();
//
//	}catch(Exception e) {
//		e.printStackTrace();
//	}

