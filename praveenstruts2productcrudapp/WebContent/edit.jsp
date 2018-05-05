<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="successMsg != null">
            <font color="green">
            <s:property value="successMsg"/>
            </font>
        </s:if>
        <s:if test="errorMsg != null">
            <font color="red">
            <s:property value="errorMsg"/>
            </font>
        </s:if>
        <h1>Edit Product</h1>
        <s:form action="updateProduct" method="post">
            <s:textfield name="product.pid" label="Product Id" readonly="true"/>
            <s:textfield name="product.pname" label="Product Name"/>
            <s:textfield name="product.price" label="Product Price"/>
            <s:textfield name="product.qty" label="Product Quantity"/>
            <s:submit value="Update"></s:submit>
        </s:form>
        
        <a href="listPage.action">Go To List Page</a>
    </body>
</html>
