package tb_pr_1100mt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tb_pr_mt")
public class TB_PR_MTController extends HttpServlet {

	// 데이터 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		System.out.println("type" + type);
		if ("1110".equals(type)) {
			// TB_PR_1110MTDTO 조회 생산일정
			TB_PR_1110MTDAO dao = new TB_PR_1110MTDAO();
			List resultList = dao.selectTBPRList();

			// test_TB_PR_1000MT_DAO 조회 작업지시서
			test_TB_PR_1000MT_DAO dao1 = new test_TB_PR_1000MT_DAO();
			List workList = dao1.selectTestWorkList();

			// test_TB_MB_1000MT_DAO 조회 회원정보
			test_TB_MB_1000MT_DAO dao2 = new test_TB_MB_1000MT_DAO();
			List wemberList = dao2.selectTestMemberList();

			// test_TB_MD_1000MTDAO 조회 회원정보
			TB_MD_1000MTDAO dao3 = new TB_MD_1000MTDAO();
			List StandardList = dao3.selectTestStandardList();

			request.setAttribute("resultList", resultList);
			request.setAttribute("type", "1110");

			request.setAttribute("workList", workList);

			request.setAttribute("wemberList", wemberList);

			request.setAttribute("StandardList", StandardList);

			String url = "/pr_popup_tak.jsp";
//			String url = "/WEB-INF/views/pr_popup_tak.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} else if ("1100".equals(type)) {
			// TB_PR_1100MTDTO 조회
			TB_PR_1100MTDAO dao = new TB_PR_1100MTDAO();
			List resultList = dao.selectTBPRList();

			// test_TB_PR_1000MT_DAO 조회 작업지시서
			test_TB_PR_1000MT_DAO dao1 = new test_TB_PR_1000MT_DAO();
			List workList = dao1.selectTestWorkList();

			// test_TB_MB_1000MT_DAO 조회 회원정보
			test_TB_MB_1000MT_DAO dao2 = new test_TB_MB_1000MT_DAO();
			List wemberList = dao2.selectTestMemberList();

			// test_TB_MD_1000MTDAO 조회 회원정보
			TB_MD_1000MTDAO dao3 = new TB_MD_1000MTDAO();
			List StandardList = dao3.selectTestStandardList();

			// test_TB_MD_1000MTDAO 조회 라인코드,라인명
			TB_MD_1000MTDAO dao4 = new TB_MD_1000MTDAO();
			List LineList = dao4.selectTestLineList();

			for(int i=0; i<workList.size(); i++) {
				test_TB_PR_1000MT_DTO dto0 = (test_TB_PR_1000MT_DTO) workList.get(i);
				
				System.out.println("workList : " + dto0.toString());
				System.out.println();
			}
			
			
			request.setAttribute("resultList", resultList);
			request.setAttribute("type", "1100");

			request.setAttribute("workList", workList);

			request.setAttribute("wemberList", wemberList);

			request.setAttribute("StandardList", StandardList);
			
			request.setAttribute("LineList", LineList);

			String url = "/pm_popup_tak.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			// TB_PR_1110MTDTO 조회 생산일정
			TB_PR_1110MTDAO dao = new TB_PR_1110MTDAO();
			List resultList1 = dao.selectTBPRList();
			
			// TB_PR_1100MTDTO 전체라인 조회 생산
			TB_PR_1100MTDAO dao0 = new TB_PR_1100MTDAO();
			List resultList2 = dao0.selectTBPRList();
			
			// TB_PR_1100MTDTO A라인 조회 생산
			TB_PR_1100MTDAO dao0_1 = new TB_PR_1100MTDAO();
			List ALineList = dao0_1.ALineList();
			
			// TB_PR_1100MTDTO B라인 조회 생산
			TB_PR_1100MTDAO dao0_2 = new TB_PR_1100MTDAO();
			List BLineList = dao0_2.BLineList();
			
			// TB_PR_1100MTDTO C라인 조회 생산
			TB_PR_1100MTDAO dao0_3 = new TB_PR_1100MTDAO();
			List CLineList = dao0_3.CLineList();

			
			
			// test_TB_PR_1000MT_DAO 조회 작업지시서
			test_TB_PR_1000MT_DAO dao1 = new test_TB_PR_1000MT_DAO();
			List workList = dao1.selectTestWorkList();
			
			
			

			// test_TB_MB_1000MT_DAO 조회 회원정보
			test_TB_MB_1000MT_DAO dao2 = new test_TB_MB_1000MT_DAO();
			List wemberList = dao2.selectTestMemberList();

			// test_TB_MD_1000MTDAO 조회 기준정보 품명,품목코드
			TB_MD_1000MTDAO dao3 = new TB_MD_1000MTDAO();
			List StandardList = dao3.selectTestStandardList();

			// test_TB_MD_1000MTDAO 조회 라인코드,라인명
			TB_MD_1000MTDAO dao4 = new TB_MD_1000MTDAO();
			List LineList = dao4.selectTestLineList();

			request.setAttribute("resultList1", resultList1);
			
			request.setAttribute("resultList2", resultList2);
			
			request.setAttribute("ALineList", ALineList);
			request.setAttribute("BLineList", BLineList);
			request.setAttribute("CLineList", CLineList);

			request.setAttribute("workList", workList);

			request.setAttribute("wemberList", wemberList);

			request.setAttribute("StandardList", StandardList);

			request.setAttribute("LineList", LineList);

			String url = "/Production management_tak.jsp";
//						String url = "/WEB-INF/views/pr_popup_tak.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}

		/*
		 * 작업지시서에서 데이터 조회해올때 test_TB_PR_1000MT_DAO dao1 = new test_TB_PR_1000MT_DAO();
		 * List workList = dao1.selectTestWorkList(); 결과 : 생산코드, 라인호기코드, 라인호기명, 품목코드
		 * request.setAttribute("workList", workList); String url =
		 * "/tb_pr_mt?type=1100"; request.getRequestDispatcher(url).forward(request,
		 * response);
		 */
		
	}

