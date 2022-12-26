package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/coffees/add")
public class CoffeeAddController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("coffeeName");
		String size = req.getParameter("coffeeSize");
		int price = Integer.parseInt(req.getParameter("coffeePrice"));
		Coffee coffee = new Coffee(name, size, price);
		
		CoffeeService service = new CoffeeService();
		service.save(coffee);
		
		resp.sendRedirect("../index.jsp");
		
	}
	
}
