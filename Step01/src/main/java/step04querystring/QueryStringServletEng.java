package step04querystring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test6")
public class QueryStringServletEng extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		// 서버로 전달받은 값을 얻고자 할 떄 사용하는 메서드 getParameter(html 태그의 name attribute 값)
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		
		System.out.println(id);
		System.out.println(password);
		System.out.println(hobby);
		System.out.println(gender);
		System.out.println(country);
		
		PrintWriter out = resp.getWriter();
		out.print("ID: " + id + "<br/>");
		out.print("비밀번호: " + password + "<br/>");
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		
		System.out.println(id);
		System.out.println(password);
		System.out.println(hobby);
		System.out.println(gender);
		System.out.println(country);
		
		PrintWriter out = resp.getWriter();
		out.print("ID: " + id + "<br/>");
		out.print("비밀번호: " + password + "<br/>");
		
		out.close();
	}
	
	
}
