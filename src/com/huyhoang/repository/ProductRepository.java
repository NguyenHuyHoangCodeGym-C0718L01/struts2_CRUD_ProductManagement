package com.huyhoang.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.huyhoang.DAO.*;
import com.huyhoang.model.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
public class ProductRepository {
	
	private Connection connection;
	
	public ProductRepository(){
		try {
			this.connection = DatabaseConnect.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Connection getConnection() {
		return connection;
	}



	public void setConnection(Connection connection) {
		this.connection = connection;
	}



	// method for save product data in database
	public int registerProduct(Product product) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO products VALUES (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getDescription());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	// method for fetch saved product data
	public List<Product> getAllProducts() throws SQLException, Exception {
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "SELECT * FROM struts.products";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
		return list;
	}
	
	public Product getProductById(int id) throws SQLException, Exception{
		ResultSet rs = null;
		Product product = null;
		try {
			String sql = "SELECT products.id, products.product_name, products.price, products.description FROM struts.products where products.id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public int deleteProduct(int id) throws SQLException{
		int i = 0;
		try {
			String sql = "Delete From struts.products where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public int updateProduct(Product product) throws Exception{
		int i = 0;
		try {
			String sql = "Update struts.products SET name=?, price=?, description=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setInt(2,  product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setInt(4,  product.getId());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
