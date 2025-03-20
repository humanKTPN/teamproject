package tb_rt_1000mt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tb_bm_1000mt.DAO_BM_Kwak;
import tb_bm_1000mt.DTO_BM_Kwak;


@WebServlet("/CNTRL_RT_Kwak")
public class CNTRL_RT_Kwak extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String command = request.getParameter("command");
			
//			System.out.println("cd : "+ cd);
//			if(command != null && command.equals("update")) {
			if("삭제".equals(command)) {
				System.out.println("delete");
				String cd = request.getParameter("rt_cd");
				
				DAO_RT_Kwak mdDAO = new DAO_RT_Kwak();
				
				
				String url = "processDesc_main.jsp";
				response.sendRedirect(url);
				
				try {
					mdDAO.delData(cd);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else if("수정".equals(command)) {
				System.out.println("update");
				String cd = request.getParameter("rt_cd");
				String url = "processDesc_mod.jsp";
				response.sendRedirect(url+"?rt_cd="+cd);
				
				DAO_RT_Kwak dao = new DAO_RT_Kwak(); 
				try {
					dao.getDataInfo(cd);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}  else if("완료".equals(command)) {
				System.out.println("update2");
				
				DAO_RT_Kwak dao = new DAO_RT_Kwak(); 
				
				String rt_cd = request.getParameter("rt_cd");
				String rt_desc = request.getParameter("rt_desc");
				String rt_nm = request.getParameter("rt_nm");
				String item_cd = request.getParameter("item_cd");
				
				DTO_RT_Kwak addDTO = new DTO_RT_Kwak();
				addDTO.setRT_CD(rt_cd);
				addDTO.setRT_NM(rt_nm);
				addDTO.setRT_DESC(rt_desc);
				addDTO.setITEM_CD(item_cd);
				
				String url = "processDesc_main.jsp";
				response.sendRedirect(url);
				
				try {
					dao.modData(addDTO);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else if("추가".equals(command)) {
				// insert 장소
					System.out.println("도착");
					String rt_cd = request.getParameter("rt_cd");
					String rt_nm = request.getParameter("rt_nm");
					String item_cd = request.getParameter("item_cd");
					String rt_desc = request.getParameter("rt_desc");
		
					System.out.println("rt_cd : "+ rt_cd);
					System.out.println("rt_nm : "+ rt_nm);
					System.out.println("rt_desc : "+ rt_desc);
					
					DTO_RT_Kwak addDTO = new DTO_RT_Kwak();
					addDTO.setRT_CD(rt_cd);
					addDTO.setRT_NM(rt_nm);
					addDTO.setITEM_CD(item_cd);
					addDTO.setRT_DESC(rt_desc.replace("\r\n", "<br>"));
					
					DAO_RT_Kwak mdDAO = new DAO_RT_Kwak();
					
					String url = "processDesc_main.jsp";
					response.sendRedirect(url);
					
					try {
						mdDAO.addData(addDTO);
					} catch (SQLException | IOException e) {
						e.printStackTrace();
					}
			}
			

		}

	}