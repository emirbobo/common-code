<%@ page import="java.util.List" %>
<%@ page import="com.emirbobo.web.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/1
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include><%
  List users = (List) request.getAttribute("users");
  if(users != null)
  {
    for(Object o : users)
    {
      User user = (User) o;
      %><br><%=user.getUname()%><%
    }
  }
%>

</body>
</html>
