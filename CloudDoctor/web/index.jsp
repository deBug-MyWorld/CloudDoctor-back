<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/1/16
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/PicsUpload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="file"  name="file"/>
    <input type="submit" value="upload">
  </form>
  </body>
</html>
