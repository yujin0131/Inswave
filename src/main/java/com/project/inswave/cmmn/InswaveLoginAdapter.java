package com.project.inswave.cmmn;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.inswave.elfw.exception.ElException;
import com.inswave.elfw.log.AppLog;
import com.inswave.elfw.login.LoginAdapter;
import com.inswave.elfw.login.LoginException;
import com.inswave.elfw.login.LoginInfo;
import com.inswave.elfw.util.ElBeanUtils;

import com.project.inswave.emp.service.EmpService;
import com.project.inswave.emp.vo.EmpVo;

/**  
 * @Class Name : InswaveLoginAdapter.java
 * @Description : 프로젝트 로그인 어댑터
 * @Modification Information  
 * @
 * @  수정일                  수정자                  수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023/02/21   개발팀             최초생성
 * 
 * @author 개발팀
 * @since 2023/02/21
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by Inswave All right reserved.
 */
public class InswaveLoginAdapter extends LoginAdapter {

    
	/**
	 * 데모용 로그인 어댑터의 생성자
	 * @param adapterInfoMap Adapter 정보
	 */
	public InswaveLoginAdapter(Map<String, Object> adapterInfoMap){
		super(adapterInfoMap);
	}

	/**
	 * 데모용 로그인 처리를 담당하는 구현체 메소드.
	 * 프레임워크 DefaultLoginAdapter 추상클래스의 로그인 구현체 메소드
	 * @param request
	 * @param id
	 * @param params 기타 동적 파라미터에 추가할 수 있다.(ex. 서비스 구현체 )
	 * @return LoginInfo
	 * @throws LoginException
	 */
	@Override
	public LoginInfo login(HttpServletRequest request, String id, Object... params) throws LoginException {

		// 로그인 체크를 수행  (샘플 예제)
		try{
			String pw = (String)params[0];
			EmpService empService = (EmpService)ElBeanUtils.getBean("empServiceImpl");
			EmpVo empVo = new EmpVo();

			empVo.setEmpno(Integer.parseInt(id) );
			EmpVo resEmpVo = empService.selectEmp(empVo);

			if( resEmpVo == null ) {
				throw new LoginException("EL.ERROR.LOGIN.0001");
			}
			
			String resPw = String.valueOf(resEmpVo.getMgr());
			if(pw == null || !pw.equals(resPw)){
				throw new LoginException("EL.ERROR.LOGIN.0002");
			}
		}catch(NumberFormatException e){
			AppLog.error("login Error1",e);
			throw new LoginException("EL.ERROR.LOGIN.0001");
		}catch(ElException e){
			AppLog.error("login Error2",e);
			throw e;		
		}catch(Exception e){
			AppLog.error("login Error3",e);
			throw new LoginException("EL.ERROR.LOGIN.0003");
		}

		
		// 3. 로그인 성공 설정 
		LoginInfo info = new LoginInfo();		
		info.setSuc(true);
		AppLog.debug("[Login] Inswave Login 성공.....");
			
		return info;
	}

	/**
	 * 데모용 로그아웃 처리를 담당하는 구현체 메소드.
	 * 프레임워크 DefaultLoginAdapter 추상클래스의 로그아웃 구현체 메소드
	 * @param request
	 * @param id
	 * @param params 기타 동적 파라미터에 추가할 수 있다.
	 * @return LoginInfo
	 * @throws LoginException
	 */
	@Override
	public LoginInfo logout(HttpServletRequest request, String id, Object... params) throws LoginException {
		LoginInfo info = new LoginInfo();
		try{			
			// 1. 로그아웃 처리로직 추가
			
			// 2. 로그아웃 성공 설정 
			info.setSuc(true);
			AppLog.debug("[Logout] Inswave Logout 성공.....");
			
		}catch(Exception e){
			throw new LoginException(e);
		}		
		return info;
	}

}
