<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<s:url action="product/addProduct.html" var="addProduct" />
	<s:a href="%{addProduct}">Add new Product</s:a>
	<br>
	<br>
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Product name</th>
			<th>Product price</th>
			<th>Product description</th>
			<th>Option</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.name }</td>
				<td>${list.price }</td>
				<td>${list.description }</td>
				<td><s:url id="deleteProd" action="product/deleteProduct">
						<s:param name="idProduct">${list.id }</s:param>
					</s:url> <s:a href="%{deleteProd}"
						onclick="return confirm('Are you sure?')">Delete</s:a> | <s:url id="editProd" action="product/editProduct">
						<s:param name="idProduct">${list.id }</s:param>
					</s:url> <s:a href="%{editProd}">Edit</s:a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>