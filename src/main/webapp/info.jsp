<%@ page import="com.example.sprinttwo.model.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>User Information</title>
  <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container mt-3">
  <div class="row">
    <h4 class="text-center">
      WELCOME TO YOUR PROFILE
    </h4>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <table>
        <%
          Users user = (Users) request.getAttribute("user");
          if(user!=null){
        %>
        <tr>
          <td>ID:</td>
          <td><%= user.getId() %></td>
        </tr>
        <tr>
          <td>Email:</td>
          <td><%= user.getEmail() %></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><%= user.getPassword() %></td>
        </tr>
        <tr>
          <td>Full Name:</td>
          <td><%= user.getFullName() %></td>
        </tr>
        <%
          }
        %>
      </table>
    </div>
  </div>
</div>
</body>
</html>
