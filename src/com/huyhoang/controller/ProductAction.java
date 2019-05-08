package com.huyhoang.controller;
import java.sql.SQLException;
import java.util.ArrayList;
/*import java.util.HashMap;*/
import java.util.List;
/*import java.util.Map;*/



import com.huyhoang.service.*;
import com.huyhoang.model.*;
/*import com.opensymphony.xwork2.ActionContext;*/
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1402346129148799033L;
	
	private ProductService productService = new ProductService();
	private int idProduct;
	private String nameProduct;
	private int priceProduct;
	private String descriptionProduct;
	private List<Product> list = new ArrayList<Product>();
	private String messages;
	
	
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getDescriptionProduct() {
		return descriptionProduct;
	}
	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	//post product to save
	public String proAddProduct(){
		Product product = new Product(0, getNameProduct(), getPriceProduct(), getDescriptionProduct());
		int result = productService.saveProduct(product);
		if(result <= 0){
			return "failure";
		}else{
			return "success";
		}
	}
	
	//get add product page
	public String addProduct(){
		return "success";
	}
	
	public String execute(){
		List<Product> listProducts = new ArrayList<Product>();
		try {
			listProducts = productService.getListProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setList(listProducts);
		/*ValueStack stack = ActionContext.getContext().getValueStack();
	    Map<String, Object> context = new HashMap<String, Object>();
	    context.put("list", list);
	    stack.push(context);*/
		return "success";
	}
	
	public String deleteProduct(){
		int result = productService.deleteProduct(idProduct);
		if(result <= 0){
			return "failure";
		}else{
			return "success";
		}
	}
	
	public String editProduct(){
		Product product = new Product();
		try {
			product = productService.getProductById(idProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIdProduct(product.getId());
		setNameProduct(product.getName());
		setPriceProduct(product.getPrice());
		setDescriptionProduct(product.getDescription());
		/*setIdProduct(8);
		setNameProduct("balo laptop Razer");
		setPriceProduct(1500000);
		setDescriptionProduct("Balo chong nuoc, chong dan");*/
	   /* Map<String, Object> context = new HashMap<String, Object>();
	    context.put("idProd", getIdProduct());
	    ActionContext.getContext().getValueStack().push(context);*/
		/*if(product!=null){
			return "success";
		}else{
			return "failure";
		}*/
		return"success";
	}
	
	public String proEditProduct(){
		/*Map<String, Object> context = new HashMap<String, Object>();
		context = ActionContext.getContext().getValueStack().getContext();
		int idProd = (Integer) context.get("idProd");*/
		Product product = new Product(getIdProduct(), getNameProduct(), getPriceProduct(), getDescriptionProduct());
		int result = productService.updateProduct(product);
		if(result <= 0){
			return "failure";
		}else{
			setMessages("Update successfully!");
			return "success";
		}
	}
}
