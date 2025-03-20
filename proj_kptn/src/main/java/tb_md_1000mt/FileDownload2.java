package tb_md_1000mt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/download.do")
public class FileDownload2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String fileName = "1741591323720_05. 스마트 팩토리MES 구축(Ⅰ)-ERD-곽우림.png";
		String fileName = request.getParameter("filename");
		String path = "C:\\temp\\upload";
		File file = new File(path+"\\"+fileName);
		
		//브라우저 캐시를 사용하지 않도록 설정
		response.setHeader("Cache-Control", "no-cache");
		//첨부파일 응답, 파일 이름 세팅
		response.addHeader("Content-disposition", "attachment; fileName="+fileName);
	
		// 파일읽기
		FileInputStream fis = new FileInputStream(file);
		// 메모리로 퍼 올릴 바가지 크기 설정
		byte[] buf = new byte[1024*1]; //보통은 8kb
		
		OutputStream os = response.getOutputStream();
		
		int count = -1;
		// 바가지 크기만큼 읽음
		// 읽을 내용 없으면 -1
		while((count = fis.read(buf)) != -1) {
			//브라우저로 전달
			// 0 : 건너뛴 byte 수
			// count : 보낼 byte 수
			os.write(buf, 0, count);
		}
		os.flush();
		os.close();
		fis.close();
	}

}
