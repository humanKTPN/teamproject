package tb_pr_1100mt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TB_PR_1110MTDAO {

	// 데이터 삽입 (Insert)
	public int insert(TB_PR_1110MTDTO dto) {
		System.out.println("TB_PR_1110MTDAO insert 실행");
		int result = -1;

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String query = "INSERT INTO TB_PR_1110MT (PROD_PLN_CD, ITEM_NM, TRG_PROD_CNT, Prod_strt_dt, PROD_END_DT, ITEM_CD) "
					+ "VALUES ('PR_'||to_char(sysdate,'yymm')||'_'||LPAD(SQ_PR_1110MT.nextval,4,0), ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getItem_nm());
			ps.setInt(2, dto.getTrg_prod_cnt());
			ps.setString(3, dto.getProd_strt_dt());
			ps.setString(4, dto.getProd_end_dt());
			ps.setString(5, dto.getItem_cd());

			// [SQL 실행] 및 [결과 확보]
			result = ps.executeUpdate(); // int에는 영향받은 줄의 수

			System.out.println("SQL문까지 도달");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 데이터 조회 (Select)
	List selectTBPRList() {
		System.out.println("selectTBPRList 실행");
		List list = new ArrayList();

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String query = "SELECT * FROM TB_PR_1110MT";
			PreparedStatement ps = con.prepareStatement(query);

			// [SQL 실행] 및 [결과 확보]
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TB_PR_1110MTDTO dto = new TB_PR_1110MTDTO();
				dto = new TB_PR_1110MTDTO();
				dto.setProd_pln_cd(rs.getString("Prod_pln_cd"));
				dto.setItem_nm(rs.getString("ITEM_NM"));
				dto.setTrg_prod_cnt(rs.getInt("TRG_PROD_CNT"));
				dto.setProd_strt_dt(rs.getString("Prod_strt_dt"));
				dto.setProd_end_dt(rs.getString("PROD_END_DT"));
				dto.setItem_cd(rs.getString("ITEM_CD"));

				list.add(dto);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println("TB_PR_1110MTDAO list: "+list);
		return list;
	}

	// 데이터 수정 (Update)
	public int update(TB_PR_1110MTDTO dto) {
		System.out.println("TB_PR_1110MTDAO update 실행");
		int result = -1;

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String query = "UPDATE TB_PR_1110MT SET "
					+ "ITEM_NM = ?, TRG_PROD_CNT = ?, Prod_strt_dt = ?, PROD_END_DT = ?, ITEM_CD = ? "
					+ "WHERE PROD_PLN_CD = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getItem_nm());
			ps.setInt(2, dto.getTrg_prod_cnt());
			ps.setString(3, dto.getProd_strt_dt());
			ps.setString(4, dto.getProd_end_dt());
			ps.setString(5, dto.getItem_cd());
			ps.setString(6, dto.getProd_pln_cd());
			System.out.println("dto.getItem_nm() :"+dto.getItem_nm());
			System.out.println("dto.getTrg_prod_cnt :"+dto.getTrg_prod_cnt());
			System.out.println("dto.getProd_strt_dt() :"+dto.getProd_strt_dt());
			System.out.println("dto.getItem_cd() :"+dto.getItem_cd());
			System.out.println("dto.getProd_pln_cd() :"+dto.getProd_pln_cd());

			// [SQL 실행] 및 [결과 확보]
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
