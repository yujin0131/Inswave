<%@page import="com.inswave.elfw.core.ElHeader"%>
<%@page import="com.project.inswave.emp.vo.*"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    /**
  * @Class Name : empList.jsp
  * @Description : 사원정보 List 화면
  * @Modification Information
  * 
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2013.06.01            최초 생성
  *
  * author 실행환경 개발팀
  * since 2013.06.01
  *  
  * Copyright (C) 2009 by BSJ  All right reserved.
  */
%>

<%
    com.inswave.elfw.core.ElHeader  elHeader = (com.inswave.elfw.core.ElHeader)request.getAttribute("elHeader");

	/* 업무정보 */
EmpVo empVo = (EmpVo)request.getAttribute("empVo");
if(empVo==null) empVo = new EmpVo();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>사원정보 List</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/ElDemo.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */
function fn_egov_select(empno) {
	document.listForm.empno.value = empno;
   	document.listForm.action = "<c:url value='/DmoEmpUpdView.do'/>";
   	document.listForm.submit();		
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.listForm.action = "<c:url value='/DmoEmpView.do'/>";
   	document.listForm.submit();		
}

/* 글 목록 화면 function */
function fn_egov_selectList() {
	document.listForm.pageIndex.value = "1";
	document.listForm.action = "<c:url value='/DmoEmpList.do'/>";
   	document.listForm.submit();
}

/* pagination 페이지 링크 function */
function fn_link_page(pageNo){
	document.listForm.pageIndex.value = pageNo;	
	document.listForm.action = "<c:url value='/DmoEmpList.do'/>";
   	document.listForm.submit();
}



function logout(path){
	location.href= path + 'CmmLoginFrm.do';
}

-->
</script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
<form  name="listForm" method="post">
<input type="hidden" name="empno" value="0"/>

<div id="content_pop">
	<!-- 타이틀 -->	
	<div id="title">					
		<table width="100%" border="0" cellpadding="0" cellspacing="0">		  
			<tr>
				<td class="title_l">
					<img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"> 사원 List
				</td>							
				<td class="title_r">
						<a href="javascript:logout('<c:url value='/'/>')">로그아웃</a>	    
				</td>
			</tr>
		</table>
	</div>	
	<!-- // 타이틀 -->
	<div id="search">
		<table class="search_table" width="100%" border="0" cellpadding="0" cellspacing="0">  
			<tr>
				<td class="search_l" width='485'>
					성명: <input type="text" name="scEname" class="txt" value="${empVo.scEname}" size='10'/>
					부서명: <input type="text" name="scDname" class="txt" value="${empVo.scDname}" size='10'/>
					부서 :

					<%=com.inswave.elfw.util.HtmlUtil.getComboList( 
							(com.inswave.elfw.util.vo.DefaultSelectListVo)request.getAttribute("deptList")
						  , "scDeptno"
						  , "class=\"use\""
						  , "-전체-"
						  , empVo.getScDeptno())%>	
				  
				</td>	
				<td class="search_m"  width='150'>
					페이지크기 : 
					<select  name="pageSize"> 							   
					    <option value="5"   <c:if test="${empVo.pageSize=='5'}">selected</c:if>>5</option>
						<option value="10"  <c:if test="${empVo.pageSize=='10'}">selected</c:if>>10</option>
						<option value="15"  <c:if test="${empVo.pageSize=='15'}">selected</c:if>>15</option>
						<option value="20"  <c:if test="${empVo.pageSize=='20'}">selected</c:if>>20</option>
						<option value="30"  <c:if test="${empVo.pageSize=='30'}">selected</c:if>>30</option>
						<option value="50"  <c:if test="${empVo.pageSize=='50'}">selected</c:if>>50</option>
						<option value="100" <c:if test="${empVo.pageSize=='100'}">selected</c:if>>100</option>				
					</select>					    
				</td>										
				<td class="search_r" width='45'>
				    <span class="btn_blue_l"><a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span>
				</td>
			</tr>
		</table>				 	
	</div>
	
	
	<!-- pageInfo -->
	<div id="pageInfo">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<colgroup>
				<col width="">				
				<col width="100px">			
			</colgroup>		  
			<tr>
				<td align="left" class="listtd">■ 총 ${empVo.totalCount} 건</td>			
												
				<td align="right" class="listtd">■ ${empVo.pageIndex} / ${empVo.totalPageCount}페이지</td>
			</tr>
		</table>
	</div>				
	
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="40">				
				<col width="100">
				<col width="150">
				<col width="80">
				<col width="">
				<col width="60">
			</colgroup>		  
			<tr>
				<th align="center">No</th>
				<th align="center">사번</th>
				<th align="center">성명</th>
				<th align="center">직업</th>
				<th align="center">입사일</th>
				<th align="center">부서</th>
			</tr>
			<c:forEach var="empVo" items="${empVoList.empVoList}" varStatus="status">
			<tr>
				<td align="center" class="listtd"><c:out value="${status.count}"/></td>
				<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${empVo.empno}"/>')"><c:out value="${empVo.empno}"/></a></td>
				<td align="left" class="listtd"><c:out value="${empVo.ename}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${empVo.job}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${empVo.hiredate}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${empVo.dname}"/>&nbsp;</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="paging">
	    <%=new com.project.inswave.cmmn.InswaveWebPageRenderer(new com.project.inswave.cmmn.InswavePageLabelInfo()).getPageRenderer(empVo) %>
		<input type='hidden' name="pageIndex" value="${empVo.pageIndex}" />
	</div>
	<div id="sysbtn1">
		<ul>
		<div id="sysbtn"><ul>
		<li><span class="btn_blue_l_<%=com.inswave.elfw.util.AdminAuth.getAdminAuth(elHeader.getAuth()) %>"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>
		</div>
		</ul>
	</div>
</div>



</form>
</body>
</html>
