package tb_pr_1000mt;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import tb_md_1000mt.DAO_MD_main_Kwak;
import tb_md_1000mt.DTO_MD_add_Kwak;
import tb_md_1000mt.DTO_MD_main_Kwak;
import tb_md_1000mt.MasterDataManage_add_kwak_DAO;

/**
 * Servlet implementation class CNTRL_BM_Kwak
 */
@WebServlet("/CNTRL_PR_Kwak")

public class CNTRL_PR_Kwak extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		
		System.out.println("cd : "+ command);
		
		
//		if(command != null && command.equals("update")) {
		if("삭제".equals(command)) {
			System.out.println("delete");
			String cd = request.getParameter("prod_cd");
			
			DAO_PR_Kwak mdDAO = new DAO_PR_Kwak();
			
			String url = "workManage_main_kwak.jsp";
			response.sendRedirect(url);
			try {
				mdDAO.delData(cd);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} 
//		else if("수정".equals(command)) {
//			System.out.println("update");
//			String cd = request.getParameter("bom_cd");
//			String url = "bom_mod_kwak.jsp";
//			response.sendRedirect(url+"?bom_cd="+cd);
//			
//			DAO_PR_Kwak dao = new DAO_PR_Kwak(); 
//			try {
//				dao.getDataInfo(cd);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
//		}  
		 else if("검색".equals(command)) {
			System.out.println("search");
//
//			String cate = request.getParameter("cate");
//			String sch = request.getParameter("search_desc");
			
			
			System.out.println("dto.Cate : " +request.getParameter("cate"));
			System.out.println("dto.Sch : " + request.getParameter("search_desc"));
			System.out.println("s : " + request.getParameter("ss"));
			System.out.println(request.getParameter("str_dt").replace("-",""));

			
//			String url = "workManage_sch_kwak.jsp";
			String url = "workManage_main_kwak.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			
			
		}
		else if("추가".equals(command)) {
			// insert 장소
				String mb_nm = request.getParameter("mb_nm");
				String ln_cd = request.getParameter("ln_cd");
				String pln_cd = request.getParameter("h_pln_cd");
				String item_cd = request.getParameter("h_item_cd");
				String prod_dt = request.getParameter("prod_dt").replace("-", "");
				String ln_nm = request.getParameter("h_ln_nm");
				String indc_qntt = request.getParameter("indc_qntt");
				String bom_cd = request.getParameter("bom_cd");
				String rt_cd = request.getParameter("rt_cd");
				
//	
				System.out.println("mb_nm : "+ mb_nm);
				System.out.println("ln_cd : "+ ln_cd);
				System.out.println("pln_cd : "+ pln_cd);
				System.out.println(prod_dt);
////				System.out.println("bom_nm : "+ bom_nm);
//				
				DTO_PR_Kwak addDTO = new DTO_PR_Kwak();
				addDTO.setPR_MB_NM(mb_nm);
				addDTO.setLINE_CD(ln_cd);
				addDTO.setPROD_PLN_CD(pln_cd);
				addDTO.setITEM_CD(item_cd);
				addDTO.setPROD_DT(prod_dt);
				addDTO.setLINE_NM(ln_nm);
				addDTO.setINDC_QNTT(indc_qntt);
				addDTO.setBOM_CD2(bom_cd);
				addDTO.setRT_CD2(rt_cd);
				
				String url = "workManage_main_kwak.jsp";
				response.sendRedirect(url);
				
				
				DAO_PR_Kwak mdDAO = new DAO_PR_Kwak();
				try {
					mdDAO.addData(addDTO);
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
		}

}
	
	
}
