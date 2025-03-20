package testMM.v01_park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class testProduct_DAO {
	
	// 생산 테이블 테스트
	
	// 조회
	// 생산이 완료된 생산코드들 조회
	public List selectAllProduct() {

		System.out.println("testProduct_DAO selectProduct 실행");
		
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
			String query = " select PROD_CD, "
					+ "	PROD_QNTT "
					+ " from TB_PR_1100MT where PROD_END_YN = 'Y' ";
			// 생산이 완료된 생산코드(들) 출력,  0~n개 나옴
			PreparedStatement ps = con.prepareStatement(query);

			
	
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				testProduct_DTO dto = new testProduct_DTO();

				dto.setProd_cd(rs.getString("PROD_CD"));
				dto.setProd_qntt(rs.getInt("PROD_QNTT"));

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
	// 선택한 생산이 완료된 생산코드 1개만 출력
	public List selectProduct(testProduct_DTO dto) {

		System.out.println("testProduct_DAO selectProduct 실행");
		
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
			String query = " select PROD_CD, "
					+ "	PROD_QNTT "
					+ " from TB_PR_1100MT where PROD_END_YN = 'Y' where PROD_CD like ?";
			// 생산이 완료된 생산코드의 생산량 출력,  1개 나옴
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getProd_cd());

			
	
			// SQL 실행 및 결과 확보
			// ResultSet executeQuery() : SQL 중 select 실행
			// int executeUpdate() : select 외 모든 것
			// ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//testProduct_DTO dto = new testProduct_DTO();

				dto.setProd_cd(rs.getString("PROD_CD"));
				dto.setProd_qntt(rs.getInt("PROD_QNTT"));

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
