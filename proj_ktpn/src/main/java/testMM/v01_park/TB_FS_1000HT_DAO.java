package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_FS_1000HT_DAO {

	// 완제품 로그 테이블의 CRUD

	// 조회
	// 전체 조회
	public List selectPLog() {

		System.out.println("TB_FS_1000HT selectPLog 실행");

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
			String query = "select * from TB_FS_1000HT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_FS_1000HT_DTO dto = new TB_FS_1000HT_DTO();

				dto.setSn(rs.getString("SN"));
				dto.setProd_cd(rs.getString("PROD_CD"));
				dto.setFnsh_code(rs.getString("Fnsh_code"));
				dto.setFnshd_item_nm(rs.getString("Fnshd_item_nm"));
				dto.setCrnt_cnt(rs.getInt("CRNT_CNT"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setChng_dt(rs.getString("CHNG_DT"));
				dto.setIob_se_cd(rs.getString("IOB_SE_CD"));
				dto.setWork_nm(rs.getString("WORK_NM"));
				dto.setFnshl_loc_nm(rs.getString("Fnshl_loc_nm"));
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

	// 부분 조회
	public List selectLastPLog(String code, int i) {

		System.out.println("TB_FS_1000HT selectLastPLog 실행");

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
			String query = " select a.* form ( ";
			query += " select a.*, rownum as rn ";
			query += " from TB_FS_1000HT a ";
			query += " where a.Fnsh_code = ? ";
			query += " ordey by a.SN desc ) a ";
			query += " where a.rn = ? ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, code);
			ps.setInt(2, i);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_FS_1000HT_DTO dto = new TB_FS_1000HT_DTO();

				dto.setSn(rs.getString("SN"));
				dto.setProd_cd(rs.getString("PROD_CD"));
				dto.setFnsh_code(rs.getString("Fnsh_code"));
				dto.setFnshd_item_nm(rs.getString("Fnshd_item_nm"));
				dto.setCrnt_cnt(rs.getInt("CRNT_CNT"));
				dto.setCrnt_aftr_cnt(rs.getInt("CRNT_AFTR_CNT"));
				dto.setChng_dt(rs.getString("CHNG_DT"));
				dto.setIob_se_cd(rs.getString("IOB_SE_CD"));
				dto.setWork_nm(rs.getString("WORK_NM"));
				dto.setFnshl_loc_nm(rs.getString("Fnshl_loc_nm"));
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
	public int insertPlog(TB_FS_1000HT_DTO dto) {

		System.out.println("TB_FS_1000HT insertPlog 실행");
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
			// 완제품 로그 테이블에 데이터 삽입
			String query = "insert into TB_FS_1000HT (SN, PROD_CD,Fnsh_code, Fnshd_item_nm, CRNT_CNT, IOB_SE_CD,";
			query += " WORK_NM, Fnshl_loc_nm, Rmrk, REG_DTTM, CRNT_AFTR_CNT, CHNG_DT) ";
			query += " values (SQ_FS_1000HT.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, to_char(sysdate, 'yyyymmdd')) ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getProd_cd());
			ps.setString(2, dto.getFnsh_code());
			ps.setString(3, dto.getFnshd_item_nm());
			ps.setInt(4, dto.getCrnt_cnt());
			ps.setString(5, dto.getIob_se_cd());
			ps.setString(6, dto.getWork_nm());
			ps.setString(7, dto.getFnshl_loc_nm());
			ps.setString(8, dto.getRmrk());
			ps.setInt(9, dto.getCrnt_aftr_cnt());

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
	public int updatePlog(TB_FS_1000HT_DTO dto) {

		System.out.println("TB_FS_1000HT updatePlog 실행");
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
			// 완제품 로그 테이블에 데이터 삽입
			String query = " update TB_FS_1000HT ";
			query += " set Rmrk = ? ";
			query += " where SN = ? and Fnsh_code = ? ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getRmrk());
			ps.setString(2, dto.getSn());
			ps.setString(3, dto.getFnsh_code());

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
//								ResultSet rs = ps.executeQuery();

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

}
