<%@ page import="com.example.sprinttwo.model.User" %><%
    User currentUser = (User) session.getAttribute("currentUser");
%>
<html>
<head>
    <title>MY</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script type="text/javascript" src="js/bootstrap.bundle.js"></script>
</head>
<body>
    <div class="container p-0">
        <nav class="navbar navbar-expand-lg bg-body-tertiary border border-info border-warning border-2 rounded" style="background-color: green">
        <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarSupportedContent" style="display: flex; justify-content: space-between;">
                    <div>
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <%if (currentUser!=null){%>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-warning" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <%=currentUser.getFullName()%>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item text-warning" href="/user">Profile</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item text-warning" href="/logout">Logout</a></li>
                                </ul>
                            </li>
                    <%} else {%>
                            <li class="nav-item">
                                <a class="nav-link text-warning" aria-current="page" href="/register">Register</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-warning" aria-current="page" href="/login">Login</a>
                            </li>
                    <%}%>
                        </ul>
                    </div>

                </div>
            </div>
        </nav>
    </div>
</body>
</html>
