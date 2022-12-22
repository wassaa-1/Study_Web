package step07pagemove;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/othersite")
public class MyRedirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String siteName = req.getParameter("site");
		
		if (siteName.equals("naver")) {
			resp.sendRedirect("http://www.naver.com");
		} else {
			resp.sendRedirect("http://www.google.com");
		}
	}

}