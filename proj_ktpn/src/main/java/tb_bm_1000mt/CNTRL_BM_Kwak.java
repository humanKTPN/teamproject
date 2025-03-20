package tb_bm_1000mt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tb_md_1000mt.DAO_MD_main_Kwak;
import tb_md_1000mt.DTO_MD_add_Kwak;
import tb_md_1000mt.DTO_MD_main_Kwak;
import tb_md_1000mt.MasterDataManage_add_kwak_DAO;

/**
 * Servlet implementation class CNTRL_BM_Kwak
 */
@WebServlet("/CNTRL_BM_Kwak")

public class CNTRL_BM_Kwak extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(123);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		
//		System.out.println("cd : "+ cd);
//		if(command != null && command.equals("update")) {
		if("삭제".equals(command)) {
			System.out.println("delete");
			String cd = request.getParameter("bom_cd");
			
			DAO_BM_Kwak mdDAO = new DAO_BM_Kwak();
			try {
				mdDAO.delData(cd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String url = "bom_main_kwak.jsp";
			response.sendRedirect(url);
			
		} else if("수정".equals(command)) {
			System.out.println("update");
			String cd = request.getParameter("bom_cd");
			String url = "bom_mod_kwak.jsp";
			response.sendRedirect(url+"?bom_cd="+cd);
			
			DAO_BM_Kwak dao = new DAO_BM_Kwak(); 
			try {
				dao.getDataInfo(cd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}  else if("완료".equals(command)) {
			System.out.println("update2");
			
			DAO_BM_Kwak dao = new DAO_BM_Kwak(); 
			
			String bom_cd = request.getParameter("bom_cd");
			String bom_desc = request.getParameter("bom_desc");
			String bom_nm = request.getParameter("bom_nm");
			String item_cd = request.getParameter("item_cd");
			
			DTO_BM_Kwak addDTO = new DTO_BM_Kwak();
			addDTO.setBom_cd(bom_cd);
			addDTO.setBom_nm(bom_nm);
			addDTO.setBom_desc(bom_desc.replace("\r\n","<br>"));
			addDTO.setItem_cd(item_cd);
	
			try {
				dao.modData(addDTO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			response.sendRedirect("bom_main_kwak.jsp");
			
			
		} else if("추가".equals(command)) {
			// insert 장소
				
				String bom_cd = request.getParameter("bom_cd");
				String bom_nm = request.getParameter("bom_nm");
				String item_cd = request.getParameter("item_cd");
				String bom_desc = request.getParameter("bom_desc");
	
				System.out.println("bom_cd : "+ bom_cd);
				System.out.println("bom_nm : "+ bom_nm);
				
				DTO_BM_Kwak addDTO = new DTO_BM_Kwak();
				addDTO.setBom_cd(bom_cd);
				addDTO.setBom_nm(bom_nm);
				addDTO.setItem_cd(item_cd);
				addDTO.setBom_desc(bom_desc);
				
				String url = "bom_main_kwak.jsp";
				response.sendRedirect(url);
				
				DAO_BM_Kwak mdDAO = new DAO_BM_Kwak();
				try {
					mdDAO.addData(addDTO);
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}

}
