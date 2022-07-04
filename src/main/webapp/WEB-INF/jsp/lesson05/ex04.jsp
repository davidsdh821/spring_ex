<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>

	<c:set var="str1" value="No pain. No gain."/>
	
	<h1>1. 길이 구하기</h1>
	${fn:length(str1)} <br>
	
	<h1>2. 특정 문자열이 있는지 확인</h1>
	No가 존재하는가 ${fn:contains(str1, 'No')}<br>
	no가 존재하는가	${fn:contains(str1, 'no')}<br>
	
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}">
		문장에 no라는 문자열이 존재함(대소문자 구별 안함)<br>
	
	</c:if>
	
	<h1>3. 특정 문자열로 시작하는지 확인</h1>
	No로 시작하는가? ${fn:startsWith(str1, 'No')}
	
	<h1>4. 특정 문자열로 끝나는지 확인</h1>
	n으로 끝나는가? ${fn:endsWith(str1, 'n')}<br>
	.으로 끝나는가?(점은 재대로 검사가 안된다) ${fn:endsWith(str1, '.')}<br> <%--점으로 확인 하는것은 하지말자, 작동이 안된다. 이럴때는 단어 째로 검사를 해야한다, 철자가 아닌 단어째로!!--%>
	단어쩨로 검사 ${fn:endsWith(str1, 'gain.')}<br>

	<h1>5. 문자열 치환</h1>
	<c:set var="str2" value="I Love chiken"></c:set>
	${str2} <br>
	${fn:replace(str2, 'chiken', 'bread')}
	
	
	<h1>6. 구분자로 문자열 잘라 배열만들기</h1>
	${fn:split(str1, '.')[0]}<br>
	${fn:split(str1, '.')[1]}<br>
	
	<h1>7. 시작 인덱스부터 종료 인덱스까지 자르기</h1>
	<%-- str2변수 사용, love 추출 --%>	
	<%-- I love chiken. 2, 6 --%>
	${fn:substring(str2, 2, 6)}<br>
	
	<h1>8. 모두 소문자로 변경</h1>
	${fn:toLowerCase(str2)}<br>
	
	<h1>9. 모두 대문자로 변경</h1>
	${fn:toUpperCase(str2)}<br>
	
	
	<h1>10. 앞 뒤 공백 제거(trim)</h1>
	<c:set var="str3" value="			hello		"></c:set>
	<pre> str3:  ${str3}</pre><br>
	<pre>str3: ${fn:trim(str3)}</pre><br>
	
	
	
	
	
</body>
</html>