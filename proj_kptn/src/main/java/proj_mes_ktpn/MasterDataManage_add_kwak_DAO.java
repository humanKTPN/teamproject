package proj_mes_ktpn;

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

import proj_mes_ktpn.MasterDataManage_add_kwak_DTO;

public class MasterDataManage_add_kwak_DAO {

	 public void addTask(MasterDataManage_add_kwak_DTO mdDTO) throws SQLException,IOException {
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
				
				//SQL 준비
				String query = "INSERT INTO TB_MD_1000MT (MT_MNG_NM, MT_MNG_CD, ITEM_TP,MT_UNT_VAL, CSTMR_NM,MT_MNG_DESC,    PRS_CLS_VAL,TP_CLS_CD,USE_YN,REG_DT, MOD_DT ) VALUES (?,?,?,?,?,?,'','M','Y',TO_CHAR(SYSDATE,'YYYYMMDD'),TO_CHAR(SYSDATE,'YYYYMMDD'))";
				
				
				// 컴파일 된 sql을 받음
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1,mdDTO.getMT_MNG_NM());
				ps.setString(2,mdDTO.getMT_MNG_CD());
				ps.setString(3,mdDTO.getITEM_TP());
				ps.setString(4,mdDTO.getMT_UNT_VAL());
				ps.setString(5,mdDTO.getCSTMR_NM());
				ps.setString(6,mdDTO.getMT_MNG_DESC());
				ps.executeUpdate();
				
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
