package com.project.inswave.emp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inswave.elfw.exception.ElException;

import com.project.inswave.emp.dao.EmpDAO;
import com.project.inswave.emp.service.EmpFileService;
import com.project.inswave.emp.service.EmpService;
import com.project.inswave.emp.vo.DeptVo;
import com.project.inswave.emp.vo.EmpVo;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


/**
 * @ClassSubJect  데모용 사원정보 처리를 담당하는 구현체 서비스
 * @Class Name : EmpServiceImpl.java
 * @Description : 데모용 사원정보 처리를 담당하는 구현체 서비스
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
 *  Copyright (C) by BSJ All right reserved.
 */
@Service("empServiceImpl")
public class EmpServiceImpl  extends EgovAbstractServiceImpl implements EmpService {
	
    @Resource(name="empDAO")
    private EmpDAO empDAO;
        
    @Resource(name = "empFileServiceImpl")
    private EmpFileService empFileService;

    
	/* (non-Javadoc)
	 * @see com.project.inswave.service.emp.EmpService#selectListEmp(com.project.inswave.vo.emp.EmpVo)
	 */
	public List<EmpVo> selectListEmp(EmpVo empVo) throws ElException {
		List<EmpVo> list = empDAO.selectListEmp(empVo);	
	
		return list;
	}

	/* (non-Javadoc)
	 * @see com.project.inswave.service.emp.EmpService#selectListCountEmp(com.project.inswave.vo.emp.EmpVo)
	 */
	public long selectListCountEmp(EmpVo empVo) throws ElException {
		return empDAO.selectListCountEmp(empVo);
	}

	/* (non-Javadoc)
	 * @see com.project.inswave.service.emp.EmpService#selectEmp(com.project.inswave.vo.emp.EmpVo)
	 */
	public EmpVo selectEmp(EmpVo empVo) throws ElException {
		EmpVo resultVO = empDAO.selectEmp(empVo);			
//        if (resultVO == null)
//        	throw new UserException( "EL.ERROR.COMM.001"  ); //별도의 예외 메시지가 필요한 경우 처리 예시       
        
        return resultVO;
	}

	/* (non-Javadoc)
	 * @see com.project.inswave.service.emp.EmpService#insertEmp(com.project.inswave.vo.emp.EmpVo)
	 */
	public int insertEmp(EmpVo empVo) throws ElException, IOException {
        int iRet = empDAO.insertEmp(empVo);

        if( empVo.getInputFileData() != null  && empVo.getInputFileData().getSize() > 0 ) {
            EmpVo retEmpVo = (EmpVo)empVo.clone();
            retEmpVo = getEmpVo(empVo);       
            empFileService.insertEmpFile(retEmpVo);
        }
        return iRet;
	}
	
	/* (non-Javadoc)
	 * @see com.project.inswave.service.emp.EmpService#updateEmp(com.project.inswave.vo.emp.EmpVo)
	 */
	public int updateEmp(EmpVo empVo) throws ElException, IOException {				
        int updRet = empDAO.updateEmp(empVo);
        
        if( empVo.getInputFileData() != null && empVo.getInputFileData().getSize() > 0 ) {
            EmpVo retEmpVo = (EmpVo)empVo.clone();
            retEmpVo = getEmpVo(empVo);
            empFileService.deleteEmpFile(retEmpVo);
            empFileService.insertEmpFile(retEmpVo);
        } else {
        	if( empVo.getFileName() == null || "".equals(empVo.getFileName())) { // 첨부파일 삭제
        		empFileService.deleteEmpFile(empVo);
        	}
        }
        return updRet;   		
	}

	/* (non-Javadoc)
	 * @see com.project.inswave.service.emp.EmpService#deleteEmp(com.project.inswave.vo.emp.EmpVo)
	 */
	public int deleteEmp(EmpVo empVo) throws ElException {
		int del = empDAO.deleteEmp(empVo);
		empFileService.deleteEmpFile(empVo);
		return del;
	}	
		
	/* (non-Javadoc)
	 * @see com.project.inswave.service.emp.EmpService#selectListDept(java.util.HashMap)
	 */
	public ArrayList<DeptVo> selectListDept(HashMap searchKeyHm) throws ElException{
		return empDAO.selectListDept(searchKeyHm);
	}
	
	/**
	 * EmpVo 의 MultipartFile 의 Stream 을 VO 에 Byte array 데이터 형태로 담는다.
	 * @param empVo
	 * @return 파일데이터를 담은 EmpVo
	 * @throws Exception
	 */
	private EmpVo getEmpVo( EmpVo empVo ) throws ElException, IOException{ 
		if( empVo.getInputFileData() == null )  return null;
    	
		long iFileSize = empVo.getInputFileData().getSize();
		if( iFileSize > 0 ) {
			InputStream is = empVo.getInputFileData().getInputStream();  
			byte[] fileData = new byte[(int)iFileSize];  
			is.read(fileData);
			is.close();
			empVo.setFileName(empVo.getInputFileData().getOriginalFilename());
			empVo.setFileData(fileData);	
		}  
		
		return empVo;
	}

}
