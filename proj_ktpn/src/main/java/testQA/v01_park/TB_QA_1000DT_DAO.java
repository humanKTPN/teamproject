package testQA.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class TB_QA_1000DT_DAO {

	// QA리포트 테이블의 CRUD
	
	// select - 조회
	public List selectQAreport(String web) {

		System.out.println("TB_QA_1000DT selectQAreport 실행");

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
			String query = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			// 품질관리 테이블에서 생산부분빼고 품질컬럼만있고 생산코드써서 생산테이블이랑 조인?
			// 품질관리 메인페이지에서 작동
			if ("mainQa".equals(web)) {

				// 생산일순으로 정렬해서 일부 컬럼만 조회
				query = " select PROD_CD, ITEM_CD, ITEM_NM, STRTH_VAL, SZ_VAL, Clrl_val, Qlty_val ";
				query += " from TB_QA_1000DT order by PROD_END_TIME asc ";

				ps = con.prepareStatement(query);

				rs = ps.executeQuery();

				while (rs.next()) {
					TB_QA_1000DT_DTO dto = new TB_QA_1000DT_DTO();

					dto.setProd_cd(rs.getString("PROD_CD"));
					dto.setItem_cd(rs.getString("ITEM_CD"));
					dto.setItem_nm(rs.getString("ITEM_NM"));
					dto.setStrth_val(rs.getInt("STRTH_VAL"));
					dto.setSz_val(rs.getInt("SZ_VAL"));
					dto.setClrl_val(rs.getString("Clrl_val"));
					dto.setQlty_val(rs.getInt("Qlty_val"));
					dto.setChckr_nm(rs.getString("CHCKR_NM"));

					list.add(dto);
					System.out.println("조회 중");
				}
			}

			// 품질관리 보고서 페이지에서 작동
			else if ("Qareport".equals(web)) {

				// 생산일순으로 정렬해서 모두 조회
				query = " select * from TB_QA_1000DT order by PROD_END_TIME asc ";

				ps = con.prepareStatement(query);

				rs = ps.executeQuery();

				while (rs.next()) {
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
	public int insertQAreport(TB_QA_1000DT_DTO dto) {

		System.out.println("TB_QA_1000DT insertQAreport 실행");
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
			String query = "insert into TB_QA_1000DT (PROD_CD, ITEM_CD, ITEM_NM, WORK_NM, PROD_END_TIME, INDC_QNTT, PROD_QNTT, DFC_RT) ";
			query += " select PROD_CD, ITEM_CD, ITEM_NM, WORK_NM, PROD_END_TIME, INDC_QNTT, PROD_QNTT, DFC_RT ";
			query += " from TB_PR_1100MT ";
			query += " where PROD_END_YN like 'y' ";
			// 이전에 들어깄던 데이터가 또 들어갈 위험이 있다 - 생산코드 중복
			// 해결 : 삽입 조건을 생산 완료인 것과 지금 있는 삽입하려는 생산코드가 qa리포트 테이블에 없어야한다로 설정
			query += " and PROD_CD not in select PROD_CD from TB_QA_1000DT ";
			
			PreparedStatement ps = con.prepareStatement(query);

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

	public int updateQAreport(TB_QA_1000DT_DTO dto) {

		System.out.println("TB_QA_1000DT updateQAreport 실행");

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
			// 생산코드가 ?인 것의 컬럼 데이터 값 수정
			String query = " update TB_QA_1000DT ";
			query += " set CHCKR_NM = ?, Chckr_dttm = ?, STRTH_VAL = ?, SZ_VAL = ?, Clrl_val = ?, Qlty_val = ?, Fail_caus_desc = ?, Rmrk = ? ";
			query += " where PROD_CD = ? ";

			PreparedStatement ps = con.prepareStatement(query);

			// 물음표에 값을 넣어라
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

			System.out.println("수정 완료");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public int deleteQAreport(TB_QA_1000DT_DTO dto) {

		System.out.println("TB_QA_1000DT deleteQAreport 실행");

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
			// 생산코드가 ?인 것의 모든 데이터 삭제
			query = "delete from TB_QA_1000DT ";
			query += " where PROD_CD = ? ";
			// 문제1. 만약 삭제하면 품질에 상관없는 생산쪽 데이터도 삭제
			// 하나의 열이 다 삭제된다
			// 현재 테이블에선 생산코드가 ?인 것의 품질 관련 데이터만 삭제하려면 delete가 아니고 update를 사용해야한다
		
			
			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어라
			ps.setString(1, dto.getProd_cd());

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
