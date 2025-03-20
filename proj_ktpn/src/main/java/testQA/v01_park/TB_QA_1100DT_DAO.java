package testQA.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import testMM.v01_park.TB_OD_1000MT_DTO;

public class TB_QA_1100DT_DAO {
	
	// QA리포트 테이블의 CRUD
	
	// 조회
	// 전체 조회
	public List selectQCreport() {

		System.out.println("TB_QA_1100DT selectQCreport 실행");

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
			String query = "select * from TB_QA_1100DT ";
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TB_QA_1100DT_DTO dto = new TB_QA_1100DT_DTO();

				dto.setProd_cd(rs.getString("PROD_CD"));
				dto.setItem_cd(rs.getString("ITEM_CD"));
				dto.setItem_nm(rs.getString("ITEM_NM"));
				dto.setChckr_nm(rs.getString("CHCKR_NM"));
				dto.setChckr_dttm(rs.getDate("Chckr_dttm"));
				dto.setStrth_val(rs.getInt("STRTH_VAL"));
				dto.setSz_val(rs.getInt("SZ_VAL"));
				dto.setClrl_val(rs.getString("Clrl_val"));
				dto.setQlty_val(rs.getInt("Qlty_val"));
				dto.setFail_caus_desc(rs.getString("Fail_caus_desc"));
				dto.setRmrk(rs.getString("Rmrk"));
			
				
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
	public int insertQCreport(TB_QA_1100DT_DTO dto) {

		System.out.println("TB_QA_1100DT insertQCreport 실행");
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
			// 생산 테이블에서 생산이 완료된 것들만 qa테이블에 데이터 삽입
			String query =  " insert into TB_QA_1100DT (PROD_CD, ITEM_CD, ITEM_NM, CHCKR_NM, Chckr_dttm, STRTH_VAL, SZ_VAL, Clrl_val, Qlty_val, Fail_caus_desc, Rmrk) ";
				   query += " values (?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?) ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getProd_cd());
			ps.setString(2, dto.getItem_cd());
			ps.setString(3, dto.getItem_nm());
			ps.setString(4, dto.getChckr_nm());
			ps.setInt(5, dto.getStrth_val());
			ps.setInt(6, dto.getSz_val());
			ps.setString(7, dto.getClrl_val());
			ps.setInt(8, dto.getQlty_val());
			ps.setString(9, dto.getFail_caus_desc());
			ps.setString(10, dto.getRmrk());
			
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
	public int updateQCreport(TB_QA_1100DT_DTO dto) {

		System.out.println("TB_QA_1100DT updateQCreport 실행");
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
			// 생산 테이블에서 생산이 완료된 것들만 qa테이블에 데이터 수정
			String query =  " update TB_QA_1100DT ";
				   query += " set CHCKR_NM = ?, Chckr_dttm = ?, STRTH_VAL = ?, SZ_VAL = ?, ";
				   query +=	" Clrl_val = ?, Qlty_val = ?, Fail_caus_desc = ?, Rmrk = ? ";
				   query += " where PROD_CD = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);			
			ps.setString(1, dto.getChckr_nm());
			ps.setDate(2, dto.getChckr_dttm());
			ps.setInt(3, dto.getStrth_val());
			ps.setInt(4, dto.getSz_val());
			ps.setString(5, dto.getClrl_val());
			ps.setInt(6, dto.getQlty_val());
			ps.setString(7, dto.getFail_caus_desc());
			ps.setString(8, dto.getRmrk());
			ps.setString(9, dto.getProd_cd());
			
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
	
	
	// 삭제
	public int deleteQCreport(TB_QA_1100DT_DTO dto) {

		System.out.println("TB_QA_1100DT deleteQCreport 실행");
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
			// 생산 테이블에서 생산이 완료된 것들만 qa테이블에 데이터 삽입
			String query =  " delete from TB_QA_1100DT ";
				   query += " where PROD_CD = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getProd_cd());
			
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
	
	
	// 품질 테이블과 생산 테이블을 조인해서 입력한 생산코드의 데이터만 보여주는 조회
	public List joinQCnPR(String code) {

		System.out.println("TB_QA_1100DT joinQCnPR 실행");

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
			// 조인해서 생산코드가 ?인 결과를 출력
			String query =  " select pr.PROD_CD, pr.ITEM_CD, pr.ITEM_NM, pr.WORK_NM, pr.PROD_END_TIME, pr.INDC_QNTT, pr.PROD_QNTT, pr.DFC_RT, ";
				   query += "        qa.CHCKR_NM, qa.Chckr_dttm, qa.STRTH_VAL, qa.SZ_VAL, qa.Clrl_val, qa.Qlty_val, qa.Fail_caus_desc, qa.Rmrk ";
				   query += "   from TB_QA_1100DT qa, TB_PR_1100MT pr ";
				   query += "  where qa.PROD_CD = pr.PROD_CD ";
				   query += "    and qa.PROD_CD = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, code);
			
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				// 조인 데이터를 받을 dto
				
				
				TB_QA_1000DT_DTO dto = new TB_QA_1000DT_DTO();

				dto.setProd_cd(rs.getString("PROD_CD"));
				dto.setItem_cd(rs.getString("ITEM_CD"));
				dto.setItem_nm(rs.getString("ITEM_NM"));
				dto.setWork_nm(rs.getString("WORK_NM"));
				dto.setProd_end_time(rs.getString("PROD_END_TIME"));
				dto.setIndc_qntt(rs.getInt("INDC_QNTT"));
				dto.setProd_qntt(rs.getInt("PROD_QNTT"));
				dto.setDfc_rt(rs.getInt("DFC_RT"));
				dto.setChckr_nm(rs.getString("CHCKR_NM"));
				dto.setChckr_dttm(rs.getDate("Chckr_dttm"));
				dto.setStrth_val(rs.getInt("STRTH_VAL"));
				dto.setSz_val(rs.getInt("SZ_VAL"));
				dto.setClrl_val(rs.getString("Clrl_val"));
				dto.setQlty_val(rs.getInt("Qlty_val"));
				dto.setFail_caus_desc(rs.getString("Fail_caus_desc"));
				dto.setRmrk(rs.getString("Rmrk"));
			
				
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
