package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_MR_1000MT_DAO {

	// 원자재 현재 재고 테이블의 CRUD

	// 조회
	// 전체 조회
	public List selectCurrentM() {

		System.out.println("TB_MR_1000MT selectCurrentM 실행");

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
			String query = "select * from TB_MR_1000MT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_MR_1000MT_DTO dto = new TB_MR_1000MT_DTO();

				dto.setMtrl_cd(rs.getString("MTRL_CD"));
				dto.setMtrl_nm(rs.getString("MTRL_NM"));
				dto.setStn_cnt(rs.getInt("STN_CNT"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setOrdr_rqrd_yn(rs.getString("ORDR_RQRD_YN"));
				dto.setMtrl_loc_nm(rs.getString("MTRL_CD_NM"));

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

	// 원자재코드 조회
	public List selectCurrentM(String Mcode) {

		System.out.println("TB_MR_1000MT selectCurrentM 실행");

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
			String query = "select * from TB_MR_1000MT where MTRL_CD like ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Mcode);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_MR_1000MT_DTO dto = new TB_MR_1000MT_DTO();

				dto.setMtrl_cd(rs.getString("MTRL_CD"));
				dto.setMtrl_nm(rs.getString("MTRL_NM"));
				dto.setStn_cnt(rs.getInt("STN_CNT"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setOrdr_rqrd_yn(rs.getString("ORDR_RQRD_YN"));
				dto.setMtrl_loc_nm(rs.getString("MTRL_CD_NM"));

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
	/*
	 * 삽입 흐름 -> 원자재현황 테이블에 값을 넣고, 그 값을 원자재 로그테이블에 반영
	 */
	public int insertCurrentM(TB_MR_1000MT_DTO dto) {

		System.out.println("TB_MR_1000MT insertCurrentM 실행");
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
			// 원자재 로그 테이블에 데이터 삽입
			String query = "insert into TB_MR_1000MT (MTRL_CD, MTRL_NM, STN_CNT, ORDR_RQRD_YN, ";
			query += " MTRL_LOC_NM, CRNT_AFTR_CNT) ";
			query += " values ( ?, ?, ?, ?, ?, ?) ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getMtrl_cd());
			ps.setString(2, dto.getMtrl_nm());
			ps.setInt(3, dto.getStn_cnt());

			ps.setString(4, dto.getOrdr_rqrd_yn());

			ps.setString(5, dto.getMtrl_loc_nm());

			ps.setInt(6, dto.getCrnt_aftr_cnt());

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
	public int updateCurrentM(TB_MR_1000MT_DTO dto) {

		System.out.println("TB_MR_1000MT updateDealCompany 실행");

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

			String query = null;
			PreparedStatement ps = null;

			query = " update TB_MR_1000MT ";
			query += " set ORDR_RQRD_YN = ?, MTRL_LOC_NM = ?, CRNT_AFTR_CNT = ? ";
			query += " where MTRL_CD = ? ";

			ps = con.prepareStatement(query);
			// 물음표에 값을 넣어라
			ps.setString(1, dto.getOrdr_rqrd_yn());
			ps.setString(2, dto.getMtrl_loc_nm());
			ps.setInt(3, dto.getCrnt_aftr_cnt());
			ps.setString(4, dto.getMtrl_cd());

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

	// 삭제
	public int deleteCurrentM(TB_MR_1000MT_DTO dto) {

		System.out.println("TB_MR_1000MT deleteDealCompany 실행");

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
			String query = "delete from TB_MR_1000MT ";

			query += " where MTRL_CD = ? ";

			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어라
			ps.setString(1, dto.getMtrl_cd());

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
	
	public List selcectMlog () {
		
		System.out.println("TB_MR_1000MT selectCurrentM 실행");

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
			// 원자재로그에서 제일 마지막 로그 값 가져오기
			String query = "select * from TB_MR_1000HT where MTRL_CD = ? and ";	
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_MR_1000MT_DTO dto = new TB_MR_1000MT_DTO();

				dto.setMtrl_cd(rs.getString("MTRL_CD"));
				dto.setMtrl_nm(rs.getString("MTRL_NM"));
				dto.setStn_cnt(rs.getInt("STN_CNT"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setOrdr_rqrd_yn(rs.getString("ORDR_RQRD_YN"));
				dto.setMtrl_loc_nm(rs.getString("MTRL_CD_NM"));

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
}
