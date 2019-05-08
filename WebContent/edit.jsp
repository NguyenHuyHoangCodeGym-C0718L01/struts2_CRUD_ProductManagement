<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit new product</title>
</head>
<body>
	<c:if test="${messages }!=null">
		<s:text name="messages"/>
	</c:if>
	<s:form action="proEditProduct.html" method="post">
		<%-- <label>Id</label>
		<s:text name="idProduct"></s:text> --%>
		<s:textfield label="Product id" name="idProduct" readonly="true"></s:textfield>
		<s:textfield label="Product name" name="nameProduct"></s:textfield>
		<s:textfield label="Product price" name="priceProduct"></s:textfield>
		<s:textarea cols="20" rows="5" name="descriptionProduct"></s:textarea>
		<s:submit value="Edit Product"></s:submit>
	</s:form>
</body>
</html>