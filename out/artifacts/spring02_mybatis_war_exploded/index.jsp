<%--
  Created by IntelliJ IDEA.
  User: ching
  Date: 2019/8/13
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <c:forEach items="${list}" var="a">
          ${a.uid} ${a.uname} ${a.birth}
      </c:forEach>
  </body>
</html>
