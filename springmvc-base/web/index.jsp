<%--
  Created by IntelliJ IDEA.
  User: hspcadmin
  Date: 2019/9/23
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="home/demo3" method="post">
      <input type="text" name="name1"><br>
      <input type="text" name="age"><br>
      <%--<input type="checkbox" name="hover" value="学习">
      <input type="checkbox" name="hover" value="代码">
      <input type="checkbox" name="hover" value="运动">
      <input type="checkbox" name="hover" value="电影">--%>
      <input type="text" name="people.age"><br>
      <input type="text" name="people.name"><br>
      <input type="submit" value="提交"><br>
  </form>
  <a href="home/download?fileName=js.js">跳转</a>
  </body>
  <hr>
  <form action="home/upload" method="post" enctype="multipart/form-data">
      <input type="file" name="uploadFile"><br>
      <input type="text" name="name"><br>
      <input type="submit" value="提交"><br>
  </form>
</html>
