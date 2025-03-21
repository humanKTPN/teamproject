

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gcookie2")
public class GetCookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		
		// 쿠키가 하나도 없으면 null
		Cookie[] cookies = request.getCookies();
		
		boolean isShow = true;
		
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				String name = c.getName();
				String value = c.getValue();
				System.out.println("name: "+ name +", value: "+ value);
				
				if("account1".equals(name)) { // key값 불러오기
					String str = URLDecoder.decode(value, "utf-8");
					System.out.println("str : "+ str);
				} else if("account2".equals(name)) { // key값 불러오기
					String str = URLDecoder.decode(value, "utf-8");
					System.out.println("str : "+ str);
				}
				
				if("oac1".equals(name) && "true".equals(value)) {
					isShow = false; // 메뉴 접었다폈다 기능.
					RequestDispatcher dispatcher = request.getRequestDispatcher("dashBoard_kwak.jsp");
					dispatcher.forward(request, response);
					System.out.println(isShow);
				} else if("oac2".equals(name) && "false".equals(value)) {
					isShow = true; // 메뉴 접었다폈다 기능.
					RequestDispatcher dispatcher = request.getRequestDispatcher("dashBoard_kwak.jsp");
					dispatcher.forward(request, response);
					System.out.println(isShow);
				}
			}
		} else {
			System.out.println("쿠키가 없습니다");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
