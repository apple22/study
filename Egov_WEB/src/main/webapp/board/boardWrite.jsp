<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 등록</title>
</head>
<style>
table {
	width: 600px;
	board-collapse: collapse;
}

body {
	font-size: 9pt;
}

button {
	font-size: 9pt;
}

th, td {
	border: 1px solid #cccccc;
	padding: 3px;
}

input1 {
	width: 98%;
}

.textarea {
	width: 98%;
	height: 70%;
}
</style>
<!-- <script>
function fn_submit(){
	if( document.frm.title.value == "" ){
		alert("제목을 입력해주세요");
		document.frm.title.focus();
		return false;
		
	}
	
	if( document.frm.pass.value == "" ){
		alert("암호를 입력해주세요");
		document.frm.pass.focus();
		return false;
		
	}
	
	document.frm.submit(); // 동기 전송 방식
	
		
}

</script> -->
<body>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#title").val("제목입력");
		});

		function fn_submit() {
			if ($.trim($("#title").val()) == "") {
				alert("제목을 입력해 주세요");
				$("#title").focus();
				return false;
			}

			$("#title").val($.trim($("#title").val()));

			if ($.trim($("#pass").val()) == "") {
				alert("암호를 입력해 주세요");
				$("#pass").focus();
				return false;
			}

			$("#pass").val($.trim($("#pass").val()));

			var formData = $("#frm").serialize();
			//비동기 전송 방식의 기능을 가지고 있는 Jquery의 함수

			$.ajax({
				type : "POST",
				data : formdata,
				url : "boardWriteSave.do",
				dataType : "text", // 리턴 타입
				success : function(data) { // controller -> "OK"
					if (data == "ok") {
						alert("저장 완료");
						location = "boardList.do";
					}
				},
				error : function() {
					alert("저장 실패");
				}
			});

		}
	</script>


	<form id="frm">
		<table>
			<caption>게시판 등록</caption>
			<tr>
				<th width="20%"><label for="title">제목</label></th>
				<td width="80%"><input type="text" name="title" id="title"
					class="input1"></td>
			</tr>
			<tr>
				<th><label for="pass">암호</label></th>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<th><label for="name">글쓴이</label></th>
				<td><input type="password" name="name" id="name"></td>
			</tr>
			<tr>
				<th><label for="content">내용</label></th>
				<td><textarea name="content" id="content"></textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit" onclick="fn_submit(); return false;">저장</button>
					<button type="reset">취소</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>