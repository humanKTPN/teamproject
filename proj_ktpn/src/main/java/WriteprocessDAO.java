import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class WriteprocessDAO {

	public int insertProcess(WriteprocessDTO writeprocessDTO) {

		System.out.println("insertProcess 실행");
		int result = -1;

		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비] // 수정 필요
			String query = " insert into tb_br_1000mt ";

			query += " values ( ?,?,?,sysdate )";
			PreparedStatement ps = con.prepareStatement(query);

			// ?를 이용한 값삽입 쿼리 작성
			
			
			
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
