package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TB_OD_1000MT_DAO {

	// 거래처 테이블의 CRUD
	
	// db 연결 메소드
	public Connection DBConnect() {
		
		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();
			
			if(con != null) {
				System.out.println("DB 접속 완료");
			} else {
				System.out.println("DB 접속 실패");
			}
			
			return con;
			//con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	// select - 조회
	public List selectDealCompany() {

		System.out.println("TB_OD_1000MT selectDealCompany 실행");

		List list = new ArrayList();

		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			// SQL 준비
			String query = "select * from TB_OD_1000MT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_OD_1000MT_DTO dto = new TB_OD_1000MT_DTO();

				dto.setCstmr_code(rs.getString("CSTMR_CODE"));
				dto.setCmp_nm(rs.getString("CMP_NM"));
				dto.setMngr_nm(rs.getString("MNGR_NM"));
				dto.setTel_no(rs.getString("TEL_NO"));
				dto.setTrn_itm_item_nm(rs.getString("TRN_ITM_ITEM_NM"));
				dto.setReg_dt(rs.getString("REG_DT"));
				dto.setMod_dt(rs.getString("MOD_DT"));
				
				list.add(dto);
				System.out.println("조회 중");
			}
			System.out.println("조회 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}
	// 메소드마다 db접속은 비효율적인듯

	// insert - 삽입
	public int insertDealCompany(TB_OD_1000MT_DTO dto) {

		System.out.println("TB_OD_1000MT insertDealCompany 실행");
		int result = -1;

		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			// SQL 준비
			String query = "insert into TB_OD_1000MT ";

			query += " values ( 'T'||LPAD(sq_od_1000mt.NEXTVAL, 4, '0'), ?, null, null, null, to_char(sysdate, 'yyyymmdd'), to_char(sysdate, 'yyyymmdd'))";

			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어라
			ps.setString(1, dto.getCmp_nm());

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//						ResultSet rs = ps.executeQuery();

			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();

			System.out.println("삽입 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public int updateDealCompany(TB_OD_1000MT_DTO dto) {

		System.out.println("TB_OD_1000MT updateDealCompany 실행");

		int result = -1;

		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			// SQL 준비
			String query = "update TB_OD_1000MT " + " set cmp_nm = ? " + " where cstmr_code = 'T0002' ";

			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어라
			ps.setString(1, dto.getCmp_nm());

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//						ResultSet rs = ps.executeQuery();

			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();

			System.out.println("수정 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public int deleteDealCompany(TB_OD_1000MT_DTO dto) {
		
		System.out.println("TB_OD_1000MT deleteDealCompany 실행");

		int result = -1;
	
		try {

			// DB 접속시작
			// context.xml의 Resource 중에 jdbc/oracle 가져오기
			// JNDI 방식으로
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null
			Connection con = ds.getConnection();

			// SQL 준비
			String query = "delete from TB_OD_1000MT ";

			query += " where 거래처코드 =  ?";

			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어라
			ps.setString(1, dto.getCmp_nm());

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//						ResultSet rs = ps.executeQuery();

			// int에는 영양받은 줄의 수
			result = ps.executeUpdate();

			System.out.println("삭제 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
}
