package step02httpresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test4")
public class ServletResponseKor2 extends HttpServlet {
	
	/**
	 * HttpServletRequest - 클라이언트가 보낸 요청 정보(Request Message, 요청 객체)를 담고 있는 객체
	 * HttpServletResponse - 서버가 클라이언트에게 응답 과정에서 포함시킬 응답 정보(Response Message)를 담고 있는 객체
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 서버가 브라우저(클라이언트)에게 응답할 때 문서의 타입, 인코딩 타입을 명시해야 함
		
		// 서버가 클라이언트에 응답하는 데이터는 HTML 파일임을 명시
		response.setContentType("text/html");
		// 서버가 클라이언트에 응답하는 인코딩 타입 명시
		response.setCharacterEncoding("UTF-8");

		// 한 줄로 쓰려면 
//		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>안녕!</body>");
		out.print("</html>");
		
		// 자원 해제
		out.close();
	}

}
