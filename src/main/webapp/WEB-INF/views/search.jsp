<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Controller의 list명은 items의 값 -->
<div>
	<h4 style="text-align : center;">검색 결과</h4>
<hr>
<div>
	<h5>▶ 한국사(${historyList.size()})</h5>
	<br>
	<div>
		<c:forEach var="item" items="${historyList}">
			<a href="/history/detail/${item.id}" class="list-group-item list-group-item-action">
			<table>
				<tbody>
					<tr>
						<td>${item.title} - ${item.writer}</td>
						<td style="text-align:right;"><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
						<%-- <td>${item.contents}</td> --%>
					</tr>
				</tbody>
			</table>
			</a>
		</c:forEach>
	</div>
</div>
<hr>
<hr>
<div>
	<h5>▶ 공지사항(${noticeList.size()})</h5>
	<br>
	<c:forEach var="item" items="${noticeList}">
		<a href="/notice/detail/${item.id}" class="list-group-item list-group-item-action"> 
		<table>
			<tbody>
				<tr>
					<td>${item.title} - ${item.writer}</td>
					<td style="text-align:right;"><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
					<%-- <td>${item.contents}</td> --%>
				</tr>
			</tbody>
		</table>
		</a>
	</c:forEach>
</div>
<hr>
<hr>
<div>
	<h5>▶ 자주하는질문(${oftenList.size()})</h5>
	<br>
	<c:forEach var="item" items="${oftenList}">
		<a href="/oftenqa/detail/${item.id}" class="list-group-item list-group-item-action">
		<table>
			<tbody>
				<tr>
					<td> ${item.title} - ${item.writer}</td>
					<td style="text-align:right;"><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
					<%-- <td>${item.contents}</td> --%>
				</tr>
			</tbody>
		</table>
		</a>
	</c:forEach>
</div>
<hr>
<hr>
<div>
	<h5>▶ Q&A(${qaList.size()})</h5>
	<br>
	<c:forEach var="item" items="${qaList}">
		<a href="/qa/detail/${item.id}" class="list-group-item list-group-item-action">
		<table>
			<tbody>
				<tr>
					<td> ${item.title} - ${item.writer}</td>
					<td style="text-align:right;"><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
					<%-- <td>${item.contents}</td> --%>
				</tr>
			</tbody>
		</table>
		</a>
	</c:forEach>
</div>
<hr>
</div>


