package com.huyhoang.service;

/*import java.sql.ResultSet;*/
import java.sql.SQLException;
/*import java.util.ArrayList;*/
import java.util.List;

import com.huyhoang.model.Product;
import com.huyhoang.repository.*;
public class ProductService {

	private ProductRepository productRepository;
	
	public ProductService(){
		productRepository = new ProductRepository();
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public int saveProduct(Product product){
		try{
			return productRepository.registerProduct(product);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public int deleteProduct(int id){
		try{
			return productRepository.deleteProduct(id);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public int updateProduct(Product product){
		try{
			return productRepository.updateProduct(product);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public Product getProductById(int id) throws SQLException, Exception{
		return productRepository.getProductById(id);
	}
	
	public List<Product> getListProducts() throws SQLException, Exception{
		return productRepository.getAllProducts();
	}
}
