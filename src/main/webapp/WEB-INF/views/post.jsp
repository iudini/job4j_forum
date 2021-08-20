<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>${post.name}</title>
</head>
<body>
<div class="container mt-3">
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h4 class="my-0 mr-md-auto font-weight-normal">Форум job4j</h4>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="<c:url value="/"/>">Home</a>
            <a class="p-2 text-dark" href="<c:url value='/create'/>">New post</a>
            <a class="p-2 text-dark" href="<c:url value='/login'/>">Login</a>
        </nav>
    </div>

    <div class="col-md-8 blog-main">
        <div class="blog-post">
            <h2 class="blog-post-title">${post.name}</h2>
            <p class="blog-post-meta">${post.created.getTime()}</p>
            <p>${post.desc}</p>
        </div>
    </div>

    <div class="col-md-8 blog-main">
        <div class="blog-post">
            <h2 class="blog-post-title">Комментарии</h2>
            <c:forEach items="${comments}" var="comment">
                <div style="background-color:beige;">
                    <p class="blog-post-meta" style="background-color:#f5ffdf;">${comment.created.getTime()} by ${comment.author}</p>
                    <p>${comment.desc}</p>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <form action="<c:url value='/add_comment?id=${post.id}'/>" method="post">
            <input type="text" class="form-control" placeholder="Your name" name="author">
            <textarea class="form-control" name="desc"></textarea>
            <input name="submit" type="submit" value="submit"/>
        </form>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>