<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/InswaveApp/css/comm/header.css"/>
<link type="text/css" rel="stylesheet" href="/InswaveApp/css/techBlog/news.css"/>
</head>

<body>
	<header>
		<div class="header_main">
			<div class="header_left">
				<a href="/InswaveApp/html/techBlog/main.html" class="header_title">
					<img src="/InswaveApp/images/techBlog/InswaveLogoText.png" class="header_logo_img"></img>
					<div class="header_logo_text">기술블로그</div>
				</a>
			</div>
			<div class="header_right">
				<div class="header_link"> 
					<a href="https://inswave.com/confluence/spacedirectory/view.action" class="header_link_confluence">Confluence</a>
					<a href="https://inswave.com/jira/secure/Dashboard.jspa" class="header_link_jira">Jira</a>
					<a href="/InswaveApp/api/news.do" class="header_link_News">News</a>
					<div class="header_InsFam">
						<a class="header_link_InsFam">InsFam</a>
						<div class="div_InsFam" id="div_InsFam">
							<div class=InsFam_IO onclick="location.href='../user/signIn.html'">로그인</div>
							<div class=InsFam_write onclick="InsFam_Write();">글쓰기</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<article>
		<div class="news_header">
			<h1>
				<span class="news_text">Recent News</span>
				<em>${length}</em>
			</h1>
		</div>
		<div class="news_body">
			<ul class="news_list">
				<c:forEach items="${items}" var="item">

					<li class="news_list_item">
						<a class="news_item_link" href="<c:out value="${item.link}"/>">
							<div class="news_item_info">
								<p class="title"><c:out value="${item.title}" escapeXml="false"/></p>
								<p class="summary">
								<c:out value="${item.description}" escapeXml="false"/>
								</p>
							</div>
							<div class="news_date">
								<div class="news_item_date_area">
									<div class="news_item_pastDate">
			                            {{item[4]}}
			                        </div>
			                        <div class="news_item_date">
			                           	<c:out value="${item.pubDate}" escapeXml="false"/>
			                        </div>
								</div>
							</div>
						</a>
					</li>	
				
				</c:forEach>
			</ul>
		</div>
		<div class="news_pagination">
			<a class="prev">이전</a>
			<a class="page" href="#">
				<span class="selected">1</span>
			</a>
			<a class="next">다음</a>
		</div>
		
		
	
	</article>
	
	
</body>
</html>