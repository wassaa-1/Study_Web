package step03httprequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test5")
public class MyServletRequest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 문서 타입, 인코딩
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("Server port: " + req.getServerPort() + "<br/>");
		out.print("Request URI: " + req.getRequestURI() + "<br/>");
		out.print("Request URL: " + req.getRequestURL() + "<br/>");
		out.print("Context Path: " + req.getContextPath() + "<br/>");
		out.print("Request Method: " + req.getMethod() + "<br/>");
		out.print("Query String: " + req.getQueryString() + "<br/>");
		out.close();
	}
	
}
