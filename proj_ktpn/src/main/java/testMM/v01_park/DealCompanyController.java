package testMM.v01_park;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DealCompanyController
 */
@WebServlet("/dealcomp")
public class DealCompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/DealComp doGet실행");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		TB_OD_1000MT_DAO tb_OD_1000MT_DAO = new TB_OD_1000MT_DAO();
		
		
		// 조회
		List list = tb_OD_1000MT_DAO.selectDealCompany();
		
		for(int i=0; i<list.size(); i++) {
			TB_OD_1000MT_DTO dto = new TB_OD_1000MT_DTO();
			dto = (TB_OD_1000MT_DTO) list.get(i);
			
			System.out.println("dto.toString() : " + dto.toString());
			System.out.println();
		}
		
//		for(TB_OD_1000MT_DTO i : <TB_OD_1000MT_DTO> list) {
//			
//		}
		
//		String company_name = "null1";
//		System.out.println("company name : " + company_name);
//		
//		TB_OD_1000MT_DTO dto = new TB_OD_1000MT_DTO();
//		dto.setCMP_NM(company_name);
//		
//		// 삽입
//		int result = tb_OD_1000MT_DAO.insertDealCompany(dto);
//		System.out.println("result : " + result);
//		System.out.println();
//		
//		company_name = "null123";
//		System.out.println("company name : " + company_name);
//		dto.setCMP_NM(company_name);
//		
//		// 수정
//		result = tb_OD_1000MT_DAO.updateDealCompany(dto);
//		System.out.println("result : " + result);
//		System.out.println();
		
		// 삭제
//		result = tb_OD_1000MT_DAO.deleteDealCompany(dto);
//		System.out.println("result : " + result);
//		System.out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/DealComp doPost실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		List companyList = new ArrayList();
		
		String command = request.getParameter("command");			// value =order
		System.out.println("command : " + command);
		
		if("order".equals(command)) {
			
			TB_OD_1000MT_DAO odtabla_dao = new TB_OD_1000MT_DAO();
			
			companyList = odtabla_dao.selectDealCompany();
			
			for(int i=0; i<companyList.size(); i++) {
				TB_OD_1000MT_DTO dto = new TB_OD_1000MT_DTO();
				dto = (TB_OD_1000MT_DTO) companyList.get(i);
				
				System.out.println("dto.toString() : " + dto.toString());
				System.out.println();
			}
			
			request.setAttribute("companyList", companyList);
			
			String url = "TestMM_order_park.jsp";

			request.getRequestDispatcher(url).forward(request, response);
		}
		
//		String url = "dealcomp";
//		response.sendRedirect(url);
		
//		doGet(request, response);
	}

}
