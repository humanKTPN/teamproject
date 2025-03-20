

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardcon")
public class BoardContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// BoardDAO 리턴타입으로 BoardDAO 클래스를 불러와서 boardDAO라는 변수에 저장할 데이터를 넣는 메소드를 생성한다.
		BoardDAO boardDAO = new BoardDAO();
		
		//
		// selectBoardList 메소드를 생성하여 리스트 타입으로 resultList 변수에 저장한다.
		List resultList = boardDAO.selectBoardList(); 
		//
		
		// 요청한 결과값을 resultList에 담아서 별칭으로 저장.
		request.setAttribute("resultList", resultList); 
		
		// 요청한 결과값을 freeboard_nam.jsp라는 주소로 데이터를 전송하여 연결되게 한다.
		request.getRequestDispatcher("/FreeBoard_Nam.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String tflist = request.getParameter("fblist");
		System.out.println("tflist : " + tflist);
		
		BoardDTO boardDTO = new BoardDTO();
		
		// 이건 지금 볼 수가 없다.(추가 코딩)
		boardDTO.setBRD_NO(0);
		boardDTO.setTTL_NM("");
		boardDTO.setBRD_DESC(tflist);
		boardDTO.setVW_CNT(0);
		boardDTO.setREG_DTTM(null);
		
		System.out.println(boardDTO);
		
	}

}
