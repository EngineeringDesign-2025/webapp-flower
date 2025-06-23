<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>アイテム画像一覧</title>
    <style>
        .image-container {
            display: flex;
            gap: 20px; /* 画像の間にすき間を空ける */
            justify-content: center;
            margin-top: 40px;
        }
        .image-container a img {
            width: 150px;
            height: 150px;
            border: 2px solid #ccc;
            border-radius: 10px;
            transition: 0.3s;
        }
        .image-container a img:hover {
            transform: scale(1.05);
            border-color: #888;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">アイテム一覧</h2>

    <div class="image-container">
        <c:forEach items="${planterList}" var="item">
            <a href="detail.jsp?id=${planter.id}">
                <img src="${pageContext.request.contextPath}/${planter.imagePath}" alt="${palnter.name}">
            </a>
        </c:forEach>
    </div>
</body>
</html>