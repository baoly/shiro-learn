<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<div style="color: red;">${error}</div>
<form action="/formLogin" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input name="username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="password"></td>
        </tr>
        <tr>
            <td>记住我</td>
            <td><input type="checkbox" name="rememberMe"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
