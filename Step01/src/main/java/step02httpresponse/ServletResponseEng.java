package step02httpresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class ServletResponseEng extends HttpServlet {

	/**
	 * HttpServletRequest - 클라이언트가 보낸 요청 정보(Request Message, 요청 객체)를 담고 있는 객체
	 * HttpServletResponse - 서버가 클라이언트에게 응답 과정에서 포함시킬 응답 정보(Response Message)를 담고 있는 객체
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>Hello!</body>");
		out.print("</html>");
		
		// 자원 해제
		out.close();
	}
	
}
