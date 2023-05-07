<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.sprinttwo.model.News" %>
<%@ page import="com.example.sprinttwo.model.Comment" %>
<%@ page import="com.example.sprinttwo.db.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>MY NEWS</title>
  <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container mt-4 w-75">
    <%
        News news = (News) request.getAttribute("news");
        if (news != null && currentUser != null){
     %>

  <div class="row mt-3">
    <div class="col-12">
      <div class="row m-0">
        <div class="col-12 p-0">
          <div class="card mb-3 border border-3 border-warning text-warning" style="background-color: green">
            <div class="row g-0">
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title"><%=news.getTitle()%></h5>
                  <p class="card-text"><%=news.getContent()%></p>
                  <p class="card-text"><small class="text-body-secondary"><%=news.getPost_date()%></small></p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="row mt-3">
    <div class="col-3 mb-3">
      <% if(currentUser.getRole_id() == 1){ %>
      <button type="button" class="btn btn-warning mt-3" data-bs-toggle="modal" data-bs-target="#editTask">Edit</button>
      <button type="button" class="btn btn-danger mt-3 ms-3 me-3" data-bs-toggle="modal" data-bs-target="#removeTask">Delete </button>
      <% } %>
    </div>
  </div>

  <div class="row mt-2">
    <div class="col-6 mb-3">
      <form action="/add-comment" method="post">
        <input type="hidden" name="news_id" value="<%=news.getId()%>">
        <div class="row">
          <div class="col-12">
            <textarea class="form-control" name="comment" required></textarea>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <button class="btn btn-warning btn-sm">Add comment</button>
          </div>
        </div>
      </form>
    </div>
  </div>

  <div class="row mt-2">
    <div class="col-12">
      <div class="list-group">
          <%
                 ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                 if(comments!=null){
                    for(Comment c: comments){
                       User user = DBManager.getUserId(c.getUser_id());
              %>
        <div class="d-flex w-100 justify-content-between">
          <h5 class="mb-1"><%=user.getFullName()%></h5>
          <small class="text-body-secondary"><%=c.getPost_date()%></small>
        </div>
      </div>
    </div>
    <%
      }
    } else {
    %>
    <div class="alert alert-warning" role="alert">
      No blogs found.
    </div>
    <%
      }
      }
    %>
  </div>
</div>
</body>
</html>