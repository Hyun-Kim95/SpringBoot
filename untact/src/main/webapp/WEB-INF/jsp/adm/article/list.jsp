<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../part/mainLayoutHead.jspf"%>
<script>
const boardId = ${board.id};
</script>
<section class="section-1">
	<div class="bg-white shadow-md rounded container mx-auto p-8 mt-8">
		<div class="flex items-center">
			<select class="py-2 select-board-id">
				<option value="1">공지사항</option>
				<option value="2" selected="selected">자유게시판</option>
			</select>
			<script>
			$('.section-1 .select-board-id').val(boardId);
			$('.section-1 .select-board-id').change(function(){
				location.href = '?boardId=' + this.value;
			})
			</script>
			
			<div class="flex-grow"></div>
			
			<a href="add?boardId=${board.id}" class="btn-primary bg-blue-500 hover:bg-blue-dark text-white font-bold py-2 px-4 rounded">글쓰기</a>
		</div>
		
		<div>
			<c:forEach items="${articles}" var="article">
				<div class="flex items-center mt-10">
					<span class="font-bold">NO. ${article.id}</span>
					<span class="ml-2 font-light text-gray-600"> ${article.regDate}</span>
					<div class="flex-grow"></div>
						<a href="list?boardId=${article.boardId}"class="px-2 py-1 bg-gray-600 text-gray-100 font-bold rounded hover:bg-gray-500">${article.extra__boardName}</a>
				</div>
				<div class="mt-2">
					<a href="detail?id=${article.id}" class="text-2xl text-gray-700 font-bold hover:underline">${article.title}</a>
					<p class="mt-2 text-gray-600">${article.body}</p>
					<div>
						<c:if test="${article.extra__thumbImg != null}">
							<img src="${article.extra__thumbImg}" alt="" />
						</c:if>
					</div>
				</div>
				<div class="flex justify-between items-center mt-4">
					<a href="detail?id=${article.id}"class="text-blue-500 hover:underline">자세히 보기</a>
					<a href="modify?id=${article.id}"class="ml-2 text-blue-500 hover:underline">수정</a>
					<a onclick="if(!confirm('삭제하시겠습니까?')) return false;" href="doDelete?id=${article.id}"class="ml-2 text-blue-500 hover:underline">삭제</a>
					<div class="flex-grow"></div>
					<div>
						<a href="detail?id=${article.id}" class="flex items-center">
						<img src="https://images.unsplash.com/photo-1492562080023-ab3db95bfbce?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=731&amp;q=80" alt="avatar" class="mx-4 w-10 h-10 object-cover rounded-full">
						<h1 class="text-gray-700 font-bold hover:underline">${article.extra__writer}</h1>
					  	</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

<%@ include file="../part/mainLayoutFoot.jspf"%>