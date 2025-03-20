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
 * Servlet implementation class testProductController
 */
@WebServlet("/testpcon")
public class testProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/testpcon doGet실행");

		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		
		String prod_cd = request.getParameter("prod_cd");	// 셀렉트박스에서 선택한 생산코드
		
		testProduct_DAO testPdao = new testProduct_DAO();
		testProduct_DTO testPdto = new testProduct_DTO();
		
		testSM_DAO testSMdao = new testSM_DAO();
		testSM_DTO testSMdto = new testSM_DTO();
		
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		
		list1 = testPdao.selectAllProduct();				// 생산완료된 모든 생산코드 조회
		request.setAttribute("list1", list1);				// 값 전달해서 jsp에서 셀렉트박스로 표현
		
		list2 = testSMdao.selectAllPCode();					// 유형분류코드가 완제품인 기준관리코드, 기준관리명 조회
		request.setAttribute("list2", list2);				// 값 전달해서 jsp에서 셀렉트박스로 표현

		for(int i=0; i<list1.size(); i++) {
			testPdto = (testProduct_DTO) list1.get(i);
			if( testPdto.getProd_cd() != null && testPdto.getProd_cd().equals(prod_cd) ) {
				break;		// 생산코드가 prod_cd 인 객체 찾기
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/testpcon doGet실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		doGet(request, response);
	}

}
