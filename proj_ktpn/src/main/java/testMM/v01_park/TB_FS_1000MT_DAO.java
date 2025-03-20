package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_FS_1000MT_DAO {

	// 완제품 현재 재고 테이블의 CRUD
	
	// 조회
	// 전체 조회
	public List selectCurrentP() {

		System.out.println("TB_FS_1000MT selectCurrentP 실행");

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
			String query = "select * from TB_FS_1000MT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_FS_1000MT_DTO dto = new TB_FS_1000MT_DTO();

				
				dto.setFnsh_code(rs.getString("Fnsh_code"));
				dto.setFnsh_nm(rs.getString("Fnsh_nm"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setFnsh_loc_nm(rs.getString("Fnsh_loc_nm"));
				
				
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
	
	// 완제품 코드 조회
	public List selectCurrentP(String Pcode) {

		System.out.println("TB_FS_1000MT selectCurrentP 실행");

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
			String query = "select * from TB_FS_1000MT where Fnsh_code like ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Pcode);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_FS_1000MT_DTO dto = new TB_FS_1000MT_DTO();

				dto.setFnsh_code(rs.getString("Fnsh_code"));
				dto.setFnsh_nm(rs.getString("Fnsh_nm"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setFnsh_loc_nm(rs.getString("Fnsh_loc_nm"));
				
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
	
	
	// 삽입
	public int insertCurrentP(TB_FS_1000MT_DTO dto) {

		System.out.println("TB_FS_1000MT insertCurrentP 실행");
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
			// 완제품 현황 테이블에 데이터 삽입
			String query =  " insert into TB_FS_1000MT ( Fnsh_code, Fnsh_nm, CRNT_AFTR_CNT, Fnsh_loc_nm ";
				   query += " value (?, ?, ?, ?) ";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, dto.getFnsh_code());
			ps.setString(2, dto.getFnsh_nm());
			ps.setInt(3, dto.getCrnt_aftr_cnt());
			ps.setString(4, dto.getFnsh_loc_nm());
			
			

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//							ResultSet rs = ps.executeQuery();

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
	
	
	
	// 수정
	public int updateCurrentP(TB_FS_1000MT_DTO dto) {

		System.out.println("TB_FS_1000MT updateCurrentP 실행");
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
			// 완제품 현황 테이블에 데이터 삽입
			String query =  " update TB_FS_1000MT ";
				   query += " set CRNT_AFTR_CNT = ? and Fnsh_loc_nm = ? ";
				   query += " where Fnsh_code = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			
//			ps.setString(2, dto.getFnsh_nm());
			ps.setInt(1, dto.getCrnt_aftr_cnt());
			ps.setString(2, dto.getFnsh_loc_nm());
			ps.setString(3, dto.getFnsh_code());
			
			

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//							ResultSet rs = ps.executeQuery();

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
	
	
	
	// 삭제
	public int deleteCurrentP(TB_FS_1000MT_DTO dto) {

		System.out.println("TB_FS_1000MT deleteCurrentP 실행");
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
			// 완제품 현황 테이블에 데이터 삽입
			String query =  " delete TB_FS_1000MT ";
				   query += " where Fnsh_code = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getFnsh_code());
			
			

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//							ResultSet rs = ps.executeQuery();

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
