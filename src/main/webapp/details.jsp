<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <div class="row">
        <h4 class="text-center">
            Login to <%=siteName%>
        </h4>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <form method="post" action="login">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
    </div>
    <% if (request.getAttribute("text") != null) { %>
    <div class="row mt-3">
        <div class="col-12">
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("text") %>
            </div>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
