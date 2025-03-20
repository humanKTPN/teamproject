package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import testQA.v01_park.TB_QA_1000DT_DTO;

public class TB_MR_1000HT_DAO {

	// 원자재 로그 테이블의 CRUD

	// 조회
	// 전체 조회
	public List selectMLog() {

		System.out.println("TB_MR_1000HT selectMLog 실행");

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
			String query = "select * from TB_MR_1000HT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_MR_1000HT_DTO dto = new TB_MR_1000HT_DTO();

				dto.setSn(rs.getString("SN"));
				dto.setMtrl_cd(rs.getString("MTRL_CD"));
				dto.setMtrl_nm(rs.getString("MTRL_NM"));
				dto.setStn_cnt(rs.getInt("STN_CNT"));
				dto.setCrnt_cnt(rs.getInt("CRNT_CNT"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setChng_dt(rs.getString("CHNG_DT"));
				dto.setIob_se_cd(rs.getString("IOB_SE_CD"));
				dto.setOrdr_rqrd_yn(rs.getString("ORDR_RQRD_YN"));
				dto.setWork_nm(rs.getString("WORK_NM"));
				dto.setMtrl_cd_nm(rs.getString("MTRL_CD_NM"));
				dto.setRmrk(rs.getString("RMRK"));
				dto.setReg_dttm(rs.getDate("REG_DTTM"));
				
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
	
	// 조회
	// 이전 데이터 조회
	public List selectLastMLog(String Mcode, int i) {

		System.out.println("TB_MR_1000HT selectLastMLog 실행");

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
			// 원자재 로그 테이블에서 마지막에 입력한 잘못된 로그와 바로 이전 로그 찾기
			String query =  " select a.* form ( ";
				   query += " select a.*, rownum as rn ";
				   query += " from TB_MR_1000HT a ";
				   query += " where a.MTRL_CD = ? ";
				   query += " ordey by a.SN desc ) a ";
				   query += " where a.rn = ? ";
				   
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Mcode);
			ps.setInt(2, i);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_MR_1000HT_DTO dto = new TB_MR_1000HT_DTO();

				dto.setSn(rs.getString("SN"));
				dto.setMtrl_cd(rs.getString("MTRL_CD"));
				dto.setMtrl_nm(rs.getString("MTRL_NM"));
				dto.setStn_cnt(rs.getInt("STN_CNT"));
				dto.setCrnt_cnt(rs.getInt("CRNT_CNT"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setChng_dt(rs.getString("CHNG_DT"));
				dto.setIob_se_cd(rs.getString("IOB_SE_CD"));
				dto.setOrdr_rqrd_yn(rs.getString("ORDR_RQRD_YN"));
				dto.setWork_nm(rs.getString("WORK_NM"));
				dto.setMtrl_cd_nm(rs.getString("MTRL_CD_NM"));
				dto.setRmrk(rs.getString("Rmrk"));
				dto.setReg_dttm(rs.getDate("REG_DTTM"));
				
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
	public int insertMlog(TB_MR_1000HT_DTO dto) {

		System.out.println("TB_MR_1000HT insertMlog 실행");
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
			String query = "insert into TB_MR_1000HT (SN, MTRL_CD, MTRL_NM, STN_CNT, CRNT_CNT, ORDR_RQRD_YN, IOB_SE_CD,";
				   query += " WORK_NM, MTRL_CD_NM, Rmrk, REG_DTTM, CRNT_AFTR_CNT, CHNG_DT) ";
				   query += " values (SQ_MR_1000HT.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, to_char(sysdate, 'yyyymmdd')) ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getMtrl_cd());
			ps.setString(2, dto.getMtrl_nm());
			ps.setInt(3, dto.getStn_cnt());
			ps.setInt(4, dto.getCrnt_cnt());
			ps.setString(5, dto.getOrdr_rqrd_yn());
			ps.setString(6, dto.getIob_se_cd());
			ps.setString(7, dto.getWork_nm());
			ps.setString(8, dto.getMtrl_cd_nm());
			ps.setString(9, dto.getRmrk());
			ps.setInt(10, dto.getCrnt_aftr_cnt());
			

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
	public int updateMlog(TB_MR_1000HT_DTO dto) {

		System.out.println("TB_MR_1000HT updateMlog 실행");
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
			// 원자재 로그 테이블에 데이터 수정
			String query =  " update TB_MR_1000HT from ";
				   query += " set Rmrk = ? ";
				   query += " where SN = ? and MTRL_CD = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getRmrk());
			ps.setString(2, dto.getSn());
			ps.setString(3, dto.getMtrl_cd());
			

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
	
	
}
