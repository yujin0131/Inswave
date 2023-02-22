<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.inswave.elfw.util.*"%>
<%@page import="com.project.inswave.emp.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
    java.util.Enumeration eAttr = request.getAttributeNames();
while (eAttr.hasMoreElements()) {
    String aName = (String)eAttr.nextElement();
    Object obj = request.getAttribute(aName);    
    //out.println(aName + " : " + obj.toString() + "<br>");    
}

/**
* @Class Name : empRegister.jsp
* @Description : 사원 상세정보 처리 화면
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
    /* 공통정보 */
com.inswave.elfw.core.ElHeader  elHeader = (com.inswave.elfw.core.ElHeader)request.getAttribute("elHeader");
boolean resSuc = elHeader.isResSuc();
String resCode = elHeader.getResCode();
String resMsg  = elHeader.getResMsg(); 
java.util.HashMap<String,String> errorMap  = elHeader.getResValidateErr();


/* 업무정보 */
EmpVo empVo = (EmpVo)request.getAttribute("empVo");
if(empVo==null) empVo = new EmpVo();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="registerFlag" value="${empty empVo.empno or MODE != 'U' ? '등록' : '수정'}"/>
<title>사원정보 <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/ElDemo.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->


<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_emp_selectList() {
   	document.detailForm.action = "<c:url value='/DmoEmpList.do'/>";
   	document.detailForm.submit();		
}

/* 글 삭제 function */
function fn_emp_delete() {
   	document.detailForm.action = "<c:url value='/DmoEmpDel.do'/>";
   	document.detailForm.submit();		
}

/* 글 등록 function */
function fn_emp_save() {	
	frm = document.detailForm;
	frm.action = "<c:url value="${registerFlag == '등록' ? '/DmoEmpIns.do' : '/DmoEmpUpd.do'}"/>";
	frm.submit();	
}

function fn_delete_file() {	
	obj= document.getElementById("span_fileName"); 
	obj.innerHTML = "";
	detailForm.fileName.value = "";
	
}

function fn_downEmpFile(){
	document.detailForm.action = "<c:url value='/DmoEmpDown.do'/>";
   	document.detailForm.submit();		
}

function fn_reset(){
	try{
		document.detailForm.reset();
		
		document.detailForm.fileName.value = "${empFileVo.fileName}";
		obj= document.getElementById("span_fileName"); 
		obj.innerHTML = "&nbsp;&nbsp;&nbsp;${empFileVo.fileName}";
	}catch(Exception) { }
}



-->
</script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">


