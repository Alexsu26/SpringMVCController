<%--
  Created by IntelliJ IDEA.
  User: liyang
  Date: 2024/6/5
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>validation</title>
</head>
<body>
    <form id="form" method="post" action="./annotation">
        <table>
            <tr>
                <td>产品编号：</td>
                <td><input name="productId" id="productId" /></td>
            </tr>
            <tr>
                <td>用户编号：</td>
                <td><input name="userId" /></td>
            </tr>
            <tr>
                <td>交易日期：</td>
                <td><input name="data" /></td>
            </tr>
            <tr>
                <td>价格：</td>
                <td><input name="price" /></td>
            </tr>
            <tr>
                <td>数量：</td>
                <td><input name="quantity" /></td>
            </tr>
            <tr>
                <td>交易金额：</td>
                <td><input name="amount" /></td>
            </tr>
            <tr>
                <td>用户邮件：</td>
                <td><input name="email" /></td>
            </tr>
            <tr>
                <td>备注：</td>
                <td><textarea rows="5" cols="20" id = "note">
                </textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="提交" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
