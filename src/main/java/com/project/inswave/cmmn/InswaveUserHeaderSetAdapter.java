package com.project.inswave.cmmn;

import java.util.Map;

import com.inswave.elfw.ElConstants;
import com.inswave.elfw.adapter.AdapterException;
import com.inswave.elfw.core.ElHeader;
import com.inswave.elfw.core.UserHeader;
import com.inswave.elfw.session.UserHeaderSetAdapter;
import com.inswave.elfw.util.ControllerContextUtil;

public class InswaveUserHeaderSetAdapter extends UserHeaderSetAdapter{

	public InswaveUserHeaderSetAdapter(Map<String, Object> adapterInfoMap) {
		super(adapterInfoMap);
	}

	public void setInputUserHeader(UserHeader userHeader) throws AdapterException {
		InswaveUserHeader inputUserHeader = (InswaveUserHeader) userHeader;

		if (inputUserHeader != null) {
			// Input 에서 들어온 헤더 값으로 Context 의 UserHeader 값을 설정하여 Controller 로
			// 전달한다.( 필요한 값만 - 변조 위험 항목 제외 )
			InswaveUserHeader contextUserHeader = null;
			try {
			    contextUserHeader = (InswaveUserHeader) ControllerContextUtil.getUserHeader();
            }catch(Exception e){}
            
			if (contextUserHeader != null) {
				userHeader.setUserId(contextUserHeader.getUserId());
				userHeader.setUserGroupNo(contextUserHeader.getUserGroupNo());			
				// 아래 예제 
				//contextUserHeader.setLocation(inputUserHeader.getLocation());
				//contextUserHeader.setFldLen(inputUserHeader.getFldLen());
			} else {
			    contextUserHeader = new InswaveUserHeader();
			}
		}
	}

	public UserHeader getOutputUserHeader(String outputType, ElHeader elHeader, UserHeader userHeader, Object obj) throws AdapterException {
	    InswaveUserHeader paramUserHeader = new InswaveUserHeader();
	    try {
		    paramUserHeader = (InswaveUserHeader)userHeader;
		} catch( Exception e) {}
		
		if( outputType != null && ElConstants.OUTPUT_FLD.equals(outputType) ) {			
			if(  paramUserHeader != null ) {				
				byte[] bb = (byte [])obj;
				if( bb != null ) {
					// 아래 예제 
					//paramUserHeader.setFldLen(bb.length + paramUserHeader.getFixedTotalLength());				
				}
			}
		} 

		if(  paramUserHeader != null ) {
			if( elHeader.isResSuc() == false ) {
				// 아래 예제
				//paramUserHeader.setSucYn("N");
				//paramUserHeader.setErrorCode(elHeader.getResCode());
				//paramUserHeader.setErrMag(elHeader.getResMsg());
			}else {
				// 아래 예제
				//paramUserHeader.setSucYn("Y");
			}
		}
		return paramUserHeader;
	}

	public UserHeader getExceptionOutputUserHeader(String outputType, ElHeader elHeader) throws AdapterException {
		InswaveUserHeader userHeader = new InswaveUserHeader();
		
		// 아래 예제
		// userHeader.setSucYn("N");

		if (elHeader != null) {
			// 아래 예제
			//userHeader.setFldLen(userHeader.getFixedTotalLength());
			//userHeader.setErrorCode(elHeader.getResCode());
			//userHeader.setErrMag(elHeader.getResMsg());
		}

		return userHeader;
	}
	
		
}
