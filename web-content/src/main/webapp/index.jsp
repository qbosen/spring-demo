<%--
  Created by IntelliJ IDEA.
  User: qiubaisen
  Date: 2018/9/16
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户添加</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/AddCustomerServlet" method="post">
    <table align="center" border="1">
        <tr>
            <td>客户名称：</td>
            <td><input type="text" name="name"/></td>
            <td>负责人名称：</td>
            <td><input type="text" name="principalName"/></td>
        </tr>

        <tr>
            <td colspan="4"><input type="submit" value="添加"/></td>
        </tr>
    </table>
</form>
</body>
</html>
