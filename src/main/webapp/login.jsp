<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>Email: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>
                            <input type="email" class="form-control" name="email" required>
                        </label>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Password: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>
                            <input type="password" class="form-control" name="password" required>
                        </label>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn text-warning" style="background-color: green">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
