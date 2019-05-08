<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new product</title>
</head>
<body>
<s:form action="proAddProduct.html" method="post">
	<s:textfield label="Product name" name="nameProduct"></s:textfield>
	<s:textfield label="Product price" name="priceProduct"></s:textfield>
	<s:textarea cols="20" rows="5" name="descriptionProduct"></s:textarea>
	<s:submit value="Add new Product"></s:submit>
</s:form>
</body>
</html>