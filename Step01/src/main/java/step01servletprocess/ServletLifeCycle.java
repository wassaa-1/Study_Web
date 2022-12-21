package step01servletprocess;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/test")
public class ServletLifeCycle extends HttpServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service() called");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() called");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() called");
	}

}
