<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.sprinttwo.model.Items" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <div class="row">
        <h4 class="text-center">
            Welcome to <%=siteName%>
        </h4>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <button type="button" class="btn btn-primary" onclick="location.href='details.jsp'">Sign Up</button>

            <div class="modal fade" id="addTask" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>DESCRIPTION</th>
                    <th>PRICE</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("items");
                    if(items !=null){
                        for(Items it : items){
                %>
                <tr>
                    <td><%=it.getId()%></td>
                    <td><%=it.getName()%></td>
                    <td><%=it.getDescription()%></td>
                    <td><%=it.getPrice()%></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>