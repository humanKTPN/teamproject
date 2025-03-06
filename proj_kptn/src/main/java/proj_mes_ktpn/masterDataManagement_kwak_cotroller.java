package proj_mes_ktpn;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class masterDataManagement_kwak_cotroller
 */
@WebServlet("/masterDataManagement_kwak_cotroller")
public class masterDataManagement_kwak_cotroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "+ command);
//		if(command != null && command.equals("update")) {
		if("update".equals(command)) {
			System.out.println("update");
			// update 장소
//			String done = request.getParameter("done");
//			if( done == null ) {
//				done = "N";
//			}
//			System.out.println("done : "+ done);
//			
//			String str_todo_id = request.getParameter("todo_id");
//			int todo_id = Integer.parseInt(str_todo_id);
//			
//			MasterDataManage_add_kwak_DTO todoDTO = new MasterDataManage_add_kwak_DTO();
//			
//			
//			TodoDAO todoDAO = new TodoDAO();
//			int result = todoDAO.updateTodo(todoDTO);
//			System.out.println("result : "+ result);
		} else if("insert".equals(command)) {
			// insert 장소
				
				String MT_MNG_NM = request.getParameter("MT_MNG_NM");
				String MT_MNG_CD = request.getParameter("MT_MNG_CD");
				String MT_UNT_VAL = request.getParameter("MT_UNT_VAL");
				String CSTMR_NM = request.getParameter("CSTMR_NM");
				String MT_MNG_DESC = request.getParameter("MT_MNG_DESC");
				String ITEM_TP = request.getParameter("ITEM_TP");
				System.out.println("MT_MNG_NM : "+ MT_MNG_NM);
				
				MasterDataManage_add_kwak_DTO mdDTO = new MasterDataManage_add_kwak_DTO();
				mdDTO.setMT_MNG_NM(MT_MNG_NM);
				mdDTO.setMT_MNG_CD(MT_MNG_CD);
				mdDTO.setMT_UNT_VAL(MT_UNT_VAL);
				mdDTO.setCSTMR_NM(CSTMR_NM);
				mdDTO.setMT_MNG_DESC(MT_MNG_DESC);
				mdDTO.setITEM_TP(ITEM_TP);
				
				MasterDataManage_add_kwak_DAO mdDAO = new MasterDataManage_add_kwak_DAO();
				try {
					mdDAO.addTask(mdDTO);
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
		}
		
		String url = "masterdataManage_add_kwak.jsp";
		response.sendRedirect(url);
	}


}
