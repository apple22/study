<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.panel-footer{
    width: 100%;
    height: 150px;
    display: flex
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

 
<div class="container">
  <h2>Spring 01</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Celebrity information</div>
    <div class="panel-body"> <!-- 게시글 목록을 보여주는곳 -->
    <table class="table table-boardered table-hover">
<thead>
<td>Number</td>
<td>Name</td>
<td>Age</td>
<td>Height</td>
<td>Weight</td>
</thead>

<tbody>
<!-- BoardController 부터 담아서 -->
<c:forEach var="vo" items="${list}" varStatus="i">
 <tr>
    <td>${i.count}</td>
    <td>${vo.name}</td>
    <td>${vo.age}</td>
    <td>${vo.height}</td>
    <td>${vo.weight}</td>
  </tr>
</c:forEach>
</tbody>

</table></div>
   
    
    <div class="panel-footer">
    <img src="https://blog.kakaocdn.net/dn/bJ2ovS/btsHumGzZL6/vsndpCG8mIKye5pvZn6Gt0/img.gif">
    <img src="https://media.tenor.com/eN__9j9iwiIAAAAM/%ED%94%84%EB%A1%9C%EB%AF%B8%EC%8A%A4%EB%82%98%EC%9D%B8-%EC%86%A1%ED%95%98%EC%98%81.gif">
    <img src="https://media.tenor.com/usLBA8e-Jg0AAAAM/%ED%94%84%EB%AF%B8%EB%82%98-%EC%96%91%EA%B0%88%EB%9E%98.gif">
    <img src="https://blog.kakaocdn.net/dn/nwu6M/btrDV5vm0E8/hVokQPLkn5Y7pXsO1TYUg0/img.gif">
    <img src="https://blog.kakaocdn.net/dn/XphfH/btsyugBUfc8/MvW2oyRzhKgWU1MQGtM8D0/img.gif">
    </div>
  </div>
</div>
</body>
</html>