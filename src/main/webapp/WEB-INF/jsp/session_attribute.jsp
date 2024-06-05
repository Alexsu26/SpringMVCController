<%--
  Created by IntelliJ IDEA.
  User: liyang
  Date: 2024/6/5
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>session</title>
</head>
<body>
<%
    session.setAttribute("id", 1L);
    request.getRequestDispatcher("/mvccontroller/attribute/session/param")
            .forward(request, response);
    out.clear();
    out = pageContext.pushBody();
%>
</body>
</html>
