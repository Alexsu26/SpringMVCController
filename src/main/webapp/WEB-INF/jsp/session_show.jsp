<%@ page import="com.liyang.mvccontroller.entity.Role" %><%--
  Created by IntelliJ IDEA.
  User: liyang
  Date: 2024/6/5
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Show Session Attribute</title>
</head>
<body>
<%
    Role role = (Role) session.getAttribute("role");
    out.println("id = " + role.getId() + "<p/>");
    out.println("roleName = " + role.getName() + "<p/>");
    out.println("note = " + role.getNote() + "<p/>");
    Long id = (Long) session.getAttribute("id");
    out.println("id = " + id + "<p/>");
%>
</body>
</html>
