package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/coffee2/delete")
public class CoffeeDeleteController extends HttpServlet{
	CoffeeService service = new CoffeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 메뉴 삭제
		int id = Integer.parseInt(req.getParameter("coffeeId"));
		
		service.delete(id);
		
		resp.sendRedirect("../index.jsp");
	}

}
