<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : egovSampleList.jsp
  * @Description : Sample List 화면
  * @Modification Information
  * 
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2009.02.01            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.02.01
  *  
  * Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>로그인폼</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/ElDemo.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--


function loginSubmit() {
 
	if (document.frm.id.value == '') {
		document.frm.id.focus();
		alert('아이디를 입력하십시오.');
		return;
	}
 
	if (document.frm.pw.value == '') {
		document.frm.pw.focus();
		alert('비밀번호를 입력하십시오.');
		return;
	}
 
	document.frm.submit();
}
 
function cancel() {
	document.frm.reset();
}
 
function pressedKey() {
	if (event.keyCode == 13) {
		loginSubmit();
	}
}

-->
</script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
<form name='frm' method="post" action='CmmLogin.do'>


<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">		  
			<tr>
				<td class="title_l">
					<img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"> EL Demo 로그인
				</td>							
				<td class="title_r">
							    
				</td>
			</tr>
		</table>
	</div>
	

	<div id="search">
		<table class="search_table" width="100%" border="0" cellpadding="0" cellspacing="0">
	  
			<tr>
				<td class="search_l" width='250'>
					아이디: <input type='text' name="id" value="" cssClass="txt" onkeydown="pressedKey();"/>
				</td>	
				<td class="search_m"  width='250'>
					패스워드: <input type='password' name="pw" cssClass="txt" onkeydown="pressedKey();"/>			    
				</td>										
				<td class="search_r" width='150'>
					<span class="btn_blue_l"><a href="javascript:loginSubmit();">로그인</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span>			    
				</td>
			</tr>
		</table>
	</div>	
	
	
</div>
</form>
</body>
</html>
