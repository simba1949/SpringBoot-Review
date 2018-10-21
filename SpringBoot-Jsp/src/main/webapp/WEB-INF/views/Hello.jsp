<%--
  Created by IntelliJ IDEA.
  User: SIMBA
  Date: 2018/10/21
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome To JSP</title>
</head>
<body>

<h1>JSP 标题</h1>
<h1>JSP 取值：<%=request.getSession().getAttribute("say") %></h1>

</body>
</html>
