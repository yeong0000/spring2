<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Spring 2</title>
        <link 
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
        crossorigin="anonymous">
	</head>
	<body>
    <div class="container-fluid"> <!-- 핸드폰으로보거나 하면 화면 크기 조정 -->
		<header class="my-3 p-3 text-center text-bg-success">
            <h1>포스트 목록 페이지</h1>
        </header>
        
        
        
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <ul class="navbar-nav bg-light">
                <li class="nav-item">
                    <c:url var="mainPage" value="/" />
                    <a href="${mainPage}">메인 페이지</a>
                </li>
                <li class="nav-item">
                    <c:url var="postCreatePage" value="/post/create" />
                    <a href="${postCreatePage }">새 포스트 작성</a>
                </li>
            </ul>
        </nav>
        
        <main class="my-2">
            <div class="card"> <!-- 클래스를 카드라고 선언하고 테이블에 카드 바디 적어주면 카드형식으로 나옴 -->
                <table class="card-body table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">제목</th>
                            <th scope="col">작성자</th>
                            <th scope="col">작성시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${posts }" var="post"> <!-- 컨트롤러에서 모델에 posts 넣어서 -->
                            <tr>
                                <td>${post.id }</td>
                                
                                <td>
                                    <c:url var="postDetailPage" value="/post/detail">
                                        <c:param name="id" value="${post.id }" /> <!-- 몇번글로 갈거냐 -->
                                    </c:url>
                                    <a href="${postDetailPage }">${post.title }</a>
                                    <span class="text-danger">[${ post.rcnt }]</span>
                                </td>
                                <td>${post.author }</td>
                                <td> <!-- fmt 이용해서 시간을 내가 원하는 형태로 만들 수 있음  -->
                                    <fmt:formatDate value="${ post.created_time }" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
        <script 
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" 
        crossorigin="anonymous"></script>
	</div>
    </body>
</html>