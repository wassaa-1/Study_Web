package step06session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test9")
public class LoginLogoutServlet extends HttpServlet{

	// 로그인 처리
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if (id.isEmpty() || pw.isEmpty()) {
			out.print("아이디 및 비밀번호를 입력하세요");
			return;
		}
		
		HttpSession session = req.getSession();
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("로그인 완료");
		} else {
			out.print("현재 로그인 중입니다.");
		}
		out.close();
	}

	// 로그아웃 처리
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 완료");
		} else {
			out.print("로그인 상태가 아닙니다.");
		}
		out.close();
	}
	
	
	
}
