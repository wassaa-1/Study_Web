package dev.starbar.service;

import java.util.List;

import dev.starbar.dao.CoffeeDAO;
import dev.starbar.model.Coffee;

/**
 * 
 * Coffee 에 대한 비즈니스 로직을 처리하는 부분
 */
public class CoffeeService {
	private CoffeeDAO coffeeDAO = new CoffeeDAO();
	
	public List<Coffee> findAll() {
		return coffeeDAO.findAll();
	}
	
	public int save(Coffee coffee) {
		return coffeeDAO.save(coffee);
	}
	
	public int update(Coffee coffee) {
		return coffeeDAO.update(coffee);
	}
	
	public int delete(int id) {
		return coffeeDAO.delete(id);
	}
}