	// 데이터 삽입, 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		//페이지조회 추후 확인
//		List Plist =  new ArrayList();
		
		String command = request.getParameter("command");
		String type = request.getParameter("type");
		System.out.println("type : " + type);
		System.out.println("command : " + command);
		if ("insert".equals(command)) {
			if ("1110".equals(type)) {
				// TB_PR_1110MTDTO 삽입
				String prodPlnCd = request.getParameter("prodPlnCd");
				String itemNm = request.getParameter("itemNm");
				int trgProdCnt = Integer.parseInt(request.getParameter("trgProdCnt"));
				String prodStrtDt = request.getParameter("prodStrtDt");
				String prodEndDt = request.getParameter("prodEndDt");
				String itemCd = request.getParameter("itemCd");

				TB_PR_1110MTDTO dto = new TB_PR_1110MTDTO();
				dto.setProd_pln_cd(prodPlnCd);
				dto.setItem_nm(itemNm);
				dto.setTrg_prod_cnt(trgProdCnt);
				dto.setProd_strt_dt(prodStrtDt);
				dto.setProd_end_dt(prodEndDt);
				dto.setItem_cd(itemCd);

				TB_PR_1110MTDAO dao = new TB_PR_1110MTDAO();
				int result = dao.insert(dto);
				System.out.println("Insert result: " + result);
			} else if ("1100".equals(type)) {
				// TB_PR_1100MTDTO 삽입
				String prodcd = request.getParameter("prodcd");
				String mtMngCd = request.getParameter("mtMngCd");
				String liunNm = request.getParameter("liunNm");
				String itemNm = request.getParameter("itemNm");
				String itemCd = request.getParameter("itemCd");
//				String prodStrtTime = request.getParameter("PROD_STRT_TIME");
//				String prodEndTime = request.getParameter("prodEndTime");
				int indcQntt = Integer.parseInt(request.getParameter("indcQntt")); // 지시수량 넘어오게끔 추후
				int prodQntt = Integer.parseInt(request.getParameter("prodQntt"));
				String workNm = request.getParameter("workNm");
//				String eqpmOprtSttsVal = request.getParameter("eqpmOprtSttsVal");
//				String prodEndYn = request.getParameter("prodEndYn");
				

//				

				TB_PR_1100MTDTO dto = new TB_PR_1100MTDTO();
				dto.setProd_cd(prodcd);
				dto.setMt_mng_cd(mtMngCd);
				dto.setLiun_nm(liunNm);
				dto.setItem_nm(itemNm);
				dto.setItem_cd(itemCd);
//				dto.setProd_strt_time(prodStrtTime);
//				dto.setProd_end_time(prodEndTime);
				dto.setIndc_qntt(indcQntt);
				dto.setProd_qntt(prodQntt);
				dto.setWork_nm(workNm);
//				dto.setEqpm_oprt_stts_val(eqpmOprtSttsVal);
//				dto.setProd_end_yn(prodEndYn);
				

				TB_PR_1100MTDAO dao = new TB_PR_1100MTDAO();
				int result = dao.insert(dto);
				System.out.println("Insert result: " + result);
				
				
//				//페이지조회 추후확인
//				Plist = dao.selectTBPRList();
//				request.setAttribute("Plist", Plist);
//				
//				String url = "";
//				request.getRequestDispatcher(url).forward(request, response);
			}

		} else if ("update".equals(command)) {
			if ("1110".equals(type)) {
				// TB_PR_1110MTDTO 수정
				String prodPlnCd = request.getParameter("PROD_PLN_CD");
				String itemNm = request.getParameter("itemNm");
				int trgProdCnt = Integer.parseInt(request.getParameter("trgProdCnt"));
				String prodStrtDt = request.getParameter("prodStrtDt");
				String prodEndDt = request.getParameter("prodEndDt");
				String itemCd = request.getParameter("itemCd");

				TB_PR_1110MTDTO dto = new TB_PR_1110MTDTO();
				dto.setProd_pln_cd(prodPlnCd);
				dto.setItem_nm(itemNm);
				dto.setTrg_prod_cnt(trgProdCnt);
				dto.setProd_strt_dt(prodStrtDt);
				dto.setProd_end_dt(prodEndDt);
				dto.setItem_cd(itemCd);

				System.out.println("itemNm :" + itemNm);
				System.out.println("itemCd :" + itemCd);

				TB_PR_1110MTDAO dao = new TB_PR_1110MTDAO();
				int result = dao.update(dto);
				System.out.println("Update result: " + result);
			} else if ("1100".equals(type)) {
				// TB_PR_1100MTDTO 수정
				String prodcd = request.getParameter("prodcd");
				String mtMngCd = request.getParameter("mtMngCd");
				String liunNm = request.getParameter("liunNm");
				String itemNm = request.getParameter("itemNm");
				String itemCd = request.getParameter("itemCd");
//				String prodStrtTime = request.getParameter("PROD_STRT_TIME");
//				String prodEndTime = request.getParameter("prodEndTime");
				int indcQntt = Integer.parseInt(request.getParameter("indcQntt")); // 지시수량 넘어오게끔 추후
				int prodQntt = Integer.parseInt(request.getParameter("prodQntt"));
				String workNm = request.getParameter("workNm");
//				String eqpmOprtSttsVal = request.getParameter("eqpmOprtSttsVal");
//				String prodEndYn = request.getParameter("prodEndYn");
				

//				

				TB_PR_1100MTDTO dto = new TB_PR_1100MTDTO();
				dto.setProd_cd(prodcd);
				dto.setMt_mng_cd(mtMngCd);
				dto.setLiun_nm(liunNm);
				dto.setItem_nm(itemNm);
				dto.setItem_cd(itemCd);
//				dto.setProd_strt_time(prodStrtTime);
//				dto.setProd_end_time(prodEndTime);
				dto.setIndc_qntt(indcQntt);
				dto.setProd_qntt(prodQntt);
				dto.setWork_nm(workNm);
//				dto.setEqpm_oprt_stts_val(eqpmOprtSttsVal);
//				dto.setProd_end_yn(prodEndYn);
				
				System.out.println("dto: " + dto.toString());
				
				TB_PR_1100MTDAO dao = new TB_PR_1100MTDAO();
				int result = dao.update(dto);
				System.out.println("Update result: " + result);
			}
		}else if ("complete".equals(command)) {
				if ("1100".equals(type)) {
					String prodEndYn = request.getParameter("prodEndYn");
					if (prodEndYn == null) {
						prodEndYn = "Y";
					}
					// TB_PR_1100MTDTO 수정
					String prodcd = request.getParameter("prodcd");
					int dfcRt = Integer.parseInt(request.getParameter("dfcRt"));

					TB_PR_1100MTDTO dto = new TB_PR_1100MTDTO();
					dto.setProd_cd(prodcd);
					dto.setProd_end_yn(prodEndYn);
					dto.setDfc_rt(dfcRt);

					
					TB_PR_1100MTDAO dao = new TB_PR_1100MTDAO();
					int result = dao.complete(dto);
					System.out.println("complete result: " + result);
				}

			}

//			 작업 후 리스트 페이지로 리다이렉트
			if ("1100".equals(type)) {
				response.sendRedirect("tb_pr_mt?type=1100");
			} else if ("1110".equals(type)) {
				response.sendRedirect("tb_pr_mt?type=1110");
			}
		}
	}
