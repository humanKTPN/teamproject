

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	List selectMemberOne(MemberDTO memberDTO) { // 클래스명 변수명(앞으로 쓸 바구니)
		System.out.println("한명만 출력하는 시스템 실행");

		//오류
		//DTO까지 됬지만 막상 실행하면 selectMemberOne이 실행안됨.
		//selectMemberOne을 실행할려고 메소드를 만들려하면 전달인자오류로 되지 않음
		
		System.out.println(memberDTO.getId());;
		System.out.println(memberDTO.getPw());;
		System.out.println(memberDTO.getMbr_nm());

		List result = new ArrayList();

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String query =  " select * from TB_MB_1000MT where id = ? and pw = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, memberDTO.getId()); //? 세팅은 여기에다가!
			ps.setString(2, memberDTO.getPw());

			// [SQL 실행] 및 [결과 확보]
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setMbr_nm(rs.getString("mbr_nm"));
				dto.setYtn_yn(rs.getString("dlt_yn"));
				dto.setReg_dttm(rs.getDate("reg_dttm"));
				dto.setMod_dttm(rs.getDate("mod_dttm"));
				dto.setMbr_senm(rs.getString("mbr_senm"));
				
				System.out.println(dto.getMbr_nm());
				
				result.add(dto);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		
		return result;
//		

	
	}
	
	List selectMember() {
		System.out.println("member select 실행");
		
		List result = new ArrayList();
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String query =  " select * from TB_MB_1000MT ";
			PreparedStatement ps = con.prepareStatement(query);

			// [SQL 실행] 및 [결과 확보]
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setMbr_nm(rs.getString("mbr_nm"));
				dto.setYtn_yn(rs.getString("dlt_yn"));
				dto.setReg_dttm(rs.getDate("reg_dttm"));
				dto.setMod_dttm(rs.getDate("mod_dttm"));
				dto.setMbr_senm(rs.getString("mbr_senm"));
				
				result.add(dto);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/// 테이블 명 : TB_MB_1000MT
	public List updateMember(MemberDTO memberDTO) {
		System.out.println("member updateTodo 실행");
		System.out.println(memberDTO);

		List result = new ArrayList();
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();
			ResultSet rs = null;

			// [SQL 준비] (여러개 넣을때)
			String 	query =  " update TB_MB_1000MT ";
					query += " set pw = ?";
					query += " , mod_dttm = sysdate";
					query += " where id = ?";
					
			PreparedStatement ps = con.prepareStatement(query);
			
			// 첫번째 물음표에 값을 넣어달라
			ps.setString(1, memberDTO.getPw());
			ps.setString(2, memberDTO.getId());

			// [SQL 실행] 및 [결과 확보]
			// int executeUpdate() : select 외 모든 것
			// int에는 영향받은 줄의 수
			int movInt = ps.executeUpdate();
			
			if (movInt > 0) {
	            String selectQuery = "SELECT id, pw, mod_dttm FROM TB_MB_1000MT WHERE id = ?";
	            ps = con.prepareStatement(selectQuery);
	            ps.setString(1, memberDTO.getId());
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                MemberDTO updatedMember = new MemberDTO();
	                updatedMember.setId(rs.getString("id"));
	                updatedMember.setPw(rs.getString("pw"));
	                updatedMember.setMod_dttm(rs.getDate("mod_dttm"));
	                
	                result.add(updatedMember);
	            }
	        }

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
