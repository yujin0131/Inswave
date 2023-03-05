package com.project.inswave.domain.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inswave.elfw.annotation.ElDescription;
import com.inswave.elfw.annotation.ElService;
import com.inswave.elfw.annotation.ElValidator;
import com.inswave.elfw.log.AppLog;
import com.project.inswave.domain.user.SignInService;
import com.project.inswave.domain.user.User;
import com.project.inswave.util.ApiUrlUtils;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@ComponentScan(basePackages="com.project.inswave.domain.user")
public class SignInController {

//    @Resource(name = "loginProcess")
//	protected LoginProcessor loginProcess;

	@Autowired
	private final SignInService signInService;
	
	@ElService(key = ApiUrlUtils.SIGNUP_NUM)    
	@RequestMapping(value = ApiUrlUtils.SIGNUP_NUM)   
	@ElDescription(sub = "사번 중복 체크 화면", desc = "사번 중복 체크를 처리합니다.")
	@ElValidator(errUrl = "")           
	public JSONObject login(User userVO, HttpServletRequest request ) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maria");
//		
//		EntityManager entityManager = emf.createEntityManager();
//		
//		EntityTransaction tx = entityManager.getTransaction();
//		tx.begin();
//		
//		try {
//			User user = new User();
//			
//			user = entityManager.find(User.class, userVO.getInsId());
//			
//			tx.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			tx.rollback();
//		} finally {
//			
//			entityManager.close();
//		}
//		
//		emf.close();
		AppLog.info("login_controller");
		AppLog.info(Integer.toString(userVO.getInsNum()));
		User user = signInService.getUserInfo(userVO.getInsNum());
		AppLog.info("###################user select###################");
		AppLog.info("InsIdx : "  + user.getInsIdx() + "InsId : "  + user.getInsId()  + "InsPwd : "  + user.getInsPwd());
		return null;
	}
}
