package tb_md_1000mt;

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

public class MasterDataManage_add_kwak_DAO {

	 public void addTask(DTO_MD_add_Kwak addDTO) throws SQLException,IOException {
	    	System.out.println("dao");
	    	String query ="";
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
				System.out.println("getIMG_PATH_ADR : "+addDTO.getIMG_PATH_ADR());
				System.out.println("getMT_MNG_CD : "+addDTO.getMT_MNG_CD());
				
				
				
				//SQL 준비
//				String query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD, CSTMR_NM,MT_MNG_DESC,    TP_CLS_CD,USE_YN,REG_DT, MOD_DT ) VALUES (?,?,'','M','Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'))";
				
				
				
					 
					if("원자재".equals(addDTO.getTP_CLS_VAL())){
						query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD , MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT,IMG_PATH_ADR) VALUES (?,'M'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'),?,?,'Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'),?)";					
					} else if ("완제품".equals(addDTO.getTP_CLS_VAL())){
						query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD , MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT,IMG_PATH_ADR) VALUES (?,'P'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'),?,?,'Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'),?)";
					} else if ("BOM".equals(addDTO.getTP_CLS_VAL())){
						query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD , MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT,IMG_PATH_ADR) VALUES (?,'B'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'),?,?,'Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'),?)";
					} else if ("라인호기".equals(addDTO.getTP_CLS_VAL())){
						query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD , MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT,IMG_PATH_ADR) VALUES (?,'L'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'),?,?,'Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'),?)";	
					} else if ("공정".equals(addDTO.getTP_CLS_VAL())){
						query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD , MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT,IMG_PATH_ADR) VALUES (?,'R'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'),?,?,'Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'),?)";
					} else if ("거래처".equals(addDTO.getTP_CLS_VAL())){
						query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD , MT_MNG_DESC, TP_CLS_VAL, USE_YN, REG_DT, MOD_DT,IMG_PATH_ADR) VALUES (?,'T'||LPAD(SQ_MD_1000MT_M.NEXTVAL, 4, '0'),?,?,'Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'),?)";
					}
					
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1,addDTO.getMT_MNG_NM());
					ps.setString(2,addDTO.getMT_MNG_DESC());
					ps.setString(3,addDTO.getTP_CLS_VAL());
					ps.setString(4,addDTO.getIMG_PATH_ADR());
					ps.executeUpdate();
			
									
			
							
				// 컴파일 된 sql을 받음
				
				conn.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    
//	    public List<Task> getTasks() throws SQLException {
//	        System.out.println("get");
//	        
//	        List<MasterDataManage_add_kwak_DTO> tasks = new ArrayList<>();
//	        ResultSet rs = null;
//	        PreparedStatement ps = null;
//	        Connection conn = null;
//	        
//	        try {
//	            // DB 접속 시작
//	            Context ctx = new InitialContext();
//	            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
//	            conn = ds.getConnection();
//	            
//	            // SQL 준비
//	            String query = "SELECT * FROM TB_MD_1000MT";
//	            ps = conn.prepareStatement(query);
//	            rs = ps.executeQuery();
//	            while (rs.next()) {
//	            	int id = rs.getInt("id");
//	            	String task = rs.getString("TODO_LIST_DESC");
//	            	tasks.add(new MasterDataManage_add_kwak_DTO(id, task));
//	            }
//	            conn.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace(); // SQLException 처리
//	        } catch (Exception e) {
//	            e.printStackTrace(); // 일반 예외 처리
//	        } finally {
//	            try {
//	                if (rs != null) rs.close();
//	                if (ps != null) ps.close();
//	                if (conn != null) conn.close();
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return tasks;
//	    }
//	    public void deleteTask(int id) throws SQLException,IOException {
//	    	System.out.println("delete");
//	    	try {
//				
//				// db 접속 시작
//				// context.xml의 Resource 중에 jdbc/oracle 가져오기
//				// JNDI 방식으로...
//				// import 필수
//				Context ctx = new InitialContext();
//				DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/oracle");
//				//커넥션 풀에서 접속 정보를 가져오기
//				//접속안되면 null 출력
//				Connection conn = ds.getConnection();
//				//db접속 완료
//				
//				//SQL 준비
//				String query = "DELETE FROM TB_TEMP_TODO where ID = ?";			
//				// 컴파일 된 sql을 받음
//				PreparedStatement ps = conn.prepareStatement(query);
//				ps.setInt(1,id);
//				ps.executeUpdate();
//				
//				conn.close();
//
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
	
}
