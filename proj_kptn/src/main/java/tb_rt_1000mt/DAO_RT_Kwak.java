package tb_rt_1000mt;

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

import tb_bm_1000mt.DTO_BM_Kwak;

public class DAO_RT_Kwak {
	// 추가할때 나오는 데이터
    public List<DTO_RT_Kwak> getData() throws SQLException {
    System.out.println("get");
    
    List<DTO_RT_Kwak> dto = new ArrayList<>();
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
        		     + "     , TB_RT_1000MT B"
        		     + " WHERE A.USE_YN = 'Y'"
        		     + "   AND A.MT_MNG_CD = B.RT_CD(+)"
        		     + "   AND B.RT_CD IS NULL"
        		     + "   AND A.MT_MNG_CD LIKE 'R%'";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
        	String rt_cd = rs.getString("MT_MNG_CD");
        	String rt_nm = rs.getString("MT_MNG_NM");

//        	String bom_nm= rs.getString("img_path_adr");
        	dto.add(new DTO_RT_Kwak(rt_cd,rt_nm)); //dto 데이터를 리스트에 저장
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
    
    public List<DTO_RT_Kwak> listData() throws SQLException {
    	System.out.println("get");
    	
    	List<DTO_RT_Kwak> dto = new ArrayList<>();
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
    				     + "  from TB_RT_1000MT"
    					 + " where use_yn = 'Y'";
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while (rs.next()) {
    			String rt_cd = rs.getString("RT_CD");
    			String rt_nm = rs.getString("RT_NM");
    			String item_cd = rs.getString("ITEM_CD");
    			String rt_desc = rs.getString("RT_DESC");
    			
//        	String bom_nm= rs.getString("img_path_adr");
    			dto.add(new DTO_RT_Kwak(rt_cd, rt_nm, item_cd, rt_desc)); //dto 데이터를 리스트에 저장
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
    public List<DTO_RT_Kwak> getDataInfo(String rt_cd) throws SQLException {
        System.out.println(rt_cd);
        
        List<DTO_RT_Kwak> dto = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            // DB 접속 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            conn = ds.getConnection();
            
            // SQL 준비
            String query = "SELECT * FROM TB_RT_1000MT WHERE RT_CD = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, rt_cd);
            
            rs = ps.executeQuery();
            while (rs.next()) {
	            	String rert_cd = rs.getString("RT_CD");
	    			String rert_nm = rs.getString("RT_NM");
	    			String reitem_cd = rs.getString("ITEM_CD");
	    			String rert_desc = rs.getString("RT_DESC");
                dto.add(new DTO_RT_Kwak(rert_cd,rert_nm,reitem_cd,rert_desc)); // dto 데이터를 리스트에 저장
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
    public void delData(String rt_cd) throws SQLException {
    	System.out.println(rt_cd);
    	
    	List<DTO_RT_Kwak> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "DELETE FROM TB_RT_1000MT WHERE RT_CD = ?";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, rt_cd);
    		
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

    public void modData(DTO_RT_Kwak dto) throws SQLException {
    	System.out.println("도착");
    	
//    	DTO_MD_main_Kwak dto = new DTO_MD_main_Kwak();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	 
    	System.out.println("getRT_CD"+dto.getRT_CD());
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "UPDATE TB_RT_1000MT "
    						+ "SET RT_NM = ? "
    						+ ", RT_DESC = ?"
    						+ ", ITEM_CD = ?"
    					  + "WHERE RT_CD = ?";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, dto.getRT_NM());
    		ps.setString(2, dto.getRT_DESC().replace("\r\n", "<br>"));
    		ps.setString(3, dto.getITEM_CD());
    		ps.setString(4, dto.getRT_CD());
    		
    		
    		rs = ps.executeQuery();
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
    
    public void addData(DTO_RT_Kwak addDTO) throws SQLException,IOException {
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
			System.out.println("rt_desc : "+addDTO.getRT_DESC());
			//SQL 준비
//			String query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD, CSTMR_NM,MT_MNG_DESC,    TP_CLS_CD,USE_YN,REG_DT, MOD_DT ) VALUES (?,?,'','M','Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'))";
			
			String query = "INSERT INTO TB_RT_1000MT (RT_CD,RT_NM,ITEM_CD,RT_DESC, REG_DT, MOD_DT, USE_YN)"
						+ " VALUES (?,?,?,?,TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'), 'Y')";					

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,addDTO.getRT_CD());
			ps.setString(2,addDTO.getRT_NM());
			ps.setString(3,addDTO.getITEM_CD());
			ps.setString(4,addDTO.getRT_DESC());
			ps.executeUpdate();
			
			
			// 컴파일 된 sql을 받음
			
			conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
}
