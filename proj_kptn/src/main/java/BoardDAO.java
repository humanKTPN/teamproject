import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	public int insertBoard(BoardDTO boardDTO) {

		System.out.println("BoardDTO insertBoardDTO 실행");
		int result = -1;

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String query = " insert into tb_br_1000mt ";
			// 방법 1 : sql string을 그냥 만들기
//				query += " values ( seq_todo.nextval, '"+ todoDTO.getTodo() +"', sysdate, null, 'N' )";
			// 방법 2 : ? 활용하기
			query += " values ( seq_tb_br_1000mt.nextval, ?, ?, ?, Y, ?, N, sysdate, sysdate, ? )";
			PreparedStatement ps = con.prepareStatement(query);
			// 첫번째 물음표에 값을 넣어달라
			ps.setString(1, boardDTO.getBRD_SENM());
			ps.setString(2, boardDTO.getTTL_NM());
			ps.setString(3, boardDTO.getBRD_DESC());
			ps.setInt(4, boardDTO.getVW_CNT());
			ps.setString(5, boardDTO.getID());

			// [SQL 실행] 및 [결과 확보]
			// int executeUpdate() : select 외 모든 것
			// int에는 영향받은 줄의 수
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	
	List selectBoardList() {
		System.out.println("selectBoardList 실행");
		List list = new ArrayList();

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String query = " select * from tb_br_1000mt ";
			PreparedStatement ps = con.prepareStatement(query);

			// [SQL 실행] 및 [결과 확보] ////////////문제잇음
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBRD_NO(rs.getInt("BRD_NO"));
				dto.setBRD_SENM(rs.getString("BRD_SENM")); //
				dto.setTTL_NM(rs.getString("TTL_NM"));
				dto.setBRD_DESC(rs.getString("BRD_DESC"));
				dto.setBLND_YN(rs.getString("BLND_YN")); //
				dto.setVW_CNT(rs.getInt("VW_CNT"));
				dto.setDLT_YN(rs.getString("DLT_YN")); //
				dto.setREG_DTTM(rs.getDate("REG_DTTM"));
				dto.setMOD_DTTM(rs.getDate("MOD_DTTM")); //
				dto.setID(rs.getString("ID"));

				list.add(dto);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int updateTodo(BoardDTO boardDTO) {
		System.out.println("boardDTO updateBoardDTO 실행");
		System.out.println(boardDTO);
		int result = -1;

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]// 틀림
			String query = " update tb_br_1000mt "
						+ " set TTL_NM = ?"
						+ " , BRD_DESC = ?"
						+ " , BLND_YN = ?"
						+ " , MOD_DTTM = ?"
						+ " where BRD_NO = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			// 첫번째 물음표에 값을 넣어달라
			ps.setString(1, boardDTO.getBRD_DESC());
			ps.setString(2, boardDTO.getBLND_YN());
			ps.setDate(3, boardDTO.getMOD_DTTM());

			// [SQL 실행] 및 [결과 확보]
			// int executeUpdate() : select 외 모든 것
			// int에는 영향받은 줄의 수
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
