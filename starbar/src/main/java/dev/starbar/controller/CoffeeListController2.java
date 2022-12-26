package dev.starbar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/coffee2")
public class CoffeeListController2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoffeeService service = new CoffeeService();
		List<Coffee> coffees = 	service.findAll();
		// 여러 개의 커피 데이터를 html 페이지로 전달
		final String url = "updateCoffeePage.jsp";
		
		//1. jsp 페이지로 전달 - jsp 가 변환 과정을 거쳐서 html 페이지로 만듬
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		
		// list 라는 이름의 key 값에 coffees 리스트 데이터를 value로 할당
		req.setAttribute("list", coffees);
		
		dispatcher.forward(req, resp);
		
	}
	
}
