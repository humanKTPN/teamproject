package tb_md_1000mt;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class masterDataManagement_kwak_cotroller
 */
@WebServlet("/masterDataManagement_kwak_cotroller")
public class masterDataManagement_kwak_cotroller extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");

		
		System.out.println("command:"+command);
//		if(command != null && command.equals("update")) {
		if("삭제".equals(command)) {
			System.out.println("delete");
			String cd = request.getParameter("MT_MNG_CD");
			
			DAO_MD_main_Kwak mdDAO = new DAO_MD_main_Kwak();
			try {
				mdDAO.delData(cd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String url = "masterdataManage_main_kwak.jsp";
			response.sendRedirect(url);

		} else if("수정".equals(command)) {
			System.out.println("update");
			String cd = request.getParameter("MT_MNG_CD");
			response.sendRedirect("masterdataManage_mod_kwak.jsp?cd="+cd);
			
//			DAO_MD_main_Kwak dao = new DAO_MD_main_Kwak(); 
//			try {
//				dao.getDataInfo(cd);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		
		}  else if("완료".equals(command)) {
			System.out.println("update2");
			
			DAO_MD_main_Kwak dao = new DAO_MD_main_Kwak(); 
			
			String MT_MNG_NM = request.getParameter("MT_MNG_NM");
			String MT_MNG_DESC = request.getParameter("MT_MNG_DESC");
			String MT_MNG_CD = request.getParameter("MT_MNG_CD");
			
			DTO_MD_main_Kwak addDTO = new DTO_MD_main_Kwak();
			addDTO.setMT_MNG_NM(MT_MNG_NM);
			addDTO.setMT_MNG_DESC(MT_MNG_DESC);
			addDTO.setMT_MNG_CD(MT_MNG_CD);
			
			System.out.println("MT_MNG_NM:"+MT_MNG_NM);
			String url = "masterdataManage_main_kwak.jsp";
			response.sendRedirect(url);

			
			try {
				dao.modData(addDTO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else if(command == null) {
			System.out.println("추가로 왓니?");
			String encoding = "utf-8";
			request.setCharacterEncoding(encoding);
			
			DTO_MD_add_Kwak addDTO = new DTO_MD_add_Kwak();
			MasterDataManage_add_kwak_DAO mdDAO = new MasterDataManage_add_kwak_DAO();
			
			try {
				// File : 파일 또는 디렉토리(폴더)를 관리하는 class
				File currentDirPath = new File("C:\\temp\\upload");
				
				// 세팅
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setRepository(currentDirPath);	// 경로 지정
				factory.setSizeThreshold(1024 * 1024);	// 임시 파일의 크기를 byte단위로

				ServletFileUpload upload = new ServletFileUpload(factory);
				// 업로드 파일의 최대 크기 지정
				upload.setFileSizeMax(1024*1024*100); // 100 메가 바이트 100MB
				// request를 분석해서
				// 요청 파라메터들을 FileItem 뽑고 그걸 List에 담아서 돌려줌
				List<FileItem> items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					
					FileItem fileItem = (FileItem) items.get(i);

					// form 요소인지 판별
					if (fileItem.isFormField()) {
						// getFieldName : 파라메터 key
						// getString : 파라메터 value
						System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
						String title = fileItem.getString(encoding);
						if("MT_MNG_NM".equals(fileItem.getFieldName())) addDTO.setMT_MNG_NM(fileItem.getString(encoding));
						if("TP_CLS_VAL".equals(fileItem.getFieldName())) addDTO.setTP_CLS_VAL(fileItem.getString(encoding));
						if("MT_MNG_DESC".equals(fileItem.getFieldName())) addDTO.setMT_MNG_DESC(fileItem.getString(encoding));
						
//						dto.setTitle(fileItem.getString(encoding));
					} else {
						// 첨부파일 영역
						
						// getSize : 파일 크기
						if (fileItem.getSize() > 0) {
							// 파일명 추출
							String fileName_adr = fileItem.getName(); // 주소 반환
							
							String fullPath = fileItem.getName();
							String fileName = new File(fullPath).getName();
							
							System.out.println(fileName);
							
							fileName = System.currentTimeMillis() +"_"+ fileName;
							
							File uploadFile = new File(currentDirPath + "\\" + fileName);
//							File uploadFile = new File(currentDirPath + File.separator + fileName);
//							File uploadFile = new File(currentDirPath + System.getProperty("file.separator") + fileName);
							
							// 파일 저장
							fileItem.write(uploadFile);
							
							addDTO.setIMG_PATH_ADR(fileName);
							
//							String title = request.getParameter("title");

							
							
						} // end if
					} // end if
					
				} // end for		
				mdDAO.addTask(addDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
//			// insert 장소
//				
//				String MT_MNG_NM = request.getParameter("MT_MNG_NM");
//				String MT_MNG_DESC = request.getParameter("MT_MNG_DESC");
//				String MT_MNG_CD = request.getParameter("MT_MNG_CD");
//				String TP_CLS_VAL = request.getParameter("TP_CLS_VAL");
//	
//				System.out.println("MT_MNG_NM : "+ MT_MNG_NM);
//				System.out.println("MT_MNG_CD : "+ TP_CLS_VAL);
//				
//				DTO_MD_add_Kwak addDTO = new DTO_MD_add_Kwak();
//				addDTO.setMT_MNG_NM(MT_MNG_NM);
//				addDTO.setMT_MNG_DESC(MT_MNG_DESC);
//				addDTO.setMT_MNG_CD(MT_MNG_CD);
//				addDTO.setTP_CLS_VAL(TP_CLS_VAL);
//				
//				MasterDataManage_add_kwak_DAO mdDAO = new MasterDataManage_add_kwak_DAO();
//				try {
//					mdDAO.addTask(addDTO);
//				} catch (SQLException | IOException e) {
//					e.printStackTrace();
//				}
				String url = "masterdataManage_main_kwak.jsp";
				response.sendRedirect(url);
		}
		
	}


}
