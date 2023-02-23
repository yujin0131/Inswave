package com.project.inswave.cmmn.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.inswave.elfw.db.ElAbstractMybatisDAO;

/**  
 * @Class Name : InswaveDefaultAbstractDAO.java
 * @Description : 프로젝트 Default DAO 상위 클래스 - 각 업무 DAO 에서 상속받아 사용됨(기본 데이터 소스 사용시) 
 * @Modification Information  
 * @
 * @  수정일                  수정자                  수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023/02/21   개발팀                  최초생성
 * 
 * @author 개발팀
 * @since 2023/02/21
 * @version 1.0
 * @see
 * 
 *  Copyright Inswave (C) by Sampler All right reserved.
 */
public class InswaveDefaultAbstractDAO extends ElAbstractMybatisDAO{

	@Resource(name = "db1SqlSessionFactory")
	 public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	 }
	
}
