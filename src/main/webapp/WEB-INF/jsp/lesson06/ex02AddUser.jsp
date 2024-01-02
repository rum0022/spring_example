<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
			<div class="form-group">
				<label for="name">이름</label>
				
				<div class="d-flex">
					<input type="text" id="name" name="name" class="form-control col-6">
					<button type="button" id="nameCheckBtn" class="btn btn-info">중복확인</button>
				</div>	
				
				<small id="nameStatusArea"></small>
			</div>
			
			<button type="button" id="joinBtn" class="btn btn-success">회원가입</button>
	</div>
	
<script>
	$(document).ready(function() {
		//중복확인 버튼 클릭했을때
		$("#nameCheckBtn").on('click', function() {
			// nameStatusArea의 하위 태그들을 초기화
			$('#nameStatusArea').empty(); //자식태그들을 모두 비운다. (나는 포함아님)
			
			//alert("중복확인");
			let name = $("#name").val().trim();
			
			//validation
			// 이름이 비어있는지 확인
			if (!name) {// append 태그 추가
				$("#nameStatusArea").append('<span class="text-danger">이름이 비어있습니다.</span>');
				return;
			}
			
			// Ajax 통신 - 중복된 이름인지 DB에서 확인
			$.ajax({
				//request
				type:"GET" //생략가능
				, url:"/lesson06/ex02/is-duplication-name"
				, data:{"name":name}
			
				//response
				, success:function(data) {
					//json {"code":200, "is_duplication":true or false}
					if (data.is_duplication == true) {
						// 중복일 때
						$("#nameStatusArea").append('<span class="text-danger">중복된 이름입니다.</span>');
					}
				}
				, error:function(request, status, error) {
					alert("이름 중복확인에 실패했습니다.")
				}
			});
		});
		
		//회원가입 버튼 클릭
		$("#joinBtn").on('click', function() {
			//alert("회원가입");
			
			// nameStatusArea에 아무 자식태그가 없다면 가입진행
			console.log($('#nameStatusArea').children());
			if ($('#nameStatusArea').children().length < 1) {
				alert("회원가입진행");
			} else {
				alert("회원가입 불가");
			}
		});
	});
</script>			
</body>
</html>