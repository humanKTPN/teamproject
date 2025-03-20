package tb_pr_1000mt;

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

public class DAO_PR_Kwak {
	// 추가할때 나오는 데이터
    public List<DTO_PR_Kwak> getData() throws SQLException {
    System.out.println("get");
    
    List<DTO_PR_Kwak> dto = new ArrayList<>();
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;
    
    try {
        // DB 접속 시작
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        conn = ds.getConnection();
        
        // SQL 준비
        String query = "select A.PROD_PLN_CD"
        		+ "     , A.ITEM_NM"
        		+ "     , A.TRG_PROD_CNT"
        		+ "     , A.ITEM_CD"
        		+ "     , C.BOM_CD"
        		+ "     , C.BOM_DESC"
        		+ "     , D.RT_CD"
        		+ "     , D.RT_DESC"
        		+ "  from TB_PR_1110MT A"
        		+ "     , TB_PR_1000MT B"
        		+ "     , TB_BM_1000MT C"
        		+ "     , TB_RT_1000MT D"
        		+ " WHERE 1=1"
        		+ "   AND A.ITEM_CD = B.ITEM_CD (+)"
        		+ "   AND A.ITEM_CD = C.ITEM_CD"
        		+ "   AND A.ITEM_CD = D.ITEM_CD"
        		+ "   AND B.ITEM_CD IS NULL"
        		+ "   AND A.ITEM_CD IS NOT NULL";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
        	String pr_pln_cd = rs.getString("PROD_PLN_CD");
        	String item_nm = rs.getString("ITEM_NM");
        	String trg_cnt = rs.getString("TRG_PROD_CNT");
        	String item_cd = rs.getString("ITEM_CD");
        	
        	String bom_cd = rs.getString("BOM_CD");
        	String bom_desc = rs.getString("BOM_DESC");
        	String rt_cd = rs.getString("RT_CD");
        	String rt_desc = rs.getString("RT_DESC");

//        	String bom_nm= rs.getString("img_path_adr");
        	dto.add(new DTO_PR_Kwak(pr_pln_cd,item_nm,trg_cnt,item_cd,bom_cd,bom_desc,rt_cd,rt_desc)); //dto 데이터를 리스트에 저장
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
    
    public List<DTO_PR_Kwak> getMember() throws SQLException {
    	System.out.println("get");
    	
    	List<DTO_PR_Kwak> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "SELECT *"
	    				+ "  FROM TB_MB_1000MT"
	    				+ " WHERE 1=1"
	    				+ "   AND DLT_YN = 'N'";
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while (rs.next()) {
    			String pr_mb_nm = rs.getString("MBR_NM");
    			
//        	String bom_nm= rs.getString("img_path_adr");
    			dto.add(new DTO_PR_Kwak(pr_mb_nm)); //dto 데이터를 리스트에 저장
        	System.out.println(pr_mb_nm);
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
    public List<DTO_PR_Kwak> getLine() throws SQLException {
    	System.out.println("get");
    	
    	List<DTO_PR_Kwak> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "SELECT *"
	    				+ "  FROM TB_MD_1000MT"
	    				+ " WHERE 1=1"
	    				+ "   AND MT_MNG_CD LIKE 'L%'"
	    				+ "   AND USE_YN = 'Y'";
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while (rs.next()) {
    			String line_cd = rs.getString("MT_MNG_CD");
    			String line_nm = rs.getString("MT_MNG_NM");
    			
//        	String bom_nm= rs.getString("img_path_adr");
    			dto.add(new DTO_PR_Kwak(line_cd,line_nm)); //dto 데이터를 리스트에 저장
    			System.out.println(line_nm);
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
    
    public List<DTO_PR_Kwak_main> listData() throws SQLException {
    	System.out.println("get");
    	
    	List<DTO_PR_Kwak_main> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "SELECT *"
    				     + "  FROM TB_PR_1000MT"
    					 + " WHERE USE_YN = 'Y'";
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		while (rs.next()) {
    			String prod_cd = rs.getString("PROD_CD");
    			String prod_pln_cd = rs.getString("PROD_PLN_CD");
    			String liun_cd = rs.getString("LIUN_CD");
    			String liun_nm = rs.getString("LIUN_NM");
    			String item_cd = rs.getString("ITEM_CD");
    			String mngr_nm = rs.getString("MNGR_NM");
    			String prod_dt = rs.getString("PROD_DT");
    			int indc_qntt = rs.getInt("INDC_QNTT");
    			
//        	String bom_nm= rs.getString("img_path_adr");
    			dto.add(new DTO_PR_Kwak_main(prod_cd, prod_pln_cd, liun_cd, liun_nm,item_cd,mngr_nm,prod_dt,indc_qntt)); //dto 데이터를 리스트에 저장
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
//    
    // 게시글 클릭 후 보이는 화면
    public List<DTO_PR_Kwak_main> getDataInfo(String rt_cd) throws SQLException {
        System.out.println(rt_cd);
        
        List<DTO_PR_Kwak_main> dto = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            // DB 접속 시작
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            conn = ds.getConnection();
            
            // SQL 준비
            String query = "SELECT A.PROD_CD"
	            		+ "     , A.PROD_PLN_CD"
	            		+ "     , A.LIUN_CD"
	            		+ "     , A.LIUN_NM"
	            		+ "     , A.ITEM_CD"
	            		+ "     , A.MNGR_NM"
	            		+ "     , A.PROD_DT"
	            		+ "     , A.INDC_QNTT"
	            		+ "     , B.BOM_CD"
	            		+ "     , B.BOM_DESC"
	            		+ "     , C.RT_CD"
	            		+ "     , C.RT_DESC"
	            		+ "  FROM TB_PR_1000MT A"
	            		+ "     , TB_BM_1000MT B"
	            		+ "     , TB_RT_1000MT C"
	            		+ " WHERE PROD_CD = ?"
	            		+ "   AND A.ITEM_CD = B.ITEM_CD"
	            		+ "   AND B.ITEM_CD = C.ITEM_CD";
            ps = conn.prepareStatement(query);
            ps.setString(1, rt_cd);
            
            rs = ps.executeQuery();
            while (rs.next()) {
            	String prod_cd = rs.getString("PROD_CD");
    			String prod_pln_cd = rs.getString("PROD_PLN_CD");
    			String liun_cd = rs.getString("LIUN_CD");
    			String liun_nm = rs.getString("LIUN_NM");
    			String item_cd = rs.getString("ITEM_CD");
    			String mngr_nm = rs.getString("MNGR_NM");
    			String prod_dt = rs.getString("PROD_DT");
    			int indc_qntt = rs.getInt("INDC_QNTT");
    			String bom_cd = rs.getString("BOM_CD");
    			
    			String bom_desc = rs.getString("BOM_DESC");
    			String rt_cd2 = rs.getString("RT_CD");
    			String rt_desc = rs.getString("RT_DESC");
    			dto.add(new DTO_PR_Kwak_main(prod_cd, prod_pln_cd, liun_cd, liun_nm,item_cd,mngr_nm,prod_dt,indc_qntt,bom_cd,bom_desc,rt_cd2,rt_desc)); // dto 데이터를 리스트에 저장
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
    public void delData(String prod_cd) throws SQLException {
    	System.out.println(prod_cd);
    	
//    	List<DTO_PR_Kwak> dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		// SQL 준비
    		String query = "DELETE FROM TB_PR_1000MT WHERE PROD_CD = ? ";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, prod_cd);
    		
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
//
    public List<DTO_PR_Kwak_main> schData(DTO_PR_Kwak_main dto) throws SQLException {
    	System.out.println("도착");
    	
    	List<DTO_PR_Kwak_main> li_dto = new ArrayList<>();
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	String query = "";
    	 
    	System.out.println("getRT_CD : "+dto.getCate());
    	
    	try {
    		// DB 접속 시작
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		conn = ds.getConnection();
    		
    		 
    	  		// SQL 준비
    			 if("품목코드".equals(dto.getCate())) {   
    				 if((dto.getStr_dt() != "") && (dto.getEnd_dt() != "")) {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE UPPER(ITEM_CD) LIKE UPPER('%'||?||'%') AND TO_DATE(PROD_DT,'YYMMDD') BETWEEN TO_DATE(?,'YYMMDD') AND TO_DATE(?,'YYMMDD')"; 
    				 }else {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE UPPER(ITEM_CD) LIKE UPPER('%'||?||'%')";    					 
    				 }
    			 }
    			 else if("담당자명".equals(dto.getCate())) 
    				 if((dto.getStr_dt() != "") && (dto.getEnd_dt() != "")) {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE UPPER(MNGR_NM) LIKE UPPER('%'||?||'%') AND TO_DATE(PROD_DT,'YYMMDD') BETWEEN TO_DATE(?,'YYMMDD') AND TO_DATE(?,'YYMMDD')"; 
    				 }else {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE UPPER(MNGR_NM) LIKE UPPER('%'||?||'%')";    					 
    				 }
    			 else if("호기".equals(dto.getCate())) 
    				 if((dto.getStr_dt() != "") && (dto.getEnd_dt() != "")) {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE UPPER(LIUN_NM) LIKE UPPER('%'||?||'%') AND TO_DATE(PROD_DT,'YYMMDD') BETWEEN TO_DATE(?,'YYMMDD') AND TO_DATE(?,'YYMMDD')"; 
    				 }else {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE UPPER(LIUN_NM) LIKE UPPER('%'||?||'%')";    					 
    				 }
    			 else if(dto.getSch()=="" && "전체".equals(dto.getCate())) {
    				 System.out.println("ㅎㅇ");
    				 
    				 if((dto.getStr_dt() != "") && (dto.getEnd_dt() != "")) {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE TO_DATE(PROD_DT,'YYMMDD') BETWEEN TO_DATE(?,'YYMMDD') AND TO_DATE(?,'YYMMDD')"; 
    				 }else {
    					 query = "SELECT * FROM TB_PR_1000MT WHERE USE_YN = 'Y'";    					   					 
    				 }
    			 }
    			 
        		ps = conn.prepareStatement(query);
        		
    			if(dto.getStr_dt() != "" && dto.getEnd_dt() != "" && dto.getSch()!="") {
    				ps.setString(1,  dto.getSch()); 
    				ps.setString(2,  dto.getStr_dt()); 
    				ps.setString(3,  dto.getEnd_dt()); 
    			} else if (dto.getStr_dt() != "" && dto.getEnd_dt() != "" && dto.getSch()=="") {
    				ps.setString(1,  dto.getStr_dt()); 
    				ps.setString(2,  dto.getEnd_dt());
    			} else if(dto.getStr_dt() == "" && dto.getEnd_dt() == "" && dto.getSch() !="") {
    				System.out.println("HERE");
    				ps.setString(1,  dto.getSch());        			        				
    			}
    		 
        		
        		
        		rs = ps.executeQuery();
        		System.out.println("검색 완료");
        		while (rs.next()) {
                	String prod_cd = rs.getString("PROD_CD");
                	String prod_pln_cd = rs.getString("PROD_PLN_CD");
                	String liun_cd = rs.getString("LIUN_CD");
                	String liun_nm = rs.getString("LIUN_NM");
                	String item_cd = rs.getString("ITEM_CD");
                	String mngr_nm = rs.getString("MNGR_NM");
                	String prod_dt = rs.getString("PROD_DT");
                	int indc_qntt = rs.getInt("INDC_QNTT");
                	li_dto.add(new DTO_PR_Kwak_main(prod_cd, prod_pln_cd, liun_cd, liun_nm,item_cd,mngr_nm,prod_dt,indc_qntt));
             
        		}
    	
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
		return li_dto;
    }
//    
    public void addData(DTO_PR_Kwak addDTO) throws SQLException,IOException {
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
			
			String query = "INSERT INTO TB_PR_1000MT (PROD_CD, PROD_PLN_CD, LIUN_CD, MNGR_NM, ITEM_CD,PROD_DT,LIUN_NM, INDC_QNTT, BOM_CD, RT_CD, USE_YN,REG_DT, MOD_DT)"
						+ " VALUES ('D'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'),?,?,?,?,?,?,?,?,?,'Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'))";					

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,addDTO.getPROD_PLN_CD());
			ps.setString(2,addDTO.getLINE_CD());
			ps.setString(3,addDTO.getPR_MB_NM());
			ps.setString(4,addDTO.getITEM_CD());
			ps.setString(5,addDTO.getPROD_DT());
			ps.setString(6,addDTO.getLINE_NM());
			ps.setString(7,addDTO.getINDC_QNTT());
			ps.setString(8,addDTO.getBOM_CD2());
			ps.setString(9,addDTO.getRT_CD2());
			
			ps.executeUpdate();
			
			
			// 컴파일 된 sql을 받음
			
			conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	    
}
