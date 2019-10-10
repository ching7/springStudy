<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>展示用户数据</title>
</head>
<body>
    <table border="1" align="center" width="50%">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Age</td>
        </tr>
        <#list list as user>
            <tr>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.userAge}</td>
            </tr>
        </#list>
    </table>
</body>
</html>