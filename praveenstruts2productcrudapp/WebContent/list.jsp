<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table{
                border-collapse: collapse;

            }
            th, td{padding: 10px;}
            tfoot{text-align: center;}
        </style>
    </head>
    <body>
        <p align="center">
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
        </p>
        <h1 align="center">Product List</h1>
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Pname</th>
                    <th>Price</th>
                    <th>Qty</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="productList">
                    <tr>
                        <td><s:property value="pid"/></td>
                        <td><s:property value="pname"/></td>
                        <td><s:property value="price"/></td>
                        <td><s:property value="qty"/></td>
                        <td>
                            <a href="editProduct.action?pid=<s:property value="pid"/>">Edit</a>
                        </td>
                        <td>
                            <a onclick="return confirm('Are you sure to delete this item')" href="deleteProduct.action?pid=<s:property value="pid"/>">Delete</a>
                        </td>

                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
