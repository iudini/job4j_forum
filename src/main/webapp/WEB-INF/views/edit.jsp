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

    <title>
        <c:if test="${post.name==null}">New post</c:if>
        <c:if test="${post.name!=null}">${post.name}</c:if>
    </title>
</head>
<body>
<div class="container mt-3">
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h4 class="my-0 mr-md-auto font-weight-normal">Форум job4j</h4>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="<c:url value="/"/>">Home</a>
            <a class="p-2 text-dark" href="<c:url value='/create'/>">New post</a>
            <a class="p-2 text-dark" href="<c:url value='/logout'/>">Logout</a>
        </nav>
    </div>

    <div>
        <form action="<c:if test="${post.id==null}"><c:url value='/create'/></c:if>
        <c:if test="${post.id!=null}"><c:url value='/edit'/></c:if>" method="post">
            <input hidden name="id" value="${post.id}">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" value="${post.name}">
            <label for="description">Description</label>
            <input type="text" id="description" name="description" value="${post.description}">
            <input name="submit" type="submit" value="Save"/>
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