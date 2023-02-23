package com.project.inswave.emp.dao;

import org.springframework.stereotype.Repository;

import com.project.inswave.cmmn.dao.InswaveDefaultAbstractDAO;
import com.project.inswave.emp.vo.EmpVo;
import com.inswave.elfw.exception.ElException;

/**  
 * @ClassSubJect 데모용 사원정보의 파일 관련 처리를 담당하는 DAO
 * @Class Name : EmpFileDAO.java
 * @Description : 데모용 사원정보의 파일 관련 처리를 담당하는 DAO
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
@Repository("empFileDAO")
public class EmpFileDAO extends InswaveDefaultAbstractDAO {

    public int insertEmpFile(EmpVo vo) throws ElException {    	
        return insert("com.project.inswave.emp.insertEmpFile", vo);
    }

    public int updateEmpFile(EmpVo vo) throws ElException {
        return update("com.project.inswave.emp.updateEmpFile", vo);
    }

    public int deleteEmpFile(EmpVo vo) throws ElException {
        return delete("com.project.inswave.emp.deleteEmpFile", vo);
    }

    public EmpVo selectEmpFile(EmpVo vo) throws ElException {
        return (EmpVo) selectByPk("com.project.inswave.emp.selectEmpFile", vo);
    }

}
