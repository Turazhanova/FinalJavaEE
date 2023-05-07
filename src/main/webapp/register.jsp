<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container mt-3">
        <div class="row">
            <div class="col-6 mx-auto">
                <form action="/register" method="post">
                    <div class="row">
                        <div class="col-12">
                            <label>EMAIL: </label>
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
                            <label>PASSWORD: </label>
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
                            <label>FULL NAME: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <label>
                                <input type="text" class="form-control" name="full_name" required>
                            </label>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button style="background-color: green" class="btn text-warning">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
