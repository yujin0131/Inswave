package com.project.inswave.emp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.inswave.elfw.exception.ElException;
import com.inswave.elfw.log.AppLog;

import com.project.inswave.cmmn.dao.InswaveDefaultAbstractDAO;
import com.project.inswave.emp.vo.DeptVo;
import com.project.inswave.emp.vo.EmpVo;

/**  
 * @ClassSubJect 데모용 사원정보 관련 처리를 담당하는 DAO
 * @Class Name : EmpDAO.java
 * @Description : 데모용 사원정보 관련 처리를 담당하는 DAO
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
@Repository("empDAO")
public class EmpDAO extends InswaveDefaultAbstractDAO {

    public int insertEmp(EmpVo vo) throws ElException {
        return insert("com.project.inswave.emp.insertEmp", vo);
    }

    public int updateEmp(EmpVo vo) throws ElException {
        return update("com.project.inswave.emp.updateEmp", vo);
    }

    public int deleteEmp(EmpVo vo) throws ElException {
    	return delete("com.project.inswave.emp.deleteEmp", vo);
    }

    public EmpVo selectEmp(EmpVo vo) throws ElException {
 
        return (EmpVo) selectByPk("com.project.inswave.emp.selectEmp", vo);
    }

    public List<EmpVo> selectListEmp(EmpVo vo) throws ElException {
    	AppLog.debug("DAO 에서 로그 테스트");

        return list("com.project.inswave.emp.selectListEmp", vo);
    }

    public long selectListCountEmp(EmpVo vo)  throws ElException{
        return (Long)selectByPk("com.project.inswave.emp.selectListCountEmp", vo);
    }

    public ArrayList<DeptVo> selectListDept(HashMap searchKeyHm) throws ElException {
    	return (ArrayList<DeptVo>)list("com.project.inswave.emp.selectListDept", searchKeyHm);
    }

}
