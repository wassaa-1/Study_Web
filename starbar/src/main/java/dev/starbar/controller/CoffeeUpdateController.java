package dev.starbar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/coffee2/update")
public class CoffeeUpdateController extends HttpServlet {
	CoffeeService service = new CoffeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 커피 정보 변경
		int id = Integer.parseInt(req.getParameter("coffeeId"));
		String name = req.getParameter("coffeeName");
		String size = req.getParameter("coffeeSize");
		int price = Integer.parseInt(req.getParameter("coffeePrice"));
		
		Coffee coffee = new Coffee(id, name, size, price);
		
		service.update(coffee);
		
		resp.sendRedirect("../index.jsp");
		
	}

}