<form name="detailForm" method="post"  enctype="multipart/form-data">
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"> 사원정보 <c:out value="${registerFlag}"/></li>
		</ul>
	</div>

	<!-- // 타이틀 -->
	<div id="table">	
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3E2EC" bordercolordark="#FFFFFF" style="BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
		<colgroup>
			<col width="150">
			<col width="">
		</colgroup>

		<tr>
			<td class="tbtd_caption">* 사번</td>
			<td class="tbtd_content" colspan='2'>
				<c:if test="${registerFlag == '수정'}">
					<input type='text' name="empno" class="essentiality" readOnly="true" maxlength="4" value="${empVo.empno}"/>
				</c:if>
				<c:if test="${registerFlag != '수정'}">
					<input type='text' name="empno" maxlength="4" value="${empVo.empno}"/>
				</c:if>
				&nbsp;<%=CommUtil.getValidatorErrorMsg(errorMap, "empno")%>		
			</td>			
		</tr>
		 
		<tr>
			<td class="tbtd_caption">* 성명</td>
			<td class="tbtd_content" colspan='2'>
				<input type='text' name="ename" maxlength="10" class="txt" value="${empVo.ename}"/>
				&nbsp;<%=CommUtil.getValidatorErrorMsg(errorMap, "ename")%>
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption">* 직업</td>
			<td class="tbtd_content" colspan='2'>
				<input type='text' name="job" maxlength="10" class="txt" value="${empVo.job}"/>
				&nbsp;<%=CommUtil.getValidatorErrorMsg(errorMap, "job")%>
			</td>
		</tr>	
		<tr>
			<td class="tbtd_caption">* 직속상관</td>
			<td class="tbtd_content" colspan='2'>
				<input type='text' name="mgr" maxlength="4" class="txt" value="${empVo.mgr}"/>
				&nbsp;<%=CommUtil.getValidatorErrorMsg(errorMap, "mgr")%>					
			</td>
		</tr>	
		
		<tr>
			<td class="tbtd_caption">입사일</td>
			<td class="tbtd_content" colspan='2'>
				<input type='text' name="hiredate" maxlength="20" class="txt" value="${empVo.hiredate}"/>	
							
			</td>
		</tr>
		
		<tr>
			<td class="tbtd_caption">* 급여</td>
			<td class="tbtd_content" colspan='2'>
				<input type='text' name="sal" maxlength="10" class="txt" value="${empVo.sal}"/>
				&nbsp;<%=CommUtil.getValidatorErrorMsg(errorMap, "sal")%>								
			</td>
		</tr>	
		
		<tr>
			<td class="tbtd_caption">상여</td>
			<td class="tbtd_content" colspan='2'>
				<input type='text' name="comm" maxlength="10" class="txt" value="${empVo.comm}"/>				
			</td>
		</tr>						
		
		<tr>
			<td class="tbtd_caption">* 부서코드</td>
			<td class="tbtd_content" colspan='2'>	
						
			<%=com.inswave.elfw.util.HtmlUtil.getComboList( 
					(com.inswave.elfw.util.vo.DefaultSelectListVo)request.getAttribute("deptList")
				  , "deptno"
				  , "class=\"use\""
				  , "-전체-"
				  , empVo.getDeptno())%>			
									
				&nbsp;<%=CommUtil.getValidatorErrorMsg(errorMap, "deptno") %>			
			</td>
		</tr>	
		
		<tr>
			<td class="tbtd_caption">설명</td>
			<td class="tbtd_content" colspan='2'>
				<textarea name="account" class="txt" cols="65" rows="5">${empVo.account}</textarea>								
			</td>
		</tr>	
			
		<tr>
			<td class="tbtd_caption">첨부파일</td>
			<td class="tbtd_content">
				<input type="file" size= '25' name="inputFileData"/>															
			</td>
			<td class="tbtd_content" width ='300'>
				<c:if test="${empFileVo.fileName != null}">
					<a href='javascript:fn_downEmpFile()'><span id='span_fileName'>&nbsp;&nbsp;&nbsp;${empFileVo.fileName}</span></a> 	
					<input type="hidden" name="fileName" value='${empFileVo.fileName}'/>
					<span class="btn_blue_l"><a href="javascript:fn_delete_file();">파일삭제</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span>
				</c:if>					
			</td>
		</tr>	
			
	</table>
    </div>
	
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_emp_selectList();">List</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			<li><span class="btn_blue_l_<%=com.inswave.elfw.util.AdminAuth.getAdminAuth(elHeader.getAuth())%>"><a href="javascript:fn_emp_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l_<%=com.inswave.elfw.util.AdminAuth.getAdminAuth(elHeader.getAuth())%>"><a href="javascript:fn_emp_delete();">삭제</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			</c:if>
			<li><span class="btn_blue_l_<%=com.inswave.elfw.util.AdminAuth.getAdminAuth(elHeader.getAuth())%>"><a href="javascript:fn_reset();">Reset</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>
	</div>
</div>

<!-- 검색조건 유지 -->
<input type="hidden" name="scEname" value="<c:out value='${empVo.scEname}'/>"/>
<input type="hidden" name="scDname" value="<c:out value='${empVo.scDname}'/>"/>
<input type="hidden" name="scDeptno" value="<c:out value='${empVo.scDeptno}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${empVo.pageIndex}'/>"/>


</form>
</body>
</html>

