package step07pagemove;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class MouseInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String address = req.getParameter("address");

		Mouse mouse = new Mouse(name, country, address);
		req.setAttribute("mouse", mouse);
		
		RequestDispatcher rd = req.getRequestDispatcher("result");
		rd.forward(req, resp);

		out.close();
	}

}

class Mouse {
	private String name;
	private String country;
	private String address;

	public Mouse(String name, String country, String address) {
		super();
		this.name = name;
		this.country = country;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Mouse [name=" + name + ", country=" + country + ", address=" + address + "]";
	}

}
