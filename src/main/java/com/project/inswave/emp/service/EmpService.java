package com.project.inswave.emp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.inswave.elfw.exception.ElException;

import com.project.inswave.emp.vo.DeptVo;
import com.project.inswave.emp.vo.EmpVo;

/**  
 * @ClassSubJect  데모용 사원정보 관련 처리를 담당하는 인터페이스
 * @Class Name : EmpService.java
 * @Description : 데모용 사원정보 관련 처리를 담당하는 인터페이스
 * @Modification Information  
 * @
 * @  수정일                  수정자                  수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023/02/21   샘플작성자                최초생성
 * 
 * @author 개발팀
 * @since 2023/02/21
 * @version 1.0
 * @see
 * 
 *  Copyright Inswave (C) by Sampler All right reserved.
 */
public interface EmpService {
	
	/**
	 * 사원정보 페이징 처리하여 목록을 조회한다.
	 * @param empVo 사원정보 EmpVo
	 * @return  사원상세정보 목록 List<EmpVo>
	 * @throws Exception
	 */
	public List<EmpVo> selectListEmp(EmpVo empVo) throws ElException;
	
	/**
	 * @param empVo 사원정보 EmpVo
	 * @return 조회한 사원정보 전체 카운트
	 * @throws Exception
	 */
	public long selectListCountEmp(EmpVo empVo) throws ElException;
	
	/**
	 * 사원정보 상세조회를 한다.
	 * @param empVo 사원정보 EmpVo
	 * @return 사원상세정보 EmpVo
	 * @throws Exception
	 */
	public EmpVo selectEmp(EmpVo empVo) throws ElException;
		
	/**
	 * 사원정보를 등록한다.
	 * @param empVo 사원정보 EmpVo
	 * @return 사번
	 * @throws Exception
	 */
	public int insertEmp(EmpVo empVo) throws Exception;
	
	/**
	 * 사원정보를 갱신한다.
	 * @param empVo 사원정보 EmpVo
	 * @throws Exception
	 */
	public int updateEmp(EmpVo empVo) throws Exception;
	
	/**
	 * 사원정보를 삭제한다.
	 * @param empVo 사원정보 EmpVo
	 * @throws Exception
	 */
	public int deleteEmp(EmpVo empVo) throws Exception;
	
	/**
	 * 부서정보 목록을 조회한다.
	 * @param searchKeyHm HashMap 
	 * @return 부서정보 목록 - ArrayList<DeptVo>
	 * @throws Exception
	 */
	public ArrayList<DeptVo> selectListDept(HashMap searchKeyHm) throws Exception;
}
