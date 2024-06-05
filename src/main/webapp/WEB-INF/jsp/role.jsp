<%--
  Created by IntelliJ IDEA.
  User: liyang
  Date: 2024/6/5
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>参数</title>
    <script src="https://code.jquery.com/jquery-3.2.0.js">

    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            var data = {
                roleName : 'role',
                note : 'note',
                pageParams : {
                    start : 0,
                    limit : 20
                }
            }
            $.post({
                url : "./roles",
                contentType : "application/json",
                data : JSON.stringify(data),
                success : function (result) {

                }
            });
        });
    </script>
<%--    js脚本--%>

</head>
<body>
    <form action="./roles" id="form">
        <table>
            <tr>
                <td>角色名称</td>
                <td><input id="roleName" name="role_Name" value="" /></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input id="note" name="note" /></td>
            </tr>
            <tr>
                <td></td>
                <td align="right"><input type="submit" value="提交" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
