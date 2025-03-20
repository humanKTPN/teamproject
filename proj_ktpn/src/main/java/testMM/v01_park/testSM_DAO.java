package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class testSM_DAO {
	
	// 기준관리 테이블 테스트
	
	// 조회
	// 완제품 코드, 완제품명 조회
	public List selectAllPCode() {

		System.out.println("testSM_DAO selectAllPCode 실행");
		
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
			String query = " select MT_MNG_CD, "
					+ "	MT_MNG_NM "
					+ " from TB_MD_1000MT where TP_CLS_VAL like '완제품' ";
			// 완제품 코드, 완제품명 조회, 0~n개 나온다
			PreparedStatement ps = con.prepareStatement(query);
			
			// TP_CLS_VAL을 설정하지않고 직접 입력한 값을 받을 때
			// 메소드 하나로 사용가능
//			ps.setString(1, dto.getTP_CLS_VAL());
			
	
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				testSM_DTO dto = new testSM_DTO();

				dto.setMT_MNG_CD(rs.getString("MT_MNG_CD"));
				dto.setMT_MNG_NM(rs.getString("MT_MNG_NM"));

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
	// 원자재코드, 원자재명 조회
	public List selectAllMCode() {

		System.out.println("testSM_DAO selectAllMCode 실행");
		
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
			String query = " select MT_MNG_CD, "
					+ "	MT_MNG_NM "
					+ " from TB_MD_1000MT where TP_CLS_VAL like '원자재' ";
			// 원자재코드, 원자재명 조회, 0~n개 나온다
			PreparedStatement ps = con.prepareStatement(query);
			
			// TP_CLS_VAL을 설정하지않고 직접 입력한 값을 받을 때
//			ps.setString(1, dto.getTP_CLS_VAL());
			
	
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				testSM_DTO dto = new testSM_DTO();

				dto.setMT_MNG_CD(rs.getString("MT_MNG_CD"));
				dto.setMT_MNG_NM(rs.getString("MT_MNG_NM"));

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
