<%@page import="com.inswave.elfw.login.LoginException"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
    String moveUrl = null;
String moveButtonText = "이전 페이지";
com.inswave.elfw.core.ElHeader elHeader;
String resCode;
String resMsg ="";

try{
	elHeader = (com.inswave.elfw.core.ElHeader)request.getAttribute("elHeader");
	resCode = elHeader.getResCode();
	resMsg  = elHeader.getResMsg();
	if( resCode != null ) {
		if( resCode.startsWith("ERROR.LOGIN.") || resCode.startsWith("EL.ERROR.LOGIN.") ){
			moveUrl = request.getContextPath() + "/CmmLoginFrm.do";
			moveButtonText = "로그인 페이지";	
		}
	}
}catch(Exception e){
	e.printStackTrace();
}

if( resMsg == null || resMsg.equals("")) {
	resMsg = "수행중 오류가 발생하였습니다.";
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<meta http-equiv="content-language" content="ko">
<title>예외 템플릿</title>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/ElDemo.css'/>"/>

<script type="text/javascript">
function goMovePage(){
	
	<%if(moveUrl != null ){%>
		try{
			parent.location.href = "<%=moveUrl%>";
		}catch(Exception){
			
		}
		try{
			location.href = "<%=moveUrl%>";
		}catch(Exception){
			
		}	
	<%} else {%>
		history.back(-2);
	<%} %>   
}
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top"><br />
    <br />
    <br />
    <table width="600" border="0" cellpadding="0" cellspacing="0" background="<c:url value='/images/egovframework/rte/blue_bg.jpg' />">
      <tr>
        <td align="center"><table width="100%" border="0" cellspacing="9" cellpadding="0">
          <tr>
            <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
       
              <tr>
                <td><br />
                  <br /></td>
              </tr>
              <tr>
                <td align="center"><table width="520" border="0" cellspacing="2" cellpadding="2">
                  <tr>
                    <td width="74"  align="center"><img src="<c:url value='/images/egovframework/rte/danger.jpg' />" width="74" height="74" alt="danger" /></td>
                    <td width="399" valign="middle" align="center" style="font-size:14pt" ><%=resMsg %></td>
                  </tr>
                </table>
                <table width="500" border="0" cellspacing="2" cellpadding="2">
                </table>
                </td>
              </tr>
              <tr>
                <td><br />
                  <br /></td>
              </tr>
              <tr>
                <td align="center">                  
                   <table width="520" border="0" cellspacing="0" cellpadding="0">
                   	  <tr>
                   		  <td width='250'></td>
                   		  <td>
	                   		  <span class="btn_blue_l"><a href="javascript:goMovePage()"><%=moveButtonText %></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span>
	                   	  </td>	                   			                   		                   	
	                   </tr>
                   </table>   
                </td>
              </tr>
            </table>
              <br /></td>
          </tr>
        </table></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>
