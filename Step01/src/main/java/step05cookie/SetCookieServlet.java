package step05cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test7")
public class SetCookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		// id값을 저장할 쿠키 생성
		Cookie idCookie = new Cookie("id", "guest");
		resp.addCookie(idCookie);
		
		Cookie basketCookie = new Cookie("basket", "buyThings");
		resp.addCookie(basketCookie);
		
		// 쿠키의 유지 시간 지정
		idCookie.setMaxAge(60*60*3);
		
		PrintWriter out = resp.getWriter();
		out.print("서버에서 생성한 쿠키가 클라이언트로 전송되었음");
		out.close();
	}
	
}
