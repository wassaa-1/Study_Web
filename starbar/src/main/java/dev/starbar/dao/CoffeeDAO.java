package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.starbar.model.Coffee;
import dev.starbar.utils.DBUtils;

public class CoffeeDAO {
	
	public List<Coffee> findAll() {
		final String selectQuery = "SELECT * FROM coffee";
		List<Coffee> Coffees = new ArrayList<>();

		try (
			Connection con = DBUtils.getConnection();
			PreparedStatement pstmt = con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();) {				
		
			while (rs.next()) {
				final int id = rs.getInt("id");
				final String name = rs.getString("name");
				final String size = rs.getString("size");
				final int price = rs.getInt("price");
				
				Coffees.add(new Coffee(id, name, size, price));
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}

		return Coffees;
	}

	public int save(Coffee coffee) {
		String insertQuery = "INSERT INTO coffee (name, size, price) VALUES (?, ?, ?)";
		int affectedRows = 0;
		
		try(Connection con = DBUtils.getConnection();
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			) {
			pstmt.setString(1, coffee.getName()); // 1번째 물음표에는 todoNumber를 맵핑
			pstmt.setString(2, coffee.getSize());
			pstmt.setInt(3, coffee.getPrice());
			affectedRows = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows;
	}
	
	public int update(Coffee coffee) {
		String updateQuery = "UPDATE coffee set name=?, size=?, price=? WHERE id=?";
		int affectedRows = 0;
		
		try(Connection con = DBUtils.getConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			) {
			pstmt.setString(1, coffee.getName()); // 1번째 물음표에는 todoNumber를 맵핑
			pstmt.setString(2, coffee.getSize());
			pstmt.setInt(3, coffee.getPrice());
			pstmt.setInt(4, coffee.getId());
			affectedRows = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows;
	}
	
	public int delete(int id) {
		String deleteQuery = "DELETE FROM coffee WHERE id=?";
		int affectedRows = 0;
		
		try(Connection con = DBUtils.getConnection();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			) {
			pstmt.setInt(1, id); // 1번째 물음표에는 todoNumber를 맵핑
			affectedRows = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows;
	}
	
}
