package com.project.inswave.emp.service;

import com.inswave.elfw.exception.ElException;
import com.project.inswave.emp.vo.EmpVo;


/**  
 * @ClassSubJect 데모용 사원정보의 첨부파일관련 처리를 담당하는 인터페이스
 * @Class Name : EmpFileService.java
 * @Description : 데모용 사원정보의 첨부파일관련 처리를 담당하는 인터페이스
 * @Modification Information  
 * @
 * @  수정일                  수정자                  수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023/02/21    샘플작성자              최초생성
 * 
 * @author 개발팀
 * @since 2023/02/21
 * @version 1.0
 * @see
 * 
 *  Copyright Inswave (C) by Sampler All right reserved.
 */
public interface EmpFileService {
		
	/**
	 * 사원첨부파일 정보의 단건을 조회한다.
	 * @param vo 사원첨부파일정보 EmpVo
	 * @return EmpVo
	 * @throws Exception
	 */
	public EmpVo selectEmpFile(EmpVo vo) throws ElException;
		
	/**
	 * 사원첨부파일 정보를 등록한다.
	 * @param vo 사원첨부파일정보 VO
	 * @return EmpVo
	 * @throws Exception
	 */
	public int insertEmpFile(EmpVo vo) throws ElException;
	
	/**
	 * 사원첨부파일정보를 갱신한다.
	 * @param vo 사원첨부파일정보 VO
	 * @throws Exception
	 */
	public int updateEmpFile(EmpVo vo) throws ElException;
	
	/**
	 * 사원 첨부파일 정보를 삭제한다.
	 * @param vo 사원첨부파일정보 VO
	 * @throws Exception
	 */
	public int deleteEmpFile(EmpVo vo) throws ElException;
	
	public void uploadEmpFile( EmpVo vo ) throws Exception;
}
